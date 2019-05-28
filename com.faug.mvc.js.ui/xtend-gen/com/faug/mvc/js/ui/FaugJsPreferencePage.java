package com.faug.mvc.js.ui;

import com.faug.mvc.js.ui.FaugJsPreferences;
import com.faug.mvc.js.ui.internal.JsActivator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

@SuppressWarnings("all")
public class FaugJsPreferencePage extends LanguageRootPreferencePage {
  @Override
  public void init(final IWorkbench workbench) {
    this.setPreferenceStore(JsActivator.getInstance().getPreferenceStore());
  }
  
  @Override
  public void createFieldEditors() {
    Composite _fieldEditorParent = this.getFieldEditorParent();
    IntegerFieldEditor _integerFieldEditor = new IntegerFieldEditor(FaugJsPreferences.ACE_EDITOR_PORT, "Ace Editor Port", _fieldEditorParent);
    this.addField(_integerFieldEditor);
    Composite _fieldEditorParent_1 = this.getFieldEditorParent();
    BooleanFieldEditor _booleanFieldEditor = new BooleanFieldEditor(FaugJsPreferences.VALIDATE_JSON, "Enable JSON Validation", _fieldEditorParent_1);
    this.addField(_booleanFieldEditor);
    Composite _fieldEditorParent_2 = this.getFieldEditorParent();
    BooleanFieldEditor _booleanFieldEditor_1 = new BooleanFieldEditor(FaugJsPreferences.VALIDATE_JSLINT, "Enable Jslint Validation", _fieldEditorParent_2);
    this.addField(_booleanFieldEditor_1);
  }
}
