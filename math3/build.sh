java -jar /usr/local/lib/antlr-3.5.2-complete.jar Expr.g
java -jar /usr/local/lib/antlr-3.5.2-complete.jar Eval.g
javac -Xlint:unchecked ExprLexer.java ExprParser.java Eval.java Test.java
