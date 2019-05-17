package com.faug.mvc.js.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

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
import com.google.re2j.Matcher;
import com.google.re2j.Pattern;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

@SuppressWarnings("restriction")
public class JsonUiIXtextEditorCallback extends NatureAddingEditorCallback {

	private static final Pattern fgav = Pattern
			.compile("(Fg|Faug)\\.(ag|addGlobalVar)[\t ]*\\([\t ]*('|\")([^'\"]+)('|\")");

	private static final Map<String, FaugjsConfigContext> fgContexts = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsFuncNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsVarNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schPropNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schViewerNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schCrudNames = new ConcurrentHashMap<>();
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
	
	public static Set<String> matchingFuncsOrGvars(String name, String addl, int type) {
		Set<String> matched = new LinkedHashSet<String>();
		if(type==1 || type==2) {
			for(Set<String> fns: type==1?jsFuncNames.values():jsVarNames.values()) {
				for (String fn : fns) {
					if(fn.startsWith(name)) {
						matched.add(fn);
						//if(matched.size()==20)return matched;
					}
				}
			}
		} else if(type==3 || type==4 || type==5) {
			Set<String> lst = type==3?schPropNames.get(addl):(type==4?schViewerNames.get(addl):schCrudNames.get(addl));
			for (String fn : lst) {
				if(fn.startsWith(name)) {
					matched.add(fn);
					//if(matched.size()==20)return matched;
				}
			}
		}
		return matched;
	}
	
	public static boolean isSchemaParsed(String sname, int type) {
		Set<String> lst = type==3?schPropNames.get(sname):(type==4?schViewerNames.get(sname):schCrudNames.get(sname));
		return lst != null;
	}

