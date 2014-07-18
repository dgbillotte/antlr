tree grammar Eval;
options { 
    tokenVocab=Expr;
    ASTLabelType=CommonTree;
}

@header {
import java.util.HashMap;
}

@members {
    HashMap memory = new HashMap();
    public int mod(int a) {
        return a;
    }
    public void p(Object o) { System.out.println(o); }
}

prog: stat+ ;

stat: expr {System.out.println($expr.value);}
    | ^('=' ID expr) {memory.put($ID.text, new Integer($expr.value));}
    | ^('if' a=expr b=expr) {
            p("processing if");
            if($a.value > 0) {
                p("evaluating if clause: " + $b.value);
            }
        } 
    ;

expr returns [int value]
    : ^('+' a=expr b=expr) {p("eval"); $value = a+b;}
    | ^('-' a=expr b=expr) {p("eval"); $value = a-b;}
    | ^('*' a=expr b=expr) {p("eval"); $value = a*b;}
    | ^('/' a=expr b=expr) {p("eval"); $value = a/b;}
    | ^('%' a=expr b=expr) {p("eval"); $value = a \% b;}
    | ID {
            Integer v = (Integer)memory.get($ID.text);
            if(v!=null) $value = v.intValue();
            else System.err.println("undefined variable "+$ID.text);
        }
    | INT {$value = Integer.parseInt($INT.text);}
    ;
