/*
 * generated by Xtext 2.17.1
 */
package com.faug.mvc.js.parser.antlr;

import com.faug.mvc.js.parser.antlr.internal.InternalFaugParser;
import com.faug.mvc.js.services.FaugGrammarAccess;
import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class FaugParser extends AbstractAntlrParser {

	@Inject
	private FaugGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalFaugParser createParser(XtextTokenStream stream) {
		return new InternalFaugParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "JSONValue";
	}

	public FaugGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FaugGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
