package com.faug.mvc.js.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
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
import org.eclipse.ui.internal.browser.WebBrowserEditorInput;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.Problem;
import org.leadpony.justify.api.ProblemHandler;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NodeVisitor;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;

import com.faug.mvc.js.ui.internal.JsActivator;
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
	private static final Map<String, Set<String>> appVarNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsFuncNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsVarNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> jsSubFunctionNodes = new ConcurrentHashMap<>();
	private static final Map<String, String> jsAliases = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schPropNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schViewerNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> schCrudNames = new ConcurrentHashMap<>();
	private static final JsonValidationService jsonSchemaService = JsonValidationService.newInstance();

	public static FaugjsConfigContext getObj(String key) {
		return fgContexts.get(key);
	}

	public static String getJsFuncFile(String func) {
		Set<String> s = jsFuncNames.keySet();
		for (String file : s) {
			for(String fn: jsFuncNames.get(file)) {
				if(fn.startsWith(func)) {
					return file;
				}
			}
		}
		return null;
	}

	public static String getJsVarFile(String func) {
		Set<String> s = appVarNames.keySet();
		for (String file : s) {
			if (appVarNames.get(file).contains(func))
				return file;
		}
		return null;
	}
	
	public static boolean isSchemaParsed(String sname, int type) {
		Set<String> lst = type==3?schPropNames.get(sname):(type==4?schViewerNames.get(sname):schCrudNames.get(sname));
		return lst != null;
	}
	
	public static Set<String> matchingFuncsOrGvars(String name, String addl, int type, String skipFile) {
		Set<String> matched = new LinkedHashSet<String>();
		if(type==1 || type==2) {
			if(addl!=null && !addl.trim().isEmpty()) {
				if(jsAliases.containsKey(addl)) {
					addl = jsAliases.get(addl);
				}
				Set<String> s = jsSubFunctionNodes.get(addl);
				for (String fn : s) {
					if(fn.startsWith(name)) {
						matched.add(fn);
						//if(matched.size()==20)return matched;
					}
				}
			} else {
				List<Set<String>> sm = new ArrayList<>();
				if(type==1) {
					Set<String> ks = jsFuncNames.keySet();
					for (String k : ks) {
						if(skipFile==null || !k.equals(skipFile)) {
							sm.add(jsFuncNames.get(k));
						}
					}
				} else {
					Collection<Set<String>> s = appVarNames.values();
					for (Set<String> s2 : s) {
						sm.add(s2);
					}
				}
				
				if(type==1) {
					Set<String> ks = jsVarNames.keySet();
					for (String k : ks) {
						if(skipFile==null || !k.equals(skipFile)) {
							sm.add(jsVarNames.get(k));
						}
					}
					for (String t : jsAliases.keySet()) {
						if(t.startsWith(name)) {
							matched.add(t);
						}
					}
				}
				for(Set<String> fns: sm) {
					for (String fn : fns) {
						if(fn.startsWith(name)) {
							matched.add(fn);
							//if(matched.size()==20)return matched;
						}
					}
				}
			}
		} else if((type==3 || type==4 || type==5) && addl!=null) {
			Set<String> s = type==3?schPropNames.get(addl):(type==4?schViewerNames.get(addl):schCrudNames.get(addl));
			for (String fn : s) {
				if(fn.startsWith(name)) {
					matched.add(fn);
					//if(matched.size()==20)return matched;
				}
			}
		}
		return matched;
	}

	private AtomicBoolean foundFjsConfig = new AtomicBoolean(false);
	
	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		if (fgContexts.size() == 0) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			try {
				for (IEditorReference ref : window.getActivePage().getEditorReferences()) {
					IFile file = ref.getEditorInput().getAdapter(IFile.class);
					if(file!=null && file.getName()!=null && file.getName().equals("fjs-config.json")) {
						handleFaugConfig(file);
						break;
					}
				}
				for (IEditorReference ref : window.getActivePage().getEditorReferences()) {
					if(ref.getEditorInput() instanceof WebBrowserEditorInput) {
						//WebBrowserEditorInput b = (WebBrowserEditorInput)ref.getEditorInput();
						//System.out.println(b.getURL());
						IEditorReference[] refs = new IEditorReference[] {ref};
						window.getActivePage().closeEditors(refs, true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
			if(!foundFjsConfig.get()) {
				
			}
		} catch (Exception e) {
		}
	}
	
	@Override
	public void afterSetInput(XtextEditor editor) {
		handleFaugConfig(editor.getEditorInput().getAdapter(IFile.class));
	}

	private void handleFaugConfig(final IFile file) {
		FaugjsConfigContext fcntxt = JsonUiIXtextEditorCallback.getObj(file.getProject().getName());
		if (file.getName().equals("fjs-config.json")) {
			foundFjsConfig.set(true);
			if(fcntxt!=null)return;
			try {
				fcntxt = new FaugjsConfigContext();
				fcntxt.path = file.toString().replaceFirst("fjs-config.json", "");
				JsActivator.rootProjectPath = file.getRawLocation().toOSString().replace("fjs-config.json", "");
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
							appVarNames.put("fjs-config.json", gvars.keySet());
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
									appVarNames.put(config, gvarsl.keySet());
								}
							}
						});
						fgContexts.put(file.getProject().getName(), cntxt);
						return obj;
					}).thenApplyAsync((obj) -> {
						IFile f = file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path + "faug-min.js"));
						readAndParseJsFile("faug-min.js", f);
						return null;
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
									appVarNames.put(scfn, gvarsl.keySet());
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
	
	/*static ScriptableObject sharedScope;
	static Function fct = null;
	static {
		Context context = Context.enter();
		try {
			sharedScope = Context.enter().initStandardObjects();
			String content = CharStreams.toString(new InputStreamReader(JsonUiIXtextEditorCallback.class.getResourceAsStream("/api.js")));
			fct = context.compileFunction(sharedScope, content, "script", 1, null);
		} catch(Exception e) {
		} finally {
			Context.exit();
		}
	}*/

	@Override
	public void afterSave(XtextEditor editor) {
		IFile file = editor.getDocument().getAdapter(IFile.class);
		if(file.getName().equals("fjs-config.json")) {
			fgContexts.remove(file.getProject().getName());
		}
		/*if(file.getName().endsWith(".html")) {
			try {
				file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				file.deleteMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
				Context cx = Context.enter();
				Scriptable scope = cx.newObject(sharedScope);
				scope.setPrototype(sharedScope);
				scope.setParentScope(null);
			    Object result = fct.call(cx, scope, scope, new Object[] {readFileContents(file), true});
			    //System.out.println(result);
			    cx.compileFunction(scope, result.toString(), "script", 1, null);
			    
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Context.exit();
			}
			return;
		}*/
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
		Map<String, Set<String>> subFunctionNodes = new HashMap<>();
		Map<String, String> aliases = new HashMap<>();
		Set<String> appgvars = new HashSet<>();
		Set<String> gvars = new HashSet<>();

		int depth = 0;
		Stack<String> fnames = new Stack<>();
		@Override
		public boolean visit(AstNode node) {
			if(depth>1)return false;
			if (node.getType() == Token.FUNCTION && node instanceof FunctionNode) {
				String fname = null;
				if(((FunctionNode) node).getName()!=null && !((FunctionNode) node).getName().isEmpty()) {
					//System.out.println(((FunctionNode) node).getName());
					fname = ((FunctionNode) node).getName();
				}
				if(depth==0 && fname!=null) {
					fnames.push(fname);
					subFunctionNodes.put(fname, new HashSet<>());
					if(((FunctionNode) node).getParamCount()>0) {
						String fn = fname + "(";
						for (int i=0;i<((FunctionNode) node).getParamCount();++i) {
							Name p = (Name)((FunctionNode) node).getParams().get(i);
							fn += p.getIdentifier();
							if(i!=((FunctionNode) node).getParamCount()-1) {
								fn += ", ";
							}
						}
						functionNodes.add(fn + ")");
					} else {
						functionNodes.add(fname+"()");
					}
				}
				depth++;
				((FunctionNode) node).getBody().visit(this);
				depth--;
				if(depth==0 && fname!=null) {
					fnames.pop();
				}
				return false;
			} else if (node.getType() == Token.ASSIGN && node instanceof Assignment) {
				Assignment a = (Assignment) node;
				if(a.getLeft() instanceof PropertyGet && ((PropertyGet)a.getLeft()).getLeft().toSource().equals("this")) {
					if(!fnames.isEmpty()) {
						String fname = fnames.peek();
						//System.out.println(((Name)((PropertyGet)a.getLeft()).getRight()).getIdentifier());
						if(a.getRight() instanceof FunctionNode) {
							if(((FunctionNode) a.getRight()).getParamCount()>0) {
								String fn = ((Name)((PropertyGet)a.getLeft()).getRight()).getIdentifier() + "(";
								for (int i=0;i<((FunctionNode) a.getRight()).getParamCount();++i) {
									Name p = (Name)((FunctionNode) a.getRight()).getParams().get(i);
									fn += p.getIdentifier();
									if(i!=((FunctionNode) a.getRight()).getParamCount()-1) {
										fn += ", ";
									}
								}
								subFunctionNodes.get(fname).add(fn+")");
							} else {
								subFunctionNodes.get(fname).add(((Name)((PropertyGet)a.getLeft()).getRight()).getIdentifier()+"()");
							}
						} else {
							String ll = ((Name)((PropertyGet)a.getLeft()).getRight()).getIdentifier();
							if(a.getRight() instanceof PropertyGet && ((PropertyGet)a.getRight()).getRight() instanceof Name) {
								String rr = ((Name)((PropertyGet)a.getRight()).getRight()).getIdentifier();
								for (String pf : subFunctionNodes.get(fname)) {
									if(pf.startsWith(rr) && pf.indexOf("(")!=-1) {
										ll = ll + pf.substring(pf.indexOf("("));
										break;
									}
								}
							}
							subFunctionNodes.get(fname).add(ll);
						}
					}
				}
				return false;
			} else if (node.getType() == Token.VAR && node instanceof VariableDeclaration) {
				if(depth>0)return false;
				//functionNodes.add(((FunctionNode) node).getName());
				VariableDeclaration v = (VariableDeclaration) node;
		        List<VariableInitializer> vars1 = v.getVariables();
		        VariableInitializer firstVar = vars1.get(0);
		        Name firstVarName = (Name) firstVar.getTarget();
		        //System.out.println(firstVarName.getIdentifier());
		        if(firstVar.getInitializer() instanceof ObjectLiteral) {
		        	String fname = firstVarName.getIdentifier();
		        	functionNodes.add(fname);
					subFunctionNodes.put(fname, new HashSet<>());
			        ObjectLiteral obj = (ObjectLiteral)firstVar.getInitializer();
			        List<ObjectProperty> props = obj.getElements();
					for (ObjectProperty op : props) {
						if(op.getLeft() instanceof Name) {
							//System.out.println(((Name)op.getLeft()).getIdentifier());
							subFunctionNodes.get(fname).add(((Name)op.getLeft()).getIdentifier());
						}
					}
		        } else {
		        	if(firstVar.getInitializer() instanceof Name && gvars.contains(((Name)firstVar.getInitializer()).getIdentifier())) {
		        		String pvf = ((Name)firstVar.getInitializer()).getIdentifier();
		        		aliases.put(firstVarName.getIdentifier(), pvf);
		        		return false;
		        	}
		        	gvars.add(firstVarName.getIdentifier());
		        	if(firstVar.getInitializer() instanceof NewExpression && ((NewExpression)firstVar.getInitializer()).getTarget() instanceof FunctionNode) {
		        		Node node1 = ((NewExpression)firstVar.getInitializer()).getTarget();
						if(depth==0) {
							String fname = firstVarName.getIdentifier();
							subFunctionNodes.put(fname, new HashSet<>());
							fnames.push(fname);
						} else {
							String fname = fnames.peek();
							if(((FunctionNode) node).getParamCount()>0) {
								String fn = fname + "(";
								for (int i=0;i<((FunctionNode) node).getParamCount();++i) {
									Name p = (Name)((FunctionNode) node).getParams().get(i);
									fn += p.getIdentifier();
									if(i!=((FunctionNode) node).getParamCount()-1) {
										fn += ", ";
									}
								}
								subFunctionNodes.get(fname).add(fn);
							} else {
								subFunctionNodes.get(fname).add(fname+"()");
							}
						}
						depth++;
						((FunctionNode) node1).getBody().visit(this);
						//System.out.println();
						depth--;
						if(depth==0) {
							fnames.pop();
						}
		        	}
		        }
		        return false;
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
			//if(!fv.gvars.contains(gvar))System.out.println(gvar);
			fv.appgvars.add(gvar);
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
			appVarNames.put(jsf, fv.appgvars);
			jsVarNames.put(jsf, fv.gvars);
			jsFuncNames.put(jsf, fv.functionNodes);
			jsSubFunctionNodes.putAll(fv.subFunctionNodes);
			jsAliases.putAll(fv.aliases);
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
	
	/*public static void main(String[] args) throws FileNotFoundException, IOException {
		FunctionDeclVisitor fv = parseJsFile(CharStreams.toString(new InputStreamReader(new FileInputStream("/Users/sumeetc/Projects/OhumGitlab/ohumpasng_risl/src/main/resources/public/faugn.js"))));
	}*/
}
