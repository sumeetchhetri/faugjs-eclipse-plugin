package com.faug.mvc.js.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class StartupClass implements IStartup {
	@Override
	public void earlyStartup() {
		try {
			for (IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
				List<IEditorReference> editors = new ArrayList<IEditorReference>();
			    for (IWorkbenchPage page : window.getPages()) {
			        for (IEditorReference editor : page.getEditorReferences()) {
			        	IFile file = editor.getEditorInput().getAdapter(IFile.class);
						if(file==null) {
							editors.add(editor);
						}
			        }
			    }
			    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						window.getActivePage().closeEditors(editors.toArray(new IEditorReference[editors.size()]), true);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