	public static String getJsVarFile(String func) {
		for (String file : jsVarNames.keySet()) {
			if (jsVarNames.get(file).contains(func))
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
					IFile file = ref.getEditorInput().getAdapter(IFile.class);
					if(file.getName().equals("fjs-config.json")) {
						handleFaugConfig(file);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterSetInput(XtextEditor editor) {
		handleFaugConfig(editor.getEditorInput().getAdapter(IFile.class));
	}

	private void handleFaugConfig(final IFile file) {
		FaugjsConfigContext fcntxt = JsonUiIXtextEditorCallback.getObj(file.getProject().getName());
		if (file.getName().equals("fjs-config.json")) {
			if(fcntxt!=null)return;
			try {
				fcntxt = new FaugjsConfigContext();
				fcntxt.path = file.toString().replaceFirst("fjs-config.json", "");
				if (fcntxt.path.startsWith("L/")) {
					fcntxt.path = fcntxt.path.substring(2);
				}

				final FaugjsConfigContext cntxt = fcntxt;
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
							cntxt.moduleFiles.parallelStream().forEach(jsf -> {
								IFile jsFile = file.getWorkspace().getRoot()
										.getFile(Path.fromOSString(cntxt.path + jsf));
								readAndParseJsFile(jsf, jsFile);
							});
						}
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
							jsVarNames.put("fjs-config.json", gvars.keySet());
						}

						List<String> configs = null;
						try {
							configs = obj.read("$.configs");
							cntxt.configs.addAll(configs);
						} catch (Exception e) {
						}
						cntxt.configs.parallelStream().forEach(config -> {
							IFile f = file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path + config));
							ReadContext obj1 = readAndParseJsonFile(f);
							if (obj1 != null) {
								addTemplatesAndSchemas(obj1, cntxt);
								Map<String, Object> gvarsl = null;
								try {
									gvarsl = obj1.read("$.globals");
								} catch (Exception e) {
								}
								if (gvarsl != null) {
									jsVarNames.put(config, gvarsl.keySet());
								}
							}
						});
						fgContexts.put(file.getProject().getName(), cntxt);
						return obj;
					});
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else if (file.getName().endsWith(".json")) {
			if (fcntxt != null) {
				final FaugjsConfigContext cntxt = fcntxt;
				try {
					String scfn = file.getFullPath().toFile().toString().replace("/" + fcntxt.path, "");
					if(fcntxt.configs.contains(scfn)) {
						CompletableFuture.supplyAsync(() -> readAndParseJsonFile(file))
						.thenApplyAsync(obj -> validateJsonBySchema(obj, file, "/faug-sub-config-schema.json"))
						.thenApplyAsync(obj -> {
							if (obj != null) {
								addTemplatesAndSchemas(obj, cntxt);
								Map<String, Object> gvarsl = null;
								try {
									gvarsl = obj.read("$.globals");
								} catch (Exception e) {
								}
								if (gvarsl != null) {
									jsVarNames.put(scfn, gvarsl.keySet());
								}
							}
							return obj;
						});
					} else if (fcntxt.moduleFiles.contains(scfn)) {
						CompletableFuture.runAsync(() -> readAndParseJsFile(scfn, file));
					} else if (fcntxt.schemaFiles.values().contains(scfn)) {
						CompletableFuture.supplyAsync(() -> readAndParseJsonFile(file))
								.thenApplyAsync(obj -> validateJsonBySchema(obj, file, "/faug-schema-schema.json"));
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
		IFile file = editor.getDocument().getAdapter(IFile.class);
		if(file.getName().equals("fjs-config.json")) {
			fgContexts.remove(file.getProject().getName());
		}
		handleFaugConfig(file);
	}

	@Override
	public void beforeDispose(XtextEditor editor) {
	}

	public static class FaugjsConfigContext {
		String path;
		Set<String> configs = new LinkedHashSet<String>();
		Set<String> moduleFiles = new LinkedHashSet<String>();
		Map<String, String> schemaFiles = new HashMap<String, String>();
		Set<String> templateFiles = new LinkedHashSet<String>();
		
		public Set<String> matchinSchemaNames(String name) {
			Set<String> matched = new LinkedHashSet<String>();
			for(String fn: schemaFiles.keySet()) {
				if(fn.startsWith(name)) {
					matched.add(fn);
					//if(matched.size()==20)return matched;
				}
			}
			return matched;
		}

		public String lookupSchemaName(IFile file) {
			String scfn = file.getFullPath().toFile().toString().replace("/" + path, "");
			for(String fn: schemaFiles.keySet()) {
				if(schemaFiles.get(fn).equals(scfn)) {
					return fn;
				}
			}
			return null;
		}

		public CompletableFuture<ReadContext> parseSchema(String schemaName, IFile file) {
			return CompletableFuture.supplyAsync(() -> {
				if (schemaName != null && schemaFiles.containsKey(schemaName)) {
					IFile sfile = file.getWorkspace().getRoot()
							.getFile(Path.fromOSString(path + schemaFiles.get(schemaName)));
					ReadContext obj = readAndParseJsonFile(sfile);
					if(obj!=null) {
						Map<String, Object> t = null;
						try {
							t = obj.read("$.properties");
							schPropNames.put(schemaName, t.keySet());
						} catch (Exception e) {
						}
						
						try {
							List<Map<String, Object>> lt = obj.read("$.details.viewer");
							schViewerNames.put(schemaName, new LinkedHashSet<String>());
							for (Map<String, Object> mp : lt) {
								if(mp.containsKey("id")) {
									schViewerNames.get(schemaName).add(mp.get("id").toString());
								}
							}
							
						} catch (Exception e) {
						}
						
						try {
							t = obj.read("$.crud");
							schCrudNames.put(schemaName, t.keySet());
						} catch (Exception e) {
						}
						
						System.out.println("Parsed schema file " + schemaName);
					}
					return obj;
				}
				return null;
			});
		}
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
			if(!fv.gvars.contains(gvar))System.out.println(gvar);
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

	public static void readAndParseJsFile(String jsf, IFile file) {
		try {
			FunctionDeclVisitor fv = parseJsFile(readFileContents(file));
			jsFuncNames.put(jsf, fv.functionNodes);
			jsVarNames.put(jsf, fv.gvars);
		} catch (Exception e) {
			e.printStackTrace();
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
			} else {
				file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_INFINITE);
			}
		} catch (Exception e) {
			try {
				IMarker marker = file.createMarker(IMarker.PROBLEM);
				marker.setAttribute("CODE_KEY", "org.glsl.compiler.error");
				marker.setAttribute("severity", IMarker.SEVERITY_ERROR);
				marker.setAttribute("charStart", 0);
				marker.setAttribute("charEnd", 0);
				marker.setAttribute("location", "line: 0 0");
				marker.setAttribute("lineNumber", 0);
				marker.setAttribute("message", "Unable to validate the json file, internal error - " + e.getMessage());
				marker.setAttribute("FIXABLE_KEY", true);
			} catch (Exception ei) {
			}
			e.printStackTrace();
		}
		return obj;
	}
}
