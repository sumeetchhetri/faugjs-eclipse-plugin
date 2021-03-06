/*
 * generated by Xtext 2.17.1
 */
package com.faug.mvc.js.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class FaugGrammarAccess extends AbstractGrammarElementFinder {
	
	public class JSONValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cValueJSONObjectParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cValueJSONArrayParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Assignment cValueAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cValueJSONStringParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		private final Assignment cValueAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final RuleCall cValueJSONNumberParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Assignment cValueAssignment_4 = (Assignment)cAlternatives.eContents().get(4);
		private final RuleCall cValueJSONBooleanParserRuleCall_4_0 = (RuleCall)cValueAssignment_4.eContents().get(0);
		private final Assignment cValueAssignment_5 = (Assignment)cAlternatives.eContents().get(5);
		private final RuleCall cValueJSONNullParserRuleCall_5_0 = (RuleCall)cValueAssignment_5.eContents().get(0);
		
		//JSONValue:
		//	value=JSONObject | value=JSONArray | value=JSONString | value=JSONNumber | value=JSONBoolean | value=JSONNull;
		@Override public ParserRule getRule() { return rule; }
		
		//value=JSONObject | value=JSONArray | value=JSONString | value=JSONNumber | value=JSONBoolean | value=JSONNull
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//value=JSONObject
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }
		
		//JSONObject
		public RuleCall getValueJSONObjectParserRuleCall_0_0() { return cValueJSONObjectParserRuleCall_0_0; }
		
		//value=JSONArray
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//JSONArray
		public RuleCall getValueJSONArrayParserRuleCall_1_0() { return cValueJSONArrayParserRuleCall_1_0; }
		
		//value=JSONString
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }
		
		//JSONString
		public RuleCall getValueJSONStringParserRuleCall_2_0() { return cValueJSONStringParserRuleCall_2_0; }
		
		//value=JSONNumber
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//JSONNumber
		public RuleCall getValueJSONNumberParserRuleCall_3_0() { return cValueJSONNumberParserRuleCall_3_0; }
		
		//value=JSONBoolean
		public Assignment getValueAssignment_4() { return cValueAssignment_4; }
		
		//JSONBoolean
		public RuleCall getValueJSONBooleanParserRuleCall_4_0() { return cValueJSONBooleanParserRuleCall_4_0; }
		
		//value=JSONNull
		public Assignment getValueAssignment_5() { return cValueAssignment_5; }
		
		//JSONNull
		public RuleCall getValueJSONNullParserRuleCall_5_0() { return cValueJSONNullParserRuleCall_5_0; }
	}
	public class JSONObjectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONObject");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cJSONObjectAction_1 = (Action)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cPairsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cPairsJSONPairParserRuleCall_2_0_0 = (RuleCall)cPairsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cPairsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cPairsJSONPairParserRuleCall_2_1_1_0 = (RuleCall)cPairsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//JSONObject:
		//	'{' {JSONObject} (pairs+=JSONPair (',' pairs+=JSONPair)*)? '}';
		@Override public ParserRule getRule() { return rule; }
		
		//'{' {JSONObject} (pairs+=JSONPair (',' pairs+=JSONPair)*)? '}'
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//{JSONObject}
		public Action getJSONObjectAction_1() { return cJSONObjectAction_1; }
		
		//(pairs+=JSONPair (',' pairs+=JSONPair)*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//pairs+=JSONPair
		public Assignment getPairsAssignment_2_0() { return cPairsAssignment_2_0; }
		
		//JSONPair
		public RuleCall getPairsJSONPairParserRuleCall_2_0_0() { return cPairsJSONPairParserRuleCall_2_0_0; }
		
		//(',' pairs+=JSONPair)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//pairs+=JSONPair
		public Assignment getPairsAssignment_2_1_1() { return cPairsAssignment_2_1_1; }
		
		//JSONPair
		public RuleCall getPairsJSONPairParserRuleCall_2_1_1_0() { return cPairsJSONPairParserRuleCall_2_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class JSONPairElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONPair");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cKeyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cKeyJSONStringParserRuleCall_0_0 = (RuleCall)cKeyAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueJSONValueParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//JSONPair:
		//	key=JSONString ':' value=JSONValue;
		@Override public ParserRule getRule() { return rule; }
		
		//key=JSONString ':' value=JSONValue
		public Group getGroup() { return cGroup; }
		
		//key=JSONString
		public Assignment getKeyAssignment_0() { return cKeyAssignment_0; }
		
		//JSONString
		public RuleCall getKeyJSONStringParserRuleCall_0_0() { return cKeyJSONStringParserRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//value=JSONValue
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }
		
		//JSONValue
		public RuleCall getValueJSONValueParserRuleCall_2_0() { return cValueJSONValueParserRuleCall_2_0; }
	}
	public class JSONArrayElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONArray");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cJSONArrayAction_1 = (Action)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cValuesAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cValuesJSONValueParserRuleCall_2_0_0 = (RuleCall)cValuesAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cValuesAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cValuesJSONValueParserRuleCall_2_1_1_0 = (RuleCall)cValuesAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//JSONArray:
		//	'[' {JSONArray} (values+=JSONValue (',' values+=JSONValue)*)? ']';
		@Override public ParserRule getRule() { return rule; }
		
		//'[' {JSONArray} (values+=JSONValue (',' values+=JSONValue)*)? ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//{JSONArray}
		public Action getJSONArrayAction_1() { return cJSONArrayAction_1; }
		
		//(values+=JSONValue (',' values+=JSONValue)*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//values+=JSONValue
		public Assignment getValuesAssignment_2_0() { return cValuesAssignment_2_0; }
		
		//JSONValue
		public RuleCall getValuesJSONValueParserRuleCall_2_0_0() { return cValuesJSONValueParserRuleCall_2_0_0; }
		
		//(',' values+=JSONValue)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//values+=JSONValue
		public Assignment getValuesAssignment_2_1_1() { return cValuesAssignment_2_1_1; }
		
		//JSONValue
		public RuleCall getValuesJSONValueParserRuleCall_2_1_1_0() { return cValuesJSONValueParserRuleCall_2_1_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}
	public class JSONStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONString");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cJSONStringAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//JSONString:
		//	{JSONString} value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//{JSONString} value=STRING
		public Group getGroup() { return cGroup; }
		
		//{JSONString}
		public Action getJSONStringAction_0() { return cJSONStringAction_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class JSONNumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONNumber");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cJSONNumberAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueNUMBERTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//JSONNumber:
		//	{JSONNumber} value=NUMBER;
		@Override public ParserRule getRule() { return rule; }
		
		//{JSONNumber} value=NUMBER
		public Group getGroup() { return cGroup; }
		
		//{JSONNumber}
		public Action getJSONNumberAction_0() { return cJSONNumberAction_0; }
		
		//value=NUMBER
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//NUMBER
		public RuleCall getValueNUMBERTerminalRuleCall_1_0() { return cValueNUMBERTerminalRuleCall_1_0; }
	}
	public class JSONBooleanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONBoolean");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cJSONBooleanAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueBOOLEANTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//JSONBoolean:
		//	{JSONBoolean} value=BOOLEAN;
		@Override public ParserRule getRule() { return rule; }
		
		//{JSONBoolean} value=BOOLEAN
		public Group getGroup() { return cGroup; }
		
		//{JSONBoolean}
		public Action getJSONBooleanAction_0() { return cJSONBooleanAction_0; }
		
		//value=BOOLEAN
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//BOOLEAN
		public RuleCall getValueBOOLEANTerminalRuleCall_1_0() { return cValueBOOLEANTerminalRuleCall_1_0; }
	}
	public class JSONNullElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.JSONNull");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cJSONNullAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueNULLTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//JSONNull:
		//	{JSONNull} value=NULL;
		@Override public ParserRule getRule() { return rule; }
		
		//{JSONNull} value=NULL
		public Group getGroup() { return cGroup; }
		
		//{JSONNull}
		public Action getJSONNullAction_0() { return cJSONNullAction_0; }
		
		//value=NULL
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//NULL
		public RuleCall getValueNULLTerminalRuleCall_1_0() { return cValueNULLTerminalRuleCall_1_0; }
	}
	
	
	private final JSONValueElements pJSONValue;
	private final JSONObjectElements pJSONObject;
	private final JSONPairElements pJSONPair;
	private final JSONArrayElements pJSONArray;
	private final JSONStringElements pJSONString;
	private final JSONNumberElements pJSONNumber;
	private final JSONBooleanElements pJSONBoolean;
	private final JSONNullElements pJSONNull;
	private final TerminalRule tNUMBER;
	private final TerminalRule tBOOLEAN;
	private final TerminalRule tNULL;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public FaugGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pJSONValue = new JSONValueElements();
		this.pJSONObject = new JSONObjectElements();
		this.pJSONPair = new JSONPairElements();
		this.pJSONArray = new JSONArrayElements();
		this.pJSONString = new JSONStringElements();
		this.pJSONNumber = new JSONNumberElements();
		this.pJSONBoolean = new JSONBooleanElements();
		this.pJSONNull = new JSONNullElements();
		this.tNUMBER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.NUMBER");
		this.tBOOLEAN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.BOOLEAN");
		this.tNULL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "com.faug.mvc.js.Faug.NULL");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("com.faug.mvc.js.Faug".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//JSONValue:
	//	value=JSONObject | value=JSONArray | value=JSONString | value=JSONNumber | value=JSONBoolean | value=JSONNull;
	public JSONValueElements getJSONValueAccess() {
		return pJSONValue;
	}
	
	public ParserRule getJSONValueRule() {
		return getJSONValueAccess().getRule();
	}
	
	//JSONObject:
	//	'{' {JSONObject} (pairs+=JSONPair (',' pairs+=JSONPair)*)? '}';
	public JSONObjectElements getJSONObjectAccess() {
		return pJSONObject;
	}
	
	public ParserRule getJSONObjectRule() {
		return getJSONObjectAccess().getRule();
	}
	
	//JSONPair:
	//	key=JSONString ':' value=JSONValue;
	public JSONPairElements getJSONPairAccess() {
		return pJSONPair;
	}
	
	public ParserRule getJSONPairRule() {
		return getJSONPairAccess().getRule();
	}
	
	//JSONArray:
	//	'[' {JSONArray} (values+=JSONValue (',' values+=JSONValue)*)? ']';
	public JSONArrayElements getJSONArrayAccess() {
		return pJSONArray;
	}
	
	public ParserRule getJSONArrayRule() {
		return getJSONArrayAccess().getRule();
	}
	
	//JSONString:
	//	{JSONString} value=STRING;
	public JSONStringElements getJSONStringAccess() {
		return pJSONString;
	}
	
	public ParserRule getJSONStringRule() {
		return getJSONStringAccess().getRule();
	}
	
	//JSONNumber:
	//	{JSONNumber} value=NUMBER;
	public JSONNumberElements getJSONNumberAccess() {
		return pJSONNumber;
	}
	
	public ParserRule getJSONNumberRule() {
		return getJSONNumberAccess().getRule();
	}
	
	//JSONBoolean:
	//	{JSONBoolean} value=BOOLEAN;
	public JSONBooleanElements getJSONBooleanAccess() {
		return pJSONBoolean;
	}
	
	public ParserRule getJSONBooleanRule() {
		return getJSONBooleanAccess().getRule();
	}
	
	//JSONNull:
	//	{JSONNull} value=NULL;
	public JSONNullElements getJSONNullAccess() {
		return pJSONNull;
	}
	
	public ParserRule getJSONNullRule() {
		return getJSONNullAccess().getRule();
	}
	
	//terminal NUMBER:
	//	'-'? '0' | ('1'..'9' '0'..'9'*) ('.' '0'..'9'+)? ('e' | 'E' ('-' | '+')? '0'..'9'+)?;
	public TerminalRule getNUMBERRule() {
		return tNUMBER;
	}
	
	//terminal BOOLEAN:
	//	'true' | 'false';
	public TerminalRule getBOOLEANRule() {
		return tBOOLEAN;
	}
	
	//terminal NULL:
	//	'null';
	public TerminalRule getNULLRule() {
		return tNULL;
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
