/* Generated By:JJTree: Do not edit this line. ASTPostfixExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package softtest.ast.c;

import java.util.ArrayList;

import softtest.symboltable.c.NameDeclaration;
import softtest.symboltable.c.Scope;
import softtest.symboltable.c.Search;
import softtest.symboltable.c.VariableNameDeclaration;

public class ASTPostfixExpression extends AbstractExpression {
	
    NameDeclaration decl=null;
	
	public NameDeclaration getDecl() {
		return decl;
	}

	public void setDecl(NameDeclaration decl) {
		this.decl = decl;
	}
	public VariableNameDeclaration getVariableDecl() {
		VariableNameDeclaration ret = null;
		if (!image.equals("")) {
			Scope scope = getScope();
			NameDeclaration decl = Search.searchInVariableUpward(image, scope);
			if (decl instanceof VariableNameDeclaration) {
				ret = (VariableNameDeclaration) decl;
			}
		}
		return ret;
	}
	
	ArrayList<Boolean> flags = new ArrayList<Boolean>();

	public ASTPostfixExpression(int id) {
		super(id);
	}

	public ASTPostfixExpression(CParser p, int id) {
		super(p, id);
	}

	public ArrayList<Boolean> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Boolean> flags) {
		this.flags = flags;
	}

	void setFlag(boolean flag) {
		flags.add(flag);
	}

	public void setOperatorTypeAndFlag(String str, boolean flag) {
		this.setOperatorType(str);
		this.setFlag(flag);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(CParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
/* JavaCC - OriginalChecksum=7d6a3913c0bcbb18ffc59c9fdbb9e8c2 (do not edit this line) */