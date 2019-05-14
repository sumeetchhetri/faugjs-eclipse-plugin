package com.faug.mvc.js.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import com.faug.mvc.js.services.FaugGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFaugParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_NUMBER", "RULE_BOOLEAN", "RULE_NULL", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "','", "':'", "'['", "']'"
    };
    public static final int RULE_BOOLEAN=6;
    public static final int RULE_STRING=4;
    public static final int RULE_NULL=7;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=8;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_NUMBER=5;
    public static final int RULE_INT=9;
    public static final int RULE_ML_COMMENT=10;

    // delegates
    // delegators


        public InternalFaugParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFaugParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFaugParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFaug.g"; }


    	private FaugGrammarAccess grammarAccess;

    	public void setGrammarAccess(FaugGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleJSONValue"
    // InternalFaug.g:53:1: entryRuleJSONValue : ruleJSONValue EOF ;
    public final void entryRuleJSONValue() throws RecognitionException {
        try {
            // InternalFaug.g:54:1: ( ruleJSONValue EOF )
            // InternalFaug.g:55:1: ruleJSONValue EOF
            {
             before(grammarAccess.getJSONValueRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONValue();

            state._fsp--;

             after(grammarAccess.getJSONValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONValue"


    // $ANTLR start "ruleJSONValue"
    // InternalFaug.g:62:1: ruleJSONValue : ( ( rule__JSONValue__Alternatives ) ) ;
    public final void ruleJSONValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:66:2: ( ( ( rule__JSONValue__Alternatives ) ) )
            // InternalFaug.g:67:2: ( ( rule__JSONValue__Alternatives ) )
            {
            // InternalFaug.g:67:2: ( ( rule__JSONValue__Alternatives ) )
            // InternalFaug.g:68:3: ( rule__JSONValue__Alternatives )
            {
             before(grammarAccess.getJSONValueAccess().getAlternatives()); 
            // InternalFaug.g:69:3: ( rule__JSONValue__Alternatives )
            // InternalFaug.g:69:4: rule__JSONValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JSONValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJSONValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONValue"


    // $ANTLR start "entryRuleJSONObject"
    // InternalFaug.g:78:1: entryRuleJSONObject : ruleJSONObject EOF ;
    public final void entryRuleJSONObject() throws RecognitionException {
        try {
            // InternalFaug.g:79:1: ( ruleJSONObject EOF )
            // InternalFaug.g:80:1: ruleJSONObject EOF
            {
             before(grammarAccess.getJSONObjectRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONObject();

            state._fsp--;

             after(grammarAccess.getJSONObjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONObject"


    // $ANTLR start "ruleJSONObject"
    // InternalFaug.g:87:1: ruleJSONObject : ( ( rule__JSONObject__Group__0 ) ) ;
    public final void ruleJSONObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:91:2: ( ( ( rule__JSONObject__Group__0 ) ) )
            // InternalFaug.g:92:2: ( ( rule__JSONObject__Group__0 ) )
            {
            // InternalFaug.g:92:2: ( ( rule__JSONObject__Group__0 ) )
            // InternalFaug.g:93:3: ( rule__JSONObject__Group__0 )
            {
             before(grammarAccess.getJSONObjectAccess().getGroup()); 
            // InternalFaug.g:94:3: ( rule__JSONObject__Group__0 )
            // InternalFaug.g:94:4: rule__JSONObject__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONObjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONObject"


    // $ANTLR start "entryRuleJSONPair"
    // InternalFaug.g:103:1: entryRuleJSONPair : ruleJSONPair EOF ;
    public final void entryRuleJSONPair() throws RecognitionException {
        try {
            // InternalFaug.g:104:1: ( ruleJSONPair EOF )
            // InternalFaug.g:105:1: ruleJSONPair EOF
            {
             before(grammarAccess.getJSONPairRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONPair();

            state._fsp--;

             after(grammarAccess.getJSONPairRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONPair"


    // $ANTLR start "ruleJSONPair"
    // InternalFaug.g:112:1: ruleJSONPair : ( ( rule__JSONPair__Group__0 ) ) ;
    public final void ruleJSONPair() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:116:2: ( ( ( rule__JSONPair__Group__0 ) ) )
            // InternalFaug.g:117:2: ( ( rule__JSONPair__Group__0 ) )
            {
            // InternalFaug.g:117:2: ( ( rule__JSONPair__Group__0 ) )
            // InternalFaug.g:118:3: ( rule__JSONPair__Group__0 )
            {
             before(grammarAccess.getJSONPairAccess().getGroup()); 
            // InternalFaug.g:119:3: ( rule__JSONPair__Group__0 )
            // InternalFaug.g:119:4: rule__JSONPair__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONPair__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONPairAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONPair"


    // $ANTLR start "entryRuleJSONArray"
    // InternalFaug.g:128:1: entryRuleJSONArray : ruleJSONArray EOF ;
    public final void entryRuleJSONArray() throws RecognitionException {
        try {
            // InternalFaug.g:129:1: ( ruleJSONArray EOF )
            // InternalFaug.g:130:1: ruleJSONArray EOF
            {
             before(grammarAccess.getJSONArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONArray();

            state._fsp--;

             after(grammarAccess.getJSONArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONArray"


    // $ANTLR start "ruleJSONArray"
    // InternalFaug.g:137:1: ruleJSONArray : ( ( rule__JSONArray__Group__0 ) ) ;
    public final void ruleJSONArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:141:2: ( ( ( rule__JSONArray__Group__0 ) ) )
            // InternalFaug.g:142:2: ( ( rule__JSONArray__Group__0 ) )
            {
            // InternalFaug.g:142:2: ( ( rule__JSONArray__Group__0 ) )
            // InternalFaug.g:143:3: ( rule__JSONArray__Group__0 )
            {
             before(grammarAccess.getJSONArrayAccess().getGroup()); 
            // InternalFaug.g:144:3: ( rule__JSONArray__Group__0 )
            // InternalFaug.g:144:4: rule__JSONArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONArray"


    // $ANTLR start "entryRuleJSONString"
    // InternalFaug.g:153:1: entryRuleJSONString : ruleJSONString EOF ;
    public final void entryRuleJSONString() throws RecognitionException {
        try {
            // InternalFaug.g:154:1: ( ruleJSONString EOF )
            // InternalFaug.g:155:1: ruleJSONString EOF
            {
             before(grammarAccess.getJSONStringRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONString();

            state._fsp--;

             after(grammarAccess.getJSONStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONString"


    // $ANTLR start "ruleJSONString"
    // InternalFaug.g:162:1: ruleJSONString : ( ( rule__JSONString__Group__0 ) ) ;
    public final void ruleJSONString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:166:2: ( ( ( rule__JSONString__Group__0 ) ) )
            // InternalFaug.g:167:2: ( ( rule__JSONString__Group__0 ) )
            {
            // InternalFaug.g:167:2: ( ( rule__JSONString__Group__0 ) )
            // InternalFaug.g:168:3: ( rule__JSONString__Group__0 )
            {
             before(grammarAccess.getJSONStringAccess().getGroup()); 
            // InternalFaug.g:169:3: ( rule__JSONString__Group__0 )
            // InternalFaug.g:169:4: rule__JSONString__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONString__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONStringAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONString"


    // $ANTLR start "entryRuleJSONNumber"
    // InternalFaug.g:178:1: entryRuleJSONNumber : ruleJSONNumber EOF ;
    public final void entryRuleJSONNumber() throws RecognitionException {
        try {
            // InternalFaug.g:179:1: ( ruleJSONNumber EOF )
            // InternalFaug.g:180:1: ruleJSONNumber EOF
            {
             before(grammarAccess.getJSONNumberRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONNumber();

            state._fsp--;

             after(grammarAccess.getJSONNumberRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONNumber"


    // $ANTLR start "ruleJSONNumber"
    // InternalFaug.g:187:1: ruleJSONNumber : ( ( rule__JSONNumber__Group__0 ) ) ;
    public final void ruleJSONNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:191:2: ( ( ( rule__JSONNumber__Group__0 ) ) )
            // InternalFaug.g:192:2: ( ( rule__JSONNumber__Group__0 ) )
            {
            // InternalFaug.g:192:2: ( ( rule__JSONNumber__Group__0 ) )
            // InternalFaug.g:193:3: ( rule__JSONNumber__Group__0 )
            {
             before(grammarAccess.getJSONNumberAccess().getGroup()); 
            // InternalFaug.g:194:3: ( rule__JSONNumber__Group__0 )
            // InternalFaug.g:194:4: rule__JSONNumber__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONNumber__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONNumberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONNumber"


    // $ANTLR start "entryRuleJSONBoolean"
    // InternalFaug.g:203:1: entryRuleJSONBoolean : ruleJSONBoolean EOF ;
    public final void entryRuleJSONBoolean() throws RecognitionException {
        try {
            // InternalFaug.g:204:1: ( ruleJSONBoolean EOF )
            // InternalFaug.g:205:1: ruleJSONBoolean EOF
            {
             before(grammarAccess.getJSONBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONBoolean();

            state._fsp--;

             after(grammarAccess.getJSONBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONBoolean"


    // $ANTLR start "ruleJSONBoolean"
    // InternalFaug.g:212:1: ruleJSONBoolean : ( ( rule__JSONBoolean__Group__0 ) ) ;
    public final void ruleJSONBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:216:2: ( ( ( rule__JSONBoolean__Group__0 ) ) )
            // InternalFaug.g:217:2: ( ( rule__JSONBoolean__Group__0 ) )
            {
            // InternalFaug.g:217:2: ( ( rule__JSONBoolean__Group__0 ) )
            // InternalFaug.g:218:3: ( rule__JSONBoolean__Group__0 )
            {
             before(grammarAccess.getJSONBooleanAccess().getGroup()); 
            // InternalFaug.g:219:3: ( rule__JSONBoolean__Group__0 )
            // InternalFaug.g:219:4: rule__JSONBoolean__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONBoolean__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONBooleanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONBoolean"


    // $ANTLR start "entryRuleJSONNull"
    // InternalFaug.g:228:1: entryRuleJSONNull : ruleJSONNull EOF ;
    public final void entryRuleJSONNull() throws RecognitionException {
        try {
            // InternalFaug.g:229:1: ( ruleJSONNull EOF )
            // InternalFaug.g:230:1: ruleJSONNull EOF
            {
             before(grammarAccess.getJSONNullRule()); 
            pushFollow(FOLLOW_1);
            ruleJSONNull();

            state._fsp--;

             after(grammarAccess.getJSONNullRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJSONNull"


    // $ANTLR start "ruleJSONNull"
    // InternalFaug.g:237:1: ruleJSONNull : ( ( rule__JSONNull__Group__0 ) ) ;
    public final void ruleJSONNull() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:241:2: ( ( ( rule__JSONNull__Group__0 ) ) )
            // InternalFaug.g:242:2: ( ( rule__JSONNull__Group__0 ) )
            {
            // InternalFaug.g:242:2: ( ( rule__JSONNull__Group__0 ) )
            // InternalFaug.g:243:3: ( rule__JSONNull__Group__0 )
            {
             before(grammarAccess.getJSONNullAccess().getGroup()); 
            // InternalFaug.g:244:3: ( rule__JSONNull__Group__0 )
            // InternalFaug.g:244:4: rule__JSONNull__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JSONNull__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJSONNullAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJSONNull"


    // $ANTLR start "rule__JSONValue__Alternatives"
    // InternalFaug.g:252:1: rule__JSONValue__Alternatives : ( ( ( rule__JSONValue__ValueAssignment_0 ) ) | ( ( rule__JSONValue__ValueAssignment_1 ) ) | ( ( rule__JSONValue__ValueAssignment_2 ) ) | ( ( rule__JSONValue__ValueAssignment_3 ) ) | ( ( rule__JSONValue__ValueAssignment_4 ) ) | ( ( rule__JSONValue__ValueAssignment_5 ) ) );
    public final void rule__JSONValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:256:1: ( ( ( rule__JSONValue__ValueAssignment_0 ) ) | ( ( rule__JSONValue__ValueAssignment_1 ) ) | ( ( rule__JSONValue__ValueAssignment_2 ) ) | ( ( rule__JSONValue__ValueAssignment_3 ) ) | ( ( rule__JSONValue__ValueAssignment_4 ) ) | ( ( rule__JSONValue__ValueAssignment_5 ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                alt1=3;
                }
                break;
            case RULE_NUMBER:
                {
                alt1=4;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt1=5;
                }
                break;
            case RULE_NULL:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalFaug.g:257:2: ( ( rule__JSONValue__ValueAssignment_0 ) )
                    {
                    // InternalFaug.g:257:2: ( ( rule__JSONValue__ValueAssignment_0 ) )
                    // InternalFaug.g:258:3: ( rule__JSONValue__ValueAssignment_0 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_0()); 
                    // InternalFaug.g:259:3: ( rule__JSONValue__ValueAssignment_0 )
                    // InternalFaug.g:259:4: rule__JSONValue__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFaug.g:263:2: ( ( rule__JSONValue__ValueAssignment_1 ) )
                    {
                    // InternalFaug.g:263:2: ( ( rule__JSONValue__ValueAssignment_1 ) )
                    // InternalFaug.g:264:3: ( rule__JSONValue__ValueAssignment_1 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_1()); 
                    // InternalFaug.g:265:3: ( rule__JSONValue__ValueAssignment_1 )
                    // InternalFaug.g:265:4: rule__JSONValue__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFaug.g:269:2: ( ( rule__JSONValue__ValueAssignment_2 ) )
                    {
                    // InternalFaug.g:269:2: ( ( rule__JSONValue__ValueAssignment_2 ) )
                    // InternalFaug.g:270:3: ( rule__JSONValue__ValueAssignment_2 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_2()); 
                    // InternalFaug.g:271:3: ( rule__JSONValue__ValueAssignment_2 )
                    // InternalFaug.g:271:4: rule__JSONValue__ValueAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalFaug.g:275:2: ( ( rule__JSONValue__ValueAssignment_3 ) )
                    {
                    // InternalFaug.g:275:2: ( ( rule__JSONValue__ValueAssignment_3 ) )
                    // InternalFaug.g:276:3: ( rule__JSONValue__ValueAssignment_3 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_3()); 
                    // InternalFaug.g:277:3: ( rule__JSONValue__ValueAssignment_3 )
                    // InternalFaug.g:277:4: rule__JSONValue__ValueAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalFaug.g:281:2: ( ( rule__JSONValue__ValueAssignment_4 ) )
                    {
                    // InternalFaug.g:281:2: ( ( rule__JSONValue__ValueAssignment_4 ) )
                    // InternalFaug.g:282:3: ( rule__JSONValue__ValueAssignment_4 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_4()); 
                    // InternalFaug.g:283:3: ( rule__JSONValue__ValueAssignment_4 )
                    // InternalFaug.g:283:4: rule__JSONValue__ValueAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalFaug.g:287:2: ( ( rule__JSONValue__ValueAssignment_5 ) )
                    {
                    // InternalFaug.g:287:2: ( ( rule__JSONValue__ValueAssignment_5 ) )
                    // InternalFaug.g:288:3: ( rule__JSONValue__ValueAssignment_5 )
                    {
                     before(grammarAccess.getJSONValueAccess().getValueAssignment_5()); 
                    // InternalFaug.g:289:3: ( rule__JSONValue__ValueAssignment_5 )
                    // InternalFaug.g:289:4: rule__JSONValue__ValueAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONValue__ValueAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getJSONValueAccess().getValueAssignment_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__Alternatives"


    // $ANTLR start "rule__JSONObject__Group__0"
    // InternalFaug.g:297:1: rule__JSONObject__Group__0 : rule__JSONObject__Group__0__Impl rule__JSONObject__Group__1 ;
    public final void rule__JSONObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:301:1: ( rule__JSONObject__Group__0__Impl rule__JSONObject__Group__1 )
            // InternalFaug.g:302:2: rule__JSONObject__Group__0__Impl rule__JSONObject__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__JSONObject__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONObject__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__0"


    // $ANTLR start "rule__JSONObject__Group__0__Impl"
    // InternalFaug.g:309:1: rule__JSONObject__Group__0__Impl : ( '{' ) ;
    public final void rule__JSONObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:313:1: ( ( '{' ) )
            // InternalFaug.g:314:1: ( '{' )
            {
            // InternalFaug.g:314:1: ( '{' )
            // InternalFaug.g:315:2: '{'
            {
             before(grammarAccess.getJSONObjectAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getJSONObjectAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__0__Impl"


    // $ANTLR start "rule__JSONObject__Group__1"
    // InternalFaug.g:324:1: rule__JSONObject__Group__1 : rule__JSONObject__Group__1__Impl rule__JSONObject__Group__2 ;
    public final void rule__JSONObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:328:1: ( rule__JSONObject__Group__1__Impl rule__JSONObject__Group__2 )
            // InternalFaug.g:329:2: rule__JSONObject__Group__1__Impl rule__JSONObject__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__JSONObject__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONObject__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__1"


    // $ANTLR start "rule__JSONObject__Group__1__Impl"
    // InternalFaug.g:336:1: rule__JSONObject__Group__1__Impl : ( () ) ;
    public final void rule__JSONObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:340:1: ( ( () ) )
            // InternalFaug.g:341:1: ( () )
            {
            // InternalFaug.g:341:1: ( () )
            // InternalFaug.g:342:2: ()
            {
             before(grammarAccess.getJSONObjectAccess().getJSONObjectAction_1()); 
            // InternalFaug.g:343:2: ()
            // InternalFaug.g:343:3: 
            {
            }

             after(grammarAccess.getJSONObjectAccess().getJSONObjectAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__1__Impl"


    // $ANTLR start "rule__JSONObject__Group__2"
    // InternalFaug.g:351:1: rule__JSONObject__Group__2 : rule__JSONObject__Group__2__Impl rule__JSONObject__Group__3 ;
    public final void rule__JSONObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:355:1: ( rule__JSONObject__Group__2__Impl rule__JSONObject__Group__3 )
            // InternalFaug.g:356:2: rule__JSONObject__Group__2__Impl rule__JSONObject__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__JSONObject__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONObject__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__2"


    // $ANTLR start "rule__JSONObject__Group__2__Impl"
    // InternalFaug.g:363:1: rule__JSONObject__Group__2__Impl : ( ( rule__JSONObject__Group_2__0 )? ) ;
    public final void rule__JSONObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:367:1: ( ( ( rule__JSONObject__Group_2__0 )? ) )
            // InternalFaug.g:368:1: ( ( rule__JSONObject__Group_2__0 )? )
            {
            // InternalFaug.g:368:1: ( ( rule__JSONObject__Group_2__0 )? )
            // InternalFaug.g:369:2: ( rule__JSONObject__Group_2__0 )?
            {
             before(grammarAccess.getJSONObjectAccess().getGroup_2()); 
            // InternalFaug.g:370:2: ( rule__JSONObject__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalFaug.g:370:3: rule__JSONObject__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONObject__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJSONObjectAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__2__Impl"


    // $ANTLR start "rule__JSONObject__Group__3"
    // InternalFaug.g:378:1: rule__JSONObject__Group__3 : rule__JSONObject__Group__3__Impl ;
    public final void rule__JSONObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:382:1: ( rule__JSONObject__Group__3__Impl )
            // InternalFaug.g:383:2: rule__JSONObject__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__3"


    // $ANTLR start "rule__JSONObject__Group__3__Impl"
    // InternalFaug.g:389:1: rule__JSONObject__Group__3__Impl : ( '}' ) ;
    public final void rule__JSONObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:393:1: ( ( '}' ) )
            // InternalFaug.g:394:1: ( '}' )
            {
            // InternalFaug.g:394:1: ( '}' )
            // InternalFaug.g:395:2: '}'
            {
             before(grammarAccess.getJSONObjectAccess().getRightCurlyBracketKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getJSONObjectAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group__3__Impl"


    // $ANTLR start "rule__JSONObject__Group_2__0"
    // InternalFaug.g:405:1: rule__JSONObject__Group_2__0 : rule__JSONObject__Group_2__0__Impl rule__JSONObject__Group_2__1 ;
    public final void rule__JSONObject__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:409:1: ( rule__JSONObject__Group_2__0__Impl rule__JSONObject__Group_2__1 )
            // InternalFaug.g:410:2: rule__JSONObject__Group_2__0__Impl rule__JSONObject__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__JSONObject__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONObject__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2__0"


    // $ANTLR start "rule__JSONObject__Group_2__0__Impl"
    // InternalFaug.g:417:1: rule__JSONObject__Group_2__0__Impl : ( ( rule__JSONObject__PairsAssignment_2_0 ) ) ;
    public final void rule__JSONObject__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:421:1: ( ( ( rule__JSONObject__PairsAssignment_2_0 ) ) )
            // InternalFaug.g:422:1: ( ( rule__JSONObject__PairsAssignment_2_0 ) )
            {
            // InternalFaug.g:422:1: ( ( rule__JSONObject__PairsAssignment_2_0 ) )
            // InternalFaug.g:423:2: ( rule__JSONObject__PairsAssignment_2_0 )
            {
             before(grammarAccess.getJSONObjectAccess().getPairsAssignment_2_0()); 
            // InternalFaug.g:424:2: ( rule__JSONObject__PairsAssignment_2_0 )
            // InternalFaug.g:424:3: rule__JSONObject__PairsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__PairsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getJSONObjectAccess().getPairsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2__0__Impl"


    // $ANTLR start "rule__JSONObject__Group_2__1"
    // InternalFaug.g:432:1: rule__JSONObject__Group_2__1 : rule__JSONObject__Group_2__1__Impl ;
    public final void rule__JSONObject__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:436:1: ( rule__JSONObject__Group_2__1__Impl )
            // InternalFaug.g:437:2: rule__JSONObject__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2__1"


    // $ANTLR start "rule__JSONObject__Group_2__1__Impl"
    // InternalFaug.g:443:1: rule__JSONObject__Group_2__1__Impl : ( ( rule__JSONObject__Group_2_1__0 )* ) ;
    public final void rule__JSONObject__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:447:1: ( ( ( rule__JSONObject__Group_2_1__0 )* ) )
            // InternalFaug.g:448:1: ( ( rule__JSONObject__Group_2_1__0 )* )
            {
            // InternalFaug.g:448:1: ( ( rule__JSONObject__Group_2_1__0 )* )
            // InternalFaug.g:449:2: ( rule__JSONObject__Group_2_1__0 )*
            {
             before(grammarAccess.getJSONObjectAccess().getGroup_2_1()); 
            // InternalFaug.g:450:2: ( rule__JSONObject__Group_2_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFaug.g:450:3: rule__JSONObject__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__JSONObject__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getJSONObjectAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2__1__Impl"


    // $ANTLR start "rule__JSONObject__Group_2_1__0"
    // InternalFaug.g:459:1: rule__JSONObject__Group_2_1__0 : rule__JSONObject__Group_2_1__0__Impl rule__JSONObject__Group_2_1__1 ;
    public final void rule__JSONObject__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:463:1: ( rule__JSONObject__Group_2_1__0__Impl rule__JSONObject__Group_2_1__1 )
            // InternalFaug.g:464:2: rule__JSONObject__Group_2_1__0__Impl rule__JSONObject__Group_2_1__1
            {
            pushFollow(FOLLOW_6);
            rule__JSONObject__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONObject__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2_1__0"


    // $ANTLR start "rule__JSONObject__Group_2_1__0__Impl"
    // InternalFaug.g:471:1: rule__JSONObject__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__JSONObject__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:475:1: ( ( ',' ) )
            // InternalFaug.g:476:1: ( ',' )
            {
            // InternalFaug.g:476:1: ( ',' )
            // InternalFaug.g:477:2: ','
            {
             before(grammarAccess.getJSONObjectAccess().getCommaKeyword_2_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getJSONObjectAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2_1__0__Impl"


    // $ANTLR start "rule__JSONObject__Group_2_1__1"
    // InternalFaug.g:486:1: rule__JSONObject__Group_2_1__1 : rule__JSONObject__Group_2_1__1__Impl ;
    public final void rule__JSONObject__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:490:1: ( rule__JSONObject__Group_2_1__1__Impl )
            // InternalFaug.g:491:2: rule__JSONObject__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2_1__1"


    // $ANTLR start "rule__JSONObject__Group_2_1__1__Impl"
    // InternalFaug.g:497:1: rule__JSONObject__Group_2_1__1__Impl : ( ( rule__JSONObject__PairsAssignment_2_1_1 ) ) ;
    public final void rule__JSONObject__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:501:1: ( ( ( rule__JSONObject__PairsAssignment_2_1_1 ) ) )
            // InternalFaug.g:502:1: ( ( rule__JSONObject__PairsAssignment_2_1_1 ) )
            {
            // InternalFaug.g:502:1: ( ( rule__JSONObject__PairsAssignment_2_1_1 ) )
            // InternalFaug.g:503:2: ( rule__JSONObject__PairsAssignment_2_1_1 )
            {
             before(grammarAccess.getJSONObjectAccess().getPairsAssignment_2_1_1()); 
            // InternalFaug.g:504:2: ( rule__JSONObject__PairsAssignment_2_1_1 )
            // InternalFaug.g:504:3: rule__JSONObject__PairsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONObject__PairsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONObjectAccess().getPairsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__Group_2_1__1__Impl"


    // $ANTLR start "rule__JSONPair__Group__0"
    // InternalFaug.g:513:1: rule__JSONPair__Group__0 : rule__JSONPair__Group__0__Impl rule__JSONPair__Group__1 ;
    public final void rule__JSONPair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:517:1: ( rule__JSONPair__Group__0__Impl rule__JSONPair__Group__1 )
            // InternalFaug.g:518:2: rule__JSONPair__Group__0__Impl rule__JSONPair__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__JSONPair__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONPair__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__0"


    // $ANTLR start "rule__JSONPair__Group__0__Impl"
    // InternalFaug.g:525:1: rule__JSONPair__Group__0__Impl : ( ( rule__JSONPair__KeyAssignment_0 ) ) ;
    public final void rule__JSONPair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:529:1: ( ( ( rule__JSONPair__KeyAssignment_0 ) ) )
            // InternalFaug.g:530:1: ( ( rule__JSONPair__KeyAssignment_0 ) )
            {
            // InternalFaug.g:530:1: ( ( rule__JSONPair__KeyAssignment_0 ) )
            // InternalFaug.g:531:2: ( rule__JSONPair__KeyAssignment_0 )
            {
             before(grammarAccess.getJSONPairAccess().getKeyAssignment_0()); 
            // InternalFaug.g:532:2: ( rule__JSONPair__KeyAssignment_0 )
            // InternalFaug.g:532:3: rule__JSONPair__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JSONPair__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJSONPairAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__0__Impl"


    // $ANTLR start "rule__JSONPair__Group__1"
    // InternalFaug.g:540:1: rule__JSONPair__Group__1 : rule__JSONPair__Group__1__Impl rule__JSONPair__Group__2 ;
    public final void rule__JSONPair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:544:1: ( rule__JSONPair__Group__1__Impl rule__JSONPair__Group__2 )
            // InternalFaug.g:545:2: rule__JSONPair__Group__1__Impl rule__JSONPair__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__JSONPair__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONPair__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__1"


    // $ANTLR start "rule__JSONPair__Group__1__Impl"
    // InternalFaug.g:552:1: rule__JSONPair__Group__1__Impl : ( ':' ) ;
    public final void rule__JSONPair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:556:1: ( ( ':' ) )
            // InternalFaug.g:557:1: ( ':' )
            {
            // InternalFaug.g:557:1: ( ':' )
            // InternalFaug.g:558:2: ':'
            {
             before(grammarAccess.getJSONPairAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getJSONPairAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__1__Impl"


    // $ANTLR start "rule__JSONPair__Group__2"
    // InternalFaug.g:567:1: rule__JSONPair__Group__2 : rule__JSONPair__Group__2__Impl ;
    public final void rule__JSONPair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:571:1: ( rule__JSONPair__Group__2__Impl )
            // InternalFaug.g:572:2: rule__JSONPair__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONPair__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__2"


    // $ANTLR start "rule__JSONPair__Group__2__Impl"
    // InternalFaug.g:578:1: rule__JSONPair__Group__2__Impl : ( ( rule__JSONPair__ValueAssignment_2 ) ) ;
    public final void rule__JSONPair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:582:1: ( ( ( rule__JSONPair__ValueAssignment_2 ) ) )
            // InternalFaug.g:583:1: ( ( rule__JSONPair__ValueAssignment_2 ) )
            {
            // InternalFaug.g:583:1: ( ( rule__JSONPair__ValueAssignment_2 ) )
            // InternalFaug.g:584:2: ( rule__JSONPair__ValueAssignment_2 )
            {
             before(grammarAccess.getJSONPairAccess().getValueAssignment_2()); 
            // InternalFaug.g:585:2: ( rule__JSONPair__ValueAssignment_2 )
            // InternalFaug.g:585:3: rule__JSONPair__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JSONPair__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJSONPairAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__Group__2__Impl"


    // $ANTLR start "rule__JSONArray__Group__0"
    // InternalFaug.g:594:1: rule__JSONArray__Group__0 : rule__JSONArray__Group__0__Impl rule__JSONArray__Group__1 ;
    public final void rule__JSONArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:598:1: ( rule__JSONArray__Group__0__Impl rule__JSONArray__Group__1 )
            // InternalFaug.g:599:2: rule__JSONArray__Group__0__Impl rule__JSONArray__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__JSONArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONArray__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__0"


    // $ANTLR start "rule__JSONArray__Group__0__Impl"
    // InternalFaug.g:606:1: rule__JSONArray__Group__0__Impl : ( '[' ) ;
    public final void rule__JSONArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:610:1: ( ( '[' ) )
            // InternalFaug.g:611:1: ( '[' )
            {
            // InternalFaug.g:611:1: ( '[' )
            // InternalFaug.g:612:2: '['
            {
             before(grammarAccess.getJSONArrayAccess().getLeftSquareBracketKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getJSONArrayAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__0__Impl"


    // $ANTLR start "rule__JSONArray__Group__1"
    // InternalFaug.g:621:1: rule__JSONArray__Group__1 : rule__JSONArray__Group__1__Impl rule__JSONArray__Group__2 ;
    public final void rule__JSONArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:625:1: ( rule__JSONArray__Group__1__Impl rule__JSONArray__Group__2 )
            // InternalFaug.g:626:2: rule__JSONArray__Group__1__Impl rule__JSONArray__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__JSONArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONArray__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__1"


    // $ANTLR start "rule__JSONArray__Group__1__Impl"
    // InternalFaug.g:633:1: rule__JSONArray__Group__1__Impl : ( () ) ;
    public final void rule__JSONArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:637:1: ( ( () ) )
            // InternalFaug.g:638:1: ( () )
            {
            // InternalFaug.g:638:1: ( () )
            // InternalFaug.g:639:2: ()
            {
             before(grammarAccess.getJSONArrayAccess().getJSONArrayAction_1()); 
            // InternalFaug.g:640:2: ()
            // InternalFaug.g:640:3: 
            {
            }

             after(grammarAccess.getJSONArrayAccess().getJSONArrayAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__1__Impl"


    // $ANTLR start "rule__JSONArray__Group__2"
    // InternalFaug.g:648:1: rule__JSONArray__Group__2 : rule__JSONArray__Group__2__Impl rule__JSONArray__Group__3 ;
    public final void rule__JSONArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:652:1: ( rule__JSONArray__Group__2__Impl rule__JSONArray__Group__3 )
            // InternalFaug.g:653:2: rule__JSONArray__Group__2__Impl rule__JSONArray__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__JSONArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONArray__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__2"


    // $ANTLR start "rule__JSONArray__Group__2__Impl"
    // InternalFaug.g:660:1: rule__JSONArray__Group__2__Impl : ( ( rule__JSONArray__Group_2__0 )? ) ;
    public final void rule__JSONArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:664:1: ( ( ( rule__JSONArray__Group_2__0 )? ) )
            // InternalFaug.g:665:1: ( ( rule__JSONArray__Group_2__0 )? )
            {
            // InternalFaug.g:665:1: ( ( rule__JSONArray__Group_2__0 )? )
            // InternalFaug.g:666:2: ( rule__JSONArray__Group_2__0 )?
            {
             before(grammarAccess.getJSONArrayAccess().getGroup_2()); 
            // InternalFaug.g:667:2: ( rule__JSONArray__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_NULL)||LA4_0==14||LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFaug.g:667:3: rule__JSONArray__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__JSONArray__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJSONArrayAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__2__Impl"


    // $ANTLR start "rule__JSONArray__Group__3"
    // InternalFaug.g:675:1: rule__JSONArray__Group__3 : rule__JSONArray__Group__3__Impl ;
    public final void rule__JSONArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:679:1: ( rule__JSONArray__Group__3__Impl )
            // InternalFaug.g:680:2: rule__JSONArray__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__3"


    // $ANTLR start "rule__JSONArray__Group__3__Impl"
    // InternalFaug.g:686:1: rule__JSONArray__Group__3__Impl : ( ']' ) ;
    public final void rule__JSONArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:690:1: ( ( ']' ) )
            // InternalFaug.g:691:1: ( ']' )
            {
            // InternalFaug.g:691:1: ( ']' )
            // InternalFaug.g:692:2: ']'
            {
             before(grammarAccess.getJSONArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getJSONArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group__3__Impl"


    // $ANTLR start "rule__JSONArray__Group_2__0"
    // InternalFaug.g:702:1: rule__JSONArray__Group_2__0 : rule__JSONArray__Group_2__0__Impl rule__JSONArray__Group_2__1 ;
    public final void rule__JSONArray__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:706:1: ( rule__JSONArray__Group_2__0__Impl rule__JSONArray__Group_2__1 )
            // InternalFaug.g:707:2: rule__JSONArray__Group_2__0__Impl rule__JSONArray__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__JSONArray__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONArray__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2__0"


    // $ANTLR start "rule__JSONArray__Group_2__0__Impl"
    // InternalFaug.g:714:1: rule__JSONArray__Group_2__0__Impl : ( ( rule__JSONArray__ValuesAssignment_2_0 ) ) ;
    public final void rule__JSONArray__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:718:1: ( ( ( rule__JSONArray__ValuesAssignment_2_0 ) ) )
            // InternalFaug.g:719:1: ( ( rule__JSONArray__ValuesAssignment_2_0 ) )
            {
            // InternalFaug.g:719:1: ( ( rule__JSONArray__ValuesAssignment_2_0 ) )
            // InternalFaug.g:720:2: ( rule__JSONArray__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getJSONArrayAccess().getValuesAssignment_2_0()); 
            // InternalFaug.g:721:2: ( rule__JSONArray__ValuesAssignment_2_0 )
            // InternalFaug.g:721:3: rule__JSONArray__ValuesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__ValuesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getJSONArrayAccess().getValuesAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2__0__Impl"


    // $ANTLR start "rule__JSONArray__Group_2__1"
    // InternalFaug.g:729:1: rule__JSONArray__Group_2__1 : rule__JSONArray__Group_2__1__Impl ;
    public final void rule__JSONArray__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:733:1: ( rule__JSONArray__Group_2__1__Impl )
            // InternalFaug.g:734:2: rule__JSONArray__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2__1"


    // $ANTLR start "rule__JSONArray__Group_2__1__Impl"
    // InternalFaug.g:740:1: rule__JSONArray__Group_2__1__Impl : ( ( rule__JSONArray__Group_2_1__0 )* ) ;
    public final void rule__JSONArray__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:744:1: ( ( ( rule__JSONArray__Group_2_1__0 )* ) )
            // InternalFaug.g:745:1: ( ( rule__JSONArray__Group_2_1__0 )* )
            {
            // InternalFaug.g:745:1: ( ( rule__JSONArray__Group_2_1__0 )* )
            // InternalFaug.g:746:2: ( rule__JSONArray__Group_2_1__0 )*
            {
             before(grammarAccess.getJSONArrayAccess().getGroup_2_1()); 
            // InternalFaug.g:747:2: ( rule__JSONArray__Group_2_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFaug.g:747:3: rule__JSONArray__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__JSONArray__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getJSONArrayAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2__1__Impl"


    // $ANTLR start "rule__JSONArray__Group_2_1__0"
    // InternalFaug.g:756:1: rule__JSONArray__Group_2_1__0 : rule__JSONArray__Group_2_1__0__Impl rule__JSONArray__Group_2_1__1 ;
    public final void rule__JSONArray__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:760:1: ( rule__JSONArray__Group_2_1__0__Impl rule__JSONArray__Group_2_1__1 )
            // InternalFaug.g:761:2: rule__JSONArray__Group_2_1__0__Impl rule__JSONArray__Group_2_1__1
            {
            pushFollow(FOLLOW_8);
            rule__JSONArray__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONArray__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2_1__0"


    // $ANTLR start "rule__JSONArray__Group_2_1__0__Impl"
    // InternalFaug.g:768:1: rule__JSONArray__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__JSONArray__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:772:1: ( ( ',' ) )
            // InternalFaug.g:773:1: ( ',' )
            {
            // InternalFaug.g:773:1: ( ',' )
            // InternalFaug.g:774:2: ','
            {
             before(grammarAccess.getJSONArrayAccess().getCommaKeyword_2_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getJSONArrayAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2_1__0__Impl"


    // $ANTLR start "rule__JSONArray__Group_2_1__1"
    // InternalFaug.g:783:1: rule__JSONArray__Group_2_1__1 : rule__JSONArray__Group_2_1__1__Impl ;
    public final void rule__JSONArray__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:787:1: ( rule__JSONArray__Group_2_1__1__Impl )
            // InternalFaug.g:788:2: rule__JSONArray__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2_1__1"


    // $ANTLR start "rule__JSONArray__Group_2_1__1__Impl"
    // InternalFaug.g:794:1: rule__JSONArray__Group_2_1__1__Impl : ( ( rule__JSONArray__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__JSONArray__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:798:1: ( ( ( rule__JSONArray__ValuesAssignment_2_1_1 ) ) )
            // InternalFaug.g:799:1: ( ( rule__JSONArray__ValuesAssignment_2_1_1 ) )
            {
            // InternalFaug.g:799:1: ( ( rule__JSONArray__ValuesAssignment_2_1_1 ) )
            // InternalFaug.g:800:2: ( rule__JSONArray__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getJSONArrayAccess().getValuesAssignment_2_1_1()); 
            // InternalFaug.g:801:2: ( rule__JSONArray__ValuesAssignment_2_1_1 )
            // InternalFaug.g:801:3: rule__JSONArray__ValuesAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONArray__ValuesAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONArrayAccess().getValuesAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__Group_2_1__1__Impl"


    // $ANTLR start "rule__JSONString__Group__0"
    // InternalFaug.g:810:1: rule__JSONString__Group__0 : rule__JSONString__Group__0__Impl rule__JSONString__Group__1 ;
    public final void rule__JSONString__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:814:1: ( rule__JSONString__Group__0__Impl rule__JSONString__Group__1 )
            // InternalFaug.g:815:2: rule__JSONString__Group__0__Impl rule__JSONString__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__JSONString__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONString__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONString__Group__0"


    // $ANTLR start "rule__JSONString__Group__0__Impl"
    // InternalFaug.g:822:1: rule__JSONString__Group__0__Impl : ( () ) ;
    public final void rule__JSONString__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:826:1: ( ( () ) )
            // InternalFaug.g:827:1: ( () )
            {
            // InternalFaug.g:827:1: ( () )
            // InternalFaug.g:828:2: ()
            {
             before(grammarAccess.getJSONStringAccess().getJSONStringAction_0()); 
            // InternalFaug.g:829:2: ()
            // InternalFaug.g:829:3: 
            {
            }

             after(grammarAccess.getJSONStringAccess().getJSONStringAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONString__Group__0__Impl"


    // $ANTLR start "rule__JSONString__Group__1"
    // InternalFaug.g:837:1: rule__JSONString__Group__1 : rule__JSONString__Group__1__Impl ;
    public final void rule__JSONString__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:841:1: ( rule__JSONString__Group__1__Impl )
            // InternalFaug.g:842:2: rule__JSONString__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONString__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONString__Group__1"


    // $ANTLR start "rule__JSONString__Group__1__Impl"
    // InternalFaug.g:848:1: rule__JSONString__Group__1__Impl : ( ( rule__JSONString__ValueAssignment_1 ) ) ;
    public final void rule__JSONString__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:852:1: ( ( ( rule__JSONString__ValueAssignment_1 ) ) )
            // InternalFaug.g:853:1: ( ( rule__JSONString__ValueAssignment_1 ) )
            {
            // InternalFaug.g:853:1: ( ( rule__JSONString__ValueAssignment_1 ) )
            // InternalFaug.g:854:2: ( rule__JSONString__ValueAssignment_1 )
            {
             before(grammarAccess.getJSONStringAccess().getValueAssignment_1()); 
            // InternalFaug.g:855:2: ( rule__JSONString__ValueAssignment_1 )
            // InternalFaug.g:855:3: rule__JSONString__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONString__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONStringAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONString__Group__1__Impl"


    // $ANTLR start "rule__JSONNumber__Group__0"
    // InternalFaug.g:864:1: rule__JSONNumber__Group__0 : rule__JSONNumber__Group__0__Impl rule__JSONNumber__Group__1 ;
    public final void rule__JSONNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:868:1: ( rule__JSONNumber__Group__0__Impl rule__JSONNumber__Group__1 )
            // InternalFaug.g:869:2: rule__JSONNumber__Group__0__Impl rule__JSONNumber__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__JSONNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONNumber__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNumber__Group__0"


    // $ANTLR start "rule__JSONNumber__Group__0__Impl"
    // InternalFaug.g:876:1: rule__JSONNumber__Group__0__Impl : ( () ) ;
    public final void rule__JSONNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:880:1: ( ( () ) )
            // InternalFaug.g:881:1: ( () )
            {
            // InternalFaug.g:881:1: ( () )
            // InternalFaug.g:882:2: ()
            {
             before(grammarAccess.getJSONNumberAccess().getJSONNumberAction_0()); 
            // InternalFaug.g:883:2: ()
            // InternalFaug.g:883:3: 
            {
            }

             after(grammarAccess.getJSONNumberAccess().getJSONNumberAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNumber__Group__0__Impl"


    // $ANTLR start "rule__JSONNumber__Group__1"
    // InternalFaug.g:891:1: rule__JSONNumber__Group__1 : rule__JSONNumber__Group__1__Impl ;
    public final void rule__JSONNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:895:1: ( rule__JSONNumber__Group__1__Impl )
            // InternalFaug.g:896:2: rule__JSONNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONNumber__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNumber__Group__1"


    // $ANTLR start "rule__JSONNumber__Group__1__Impl"
    // InternalFaug.g:902:1: rule__JSONNumber__Group__1__Impl : ( ( rule__JSONNumber__ValueAssignment_1 ) ) ;
    public final void rule__JSONNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:906:1: ( ( ( rule__JSONNumber__ValueAssignment_1 ) ) )
            // InternalFaug.g:907:1: ( ( rule__JSONNumber__ValueAssignment_1 ) )
            {
            // InternalFaug.g:907:1: ( ( rule__JSONNumber__ValueAssignment_1 ) )
            // InternalFaug.g:908:2: ( rule__JSONNumber__ValueAssignment_1 )
            {
             before(grammarAccess.getJSONNumberAccess().getValueAssignment_1()); 
            // InternalFaug.g:909:2: ( rule__JSONNumber__ValueAssignment_1 )
            // InternalFaug.g:909:3: rule__JSONNumber__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONNumber__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONNumberAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNumber__Group__1__Impl"


    // $ANTLR start "rule__JSONBoolean__Group__0"
    // InternalFaug.g:918:1: rule__JSONBoolean__Group__0 : rule__JSONBoolean__Group__0__Impl rule__JSONBoolean__Group__1 ;
    public final void rule__JSONBoolean__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:922:1: ( rule__JSONBoolean__Group__0__Impl rule__JSONBoolean__Group__1 )
            // InternalFaug.g:923:2: rule__JSONBoolean__Group__0__Impl rule__JSONBoolean__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__JSONBoolean__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONBoolean__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONBoolean__Group__0"


    // $ANTLR start "rule__JSONBoolean__Group__0__Impl"
    // InternalFaug.g:930:1: rule__JSONBoolean__Group__0__Impl : ( () ) ;
    public final void rule__JSONBoolean__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:934:1: ( ( () ) )
            // InternalFaug.g:935:1: ( () )
            {
            // InternalFaug.g:935:1: ( () )
            // InternalFaug.g:936:2: ()
            {
             before(grammarAccess.getJSONBooleanAccess().getJSONBooleanAction_0()); 
            // InternalFaug.g:937:2: ()
            // InternalFaug.g:937:3: 
            {
            }

             after(grammarAccess.getJSONBooleanAccess().getJSONBooleanAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONBoolean__Group__0__Impl"


    // $ANTLR start "rule__JSONBoolean__Group__1"
    // InternalFaug.g:945:1: rule__JSONBoolean__Group__1 : rule__JSONBoolean__Group__1__Impl ;
    public final void rule__JSONBoolean__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:949:1: ( rule__JSONBoolean__Group__1__Impl )
            // InternalFaug.g:950:2: rule__JSONBoolean__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONBoolean__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONBoolean__Group__1"


    // $ANTLR start "rule__JSONBoolean__Group__1__Impl"
    // InternalFaug.g:956:1: rule__JSONBoolean__Group__1__Impl : ( ( rule__JSONBoolean__ValueAssignment_1 ) ) ;
    public final void rule__JSONBoolean__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:960:1: ( ( ( rule__JSONBoolean__ValueAssignment_1 ) ) )
            // InternalFaug.g:961:1: ( ( rule__JSONBoolean__ValueAssignment_1 ) )
            {
            // InternalFaug.g:961:1: ( ( rule__JSONBoolean__ValueAssignment_1 ) )
            // InternalFaug.g:962:2: ( rule__JSONBoolean__ValueAssignment_1 )
            {
             before(grammarAccess.getJSONBooleanAccess().getValueAssignment_1()); 
            // InternalFaug.g:963:2: ( rule__JSONBoolean__ValueAssignment_1 )
            // InternalFaug.g:963:3: rule__JSONBoolean__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONBoolean__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONBooleanAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONBoolean__Group__1__Impl"


    // $ANTLR start "rule__JSONNull__Group__0"
    // InternalFaug.g:972:1: rule__JSONNull__Group__0 : rule__JSONNull__Group__0__Impl rule__JSONNull__Group__1 ;
    public final void rule__JSONNull__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:976:1: ( rule__JSONNull__Group__0__Impl rule__JSONNull__Group__1 )
            // InternalFaug.g:977:2: rule__JSONNull__Group__0__Impl rule__JSONNull__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__JSONNull__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JSONNull__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNull__Group__0"


    // $ANTLR start "rule__JSONNull__Group__0__Impl"
    // InternalFaug.g:984:1: rule__JSONNull__Group__0__Impl : ( () ) ;
    public final void rule__JSONNull__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:988:1: ( ( () ) )
            // InternalFaug.g:989:1: ( () )
            {
            // InternalFaug.g:989:1: ( () )
            // InternalFaug.g:990:2: ()
            {
             before(grammarAccess.getJSONNullAccess().getJSONNullAction_0()); 
            // InternalFaug.g:991:2: ()
            // InternalFaug.g:991:3: 
            {
            }

             after(grammarAccess.getJSONNullAccess().getJSONNullAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNull__Group__0__Impl"


    // $ANTLR start "rule__JSONNull__Group__1"
    // InternalFaug.g:999:1: rule__JSONNull__Group__1 : rule__JSONNull__Group__1__Impl ;
    public final void rule__JSONNull__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1003:1: ( rule__JSONNull__Group__1__Impl )
            // InternalFaug.g:1004:2: rule__JSONNull__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JSONNull__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNull__Group__1"


    // $ANTLR start "rule__JSONNull__Group__1__Impl"
    // InternalFaug.g:1010:1: rule__JSONNull__Group__1__Impl : ( ( rule__JSONNull__ValueAssignment_1 ) ) ;
    public final void rule__JSONNull__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1014:1: ( ( ( rule__JSONNull__ValueAssignment_1 ) ) )
            // InternalFaug.g:1015:1: ( ( rule__JSONNull__ValueAssignment_1 ) )
            {
            // InternalFaug.g:1015:1: ( ( rule__JSONNull__ValueAssignment_1 ) )
            // InternalFaug.g:1016:2: ( rule__JSONNull__ValueAssignment_1 )
            {
             before(grammarAccess.getJSONNullAccess().getValueAssignment_1()); 
            // InternalFaug.g:1017:2: ( rule__JSONNull__ValueAssignment_1 )
            // InternalFaug.g:1017:3: rule__JSONNull__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JSONNull__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJSONNullAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNull__Group__1__Impl"


    // $ANTLR start "rule__JSONValue__ValueAssignment_0"
    // InternalFaug.g:1026:1: rule__JSONValue__ValueAssignment_0 : ( ruleJSONObject ) ;
    public final void rule__JSONValue__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1030:1: ( ( ruleJSONObject ) )
            // InternalFaug.g:1031:2: ( ruleJSONObject )
            {
            // InternalFaug.g:1031:2: ( ruleJSONObject )
            // InternalFaug.g:1032:3: ruleJSONObject
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONObjectParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONObject();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONObjectParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_0"


    // $ANTLR start "rule__JSONValue__ValueAssignment_1"
    // InternalFaug.g:1041:1: rule__JSONValue__ValueAssignment_1 : ( ruleJSONArray ) ;
    public final void rule__JSONValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1045:1: ( ( ruleJSONArray ) )
            // InternalFaug.g:1046:2: ( ruleJSONArray )
            {
            // InternalFaug.g:1046:2: ( ruleJSONArray )
            // InternalFaug.g:1047:3: ruleJSONArray
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONArrayParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONArray();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONArrayParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_1"


    // $ANTLR start "rule__JSONValue__ValueAssignment_2"
    // InternalFaug.g:1056:1: rule__JSONValue__ValueAssignment_2 : ( ruleJSONString ) ;
    public final void rule__JSONValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1060:1: ( ( ruleJSONString ) )
            // InternalFaug.g:1061:2: ( ruleJSONString )
            {
            // InternalFaug.g:1061:2: ( ruleJSONString )
            // InternalFaug.g:1062:3: ruleJSONString
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONString();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_2"


    // $ANTLR start "rule__JSONValue__ValueAssignment_3"
    // InternalFaug.g:1071:1: rule__JSONValue__ValueAssignment_3 : ( ruleJSONNumber ) ;
    public final void rule__JSONValue__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1075:1: ( ( ruleJSONNumber ) )
            // InternalFaug.g:1076:2: ( ruleJSONNumber )
            {
            // InternalFaug.g:1076:2: ( ruleJSONNumber )
            // InternalFaug.g:1077:3: ruleJSONNumber
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONNumberParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONNumber();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONNumberParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_3"


    // $ANTLR start "rule__JSONValue__ValueAssignment_4"
    // InternalFaug.g:1086:1: rule__JSONValue__ValueAssignment_4 : ( ruleJSONBoolean ) ;
    public final void rule__JSONValue__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1090:1: ( ( ruleJSONBoolean ) )
            // InternalFaug.g:1091:2: ( ruleJSONBoolean )
            {
            // InternalFaug.g:1091:2: ( ruleJSONBoolean )
            // InternalFaug.g:1092:3: ruleJSONBoolean
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONBooleanParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONBoolean();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONBooleanParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_4"


    // $ANTLR start "rule__JSONValue__ValueAssignment_5"
    // InternalFaug.g:1101:1: rule__JSONValue__ValueAssignment_5 : ( ruleJSONNull ) ;
    public final void rule__JSONValue__ValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1105:1: ( ( ruleJSONNull ) )
            // InternalFaug.g:1106:2: ( ruleJSONNull )
            {
            // InternalFaug.g:1106:2: ( ruleJSONNull )
            // InternalFaug.g:1107:3: ruleJSONNull
            {
             before(grammarAccess.getJSONValueAccess().getValueJSONNullParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONNull();

            state._fsp--;

             after(grammarAccess.getJSONValueAccess().getValueJSONNullParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONValue__ValueAssignment_5"


    // $ANTLR start "rule__JSONObject__PairsAssignment_2_0"
    // InternalFaug.g:1116:1: rule__JSONObject__PairsAssignment_2_0 : ( ruleJSONPair ) ;
    public final void rule__JSONObject__PairsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1120:1: ( ( ruleJSONPair ) )
            // InternalFaug.g:1121:2: ( ruleJSONPair )
            {
            // InternalFaug.g:1121:2: ( ruleJSONPair )
            // InternalFaug.g:1122:3: ruleJSONPair
            {
             before(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONPair();

            state._fsp--;

             after(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__PairsAssignment_2_0"


    // $ANTLR start "rule__JSONObject__PairsAssignment_2_1_1"
    // InternalFaug.g:1131:1: rule__JSONObject__PairsAssignment_2_1_1 : ( ruleJSONPair ) ;
    public final void rule__JSONObject__PairsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1135:1: ( ( ruleJSONPair ) )
            // InternalFaug.g:1136:2: ( ruleJSONPair )
            {
            // InternalFaug.g:1136:2: ( ruleJSONPair )
            // InternalFaug.g:1137:3: ruleJSONPair
            {
             before(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONPair();

            state._fsp--;

             after(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONObject__PairsAssignment_2_1_1"


    // $ANTLR start "rule__JSONPair__KeyAssignment_0"
    // InternalFaug.g:1146:1: rule__JSONPair__KeyAssignment_0 : ( ruleJSONString ) ;
    public final void rule__JSONPair__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1150:1: ( ( ruleJSONString ) )
            // InternalFaug.g:1151:2: ( ruleJSONString )
            {
            // InternalFaug.g:1151:2: ( ruleJSONString )
            // InternalFaug.g:1152:3: ruleJSONString
            {
             before(grammarAccess.getJSONPairAccess().getKeyJSONStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONString();

            state._fsp--;

             after(grammarAccess.getJSONPairAccess().getKeyJSONStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__KeyAssignment_0"


    // $ANTLR start "rule__JSONPair__ValueAssignment_2"
    // InternalFaug.g:1161:1: rule__JSONPair__ValueAssignment_2 : ( ruleJSONValue ) ;
    public final void rule__JSONPair__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1165:1: ( ( ruleJSONValue ) )
            // InternalFaug.g:1166:2: ( ruleJSONValue )
            {
            // InternalFaug.g:1166:2: ( ruleJSONValue )
            // InternalFaug.g:1167:3: ruleJSONValue
            {
             before(grammarAccess.getJSONPairAccess().getValueJSONValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONValue();

            state._fsp--;

             after(grammarAccess.getJSONPairAccess().getValueJSONValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONPair__ValueAssignment_2"


    // $ANTLR start "rule__JSONArray__ValuesAssignment_2_0"
    // InternalFaug.g:1176:1: rule__JSONArray__ValuesAssignment_2_0 : ( ruleJSONValue ) ;
    public final void rule__JSONArray__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1180:1: ( ( ruleJSONValue ) )
            // InternalFaug.g:1181:2: ( ruleJSONValue )
            {
            // InternalFaug.g:1181:2: ( ruleJSONValue )
            // InternalFaug.g:1182:3: ruleJSONValue
            {
             before(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONValue();

            state._fsp--;

             after(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__ValuesAssignment_2_0"


    // $ANTLR start "rule__JSONArray__ValuesAssignment_2_1_1"
    // InternalFaug.g:1191:1: rule__JSONArray__ValuesAssignment_2_1_1 : ( ruleJSONValue ) ;
    public final void rule__JSONArray__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1195:1: ( ( ruleJSONValue ) )
            // InternalFaug.g:1196:2: ( ruleJSONValue )
            {
            // InternalFaug.g:1196:2: ( ruleJSONValue )
            // InternalFaug.g:1197:3: ruleJSONValue
            {
             before(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJSONValue();

            state._fsp--;

             after(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONArray__ValuesAssignment_2_1_1"


    // $ANTLR start "rule__JSONString__ValueAssignment_1"
    // InternalFaug.g:1206:1: rule__JSONString__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JSONString__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1210:1: ( ( RULE_STRING ) )
            // InternalFaug.g:1211:2: ( RULE_STRING )
            {
            // InternalFaug.g:1211:2: ( RULE_STRING )
            // InternalFaug.g:1212:3: RULE_STRING
            {
             before(grammarAccess.getJSONStringAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getJSONStringAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONString__ValueAssignment_1"


    // $ANTLR start "rule__JSONNumber__ValueAssignment_1"
    // InternalFaug.g:1221:1: rule__JSONNumber__ValueAssignment_1 : ( RULE_NUMBER ) ;
    public final void rule__JSONNumber__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1225:1: ( ( RULE_NUMBER ) )
            // InternalFaug.g:1226:2: ( RULE_NUMBER )
            {
            // InternalFaug.g:1226:2: ( RULE_NUMBER )
            // InternalFaug.g:1227:3: RULE_NUMBER
            {
             before(grammarAccess.getJSONNumberAccess().getValueNUMBERTerminalRuleCall_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
             after(grammarAccess.getJSONNumberAccess().getValueNUMBERTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNumber__ValueAssignment_1"


    // $ANTLR start "rule__JSONBoolean__ValueAssignment_1"
    // InternalFaug.g:1236:1: rule__JSONBoolean__ValueAssignment_1 : ( RULE_BOOLEAN ) ;
    public final void rule__JSONBoolean__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1240:1: ( ( RULE_BOOLEAN ) )
            // InternalFaug.g:1241:2: ( RULE_BOOLEAN )
            {
            // InternalFaug.g:1241:2: ( RULE_BOOLEAN )
            // InternalFaug.g:1242:3: RULE_BOOLEAN
            {
             before(grammarAccess.getJSONBooleanAccess().getValueBOOLEANTerminalRuleCall_1_0()); 
            match(input,RULE_BOOLEAN,FOLLOW_2); 
             after(grammarAccess.getJSONBooleanAccess().getValueBOOLEANTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONBoolean__ValueAssignment_1"


    // $ANTLR start "rule__JSONNull__ValueAssignment_1"
    // InternalFaug.g:1251:1: rule__JSONNull__ValueAssignment_1 : ( RULE_NULL ) ;
    public final void rule__JSONNull__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFaug.g:1255:1: ( ( RULE_NULL ) )
            // InternalFaug.g:1256:2: ( RULE_NULL )
            {
            // InternalFaug.g:1256:2: ( RULE_NULL )
            // InternalFaug.g:1257:3: RULE_NULL
            {
             before(grammarAccess.getJSONNullAccess().getValueNULLTerminalRuleCall_1_0()); 
            match(input,RULE_NULL,FOLLOW_2); 
             after(grammarAccess.getJSONNullAccess().getValueNULLTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JSONNull__ValueAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000440F0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000C40F0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});

}