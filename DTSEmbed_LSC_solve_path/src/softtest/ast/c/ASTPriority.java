/* Generated By:JJTree: Do not edit this line. ASTPriority.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package softtest.ast.c;

public class ASTPriority extends SimpleNode {
	String prioritynum = "";

	public ASTPriority(int id) {
		super(id);
	}

	public ASTPriority(CParser p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(CParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	public String getPrioritynum() {
		return prioritynum;
	}

	public void setPrioritynum(String prioritynum) {
		this.prioritynum = prioritynum;
	}
}
/* JavaCC - OriginalChecksum=a217ad9e086f5b4e9729e6569c785240 (do not edit this line) */