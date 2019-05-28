package com.faug.mvc.js.ui;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.faug.mvc.js.ui.internal.JsActivator;

public class FaugJsPreferences extends AbstractPreferenceInitializer {

	public static final String ACE_EDITOR_PORT = "aceEditorPort";
	public static final String VALIDATE_JSLINT = "jsLintingRequired";
	public static final String VALIDATE_JSON = "validateJson";

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = JsActivator.getInstance().getPreferenceStore();
		store.setDefault(ACE_EDITOR_PORT, 23900);
		store.setDefault(VALIDATE_JSON, false);
		store.setDefault(VALIDATE_JSLINT, false);
	}
}
