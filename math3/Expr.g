grammar Expr;
options {
    output=AST;
    ASTLabelType=CommonTree;
}

//prog: ( stat )+ ;
prog: ( stat {System.out.println($stat.tree.toStringTree());} )+ ;
stat: expr NEWLINE        -> expr
    | ID '=' expr NEWLINE -> ^('=' ID expr)
    | ifstmnt NEWLINE     -> ifstmnt
    | NEWLINE             ->
    ;

ifstmnt  : 'if'^'('! expr ')'! '{'! stat '}'!
    ; 

//block: '{'^ stat+ '}'!

expr: multExpr (('+'^|'-'^) multExpr)*
    ;
multExpr
    : atom (('*'^|'/'^|'%'^) atom)*
    ;
atom: INT
    | ID
    | '('! expr ')'!
    ;

ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT : '0'..'9' + ;
NEWLINE:'\r' ? '\n' ;
WS : (' ' |'\t' |'\n' |'\r' )+ {skip();} ;
