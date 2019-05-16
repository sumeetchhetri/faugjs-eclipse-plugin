package com.faug.mvc.js.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.stream.JsonParser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.Problem;
import org.leadpony.justify.api.ProblemHandler;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.NodeVisitor;

import com.google.common.io.CharStreams;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

@SuppressWarnings("restriction")
public class JsonUiIXtextEditorCallback extends NatureAddingEditorCallback {

	private static final Pattern fgav = Pattern
			.compile("(Fg|Faug)\\.(ag|addGlobalVar)[\t ]*\\([\t ]*(['\"]+)([^'\"]+)(['\"]+)");

	private static final Map<String, FaugjsConfigContext> fgContexts = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsFuncNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> varNames = new ConcurrentHashMap<>();
	private static final JsonValidationService jsonSchemaService = JsonValidationService.newInstance();

	public static FaugjsConfigContext getObj(String key) {
		return fgContexts.get(key);
	}

	public static String getJsFuncFile(String func) {
		for (String file : jsFuncNames.keySet()) {
			if (jsFuncNames.get(file).contains(func))
				return file;
		}
		return null;
	}

	public static String getJsVarFile(String func) {
		for (String file : varNames.keySet()) {
			if (varNames.get(file).contains(func))
				return file;
		}
		return null;
	}

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		if (fgContexts.size() == 0) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			try {
				for (IEditorReference ref : window.getActivePage().getEditorReferences()) {
					handleFaugConfig(ref.getEditorInput().getAdapter(IFile.class));
					// System.out.println("open file " +
					// ref.getEditorInput().getAdapter(IFile.class).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			handleFaugConfig(editor.getEditorInput().getAdapter(IFile.class));
		}
	}

