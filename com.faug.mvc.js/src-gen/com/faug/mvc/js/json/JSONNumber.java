/**
 * generated by Xtext 2.17.1
 */
package com.faug.mvc.js.json;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JSON Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.faug.mvc.js.json.JSONNumber#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.faug.mvc.js.json.JsonPackage#getJSONNumber()
 * @model
 * @generated
 */
public interface JSONNumber extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see com.faug.mvc.js.json.JsonPackage#getJSONNumber_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link com.faug.mvc.js.json.JSONNumber#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // JSONNumber