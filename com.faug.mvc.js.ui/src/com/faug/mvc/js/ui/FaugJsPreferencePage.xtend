package com.faug.mvc.js.ui

import com.faug.mvc.js.ui.internal.JsActivator
import org.eclipse.jface.preference.BooleanFieldEditor
import org.eclipse.jface.preference.IntegerFieldEditor
import org.eclipse.ui.IWorkbench
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage

class FaugJsPreferencePage extends LanguageRootPreferencePage {
	
	override init(IWorkbench workbench) {
		setPreferenceStore(JsActivator.instance.preferenceStore)
	}

	override createFieldEditors() {
		addField(new IntegerFieldEditor(FaugJsPreferences.ACE_EDITOR_PORT, "Ace Editor Port", getFieldEditorParent()));
		addField(new BooleanFieldEditor(FaugJsPreferences.VALIDATE_JSON, "Enable JSON Validation", getFieldEditorParent()));
		addField(new BooleanFieldEditor(FaugJsPreferences.VALIDATE_JSLINT, "Enable Jslint Validation", getFieldEditorParent()));
	}
}
