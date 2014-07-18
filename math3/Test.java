import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
public class Test {
    public static void main(String[] args) throws Exception {
	// create a CharStream that reads from standard input
	ANTLRInputStream input = new ANTLRInputStream(System.in);
	// create a lexer that feeds off of input CharStream
	ExprLexer lexer = new ExprLexer(input);
	// create a buffer of tokens pulled from the lexer
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	// create a parser that feeds off the tokens buffer 
	ExprParser parser = new ExprParser(tokens);
	// begin parsing at rule r
	ExprParser.prog_return r = parser.prog();

	// walk the resulting tree
	CommonTree t = (CommonTree)r.getTree();
	CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
	Eval walker = new Eval(nodes);
	walker.prog();
    }
}