	private void handleFaugConfig(final IFile file) {
		if (file.toString().endsWith("fjs-config.json")) {
			try {
				FaugjsConfigContext cntxt = new FaugjsConfigContext();
				cntxt.path = file.toString().replaceFirst("fjs-config.json", "");
				if (cntxt.path.startsWith("L/")) {
					cntxt.path = cntxt.path.substring(2);
				}

				CompletableFuture.supplyAsync(() -> readAndParseJsonFile(file))
						.thenApplyAsync(obj -> validateJsonBySchema(obj, file, "/faug-config-schema.json"))
						.thenApplyAsync(obj -> {
							if (obj == null)
								return null;
							List<String> mods = null;
							try {
								mods = obj.read("$.modules");
							} catch (Exception e) {
							}
							try {
								List<String> mods1 = obj.read("$.exModules");
								if (mods == null) {
									mods = mods1;
								} else {
									mods.addAll(mods1);
								}
							} catch (Exception e) {
							}
							if (mods != null) {
								cntxt.moduleFiles.addAll(mods);
								return obj;
							}
							return null;
						}).thenApplyAsync(obj -> {
							if (obj == null)
								return null;
							cntxt.moduleFiles.parallelStream().forEach(jsf -> {
								IFile jsFile = file.getWorkspace().getRoot()
										.getFile(Path.fromOSString(cntxt.path + jsf));
								readAndParseJsFile(jsf, jsFile);
							});
							addTemplatesAndSchemas(obj, cntxt);
							return obj;
						}).thenApplyAsync(obj -> {
							if (obj == null)
								return null;
							Map<String, Object> gvars = null;
							try {
								gvars = obj.read("$.globals");
							} catch (Exception e) {
							}
							if (gvars != null) {
								varNames.put("fjs-config.json", gvars.keySet());
							}

							List<String> configs = null;
							try {
								configs = obj.read("$.configs");
							} catch (Exception e) {
							}
							return configs;
						}).thenAcceptAsync(configs -> {
							if (configs == null)
								return;
							configs.parallelStream().forEach(config -> {
								IFile f = file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path + config));
								ReadContext obj1 = readAndParseJsonFile(f);
								if (obj1 != null) {
									addTemplatesAndSchemas(obj1, cntxt);
									Map<String, Object> gvars = null;
									try {
										gvars = obj1.read("$.globals");
									} catch (Exception e) {
									}
									if (gvars != null) {
										varNames.put(config, gvars.keySet());
									}
								}
							});
							fgContexts.put(file.getProject().getName(), cntxt);
						});

				/*
				 * ReadContext obj = JsonPath.parse(readFileContents(file));
				 * 
				 * Boolean validate = null; try { validate = obj.read("$.validate"); } catch
				 * (Exception e) { }
				 * 
				 * if(validate!=null && validate) { JsonSchema schema =
				 * jsonSchemaService.readSchema(JsonUiIXtextEditorCallback.class.
				 * getResourceAsStream("/faug-config-schema.json"));
				 * file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE);
				 * ProblemHandler handler = new ProblemHandler() {
				 * 
				 * @Override public void handleProblems(List<Problem> probs) { try { for
				 * (Problem problem : probs) { IMarker marker =
				 * file.createMarker(IMarker.PROBLEM); marker.setAttribute("CODE_KEY",
				 * "org.glsl.compiler.error"); marker.setAttribute("severity",
				 * IMarker.SEVERITY_ERROR); marker.setAttribute("charStart",
				 * (int)problem.getLocation().getStreamOffset()); marker.setAttribute("charEnd",
				 * (int)(problem.getLocation().getStreamOffset()+problem.getLocation().
				 * getColumnNumber())); marker.setAttribute("location",
				 * "line: "+problem.getLocation().getLineNumber()+" "+problem.getLocation().
				 * getColumnNumber()); marker.setAttribute("lineNumber",
				 * (int)problem.getLocation().getLineNumber()); marker.setAttribute("message",
				 * problem.getContextualMessage()); marker.setAttribute("FIXABLE_KEY", true); }
				 * } catch (CoreException e) { } } }; try (JsonParser parser =
				 * jsonSchemaService.createParser(file.getContents(), schema, handler)) { while
				 * (parser.hasNext()) { parser.next(); } } catch(Exception e) { } } else {
				 * file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE); }
				 * 
				 * List<String> mods = null; try { mods = obj.read("$.modules"); } catch
				 * (Exception e) { } try { List<String> mods1 = obj.read("$.exModules"); if(mods
				 * == null) { mods = mods1; } else { mods.addAll(mods1); } } catch (Exception e)
				 * { } if(mods!=null) { cntxt.moduleFiles.addAll(mods); for (String jsf :
				 * cntxt.moduleFiles) { String c =
				 * readFileContents(file.getWorkspace().getRoot().getFile(Path.fromOSString(
				 * cntxt.path + jsf))); FunctionDeclVisitor fv = parseJsFile(c);
				 * jsFuncNames.put(jsf, fv.functionNodes); varNames.put(jsf, fv.gvars); } }
				 * 
				 * addTemplatesAndSchemas(obj, cntxt);
				 * 
				 * Map<String, Object> gvars = null; try { gvars = obj.read("$.globals"); }
				 * catch (Exception e) { } if(gvars!=null) { varNames.put("fjs-config.json",
				 * gvars.keySet()); }
				 * 
				 * List<String> configs = null; try { configs = obj.read("$.configs"); } catch
				 * (Exception e) { }
				 * 
				 * if(configs!=null) { for (String config : configs) { IFile f =
				 * file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path +
				 * config)); ReadContext obj1 = JsonPath.parse(readFileContents(f));
				 * addTemplatesAndSchemas(obj1, cntxt);
				 * 
				 * gvars = null; try { gvars = obj1.read("$.globals"); } catch (Exception e) { }
				 * if(gvars!=null) { varNames.put(config, gvars.keySet()); } } }
				 * 
				 * fgContexts.put(file.getProject().getName(), cntxt);
				 */
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else if (file.toString().endsWith(".json")) {
			FaugjsConfigContext cntxt = JsonUiIXtextEditorCallback.getObj(file.getProject().getName());
			if (cntxt != null) {
				try {
					String scfn = file.getFullPath().toFile().toString().replace("/" + cntxt.path, "");
					if (cntxt.schemaFiles.values().contains(scfn)) {
						CompletableFuture.supplyAsync(() -> readAndParseJsonFile(file))
								.thenApplyAsync(obj -> validateJsonBySchema(obj, file, "/faug-schema-schema.json"));
						/*
						 * ReadContext obj = JsonPath.parse(readFileContents(file));
						 * 
						 * Boolean validate = false; try { validate = obj.read("$.validate"); } catch
						 * (Exception e) { }
						 * 
						 * if(validate!=null && validate) { JsonSchema schema =
						 * jsonSchemaService.readSchema(JsonUiIXtextEditorCallback.class.
						 * getResourceAsStream("/faug-schema-schema.json"));
						 * file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE);
						 * ProblemHandler handler = new ProblemHandler() {
						 * 
						 * @Override public void handleProblems(List<Problem> probs) { try { for
						 * (Problem problem : probs) { IMarker marker =
						 * file.createMarker(IMarker.PROBLEM); marker.setAttribute("CODE_KEY",
						 * "org.glsl.compiler.error"); marker.setAttribute("severity",
						 * IMarker.SEVERITY_ERROR); marker.setAttribute("charStart",
						 * (int)problem.getLocation().getStreamOffset()); marker.setAttribute("charEnd",
						 * (int)(problem.getLocation().getStreamOffset()+problem.getLocation().
						 * getColumnNumber())); marker.setAttribute("location",
						 * "line: "+problem.getLocation().getLineNumber()+" "+problem.getLocation().
						 * getColumnNumber()); marker.setAttribute("lineNumber",
						 * (int)problem.getLocation().getLineNumber()); marker.setAttribute("message",
						 * problem.getContextualMessage()); marker.setAttribute("FIXABLE_KEY", true); }
						 * } catch (CoreException e) { } } }; try (JsonParser parser =
						 * jsonSchemaService.createParser(file.getContents(), schema, handler)) { while
						 * (parser.hasNext()) { parser.next(); } } catch(Exception e) { } } else {
						 * file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE); }
						 */
					}
				} catch (Throwable e) {
					e.printStackTrace();
					// System.out.println("Invalid JSON content");
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void addTemplatesAndSchemas(ReadContext obj, FaugjsConfigContext cntxt) {
		List<Object> temps = null;
		try {
			temps = obj.read("$.templates");
		} catch (Exception e) {
		}
		if (temps != null) {
			for (Object o : temps) {
				if (o instanceof String) {
					cntxt.templateFiles.add(o.toString());
				} else if (o instanceof List) {
					cntxt.templateFiles.add(((List<String>) o).get(0));
				}
			}
		}

		Map<String, Object> schms = null;
		try {
			schms = obj.read("$.schemas");
		} catch (Exception e) {
		}
		if (schms != null) {
			for (String k : schms.keySet()) {
				if (schms.get(k) instanceof String) {
					cntxt.schemaFiles.put(k, schms.get(k).toString());
				} else if (schms.get(k) instanceof List) {
					cntxt.schemaFiles.put(k, ((List<String>) schms.get(k)).get(0));
				}
			}
		}
	}

	@Override
	public void afterSave(XtextEditor editor) {
		handleFaugConfig(editor.getDocument().getAdapter(IFile.class));
	}

	@Override
	public void beforeDispose(XtextEditor editor) {
	}

	public static class FaugjsConfigContext {
		String path;
		Set<String> moduleFiles = new LinkedHashSet<String>();
		Map<String, String> schemaFiles = new HashMap<String, String>();
		Set<String> templateFiles = new LinkedHashSet<String>();
	}

	public static class FunctionDeclVisitor implements NodeVisitor {
		Set<String> functionNodes = new HashSet<>();
		Set<String> gvars = new HashSet<>();

		@Override
		public boolean visit(AstNode node) {
			if (node.getType() == Token.FUNCTION && node instanceof FunctionNode) {
				functionNodes.add(((FunctionNode) node).getName());
			}
			return true;
		}
	}

	public static String readFileContents(IFile file) throws CoreException, IOException {
		return CharStreams.toString(new InputStreamReader(file.getContents()));
	}

	private static FunctionDeclVisitor parseJsFile(String c) {
		CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
		compilerEnvirons.setRecordingComments(true);
		compilerEnvirons.setRecordingLocalJsDocComments(true);
		compilerEnvirons.setStrictMode(true);
		AstRoot astRoot = new Parser(compilerEnvirons).parse(c, null, 1);
		FunctionDeclVisitor fv = new FunctionDeclVisitor();
		astRoot.visit(fv);
		Matcher m = fgav.matcher(c);
		while (m.find()) {
			String gvar = m.group(4);
			fv.gvars.add(gvar);
		}
		return fv;
	}

	// Start async methods section
	public static ReadContext readAndParseJsonFile(IFile file) {
		try {
			return JsonPath.parse(readFileContents(file));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static FunctionDeclVisitor readAndParseJsFile(String jsf, IFile file) {
		try {
			FunctionDeclVisitor fv = parseJsFile(readFileContents(file));
			jsFuncNames.put(jsf, fv.functionNodes);
			varNames.put(jsf, fv.gvars);
			return fv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ReadContext validateJsonBySchema(ReadContext obj, IFile file, String schemaFile) {
		if (obj == null)
			return null;
		Boolean validate = null;
		try {
			validate = obj.read("$.validate");
		} catch (Exception e) {
		}

		try {
			if (validate != null && validate) {
				JsonSchema schema = jsonSchemaService
						.readSchema(JsonUiIXtextEditorCallback.class.getResourceAsStream(schemaFile));
				file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE);
				AtomicBoolean valid = new AtomicBoolean(true);
				ProblemHandler handler = new ProblemHandler() {
					@Override
					public void handleProblems(List<Problem> probs) {
						valid.set(false);
						try {
							for (Problem problem : probs) {
								IMarker marker = file.createMarker(IMarker.PROBLEM);
								marker.setAttribute("CODE_KEY", "org.glsl.compiler.error");
								marker.setAttribute("severity", IMarker.SEVERITY_ERROR);
								marker.setAttribute("charStart", (int) problem.getLocation().getStreamOffset());
								marker.setAttribute("charEnd", (int) (problem.getLocation().getStreamOffset()
										+ problem.getLocation().getColumnNumber()));
								marker.setAttribute("location", "line: " + problem.getLocation().getLineNumber() + " "
										+ problem.getLocation().getColumnNumber());
								marker.setAttribute("lineNumber", (int) problem.getLocation().getLineNumber());
								marker.setAttribute("message", problem.getContextualMessage());
								marker.setAttribute("FIXABLE_KEY", true);
							}
						} catch (CoreException e) {
						}
					}
				};

				JsonParser parser = jsonSchemaService.createParser(file.getContents(), schema, handler);
				while (parser.hasNext()) {
					parser.next();
				}

				if (valid.get()) {
					return obj;
				}
			} else {
				file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE);
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
