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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFaugParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_NUMBER", "RULE_BOOLEAN", "RULE_NULL", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "','", "'}'", "':'", "'['", "']'"
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




    // $ANTLR start "entryRuleJSONValue"
    // InternalFaug.g:64:1: entryRuleJSONValue returns [EObject current=null] : iv_ruleJSONValue= ruleJSONValue EOF ;
    public final EObject entryRuleJSONValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONValue = null;


        try {
            // InternalFaug.g:64:50: (iv_ruleJSONValue= ruleJSONValue EOF )
            // InternalFaug.g:65:2: iv_ruleJSONValue= ruleJSONValue EOF
            {
             newCompositeNode(grammarAccess.getJSONValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONValue=ruleJSONValue();

            state._fsp--;

             current =iv_ruleJSONValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONValue"


    // $ANTLR start "ruleJSONValue"
    // InternalFaug.g:71:1: ruleJSONValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleJSONObject ) ) | ( (lv_value_1_0= ruleJSONArray ) ) | ( (lv_value_2_0= ruleJSONString ) ) | ( (lv_value_3_0= ruleJSONNumber ) ) | ( (lv_value_4_0= ruleJSONBoolean ) ) | ( (lv_value_5_0= ruleJSONNull ) ) ) ;
    public final EObject ruleJSONValue() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;

        EObject lv_value_1_0 = null;

        EObject lv_value_2_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalFaug.g:77:2: ( ( ( (lv_value_0_0= ruleJSONObject ) ) | ( (lv_value_1_0= ruleJSONArray ) ) | ( (lv_value_2_0= ruleJSONString ) ) | ( (lv_value_3_0= ruleJSONNumber ) ) | ( (lv_value_4_0= ruleJSONBoolean ) ) | ( (lv_value_5_0= ruleJSONNull ) ) ) )
            // InternalFaug.g:78:2: ( ( (lv_value_0_0= ruleJSONObject ) ) | ( (lv_value_1_0= ruleJSONArray ) ) | ( (lv_value_2_0= ruleJSONString ) ) | ( (lv_value_3_0= ruleJSONNumber ) ) | ( (lv_value_4_0= ruleJSONBoolean ) ) | ( (lv_value_5_0= ruleJSONNull ) ) )
            {
            // InternalFaug.g:78:2: ( ( (lv_value_0_0= ruleJSONObject ) ) | ( (lv_value_1_0= ruleJSONArray ) ) | ( (lv_value_2_0= ruleJSONString ) ) | ( (lv_value_3_0= ruleJSONNumber ) ) | ( (lv_value_4_0= ruleJSONBoolean ) ) | ( (lv_value_5_0= ruleJSONNull ) ) )
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
                    // InternalFaug.g:79:3: ( (lv_value_0_0= ruleJSONObject ) )
                    {
                    // InternalFaug.g:79:3: ( (lv_value_0_0= ruleJSONObject ) )
                    // InternalFaug.g:80:4: (lv_value_0_0= ruleJSONObject )
                    {
                    // InternalFaug.g:80:4: (lv_value_0_0= ruleJSONObject )
                    // InternalFaug.g:81:5: lv_value_0_0= ruleJSONObject
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONObjectParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleJSONObject();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_0_0,
                    						"com.faug.mvc.js.Faug.JSONObject");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFaug.g:99:3: ( (lv_value_1_0= ruleJSONArray ) )
                    {
                    // InternalFaug.g:99:3: ( (lv_value_1_0= ruleJSONArray ) )
                    // InternalFaug.g:100:4: (lv_value_1_0= ruleJSONArray )
                    {
                    // InternalFaug.g:100:4: (lv_value_1_0= ruleJSONArray )
                    // InternalFaug.g:101:5: lv_value_1_0= ruleJSONArray
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONArrayParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleJSONArray();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_1_0,
                    						"com.faug.mvc.js.Faug.JSONArray");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFaug.g:119:3: ( (lv_value_2_0= ruleJSONString ) )
                    {
                    // InternalFaug.g:119:3: ( (lv_value_2_0= ruleJSONString ) )
                    // InternalFaug.g:120:4: (lv_value_2_0= ruleJSONString )
                    {
                    // InternalFaug.g:120:4: (lv_value_2_0= ruleJSONString )
                    // InternalFaug.g:121:5: lv_value_2_0= ruleJSONString
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONStringParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleJSONString();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_2_0,
                    						"com.faug.mvc.js.Faug.JSONString");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFaug.g:139:3: ( (lv_value_3_0= ruleJSONNumber ) )
                    {
                    // InternalFaug.g:139:3: ( (lv_value_3_0= ruleJSONNumber ) )
                    // InternalFaug.g:140:4: (lv_value_3_0= ruleJSONNumber )
                    {
                    // InternalFaug.g:140:4: (lv_value_3_0= ruleJSONNumber )
                    // InternalFaug.g:141:5: lv_value_3_0= ruleJSONNumber
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONNumberParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleJSONNumber();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_3_0,
                    						"com.faug.mvc.js.Faug.JSONNumber");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFaug.g:159:3: ( (lv_value_4_0= ruleJSONBoolean ) )
                    {
                    // InternalFaug.g:159:3: ( (lv_value_4_0= ruleJSONBoolean ) )
                    // InternalFaug.g:160:4: (lv_value_4_0= ruleJSONBoolean )
                    {
                    // InternalFaug.g:160:4: (lv_value_4_0= ruleJSONBoolean )
                    // InternalFaug.g:161:5: lv_value_4_0= ruleJSONBoolean
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONBooleanParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleJSONBoolean();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_4_0,
                    						"com.faug.mvc.js.Faug.JSONBoolean");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalFaug.g:179:3: ( (lv_value_5_0= ruleJSONNull ) )
                    {
                    // InternalFaug.g:179:3: ( (lv_value_5_0= ruleJSONNull ) )
                    // InternalFaug.g:180:4: (lv_value_5_0= ruleJSONNull )
                    {
                    // InternalFaug.g:180:4: (lv_value_5_0= ruleJSONNull )
                    // InternalFaug.g:181:5: lv_value_5_0= ruleJSONNull
                    {

                    					newCompositeNode(grammarAccess.getJSONValueAccess().getValueJSONNullParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleJSONNull();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJSONValueRule());
                    					}
                    					set(
                    						current,
                    						"value",
                    						lv_value_5_0,
                    						"com.faug.mvc.js.Faug.JSONNull");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONValue"


    // $ANTLR start "entryRuleJSONObject"
    // InternalFaug.g:202:1: entryRuleJSONObject returns [EObject current=null] : iv_ruleJSONObject= ruleJSONObject EOF ;
    public final EObject entryRuleJSONObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONObject = null;


        try {
            // InternalFaug.g:202:51: (iv_ruleJSONObject= ruleJSONObject EOF )
            // InternalFaug.g:203:2: iv_ruleJSONObject= ruleJSONObject EOF
            {
             newCompositeNode(grammarAccess.getJSONObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONObject=ruleJSONObject();

            state._fsp--;

             current =iv_ruleJSONObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONObject"


    // $ANTLR start "ruleJSONObject"
    // InternalFaug.g:209:1: ruleJSONObject returns [EObject current=null] : (otherlv_0= '{' () ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleJSONObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_pairs_2_0 = null;

        EObject lv_pairs_4_0 = null;



        	enterRule();

        try {
            // InternalFaug.g:215:2: ( (otherlv_0= '{' () ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )? otherlv_5= '}' ) )
            // InternalFaug.g:216:2: (otherlv_0= '{' () ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )? otherlv_5= '}' )
            {
            // InternalFaug.g:216:2: (otherlv_0= '{' () ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )? otherlv_5= '}' )
            // InternalFaug.g:217:3: otherlv_0= '{' () ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJSONObjectAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalFaug.g:221:3: ()
            // InternalFaug.g:222:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONObjectAccess().getJSONObjectAction_1(),
            					current);
            			

            }

            // InternalFaug.g:228:3: ( ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFaug.g:229:4: ( (lv_pairs_2_0= ruleJSONPair ) ) (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )*
                    {
                    // InternalFaug.g:229:4: ( (lv_pairs_2_0= ruleJSONPair ) )
                    // InternalFaug.g:230:5: (lv_pairs_2_0= ruleJSONPair )
                    {
                    // InternalFaug.g:230:5: (lv_pairs_2_0= ruleJSONPair )
                    // InternalFaug.g:231:6: lv_pairs_2_0= ruleJSONPair
                    {

                    						newCompositeNode(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_pairs_2_0=ruleJSONPair();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJSONObjectRule());
                    						}
                    						add(
                    							current,
                    							"pairs",
                    							lv_pairs_2_0,
                    							"com.faug.mvc.js.Faug.JSONPair");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalFaug.g:248:4: (otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalFaug.g:249:5: otherlv_3= ',' ( (lv_pairs_4_0= ruleJSONPair ) )
                    	    {
                    	    otherlv_3=(Token)match(input,15,FOLLOW_5); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getJSONObjectAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalFaug.g:253:5: ( (lv_pairs_4_0= ruleJSONPair ) )
                    	    // InternalFaug.g:254:6: (lv_pairs_4_0= ruleJSONPair )
                    	    {
                    	    // InternalFaug.g:254:6: (lv_pairs_4_0= ruleJSONPair )
                    	    // InternalFaug.g:255:7: lv_pairs_4_0= ruleJSONPair
                    	    {

                    	    							newCompositeNode(grammarAccess.getJSONObjectAccess().getPairsJSONPairParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_pairs_4_0=ruleJSONPair();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJSONObjectRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"pairs",
                    	    								lv_pairs_4_0,
                    	    								"com.faug.mvc.js.Faug.JSONPair");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJSONObjectAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONObject"


    // $ANTLR start "entryRuleJSONPair"
    // InternalFaug.g:282:1: entryRuleJSONPair returns [EObject current=null] : iv_ruleJSONPair= ruleJSONPair EOF ;
    public final EObject entryRuleJSONPair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONPair = null;


        try {
            // InternalFaug.g:282:49: (iv_ruleJSONPair= ruleJSONPair EOF )
            // InternalFaug.g:283:2: iv_ruleJSONPair= ruleJSONPair EOF
            {
             newCompositeNode(grammarAccess.getJSONPairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONPair=ruleJSONPair();

            state._fsp--;

             current =iv_ruleJSONPair; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONPair"


    // $ANTLR start "ruleJSONPair"
    // InternalFaug.g:289:1: ruleJSONPair returns [EObject current=null] : ( ( (lv_key_0_0= ruleJSONString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) ) ;
    public final EObject ruleJSONPair() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalFaug.g:295:2: ( ( ( (lv_key_0_0= ruleJSONString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) ) )
            // InternalFaug.g:296:2: ( ( (lv_key_0_0= ruleJSONString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) )
            {
            // InternalFaug.g:296:2: ( ( (lv_key_0_0= ruleJSONString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) ) )
            // InternalFaug.g:297:3: ( (lv_key_0_0= ruleJSONString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJSONValue ) )
            {
            // InternalFaug.g:297:3: ( (lv_key_0_0= ruleJSONString ) )
            // InternalFaug.g:298:4: (lv_key_0_0= ruleJSONString )
            {
            // InternalFaug.g:298:4: (lv_key_0_0= ruleJSONString )
            // InternalFaug.g:299:5: lv_key_0_0= ruleJSONString
            {

            					newCompositeNode(grammarAccess.getJSONPairAccess().getKeyJSONStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_key_0_0=ruleJSONString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJSONPairRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_0_0,
            						"com.faug.mvc.js.Faug.JSONString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getJSONPairAccess().getColonKeyword_1());
            		
            // InternalFaug.g:320:3: ( (lv_value_2_0= ruleJSONValue ) )
            // InternalFaug.g:321:4: (lv_value_2_0= ruleJSONValue )
            {
            // InternalFaug.g:321:4: (lv_value_2_0= ruleJSONValue )
            // InternalFaug.g:322:5: lv_value_2_0= ruleJSONValue
            {

            					newCompositeNode(grammarAccess.getJSONPairAccess().getValueJSONValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleJSONValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJSONPairRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"com.faug.mvc.js.Faug.JSONValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONPair"


    // $ANTLR start "entryRuleJSONArray"
    // InternalFaug.g:343:1: entryRuleJSONArray returns [EObject current=null] : iv_ruleJSONArray= ruleJSONArray EOF ;
    public final EObject entryRuleJSONArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONArray = null;


        try {
            // InternalFaug.g:343:50: (iv_ruleJSONArray= ruleJSONArray EOF )
            // InternalFaug.g:344:2: iv_ruleJSONArray= ruleJSONArray EOF
            {
             newCompositeNode(grammarAccess.getJSONArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONArray=ruleJSONArray();

            state._fsp--;

             current =iv_ruleJSONArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONArray"


    // $ANTLR start "ruleJSONArray"
    // InternalFaug.g:350:1: ruleJSONArray returns [EObject current=null] : (otherlv_0= '[' () ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleJSONArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalFaug.g:356:2: ( (otherlv_0= '[' () ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )? otherlv_5= ']' ) )
            // InternalFaug.g:357:2: (otherlv_0= '[' () ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )? otherlv_5= ']' )
            {
            // InternalFaug.g:357:2: (otherlv_0= '[' () ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )? otherlv_5= ']' )
            // InternalFaug.g:358:3: otherlv_0= '[' () ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getJSONArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalFaug.g:362:3: ()
            // InternalFaug.g:363:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONArrayAccess().getJSONArrayAction_1(),
            					current);
            			

            }

            // InternalFaug.g:369:3: ( ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_NULL)||LA5_0==14||LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFaug.g:370:4: ( (lv_values_2_0= ruleJSONValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )*
                    {
                    // InternalFaug.g:370:4: ( (lv_values_2_0= ruleJSONValue ) )
                    // InternalFaug.g:371:5: (lv_values_2_0= ruleJSONValue )
                    {
                    // InternalFaug.g:371:5: (lv_values_2_0= ruleJSONValue )
                    // InternalFaug.g:372:6: lv_values_2_0= ruleJSONValue
                    {

                    						newCompositeNode(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_values_2_0=ruleJSONValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJSONArrayRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_2_0,
                    							"com.faug.mvc.js.Faug.JSONValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalFaug.g:389:4: (otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalFaug.g:390:5: otherlv_3= ',' ( (lv_values_4_0= ruleJSONValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,15,FOLLOW_7); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getJSONArrayAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalFaug.g:394:5: ( (lv_values_4_0= ruleJSONValue ) )
                    	    // InternalFaug.g:395:6: (lv_values_4_0= ruleJSONValue )
                    	    {
                    	    // InternalFaug.g:395:6: (lv_values_4_0= ruleJSONValue )
                    	    // InternalFaug.g:396:7: lv_values_4_0= ruleJSONValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getJSONArrayAccess().getValuesJSONValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_values_4_0=ruleJSONValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getJSONArrayRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_4_0,
                    	    								"com.faug.mvc.js.Faug.JSONValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJSONArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONArray"


    // $ANTLR start "entryRuleJSONString"
    // InternalFaug.g:423:1: entryRuleJSONString returns [EObject current=null] : iv_ruleJSONString= ruleJSONString EOF ;
    public final EObject entryRuleJSONString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONString = null;


        try {
            // InternalFaug.g:423:51: (iv_ruleJSONString= ruleJSONString EOF )
            // InternalFaug.g:424:2: iv_ruleJSONString= ruleJSONString EOF
            {
             newCompositeNode(grammarAccess.getJSONStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONString=ruleJSONString();

            state._fsp--;

             current =iv_ruleJSONString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONString"


    // $ANTLR start "ruleJSONString"
    // InternalFaug.g:430:1: ruleJSONString returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJSONString() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFaug.g:436:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalFaug.g:437:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalFaug.g:437:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalFaug.g:438:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalFaug.g:438:3: ()
            // InternalFaug.g:439:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONStringAccess().getJSONStringAction_0(),
            					current);
            			

            }

            // InternalFaug.g:445:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalFaug.g:446:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalFaug.g:446:4: (lv_value_1_0= RULE_STRING )
            // InternalFaug.g:447:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getJSONStringAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJSONStringRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONString"


    // $ANTLR start "entryRuleJSONNumber"
    // InternalFaug.g:467:1: entryRuleJSONNumber returns [EObject current=null] : iv_ruleJSONNumber= ruleJSONNumber EOF ;
    public final EObject entryRuleJSONNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONNumber = null;


        try {
            // InternalFaug.g:467:51: (iv_ruleJSONNumber= ruleJSONNumber EOF )
            // InternalFaug.g:468:2: iv_ruleJSONNumber= ruleJSONNumber EOF
            {
             newCompositeNode(grammarAccess.getJSONNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONNumber=ruleJSONNumber();

            state._fsp--;

             current =iv_ruleJSONNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONNumber"


    // $ANTLR start "ruleJSONNumber"
    // InternalFaug.g:474:1: ruleJSONNumber returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleJSONNumber() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFaug.g:480:2: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) )
            // InternalFaug.g:481:2: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            {
            // InternalFaug.g:481:2: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            // InternalFaug.g:482:3: () ( (lv_value_1_0= RULE_NUMBER ) )
            {
            // InternalFaug.g:482:3: ()
            // InternalFaug.g:483:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONNumberAccess().getJSONNumberAction_0(),
            					current);
            			

            }

            // InternalFaug.g:489:3: ( (lv_value_1_0= RULE_NUMBER ) )
            // InternalFaug.g:490:4: (lv_value_1_0= RULE_NUMBER )
            {
            // InternalFaug.g:490:4: (lv_value_1_0= RULE_NUMBER )
            // InternalFaug.g:491:5: lv_value_1_0= RULE_NUMBER
            {
            lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getJSONNumberAccess().getValueNUMBERTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJSONNumberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"com.faug.mvc.js.Faug.NUMBER");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONNumber"


    // $ANTLR start "entryRuleJSONBoolean"
    // InternalFaug.g:511:1: entryRuleJSONBoolean returns [EObject current=null] : iv_ruleJSONBoolean= ruleJSONBoolean EOF ;
    public final EObject entryRuleJSONBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONBoolean = null;


        try {
            // InternalFaug.g:511:52: (iv_ruleJSONBoolean= ruleJSONBoolean EOF )
            // InternalFaug.g:512:2: iv_ruleJSONBoolean= ruleJSONBoolean EOF
            {
             newCompositeNode(grammarAccess.getJSONBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONBoolean=ruleJSONBoolean();

            state._fsp--;

             current =iv_ruleJSONBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONBoolean"


    // $ANTLR start "ruleJSONBoolean"
    // InternalFaug.g:518:1: ruleJSONBoolean returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleJSONBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFaug.g:524:2: ( ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) ) )
            // InternalFaug.g:525:2: ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) )
            {
            // InternalFaug.g:525:2: ( () ( (lv_value_1_0= RULE_BOOLEAN ) ) )
            // InternalFaug.g:526:3: () ( (lv_value_1_0= RULE_BOOLEAN ) )
            {
            // InternalFaug.g:526:3: ()
            // InternalFaug.g:527:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONBooleanAccess().getJSONBooleanAction_0(),
            					current);
            			

            }

            // InternalFaug.g:533:3: ( (lv_value_1_0= RULE_BOOLEAN ) )
            // InternalFaug.g:534:4: (lv_value_1_0= RULE_BOOLEAN )
            {
            // InternalFaug.g:534:4: (lv_value_1_0= RULE_BOOLEAN )
            // InternalFaug.g:535:5: lv_value_1_0= RULE_BOOLEAN
            {
            lv_value_1_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getJSONBooleanAccess().getValueBOOLEANTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJSONBooleanRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"com.faug.mvc.js.Faug.BOOLEAN");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONBoolean"


    // $ANTLR start "entryRuleJSONNull"
    // InternalFaug.g:555:1: entryRuleJSONNull returns [EObject current=null] : iv_ruleJSONNull= ruleJSONNull EOF ;
    public final EObject entryRuleJSONNull() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJSONNull = null;


        try {
            // InternalFaug.g:555:49: (iv_ruleJSONNull= ruleJSONNull EOF )
            // InternalFaug.g:556:2: iv_ruleJSONNull= ruleJSONNull EOF
            {
             newCompositeNode(grammarAccess.getJSONNullRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJSONNull=ruleJSONNull();

            state._fsp--;

             current =iv_ruleJSONNull; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJSONNull"


    // $ANTLR start "ruleJSONNull"
    // InternalFaug.g:562:1: ruleJSONNull returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_NULL ) ) ) ;
    public final EObject ruleJSONNull() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalFaug.g:568:2: ( ( () ( (lv_value_1_0= RULE_NULL ) ) ) )
            // InternalFaug.g:569:2: ( () ( (lv_value_1_0= RULE_NULL ) ) )
            {
            // InternalFaug.g:569:2: ( () ( (lv_value_1_0= RULE_NULL ) ) )
            // InternalFaug.g:570:3: () ( (lv_value_1_0= RULE_NULL ) )
            {
            // InternalFaug.g:570:3: ()
            // InternalFaug.g:571:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJSONNullAccess().getJSONNullAction_0(),
            					current);
            			

            }

            // InternalFaug.g:577:3: ( (lv_value_1_0= RULE_NULL ) )
            // InternalFaug.g:578:4: (lv_value_1_0= RULE_NULL )
            {
            // InternalFaug.g:578:4: (lv_value_1_0= RULE_NULL )
            // InternalFaug.g:579:5: lv_value_1_0= RULE_NULL
            {
            lv_value_1_0=(Token)match(input,RULE_NULL,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getJSONNullAccess().getValueNULLTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJSONNullRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"com.faug.mvc.js.Faug.NULL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJSONNull"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000440F0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000000C40F0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000088000L});

}