/*
 * generated by Xtext 2.17.1
 */
grammar InternalFaug;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package com.faug.mvc.js.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package com.faug.mvc.js.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.faug.mvc.js.services.FaugGrammarAccess;

}

@parser::members {

 	private FaugGrammarAccess grammarAccess;

    public InternalFaugParser(TokenStream input, FaugGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "JSONValue";
   	}

   	@Override
   	protected FaugGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleJSONValue
entryRuleJSONValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONValueRule()); }
	iv_ruleJSONValue=ruleJSONValue
	{ $current=$iv_ruleJSONValue.current; }
	EOF;

// Rule JSONValue
ruleJSONValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONObjectParserRuleCall_0_0());
				}
				lv_value_0_0=ruleJSONObject
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"com.faug.mvc.js.Faug.JSONObject");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONArrayParserRuleCall_1_0());
				}
				lv_value_1_0=ruleJSONArray
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"com.faug.mvc.js.Faug.JSONArray");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONStringParserRuleCall_2_0());
				}
				lv_value_2_0=ruleJSONString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"com.faug.mvc.js.Faug.JSONString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONNumberParserRuleCall_3_0());
				}
				lv_value_3_0=ruleJSONNumber
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"com.faug.mvc.js.Faug.JSONNumber");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONBooleanParserRuleCall_4_0());
				}
				lv_value_4_0=ruleJSONBoolean
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_4_0,
						"com.faug.mvc.js.Faug.JSONBoolean");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONNullParserRuleCall_5_0());
				}
				lv_value_5_0=ruleJSONNull
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONValueRule());
					}
					set(
						$current,
						"value",
						lv_value_5_0,
						"com.faug.mvc.js.Faug.JSONNull");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJSONObject
entryRuleJSONObject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONObjectRule()); }
	iv_ruleJSONObject=ruleJSONObject
	{ $current=$iv_ruleJSONObject.current; }
	EOF;

// Rule JSONObject
ruleJSONObject returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='{'
		{
			newLeafNode(otherlv_0, grammarAccess.getJSONObjectAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONObjectAccess().getJSONObjectAction_1(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_0_0());
					}
					lv_pairs_2_0=ruleJSONPair
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJSONObjectRule());
						}
						add(
							$current,
							"pairs",
							lv_pairs_2_0,
							"com.faug.mvc.js.Faug.JSONPair");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getJSONObjectAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_1_1_0());
						}
						lv_pairs_4_0=ruleJSONPair
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJSONObjectRule());
							}
							add(
								$current,
								"pairs",
								lv_pairs_4_0,
								"com.faug.mvc.js.Faug.JSONPair");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getJSONObjectAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleJSONPair
entryRuleJSONPair returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONPairRule()); }
	iv_ruleJSONPair=ruleJSONPair
	{ $current=$iv_ruleJSONPair.current; }
	EOF;

// Rule JSONPair
ruleJSONPair returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONPairAccess().getKeyJSONStringParserRuleCall_0_0());
				}
				lv_key_0_0=ruleJSONString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONPairRule());
					}
					set(
						$current,
						"key",
						lv_key_0_0,
						"com.faug.mvc.js.Faug.JSONString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getJSONPairAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJSONPairAccess().getValueJSONValueParserRuleCall_2_0());
				}
				lv_value_2_0=ruleJSONValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJSONPairRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"com.faug.mvc.js.Faug.JSONValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleJSONArray
entryRuleJSONArray returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONArrayRule()); }
	iv_ruleJSONArray=ruleJSONArray
	{ $current=$iv_ruleJSONArray.current; }
	EOF;

// Rule JSONArray
ruleJSONArray returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getJSONArrayAccess().getLeftSquareBracketKeyword_0());
		}
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONArrayAccess().getJSONArrayAction_1(),
					$current);
			}
		)
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_0_0());
					}
					lv_values_2_0=ruleJSONValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getJSONArrayRule());
						}
						add(
							$current,
							"values",
							lv_values_2_0,
							"com.faug.mvc.js.Faug.JSONValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getJSONArrayAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_1_1_0());
						}
						lv_values_4_0=ruleJSONValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getJSONArrayRule());
							}
							add(
								$current,
								"values",
								lv_values_4_0,
								"com.faug.mvc.js.Faug.JSONValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=']'
		{
			newLeafNode(otherlv_5, grammarAccess.getJSONArrayAccess().getRightSquareBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleJSONString
entryRuleJSONString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONStringRule()); }
	iv_ruleJSONString=ruleJSONString
	{ $current=$iv_ruleJSONString.current; }
	EOF;

// Rule JSONString
ruleJSONString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONStringAccess().getJSONStringAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_STRING
				{
					newLeafNode(lv_value_1_0, grammarAccess.getJSONStringAccess().getValueSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJSONStringRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Entry rule entryRuleJSONNumber
entryRuleJSONNumber returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONNumberRule()); }
	iv_ruleJSONNumber=ruleJSONNumber
	{ $current=$iv_ruleJSONNumber.current; }
	EOF;

// Rule JSONNumber
ruleJSONNumber returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONNumberAccess().getJSONNumberAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_NUMBER
				{
					newLeafNode(lv_value_1_0, grammarAccess.getJSONNumberAccess().getValueNUMBERTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJSONNumberRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"com.faug.mvc.js.Faug.NUMBER");
				}
			)
		)
	)
;

// Entry rule entryRuleJSONBoolean
entryRuleJSONBoolean returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONBooleanRule()); }
	iv_ruleJSONBoolean=ruleJSONBoolean
	{ $current=$iv_ruleJSONBoolean.current; }
	EOF;

// Rule JSONBoolean
ruleJSONBoolean returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONBooleanAccess().getJSONBooleanAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_BOOLEAN
				{
					newLeafNode(lv_value_1_0, grammarAccess.getJSONBooleanAccess().getValueBOOLEANTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJSONBooleanRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"com.faug.mvc.js.Faug.BOOLEAN");
				}
			)
		)
	)
;

// Entry rule entryRuleJSONNull
entryRuleJSONNull returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJSONNullRule()); }
	iv_ruleJSONNull=ruleJSONNull
	{ $current=$iv_ruleJSONNull.current; }
	EOF;

// Rule JSONNull
ruleJSONNull returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getJSONNullAccess().getJSONNullAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_NULL
				{
					newLeafNode(lv_value_1_0, grammarAccess.getJSONNullAccess().getValueNULLTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getJSONNullRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"com.faug.mvc.js.Faug.NULL");
				}
			)
		)
	)
;

RULE_NUMBER : ('-'? '0'|'1'..'9' ('0'..'9')* ('.' ('0'..'9')+)? ('e'|'E' ('-'|'+')? ('0'..'9')+)?);

RULE_BOOLEAN : ('true'|'false');

RULE_NULL : 'null';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
