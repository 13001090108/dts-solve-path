/* Generated By:JJTree: Do not edit this line. ASTInitDeclaratorList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package softtest.ast.c;

public
class ASTInitDeclaratorList extends SimpleNode {
  public ASTInitDeclaratorList(int id) {
    super(id);
  }

  public ASTInitDeclaratorList(CParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(CParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=fac0ca5bc769bf77c1c66e8c4786aa50 (do not edit this line) */
