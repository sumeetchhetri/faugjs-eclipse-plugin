package com.faug.mvc.js.ui;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.ui.model.application.ui.basic.impl.PartImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.browser.BrowserViewer;
import org.eclipse.ui.internal.browser.InternalBrowserInstance;
import org.eclipse.ui.internal.browser.WebBrowserEditor;
import org.eclipse.ui.part.WorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.faug.mvc.js.ui.JsonUiIXtextEditorCallback.FaugjsConfigContext;
import com.faug.mvc.js.ui.internal.JsActivator;
import com.google.re2j.Matcher;
import com.google.re2j.Pattern;

@SuppressWarnings("restriction")
public class JsonUiIHyperlinkDetector implements IHyperlinkDetector {

	Pattern filePat1 = Pattern.compile("\"(.*)\"[\\t ]*:[\\t ]*\"([^\"]+)\\.(json|js|html)\"");
	Pattern filePat2 = Pattern.compile("\"([^\"]+)\\.(json|js|html)\"");
	Pattern opPat = Pattern.compile("\"op\"[\t ]*:[\t ]*\"([^\"]+)\"");
	public static final Pattern snPat = Pattern.compile("\"schemaName\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern vnPat = Pattern.compile("\"viewerId\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern fnPat = Pattern.compile(
			"\"(func|serializeValueFunction|afterOp|onValidateOp|beforeOp|failure)\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern fn2Pat = Pattern.compile(
			"\\.(func|serializeValueFunction|afterOp|onValidateOp|beforeOp|failure)\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern tgPat = Pattern.compile("\"target\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern fn1Pat = Pattern.compile("\"func:([^\"]+)\"");
	Pattern fgPat = Pattern.compile("%%(Fg|Faug)\\.g\\(['\"]*([^'\"]+)['\"]*\\)");
	Pattern fvPat = Pattern.compile("\"fromVar\"[\t ]*:[\t ]*\"([^\"]+)\"");
	Pattern gvPat = Pattern.compile("gvar@([^\"]+)\"");

	@Override
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		IDocument document = textViewer.getDocument();

