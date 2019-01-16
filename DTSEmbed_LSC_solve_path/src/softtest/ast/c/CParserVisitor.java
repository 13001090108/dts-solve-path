/* Generated By:JavaCC: Do not edit this line. CParserVisitor.java Version 5.0 */
package softtest.ast.c;

public interface CParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTTranslationUnit node, Object data);
  public Object visit(ASTExternalDeclaration node, Object data);
  public Object visit(ASTFunctionDeclaration node, Object data);
  public Object visit(ASTFunctionDefinition node, Object data);
  public Object visit(ASTDeclaration node, Object data);
  public Object visit(ASTDeclarationList node, Object data);
  public Object visit(ASTNestedFunctionDeclaration node, Object data);
  public Object visit(ASTNestedFunctionDefinition node, Object data);
  public Object visit(ASTLabelDeclarationList node, Object data);
  public Object visit(ASTLabelDeclaration node, Object data);
  public Object visit(ASTLabelDeclaratorList node, Object data);
  public Object visit(ASTLabelDeclarator node, Object data);
  public Object visit(ASTLabelType node, Object data);
  public Object visit(ASTDeclarationSpecifiers node, Object data);
  public Object visit(ASTTypeofDeclarationSpecifier node, Object data);
  public Object visit(ASTStorageClassSpecifier node, Object data);
  public Object visit(ASTTypeSpecifier node, Object data);
  public Object visit(ASTTypeQualifier node, Object data);
  public Object visit(ASTStructOrUnionSpecifier node, Object data);
  public Object visit(ASTStructOrUnion node, Object data);
  public Object visit(ASTStructDeclarationList node, Object data);
  public Object visit(ASTInitDeclaratorList node, Object data);
  public Object visit(ASTInitDeclarator node, Object data);
  public Object visit(ASTStructDeclaration node, Object data);
  public Object visit(ASTSpecifierQualifierList node, Object data);
  public Object visit(ASTStructDeclaratorList node, Object data);
  public Object visit(ASTStructDeclarator node, Object data);
  public Object visit(ASTEnumSpecifier node, Object data);
  public Object visit(ASTEnumeratorList node, Object data);
  public Object visit(ASTEnumerator node, Object data);
  public Object visit(ASTDeclarator node, Object data);
  public Object visit(ASTDirectDeclarator node, Object data);
  public Object visit(ASTPointer node, Object data);
  public Object visit(ASTTypeQualifierList node, Object data);
  public Object visit(ASTParameterTypeList node, Object data);
  public Object visit(ASTParameterList node, Object data);
  public Object visit(ASTParameterDeclaration node, Object data);
  public Object visit(ASTIdentifierList node, Object data);
  public Object visit(ASTInitializer node, Object data);
  public Object visit(ASTInitializerList node, Object data);
  public Object visit(ASTTypeName node, Object data);
  public Object visit(ASTAbstractDeclarator node, Object data);
  public Object visit(ASTDirectAbstractDeclarator node, Object data);
  public Object visit(ASTTypedefName node, Object data);
  public Object visit(ASTStatement node, Object data);
  public Object visit(ASTLabeledStatement node, Object data);
  public Object visit(ASTExpressionStatement node, Object data);
  public Object visit(ASTCompoundStatement node, Object data);
  public Object visit(ASTStatementList node, Object data);
  public Object visit(ASTSelectionStatement node, Object data);
  public Object visit(ASTIterationStatement node, Object data);
  public Object visit(ASTJumpStatement node, Object data);
  public Object visit(ASTExpression node, Object data);
  public Object visit(ASTAssignmentExpression node, Object data);
  public Object visit(ASTAssignmentOperator node, Object data);
  public Object visit(ASTConditionalExpression node, Object data);
  public Object visit(ASTConstantExpression node, Object data);
  public Object visit(ASTLogicalORExpression node, Object data);
  public Object visit(ASTLogicalANDExpression node, Object data);
  public Object visit(ASTInclusiveORExpression node, Object data);
  public Object visit(ASTExclusiveORExpression node, Object data);
  public Object visit(ASTANDExpression node, Object data);
  public Object visit(ASTEqualityExpression node, Object data);
  public Object visit(ASTRelationalExpression node, Object data);
  public Object visit(ASTShiftExpression node, Object data);
  public Object visit(ASTAdditiveExpression node, Object data);
  public Object visit(ASTMultiplicativeExpression node, Object data);
  public Object visit(ASTCastExpression node, Object data);
  public Object visit(ASTUnaryExpression node, Object data);
  public Object visit(ASTUnaryOperator node, Object data);
  public Object visit(ASTPostfixExpression node, Object data);
  public Object visit(ASTPrimaryExpression node, Object data);
  public Object visit(ASTArgumentExpressionList node, Object data);
  public Object visit(ASTConstant node, Object data);
  public Object visit(ASTFieldId node, Object data);
  public Object visit(ASTPRAGMA node, Object data);
}
/* JavaCC - OriginalChecksum=cfae9b848afffc6cdfb512d3c046bfb5 (do not edit this line) */
