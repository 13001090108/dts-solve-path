/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package softtest.ast.c;

public
class ASTDeclaration extends SimpleNode {
  public ASTDeclaration(int id) {
    super(id);
  }

  public ASTDeclaration(CParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(CParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3225de276183f53e8b177c13c79982f9 (do not edit this line) */