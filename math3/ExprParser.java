// $ANTLR 3.5.2 Expr.g 2014-07-17 23:17:50

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ExprParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Expr.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// Expr.g:7:1: prog : ( stat )+ ;
	public final ExprParser.prog_return prog() throws RecognitionException {
		ExprParser.prog_return retval = new ExprParser.prog_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat1 =null;


		try {
			// Expr.g:7:5: ( ( stat )+ )
			// Expr.g:7:7: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// Expr.g:7:7: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==9||LA1_0==16) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Expr.g:7:9: stat
					{
					pushFollow(FOLLOW_stat_in_prog33);
					stat1=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat1.getTree());

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

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// Expr.g:8:1: stat : ( expr NEWLINE -> expr | ID '=' expr NEWLINE -> ^( '=' ID expr ) | ifstmnt NEWLINE -> ifstmnt | NEWLINE ->);
	public final ExprParser.stat_return stat() throws RecognitionException {
		ExprParser.stat_return retval = new ExprParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE3=null;
		Token ID4=null;
		Token char_literal5=null;
		Token NEWLINE7=null;
		Token NEWLINE9=null;
		Token NEWLINE10=null;
		ParserRuleReturnScope expr2 =null;
		ParserRuleReturnScope expr6 =null;
		ParserRuleReturnScope ifstmnt8 =null;

		CommonTree NEWLINE3_tree=null;
		CommonTree ID4_tree=null;
		CommonTree char_literal5_tree=null;
		CommonTree NEWLINE7_tree=null;
		CommonTree NEWLINE9_tree=null;
		CommonTree NEWLINE10_tree=null;
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_15=new RewriteRuleTokenStream(adaptor,"token 15");
		RewriteRuleSubtreeStream stream_ifstmnt=new RewriteRuleSubtreeStream(adaptor,"rule ifstmnt");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Expr.g:8:5: ( expr NEWLINE -> expr | ID '=' expr NEWLINE -> ^( '=' ID expr ) | ifstmnt NEWLINE -> ifstmnt | NEWLINE ->)
			int alt2=4;
			switch ( input.LA(1) ) {
			case INT:
			case 9:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==15) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||LA2_2==8||(LA2_2 >= 11 && LA2_2 <= 14)) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 16:
				{
				alt2=3;
				}
				break;
			case NEWLINE:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Expr.g:8:7: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat43);
					expr2=expr();
					state._fsp--;

					stream_expr.add(expr2.getTree());
					NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat45);  
					stream_NEWLINE.add(NEWLINE3);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 8:27: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Expr.g:9:7: ID '=' expr NEWLINE
					{
					ID4=(Token)match(input,ID,FOLLOW_ID_in_stat64);  
					stream_ID.add(ID4);

					char_literal5=(Token)match(input,15,FOLLOW_15_in_stat66);  
					stream_15.add(char_literal5);

					pushFollow(FOLLOW_expr_in_stat68);
					expr6=expr();
					state._fsp--;

					stream_expr.add(expr6.getTree());
					NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat70);  
					stream_NEWLINE.add(NEWLINE7);

					// AST REWRITE
					// elements: expr, 15, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 9:27: -> ^( '=' ID expr )
					{
						// Expr.g:9:30: ^( '=' ID expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_15.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// Expr.g:10:7: ifstmnt NEWLINE
					{
					pushFollow(FOLLOW_ifstmnt_in_stat88);
					ifstmnt8=ifstmnt();
					state._fsp--;

					stream_ifstmnt.add(ifstmnt8.getTree());
					NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat90);  
					stream_NEWLINE.add(NEWLINE9);

					// AST REWRITE
					// elements: ifstmnt
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 10:27: -> ifstmnt
					{
						adaptor.addChild(root_0, stream_ifstmnt.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// Expr.g:11:7: NEWLINE
					{
					NEWLINE10=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat106);  
					stream_NEWLINE.add(NEWLINE10);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 11:27: ->
					{
						root_0 = null;
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class ifstmnt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ifstmnt"
	// Expr.g:14:1: ifstmnt : 'if' ^ '(' ! expr ')' ! '{' ! stat '}' !;
	public final ExprParser.ifstmnt_return ifstmnt() throws RecognitionException {
		ExprParser.ifstmnt_return retval = new ExprParser.ifstmnt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal11=null;
		Token char_literal12=null;
		Token char_literal14=null;
		Token char_literal15=null;
		Token char_literal17=null;
		ParserRuleReturnScope expr13 =null;
		ParserRuleReturnScope stat16 =null;

		CommonTree string_literal11_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal17_tree=null;

		try {
			// Expr.g:14:10: ( 'if' ^ '(' ! expr ')' ! '{' ! stat '}' !)
			// Expr.g:14:12: 'if' ^ '(' ! expr ')' ! '{' ! stat '}' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal11=(Token)match(input,16,FOLLOW_16_in_ifstmnt134); 
			string_literal11_tree = (CommonTree)adaptor.create(string_literal11);
			root_0 = (CommonTree)adaptor.becomeRoot(string_literal11_tree, root_0);

			char_literal12=(Token)match(input,9,FOLLOW_9_in_ifstmnt136); 
			pushFollow(FOLLOW_expr_in_ifstmnt139);
			expr13=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr13.getTree());

			char_literal14=(Token)match(input,10,FOLLOW_10_in_ifstmnt141); 
			char_literal15=(Token)match(input,17,FOLLOW_17_in_ifstmnt144); 
			pushFollow(FOLLOW_stat_in_ifstmnt147);
			stat16=stat();
			state._fsp--;

			adaptor.addChild(root_0, stat16.getTree());

			char_literal17=(Token)match(input,18,FOLLOW_18_in_ifstmnt149); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ifstmnt"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Expr.g:19:1: expr : multExpr ( ( '+' ^| '-' ^) multExpr )* ;
	public final ExprParser.expr_return expr() throws RecognitionException {
		ExprParser.expr_return retval = new ExprParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal19=null;
		Token char_literal20=null;
		ParserRuleReturnScope multExpr18 =null;
		ParserRuleReturnScope multExpr21 =null;

		CommonTree char_literal19_tree=null;
		CommonTree char_literal20_tree=null;

		try {
			// Expr.g:19:5: ( multExpr ( ( '+' ^| '-' ^) multExpr )* )
			// Expr.g:19:7: multExpr ( ( '+' ^| '-' ^) multExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr165);
			multExpr18=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr18.getTree());

			// Expr.g:19:16: ( ( '+' ^| '-' ^) multExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 12 && LA4_0 <= 13)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// Expr.g:19:17: ( '+' ^| '-' ^) multExpr
					{
					// Expr.g:19:17: ( '+' ^| '-' ^)
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==12) ) {
						alt3=1;
					}
					else if ( (LA3_0==13) ) {
						alt3=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}

					switch (alt3) {
						case 1 :
							// Expr.g:19:18: '+' ^
							{
							char_literal19=(Token)match(input,12,FOLLOW_12_in_expr169); 
							char_literal19_tree = (CommonTree)adaptor.create(char_literal19);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal19_tree, root_0);

							}
							break;
						case 2 :
							// Expr.g:19:23: '-' ^
							{
							char_literal20=(Token)match(input,13,FOLLOW_13_in_expr172); 
							char_literal20_tree = (CommonTree)adaptor.create(char_literal20);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal20_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_multExpr_in_expr176);
					multExpr21=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr21.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multExpr"
	// Expr.g:21:1: multExpr : atom ( ( '*' ^| '/' ^| '%' ^) atom )* ;
	public final ExprParser.multExpr_return multExpr() throws RecognitionException {
		ExprParser.multExpr_return retval = new ExprParser.multExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal23=null;
		Token char_literal24=null;
		Token char_literal25=null;
		ParserRuleReturnScope atom22 =null;
		ParserRuleReturnScope atom26 =null;

		CommonTree char_literal23_tree=null;
		CommonTree char_literal24_tree=null;
		CommonTree char_literal25_tree=null;

		try {
			// Expr.g:22:5: ( atom ( ( '*' ^| '/' ^| '%' ^) atom )* )
			// Expr.g:22:7: atom ( ( '*' ^| '/' ^| '%' ^) atom )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_atom_in_multExpr194);
			atom22=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom22.getTree());

			// Expr.g:22:12: ( ( '*' ^| '/' ^| '%' ^) atom )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==8||LA6_0==11||LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Expr.g:22:13: ( '*' ^| '/' ^| '%' ^) atom
					{
					// Expr.g:22:13: ( '*' ^| '/' ^| '%' ^)
					int alt5=3;
					switch ( input.LA(1) ) {
					case 11:
						{
						alt5=1;
						}
						break;
					case 14:
						{
						alt5=2;
						}
						break;
					case 8:
						{
						alt5=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}
					switch (alt5) {
						case 1 :
							// Expr.g:22:14: '*' ^
							{
							char_literal23=(Token)match(input,11,FOLLOW_11_in_multExpr198); 
							char_literal23_tree = (CommonTree)adaptor.create(char_literal23);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal23_tree, root_0);

							}
							break;
						case 2 :
							// Expr.g:22:19: '/' ^
							{
							char_literal24=(Token)match(input,14,FOLLOW_14_in_multExpr201); 
							char_literal24_tree = (CommonTree)adaptor.create(char_literal24);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal24_tree, root_0);

							}
							break;
						case 3 :
							// Expr.g:22:24: '%' ^
							{
							char_literal25=(Token)match(input,8,FOLLOW_8_in_multExpr204); 
							char_literal25_tree = (CommonTree)adaptor.create(char_literal25);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal25_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_atom_in_multExpr208);
					atom26=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom26.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// Expr.g:24:1: atom : ( INT | ID | '(' ! expr ')' !);
	public final ExprParser.atom_return atom() throws RecognitionException {
		ExprParser.atom_return retval = new ExprParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT27=null;
		Token ID28=null;
		Token char_literal29=null;
		Token char_literal31=null;
		ParserRuleReturnScope expr30 =null;

		CommonTree INT27_tree=null;
		CommonTree ID28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree char_literal31_tree=null;

		try {
			// Expr.g:24:5: ( INT | ID | '(' ! expr ')' !)
			int alt7=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt7=1;
				}
				break;
			case ID:
				{
				alt7=2;
				}
				break;
			case 9:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// Expr.g:24:7: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					INT27=(Token)match(input,INT,FOLLOW_INT_in_atom221); 
					INT27_tree = (CommonTree)adaptor.create(INT27);
					adaptor.addChild(root_0, INT27_tree);

					}
					break;
				case 2 :
					// Expr.g:25:7: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID28=(Token)match(input,ID,FOLLOW_ID_in_atom229); 
					ID28_tree = (CommonTree)adaptor.create(ID28);
					adaptor.addChild(root_0, ID28_tree);

					}
					break;
				case 3 :
					// Expr.g:26:7: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal29=(Token)match(input,9,FOLLOW_9_in_atom237); 
					pushFollow(FOLLOW_expr_in_atom240);
					expr30=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr30.getTree());

					char_literal31=(Token)match(input,10,FOLLOW_10_in_atom242); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog33 = new BitSet(new long[]{0x0000000000010272L});
	public static final BitSet FOLLOW_expr_in_stat43 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat64 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_stat66 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_expr_in_stat68 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifstmnt_in_stat88 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_ifstmnt134 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_ifstmnt136 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_expr_in_ifstmnt139 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ifstmnt141 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifstmnt144 = new BitSet(new long[]{0x0000000000010270L});
	public static final BitSet FOLLOW_stat_in_ifstmnt147 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifstmnt149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr165 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_12_in_expr169 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_13_in_expr172 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_multExpr_in_expr176 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_atom_in_multExpr194 = new BitSet(new long[]{0x0000000000004902L});
	public static final BitSet FOLLOW_11_in_multExpr198 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_14_in_multExpr201 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_8_in_multExpr204 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_atom_in_multExpr208 = new BitSet(new long[]{0x0000000000004902L});
	public static final BitSet FOLLOW_INT_in_atom221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_atom237 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_expr_in_atom240 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_atom242 = new BitSet(new long[]{0x0000000000000002L});
}
