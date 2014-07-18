// $ANTLR 3.5.2 Eval.g 2014-07-17 23:39:58

import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Eval extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'%'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'='", "'if'", "'{'", 
		"'}'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public Eval(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public Eval(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return Eval.tokenNames; }
	@Override public String getGrammarFileName() { return "Eval.g"; }


	    //HashMap memory = new HashMap();
	    HashMap symbols = new HashMap();
	    //public int mod(int a) {
	    //    return a;
	    //}
	    StringBuffer body = new StringBuffer();
	    public void p(Object o) { System.out.print(o); }
	    public void pln(Object o) { System.out.println(o); }
	    public String buildDoc() {
	        StringBuffer doc = new StringBuffer("class TestOut {\n" +
	            "public static void main(String[] args) throws Exception {\n");
	        doc.append(body.toString());
	        doc.append("}\n}\n");
	        return doc.toString();
	    }



	// $ANTLR start "prog"
	// Eval.g:29:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		String stat1 =null;

		try {
			// Eval.g:37:5: ( ( stat )+ )
			// Eval.g:37:7: ( stat )+
			{
			// Eval.g:37:7: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= INT)||LA1_0==8||(LA1_0 >= 11 && LA1_0 <= 16)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Eval.g:37:8: stat
					{
					pushFollow(FOLLOW_stat_in_prog73);
					stat1=stat();
					state._fsp--;

					 body.append(stat1); 
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}


			        p(buildDoc());
			    
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// Eval.g:39:1: stat returns [String value] : ( expr | ^( '=' ID expr ) | ^( 'if' expr s= stat ) );
	public final String stat() throws RecognitionException {
		String value = null;


		CommonTree ID3=null;
		String s =null;
		String expr2 =null;
		String expr4 =null;
		String expr5 =null;

		try {
			// Eval.g:40:5: ( expr | ^( '=' ID expr ) | ^( 'if' expr s= stat ) )
			int alt2=3;
			switch ( input.LA(1) ) {
			case ID:
			case INT:
			case 8:
			case 11:
			case 12:
			case 13:
			case 14:
				{
				alt2=1;
				}
				break;
			case 15:
				{
				alt2=2;
				}
				break;
			case 16:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Eval.g:40:7: expr
					{
					pushFollow(FOLLOW_expr_in_stat95);
					expr2=expr();
					state._fsp--;

					 value = expr2 + ";";
					}
					break;
				case 2 :
					// Eval.g:41:7: ^( '=' ID expr )
					{
					match(input,15,FOLLOW_15_in_stat106); 
					match(input, Token.DOWN, null); 
					ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_stat108); 
					pushFollow(FOLLOW_expr_in_stat110);
					expr4=expr();
					state._fsp--;

					match(input, Token.UP, null); 


					        symbols.put((ID3!=null?ID3.getText():null), new Integer(1));
					        value = "int " + (ID3!=null?ID3.getText():null) + " = " + expr4 + ";\n";
					    
					}
					break;
				case 3 :
					// Eval.g:45:7: ^( 'if' expr s= stat )
					{
					match(input,16,FOLLOW_16_in_stat122); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_stat124);
					expr5=expr();
					state._fsp--;

					pushFollow(FOLLOW_stat_in_stat128);
					s=stat();
					state._fsp--;

					match(input, Token.UP, null); 


					            value = "if(" + expr5 + "> 0){" + s + "}\n";
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// Eval.g:50:1: expr returns [String value] : ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( '%' a= expr b= expr ) | ID | INT );
	public final String expr() throws RecognitionException {
		String value = null;


		CommonTree ID6=null;
		CommonTree INT7=null;
		String a =null;
		String b =null;

		try {
			// Eval.g:51:5: ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( '%' a= expr b= expr ) | ID | INT )
			int alt3=7;
			switch ( input.LA(1) ) {
			case 12:
				{
				alt3=1;
				}
				break;
			case 13:
				{
				alt3=2;
				}
				break;
			case 11:
				{
				alt3=3;
				}
				break;
			case 14:
				{
				alt3=4;
				}
				break;
			case 8:
				{
				alt3=5;
				}
				break;
			case ID:
				{
				alt3=6;
				}
				break;
			case INT:
				{
				alt3=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// Eval.g:51:7: ^( '+' a= expr b= expr )
					{
					match(input,12,FOLLOW_12_in_expr154); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr158);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr162);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = "(" + a + "+" + b + ")"; 
					}
					break;
				case 2 :
					// Eval.g:52:7: ^( '-' a= expr b= expr )
					{
					match(input,13,FOLLOW_13_in_expr174); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr178);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr182);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = "(" + a + "-" + b + ")"; 
					}
					break;
				case 3 :
					// Eval.g:53:7: ^( '*' a= expr b= expr )
					{
					match(input,11,FOLLOW_11_in_expr194); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr198);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr202);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = "(" + a + "*" + b + ")"; 
					}
					break;
				case 4 :
					// Eval.g:54:7: ^( '/' a= expr b= expr )
					{
					match(input,14,FOLLOW_14_in_expr214); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr218);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr222);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = "(" + a + "/" + b + ")"; 
					}
					break;
				case 5 :
					// Eval.g:55:7: ^( '%' a= expr b= expr )
					{
					match(input,8,FOLLOW_8_in_expr234); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr238);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr242);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					value = "(" + a + "%" + b + ")"; 
					}
					break;
				case 6 :
					// Eval.g:56:7: ID
					{
					ID6=(CommonTree)match(input,ID,FOLLOW_ID_in_expr253); 

					            Integer v = (Integer)symbols.get((ID6!=null?ID6.getText():null));
					            if(v!=null && v == 1) value = (ID6!=null?ID6.getText():null);
					            else System.err.println("undefined variable " + (ID6!=null?ID6.getText():null));
					        
					}
					break;
				case 7 :
					// Eval.g:61:7: INT
					{
					INT7=(CommonTree)match(input,INT,FOLLOW_INT_in_expr263); 
					value = (INT7!=null?INT7.getText():null);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog73 = new BitSet(new long[]{0x000000000001F932L});
	public static final BitSet FOLLOW_expr_in_stat95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_stat106 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_stat108 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_stat110 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_16_in_stat122 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_stat124 = new BitSet(new long[]{0x000000000001F930L});
	public static final BitSet FOLLOW_stat_in_stat128 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_12_in_expr154 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr158 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_expr162 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_13_in_expr174 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr178 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_expr182 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_11_in_expr194 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr198 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_expr202 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_14_in_expr214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr218 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_expr222 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_8_in_expr234 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr238 = new BitSet(new long[]{0x0000000000007930L});
	public static final BitSet FOLLOW_expr_in_expr242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expr253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_expr263 = new BitSet(new long[]{0x0000000000000002L});
}
