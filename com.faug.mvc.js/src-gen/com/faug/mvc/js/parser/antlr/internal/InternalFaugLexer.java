package com.faug.mvc.js.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFaugLexer extends Lexer {
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

    public InternalFaugLexer() {;} 
    public InternalFaugLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFaugLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalFaug.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:11:7: ( '{' )
            // InternalFaug.g:11:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:12:7: ( ',' )
            // InternalFaug.g:12:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:13:7: ( '}' )
            // InternalFaug.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:14:7: ( ':' )
            // InternalFaug.g:14:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:15:7: ( '[' )
            // InternalFaug.g:15:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:16:7: ( ']' )
            // InternalFaug.g:16:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:598:13: ( ( ( '-' )? '0' | '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( 'e' | 'E' ( '-' | '+' )? ( '0' .. '9' )+ )? ) )
            // InternalFaug.g:598:15: ( ( '-' )? '0' | '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( 'e' | 'E' ( '-' | '+' )? ( '0' .. '9' )+ )? )
            {
            // InternalFaug.g:598:15: ( ( '-' )? '0' | '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( 'e' | 'E' ( '-' | '+' )? ( '0' .. '9' )+ )? )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='-'||LA8_0=='0') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='1' && LA8_0<='9')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalFaug.g:598:16: ( '-' )? '0'
                    {
                    // InternalFaug.g:598:16: ( '-' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0=='-') ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalFaug.g:598:16: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalFaug.g:598:25: '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( 'e' | 'E' ( '-' | '+' )? ( '0' .. '9' )+ )?
                    {
                    matchRange('1','9'); 
                    // InternalFaug.g:598:34: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalFaug.g:598:35: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // InternalFaug.g:598:46: ( '.' ( '0' .. '9' )+ )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='.') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalFaug.g:598:47: '.' ( '0' .. '9' )+
                            {
                            match('.'); 
                            // InternalFaug.g:598:51: ( '0' .. '9' )+
                            int cnt3=0;
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // InternalFaug.g:598:52: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt3 >= 1 ) break loop3;
                                        EarlyExitException eee =
                                            new EarlyExitException(3, input);
                                        throw eee;
                                }
                                cnt3++;
                            } while (true);


                            }
                            break;

                    }

                    // InternalFaug.g:598:65: ( 'e' | 'E' ( '-' | '+' )? ( '0' .. '9' )+ )?
                    int alt7=3;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='e') ) {
                        alt7=1;
                    }
                    else if ( (LA7_0=='E') ) {
                        alt7=2;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalFaug.g:598:66: 'e'
                            {
                            match('e'); 

                            }
                            break;
                        case 2 :
                            // InternalFaug.g:598:70: 'E' ( '-' | '+' )? ( '0' .. '9' )+
                            {
                            match('E'); 
                            // InternalFaug.g:598:74: ( '-' | '+' )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0=='+'||LA5_0=='-') ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // InternalFaug.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // InternalFaug.g:598:85: ( '0' .. '9' )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // InternalFaug.g:598:86: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt6 >= 1 ) break loop6;
                                        EarlyExitException eee =
                                            new EarlyExitException(6, input);
                                        throw eee;
                                }
                                cnt6++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:600:14: ( ( 'true' | 'false' ) )
            // InternalFaug.g:600:16: ( 'true' | 'false' )
            {
            // InternalFaug.g:600:16: ( 'true' | 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='t') ) {
                alt9=1;
            }
            else if ( (LA9_0=='f') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalFaug.g:600:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalFaug.g:600:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_NULL"
    public final void mRULE_NULL() throws RecognitionException {
        try {
            int _type = RULE_NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:602:11: ( 'null' )
            // InternalFaug.g:602:13: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NULL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:604:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalFaug.g:604:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalFaug.g:604:11: ( '^' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='^') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFaug.g:604:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalFaug.g:604:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFaug.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:606:10: ( ( '0' .. '9' )+ )
            // InternalFaug.g:606:12: ( '0' .. '9' )+
            {
            // InternalFaug.g:606:12: ( '0' .. '9' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFaug.g:606:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:608:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalFaug.g:608:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalFaug.g:608:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalFaug.g:608:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalFaug.g:608:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalFaug.g:608:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFaug.g:608:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalFaug.g:608:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalFaug.g:608:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\\') ) {
                            alt14=1;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalFaug.g:608:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFaug.g:608:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:610:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalFaug.g:610:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalFaug.g:610:24: ( options {greedy=false; } : . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalFaug.g:610:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:612:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalFaug.g:612:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalFaug.g:612:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalFaug.g:612:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalFaug.g:612:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFaug.g:612:41: ( '\\r' )? '\\n'
                    {
                    // InternalFaug.g:612:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalFaug.g:612:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:614:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalFaug.g:614:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalFaug.g:614:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||LA20_0=='\r'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalFaug.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFaug.g:616:16: ( . )
            // InternalFaug.g:616:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalFaug.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_NUMBER | RULE_BOOLEAN | RULE_NULL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt21=16;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // InternalFaug.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalFaug.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalFaug.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalFaug.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalFaug.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalFaug.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalFaug.g:1:46: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 8 :
                // InternalFaug.g:1:58: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 9 :
                // InternalFaug.g:1:71: RULE_NULL
                {
                mRULE_NULL(); 

                }
                break;
            case 10 :
                // InternalFaug.g:1:81: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 11 :
                // InternalFaug.g:1:89: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 12 :
                // InternalFaug.g:1:98: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 13 :
                // InternalFaug.g:1:110: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 14 :
                // InternalFaug.g:1:126: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 15 :
                // InternalFaug.g:1:142: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 16 :
                // InternalFaug.g:1:150: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\7\uffff\1\23\2\32\3\36\1\23\1\uffff\3\23\12\uffff\1\32\1\36\1\uffff\2\36\4\uffff\3\36\1\53\1\36\1\55\1\uffff\1\53\1\uffff";
    static final String DFA21_eofS =
        "\56\uffff";
    static final String DFA21_minS =
        "\1\0\6\uffff\3\60\1\162\1\141\1\165\1\101\1\uffff\2\0\1\52\12\uffff\1\60\1\165\1\uffff\2\154\4\uffff\1\145\1\163\1\154\1\60\1\145\1\60\1\uffff\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\uffff\6\uffff\1\60\2\71\1\162\1\141\1\165\1\172\1\uffff\2\uffff\1\57\12\uffff\1\71\1\165\1\uffff\2\154\4\uffff\1\145\1\163\1\154\1\172\1\145\1\172\1\uffff\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\7\uffff\1\12\3\uffff\1\17\1\20\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\13\2\uffff\1\12\2\uffff\1\14\1\15\1\16\1\17\6\uffff\1\10\1\uffff\1\11";
    static final String DFA21_specialS =
        "\1\0\16\uffff\1\1\1\2\35\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\23\2\22\2\23\1\22\22\23\1\22\1\23\1\17\4\23\1\20\4\23\1\2\1\7\1\23\1\21\1\10\11\11\1\4\6\23\32\16\1\5\1\23\1\6\1\15\1\16\1\23\5\16\1\13\7\16\1\14\5\16\1\12\6\16\1\1\1\23\1\3\uff82\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "\12\33",
            "\12\34",
            "\1\35",
            "\1\37",
            "\1\40",
            "\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\0\41",
            "\0\41",
            "\1\42\4\uffff\1\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\34",
            "\1\45",
            "",
            "\1\46",
            "\1\47",
            "",
            "",
            "",
            "",
            "\1\50",
            "\1\51",
            "\1\52",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\54",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | RULE_NUMBER | RULE_BOOLEAN | RULE_NULL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='{') ) {s = 1;}

                        else if ( (LA21_0==',') ) {s = 2;}

                        else if ( (LA21_0=='}') ) {s = 3;}

                        else if ( (LA21_0==':') ) {s = 4;}

                        else if ( (LA21_0=='[') ) {s = 5;}

                        else if ( (LA21_0==']') ) {s = 6;}

                        else if ( (LA21_0=='-') ) {s = 7;}

                        else if ( (LA21_0=='0') ) {s = 8;}

                        else if ( ((LA21_0>='1' && LA21_0<='9')) ) {s = 9;}

                        else if ( (LA21_0=='t') ) {s = 10;}

                        else if ( (LA21_0=='f') ) {s = 11;}

                        else if ( (LA21_0=='n') ) {s = 12;}

                        else if ( (LA21_0=='^') ) {s = 13;}

                        else if ( ((LA21_0>='A' && LA21_0<='Z')||LA21_0=='_'||(LA21_0>='a' && LA21_0<='e')||(LA21_0>='g' && LA21_0<='m')||(LA21_0>='o' && LA21_0<='s')||(LA21_0>='u' && LA21_0<='z')) ) {s = 14;}

                        else if ( (LA21_0=='\"') ) {s = 15;}

                        else if ( (LA21_0=='\'') ) {s = 16;}

                        else if ( (LA21_0=='/') ) {s = 17;}

                        else if ( ((LA21_0>='\t' && LA21_0<='\n')||LA21_0=='\r'||LA21_0==' ') ) {s = 18;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='!'||(LA21_0>='#' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='+')||LA21_0=='.'||(LA21_0>=';' && LA21_0<='@')||LA21_0=='\\'||LA21_0=='`'||LA21_0=='|'||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_15 = input.LA(1);

                        s = -1;
                        if ( ((LA21_15>='\u0000' && LA21_15<='\uFFFF')) ) {s = 33;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_16 = input.LA(1);

                        s = -1;
                        if ( ((LA21_16>='\u0000' && LA21_16<='\uFFFF')) ) {s = 33;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}