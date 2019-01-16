package softtest.PFCGandCFG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jaxen.JaxenException;

import CTSsofttest.ast.c.ASTPostfixExpression;
import CTSsofttest.ast.c.SimpleNode;
import CTSsofttest.cfg.c.VexNode;
import softtest.ast.c.ASTFunctionDefinition;
import softtest.ast.c.ASTPrimaryExpression;
import softtest.ast.c.ASTTranslationUnit;
import softtest.callgraph.c.CVexNode;
import softtest.cfg.c.Graph;
import softtest.fsmanalysis.c.AnalysisElement;
import softtest.interpro.c.MethodNode;

public class FCGNode {
	
	public MethodNode methodNode;
	public AnalysisElement aElement;
	public ASTTranslationUnit fileRoot;
	public ASTFunctionDefinition funcRoot;
	
	public HashSet<FCGNode> parents=new HashSet<>();
	public HashSet<FCGNode> childs=new HashSet<>();
	public int inDegree=0;
	public int outDegree=0;
	public String srcfile="";
	public String funcName="";
	public int isRecursion=0;
	public Graph graph=null;
	public CVexNode cVexNode=null;
	public boolean flag=true;//是否是库函数
	public boolean openCFG=false;//控制流图的打开标记，防止重复打开
	
	
	public static List<softtest.ast.c.ASTPostfixExpression>  findNext(FCGEdge edge) {

	ASTFunctionDefinition def = (ASTFunctionDefinition)edge.tailNode.funcRoot;
	String xpathString = ".//PrimaryExpression[@Image='" + edge.headNode.methodNode.getMethod().getName() + "']";
	Graph cfg = def.getGraph();
	softtest.cfg.c.VexNode entryNode = cfg.getEntryNode();
	softtest.ast.c.SimpleNode entry_astnode = entryNode.getTreenode();
	List<softtest.ast.c.ASTPostfixExpression> xList = null;
	try {
		xList = entry_astnode.findChildNodesWithXPath(xpathString);
	} catch (JaxenException e) {
		e.printStackTrace();
	}
	return xList;

	}

	

}
