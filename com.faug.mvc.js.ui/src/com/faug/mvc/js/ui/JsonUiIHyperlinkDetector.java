package com.faug.mvc.js.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.faug.mvc.js.ui.JsonUiIXtextEditorCallback.FaugjsConfigContext;
import com.google.re2j.Matcher;
import com.google.re2j.Pattern;

public class JsonUiIHyperlinkDetector implements IHyperlinkDetector {

	Pattern filePat = Pattern.compile("\"([^\"]+)\\.(json|js|html)\"");
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
				Matcher m = filePat.matcher(candidate);
				if (m.find()) {
					flink.fUrlRegion = new Region(flink.fUrlRegion.getOffset() + m.start(1),
							m.group(1).length() + m.group(2).length());
					flink.file = file.getWorkspace().getRoot()
							.getFile(Path.fromOSString(cntxt.path + m.group(1) + "." + m.group(2)));
				} else {
					return null;
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
			// System.out.println(flink.toString());
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
		// System.out.println("tryin line number " + ln);
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
					srchTxt = "(Fg|Faug)\\.(ag|addGlobalVar)[\t ]*\\([\t ]*(['\"]+)" + gvName;
				} else {
					srchTxt = "(\"" + gvName + "\"[\t ]*:[\t ]*)";
				}
			}
			try {
				IEditorPart part = IDE.openEditor(page, file);
				part.setFocus();
				if (srchTxt != null) {
					String scDat = JsonUiIXtextEditorCallback.readFileContents(file);
					Pattern p = Pattern.compile(srchTxt);
					Matcher m = p.matcher(scDat);
					if (m.find()) {
						if (m.groupCount() == 2) {
							((ITextEditor) part).selectAndReveal(m.start() + m.group(1).length(), m.group(2).length());
						} else {
							((ITextEditor) part).selectAndReveal(m.start(), 0);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
