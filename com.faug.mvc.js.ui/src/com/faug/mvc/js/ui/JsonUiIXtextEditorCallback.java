package com.faug.mvc.js.ui;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
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

	private static final AtomicReference<FaugjsConfigContext> FgCntxt = new AtomicReference<>();
	private static final Map<String, Set<String>> jsFuncNames = new ConcurrentHashMap<>();
	private static final Map<String, Set<String>> varNames = new ConcurrentHashMap<>();

	public static FaugjsConfigContext getObj() {
		return FgCntxt.get();
	}
	
	public static String getJsFuncFile(String func) {
		for (String file : jsFuncNames.keySet()) {
			if(jsFuncNames.get(file).contains(func))return file;
		}
		return null;
	}
	
	public static String getJsVarFile(String func) {
		for (String file : varNames.keySet()) {
			if(varNames.get(file).contains(func))return file;
		}
		return null;
	}

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		try {
			for (IEditorReference ref : window.getActivePage().getEditorReferences()) {
				handleFaugConfig(ref.getEditorInput().getAdapter(IFile.class));
				System.out.println("open file " + ref.getEditorInput().getAdapter(IFile.class).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleFaugConfig(IFile file) {
		if (file.toString().contains("fjs-config") && file.toString().endsWith(".json")) {
			FaugjsConfigContext cntxt = FgCntxt.get();
			if (cntxt == null) {
				try {
					ReadContext obj = JsonPath.parse(readFileContents(file));
					cntxt = new FaugjsConfigContext();

					List<String> mods = null;
					try {
						mods = obj.read("$.modules");
					} catch (Exception e) {
					}
					if(mods!=null) {
						cntxt.moduleFiles.addAll(mods);
						for (String jsf : cntxt.moduleFiles) {
							String c = readFileContents(file.getProject().getFile(jsf));
							FunctionDeclVisitor fv = parseJsFile(c);
							jsFuncNames.put(jsf, fv.functionNodes);
							varNames.put(jsf, fv.gvars);
						}
					}

					addTemplatesAndSchemas(obj, cntxt);
					
					Map<String, Object> gvars = null;
					try {
						gvars = obj.read("$.globals");
					} catch (Exception e) {
					}
					if(gvars!=null) {
						varNames.put("fjs-config.json", gvars.keySet());
					}

					List<String> configs = null;
					try {
						configs = obj.read("$.configs");
					} catch (Exception e) {
					}
					if(configs!=null) {
						for (String config : configs) {
							IFile f = file.getProject().getFile(config);
							ReadContext obj1 = JsonPath.parse(readFileContents(f));
							//System.out.println("reading file " + config);
							addTemplatesAndSchemas(obj1, cntxt);
						}
					}

					FgCntxt.set(cntxt);
				} catch (Throwable e) {
					e.printStackTrace();
					System.out.println("Invalid JSON content");
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
		if(temps!=null) {
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
		if(schms!=null) {
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
		System.out.println("save called");
	}

	public static class FaugjsConfigContext {
		Set<String> moduleFiles = new LinkedHashSet<String>();
		Map<String, String> schemaFiles = new HashMap<String, String>();
		Set<String> templateFiles = new LinkedHashSet<String>();
	}
	
	static final Pattern fgav = Pattern.compile("(Fg|Faug)\\.(ag|addGlobalVar)[\t ]*\\([\t ]*(['\"]+)([^'\"]+)(['\"]+)");
	public static class FunctionDeclVisitor implements NodeVisitor {
		Set<String> functionNodes = new HashSet<>();
		Set<String> gvars = new HashSet<>();

	    @Override
	    public boolean visit(AstNode node) {
	        if(node.getType() ==  Token.FUNCTION  && node instanceof FunctionNode){
	            functionNodes.add(((FunctionNode) node).getName());
	        }
	        return true;
	    }
	}

	public static String readFileContents(IFile file) throws CoreException, IOException {
		return CharStreams.toString(new InputStreamReader(file.getContents()));
	}

	private FunctionDeclVisitor parseJsFile(String c) {
		CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
		compilerEnvirons.setRecordingComments(true);
		compilerEnvirons.setRecordingLocalJsDocComments(true);
		compilerEnvirons.setStrictMode(true);
		try {
			AstRoot astRoot = new Parser(compilerEnvirons).parse(c, null, 1);
			FunctionDeclVisitor fv = new FunctionDeclVisitor();
			astRoot.visit(fv);
			Matcher m = fgav.matcher(c);
			while(m.find()) {
				String gvar = m.group(4);
				fv.gvars.add(gvar);
			}
			return fv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
