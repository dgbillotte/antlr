tree grammar Eval;
options { 
    tokenVocab=Expr;
    ASTLabelType=CommonTree;
}

@header {
import java.util.HashMap;
}

@members {
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
}

prog
    //@init {

    //}
    @after {
        p(buildDoc());
    }

    : (stat { body.append($stat.value); } )+ ;

stat returns [String value]
    : expr { $value = $expr.value + ";";}
    | ^('=' ID expr) {
        symbols.put($ID.text, new Integer(1));
        $value = "int " + $ID.text + " = " + $expr.value + ";\n";
    }
    | ^('if' expr s=stat) {
            $value = "if(" + $expr.value + "> 0){" + $s.value + "}\n";
        } 
    ;

expr returns [String value]
    : ^('+' a=expr b=expr) {$value = "(" + a + "+" + b + ")"; }
    | ^('-' a=expr b=expr) {$value = "(" + a + "-" + b + ")"; }
    | ^('*' a=expr b=expr) {$value = "(" + a + "*" + b + ")"; }
    | ^('/' a=expr b=expr) {$value = "(" + a + "/" + b + ")"; }
    | ^('%' a=expr b=expr) {$value = "(" + a + "\%" + b + ")"; }
    | ID {
            Integer v = (Integer)symbols.get($ID.text);
            if(v!=null && v == 1) $value = $ID.text;
            else System.err.println("undefined variable " + $ID.text);
        }
    | INT {$value = $INT.text;}
    ;

/* expr returns [int value]
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
*/