		IXtextDocument xtextDocument = (IXtextDocument) document;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IFile file = window.getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);

		FaugjsConfigContext cntxt = JsonUiIXtextEditorCallback.getObj(file.getProject().getName());

		int offset = region.getOffset();
		String candidate = null;
		FaugJsLink flink = new FaugJsLink();
		try {
			int linenumber = document.getLineOfOffset(offset);
			flink.fUrlRegion = document.getLineInformationOfOffset(offset);
			candidate = document.get(flink.fUrlRegion.getOffset(), flink.fUrlRegion.getLength());
			if (candidate.trim().startsWith("\"op\"")) {
				Matcher m = opPat.matcher(candidate);
				if (m.find()) {
					flink.opName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
					deduceSchemaName(flink, xtextDocument, linenumber, linenumber - 1);
				}
			} else if (candidate.trim().startsWith("\"viewerId\"")) {
				Matcher m = vnPat.matcher(candidate);
				if (m.find()) {
					flink.viewerName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
					deduceSchemaName(flink, xtextDocument, linenumber, linenumber - 1);
				} else {
					return null;
				}
			} else if (candidate.trim().startsWith("\"schemaName\"")) {
				Matcher m = snPat.matcher(candidate);
				if (m.find()) {
					flink.schemaName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
				} else {
					return null;
				}
			} else if (candidate.trim().startsWith("\"func\"")
					|| candidate.trim().startsWith("\"serializeValueFunction\"")
					|| candidate.trim().startsWith("\"afterOp\"") || candidate.trim().startsWith("\"onValidateOp\"")
					|| candidate.trim().startsWith("\"beforeOp\"") || candidate.trim().startsWith("\"failure\"")) {
				Matcher m = fnPat.matcher(candidate);
				if (m.find()) {
					flink.fnName = m.group(2);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(2), m.group(2).length());
				} else {
					return null;
				}
			} else if (candidate.trim().startsWith("\"target\"")) {
				Matcher m = tgPat.matcher(candidate);
				if (m.find()) {
					flink.opName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
					flink.file = file;
				} else {
					return null;
				}
			} else if (candidate.contains(".func\"") || candidate.contains(".serializeValueFunction\"")
					|| candidate.contains(".afterOp\"") || candidate.contains(".onValidateOp\"")
					|| candidate.contains(".beforeOp\"") || candidate.contains(".failure\"")) {
				Matcher m = fn2Pat.matcher(candidate);
				if (m.find()) {
					flink.fnName = m.group(2);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(2), m.group(2).length());
				} else {
					return null;
				}
			} else if (candidate.contains("\"func:")) {
				Matcher m = fn1Pat.matcher(candidate);
				if (m.find()) {
					flink.fnName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
				} else {
					return null;
				}
			} else if (candidate.contains("%%Fg.")) {
				Matcher m = fgPat.matcher(candidate);
				if (m.find()) {
					flink.gvName = m.group(2);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(2), m.group(2).length());
				} else {
					return null;
				}
			} else if (candidate.contains("\"fromVar\"")) {
				Matcher m = fvPat.matcher(candidate);
				if (m.find()) {
					flink.gvName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
				} else {
					return null;
				}
			} else if (candidate.contains("gvar@")) {
				Matcher m = gvPat.matcher(candidate);
				if (m.find()) {
					flink.gvName = m.group(1);
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1), m.group(1).length());
				} else {
					return null;
				}
			} else {
				Matcher m = filePat1.matcher(candidate);
				if (m.find()) {
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(2),
							m.group(2).length() + m.group(3).length() + 1);
					flink.file = file.getWorkspace().getRoot()
							.getFile(Path.fromOSString(cntxt.path + m.group(2) + "." + m.group(3)));
					if(m.group(1).equalsIgnoreCase("templateFile") || m.group(1).equalsIgnoreCase("optionTemplateFile")
							|| m.group(1).equalsIgnoreCase("genericTemplateFile") || m.group(1).equalsIgnoreCase("genericOptionTemplateFile")) {
						flink.params = "isTransient,elName,rows,selectedVal,details,vars";
					}
				} else {
					m = filePat2.matcher(candidate);
					if (m.find()) {
						flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1),
								m.group(1).length() + m.group(2).length() + 1);
						flink.file = file.getWorkspace().getRoot()
								.getFile(Path.fromOSString(cntxt.path + m.group(1) + "." + m.group(2)));
						flink.params = cntxt.lookupTemplateParams(flink.file);
					} else {
						return null;
					}
				}
			}
			if (flink.schemaName != null && cntxt.schemaFiles.containsKey(flink.schemaName)) {
				flink.file = file.getWorkspace().getRoot()
						.getFile(Path.fromOSString(cntxt.path + cntxt.schemaFiles.get(flink.schemaName)));
			} else if (flink.fnName != null) {
				String jsf = JsonUiIXtextEditorCallback.getJsFuncFile(flink.fnName);
				if (jsf != null) {
					flink.file = file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path + jsf));
				}
			} else if (flink.gvName != null) {
				String jsf = JsonUiIXtextEditorCallback.getJsVarFile(flink.gvName);
				if (jsf != null) {
					flink.configGv = jsf.equals("fjs-config.json") ? true : false;
					flink.file = file.getWorkspace().getRoot().getFile(Path.fromOSString(cntxt.path + jsf));
				}
			}
			// JsActivator.info(flink.toString());
			return new IHyperlink[] { flink };
		} catch (BadLocationException ex) {
			return null;
		}
	}

	private void deduceSchemaName(FaugJsLink flink, IDocument document, int oln, int ln) throws BadLocationException {
		if (oln == ln)
			return;
		IRegion lineRegion = document.getLineInformation(ln);
		String candidate = document.get(lineRegion.getOffset(), lineRegion.getLength()).trim();
		if (candidate.startsWith("\"schemaName\"")) {
			Matcher m = snPat.matcher(candidate);
			if (m.find()) {
				flink.schemaName = m.group(1);
			}
			return;
		}
		// JsActivator.info("tryin line number " + ln);
		if (flink.schemaName != null || ln == oln - 3 || ln == oln + 3)
			return;
		deduceSchemaName(flink, document, oln, ln - 1);
		deduceSchemaName(flink, document, oln, ln + 1);
	}

	public static class FaugJsLink implements IHyperlink {
		IRegion fUrlRegion;
		IFile file;
		String viewerName;
		String opName;
		String schemaName;
		String fnName;
		String gvName;
		boolean configGv = true;
		String params = null;

		public FaugJsLink() {
		}

		@Override
		public IRegion getHyperlinkRegion() {
			return fUrlRegion;
		}

		@Override
		public String getTypeLabel() {
			return null;
		}

		@Override
		public String getHyperlinkText() {
			return null;
		}

		@Override
		public void open() {
			if (file == null)
				return;
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			String srchTxt = null;
			if (opName != null) {
				srchTxt = "(\"" + opName + "\"[\t ]*:[\t ]*)";
			} else if (viewerName != null) {
				srchTxt = "(\"id\"[\t ]*:[\t ]*\"" + viewerName + "\")";
			} else if (fnName != null) {
				srchTxt = "(function[\t ]+)(" + fnName + ")[\t ]*\\(";
			} else if (gvName != null) {
				if (!configGv) {
					srchTxt = "(Fg|Faug)[\t ]*\\.[\t ]*(ag|addGlobalVar)[\t ]*\\([\t ]*['\"]+(" + gvName + ")";
				} else {
					srchTxt = "(\"" + gvName + "\"[\t ]*:[\t ]*)";
				}
			}
			try {
				int start = 0, length = 0;
				String scDat = null;
				if (srchTxt != null) {
					scDat = JsonUiIXtextEditorCallback.readFileContents(file);
					Pattern p = Pattern.compile(srchTxt);
					Matcher m = p.matcher(scDat);
					if (m.find()) {
						if (m.groupCount() == 3 && !configGv) {
							start = m.start(3);
							length = m.group(3).length();
						} else if (m.groupCount() == 2) {
							start = m.start(2);
							length = m.group(2).length();
						} else {
							start = m.start();
							length = 0;
						}
					}
				}
				if(file.getName().endsWith("html") || file.getName().endsWith("js")) {
					FaugjsConfigContext cntxt = JsonUiIXtextEditorCallback.getObj(file.getProject().getName());
					int linenum = -1, colnums = -1, colnume = -1;
					if(scDat!=null && start>0) {
						String[] lines = scDat.substring(0, start).split("\n");
						linenum = lines.length;
						colnums = lines[linenum-1].length();
						colnume = lines[linenum-1].length() + length;
					}
					openFaugFile(file, linenum, colnums, colnume, params, scDat, cntxt.getRootProjectPath());
				} else {
					IEditorPart part = IDE.openEditor(page, file);
					part.setFocus();
					if (start>0) {
						/*if (grpcnt == 2) {
							((ITextEditor) part).selectAndReveal(start, length);
						} else {*/
							((ITextEditor) part).selectAndReveal(start, 0);
						//}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static final Map<String, Object[]> biMap = new ConcurrentHashMap<>();
	public static IWebBrowser getBrowser(String bid) {
		if(bid==null || !biMap.containsKey(bid))return null;
		Object[] o = biMap.get(bid);
		return (IWebBrowser)o[0];
	}
	public static boolean removeBrowser(String bid) {
		if(bid==null)return false;
		if(biMap.remove(bid)!=null) {
			//System.out.println("removed "+bid);
			return true;
		}
		return false;
	}
	public static void closeAllBrowsers() {
		for (Object[] o : biMap.values()) {
			if(o[0]!=null) {
				((IWebBrowser)o[0]).close();
			}
		}
		biMap.clear();
	}
	public static IWebBrowser isEditorAlreadyOpen(String file) {
		for (Object[] o : biMap.values()) {
			if(o[0]!=null) {
				if(o[1].equals(file))return (IWebBrowser)o[0];
			}
		}
		return null;
	}
	
	static AtomicInteger bi = new AtomicInteger(1);
	
	public static boolean openFaugFile(IFile file, int linenum, int colnums, int colnume, String params, String scDat, String rootProjectPath) throws Exception {
		if(file.getName().endsWith("html") || file.getName().endsWith("js")) {
			String extraArgs = "";
			String linenums = "", colnumss = "", colnumes = "";
			if(colnums>-1) {
				colnumss = String.valueOf(colnums);
			}
			if(colnume>-1) {
				colnumes = String.valueOf(colnume);
			}
			if(linenum>-1) {
				linenums = String.valueOf(linenum);
				extraArgs = "&line=" + linenums + "&cols=" + colnumss + "&cole=" + colnumes;
			}
			
			extraArgs += "&jslint="+JsActivator.isValidateJslint();
			extraArgs += "&project="+file.getProject().getName();
			extraArgs += "&modt="+new File(file.getRawLocation().toOSString()).lastModified();
			String url = JsActivator.getAceUrl() + "?file="+URLEncoder.encode(file.getRawLocation().toOSString(), "UTF-8")+extraArgs;
			if(file.getName().endsWith("html") && params!=null) {
				url += "&params="+params;
			}
			String currfile = file.getRawLocation().toOSString().substring(rootProjectPath.length());
			String bn = currfile.indexOf("/")!=-1?currfile.substring(currfile.lastIndexOf("/")+1):currfile;
			if(bn.indexOf("\\")!=-1) {
				bn = bn.replace('\\', '/');
			}
			if(currfile.indexOf("\\")!=-1) {
				currfile = currfile.replace('\\', '/');
			}
			if(currfile.startsWith("/")) {
				currfile = currfile.substring(1);
			}
			
			IWebBrowser wb = isEditorAlreadyOpen(currfile);
			if(wb!=null) {
				InternalBrowserInstance ibe = (InternalBrowserInstance)wb;
				Field f = InternalBrowserInstance.class.getDeclaredField("part");
				f.setAccessible(true);
				WebBrowserEditor wbe = (WebBrowserEditor)f.get(ibe);
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(wbe);
				f = WebBrowserEditor.class.getDeclaredField("webBrowser");
				f.setAccessible(true);
				BrowserViewer bwv = (BrowserViewer)f.get(wbe);
				if(linenum>-1) {
					bwv.getBrowser().execute("linenum="+linenums+";colnums="+colnumss+";colnume="+colnumes+";jumpToLineColFunc();");
				}
				return true;
			}
			
			String bid = "bid_"+bi.incrementAndGet();
			url += "&bid="+bid;
			IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser(0, bid, bn, currfile);
			biMap.put(bid, new Object[] {browser, currfile});
			//System.out.println("added "+bid + " file " + currfile + " date " + new Date());
			browser.openURL(new URL(url));
			
			InternalBrowserInstance ibe = (InternalBrowserInstance)browser;
			Field f = InternalBrowserInstance.class.getDeclaredField("part");
			f.setAccessible(true);
			WebBrowserEditor wbe = (WebBrowserEditor)f.get(ibe);
			
			IPartService partService = (IPartService) wbe.getEditorSite().getService(IPartService.class);
			partService.addPartListener(new IPartListener() {
				@Override
				public void partOpened(IWorkbenchPart part) {
				}
				
				@Override
				public void partDeactivated(IWorkbenchPart part) {
				}
				
				@Override
				public void partClosed(IWorkbenchPart part) {
					if(part instanceof WebBrowserEditor) {
						try {
							Field f = WorkbenchPart.class.getDeclaredField("partSite");
							f.setAccessible(true);
							IWorkbenchPartSite wbes = (IWorkbenchPartSite)f.get(wbe);
							f = PartSite.class.getDeclaredField("model");
							f.setAccessible(true);
							PartImpl partImpl = (PartImpl)f.get(wbes);
							if(!removeBrowser(bid) || !partImpl.isDirty()) {
								return;
							}
							WebBrowserEditor wbe = (WebBrowserEditor)part;
							f = WebBrowserEditor.class.getDeclaredField("webBrowser");
							f.setAccessible(true);
							BrowserViewer bwv = (BrowserViewer)f.get(wbe);
							boolean result = MessageDialog.openConfirm(wbe.getSite().getShell(), "File changed", "Do you want to save the changes?");
							if(result) {
								/*String url = bwv.getBrowser().getUrl();
								url = url.substring(url.indexOf("?")+1);
								String[] pars = url.split("&");
								for (String par : pars) {
									String[] p = par.split("=");
									if(p[0].equals("file")) {
										Object o = bwv.getBrowser().evaluate("return editor.getValue();");
										if(o!=null && o instanceof String) {
											BufferedWriter bfw = new BufferedWriter(new FileWriter(URLDecoder.decode(p[1], "UTF-8")));
											bfw.write(o.toString());
											bfw.close();
											break;
										}
									}
								}*/
								bwv.getBrowser().execute("saveFileFunc();");
							} else {
								// Cancel Button selected do something
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				@Override
				public void partBroughtToTop(IWorkbenchPart part) {
				}
				
				@Override
				public void partActivated(IWorkbenchPart part) {
				}
			});
			
			//ICommandService cmdService = (ICommandService) wbe.getEditorSite().getService(ICommandService.class);
			/*InternalBrowserInstance ibe = (InternalBrowserInstance)browser;
			Field f = InternalBrowserInstance.class.getDeclaredField("part");
			f.setAccessible(true);
			WebBrowserEditor wbe = (WebBrowserEditor)f.get(ibe);
			ICommandService cmdService = (ICommandService) wbe.getEditorSite().getService(ICommandService.class);
			//wbe.getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.SAVE.getId(), new );*/
			//JsActivator.info(url);
			return true;
		}
		return false;
	}
}
