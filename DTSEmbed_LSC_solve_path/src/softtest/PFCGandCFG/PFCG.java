package softtest.PFCGandCFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.dom.ThisExpression;

import softtest.ast.c.ASTTranslationUnit;
import softtest.callgraph.c.CGraph;
import softtest.interpro.c.InterCallGraph;
import softtest.interpro.c.InterCallGraph2;
import softtest.outputCG.CGFromProject;
import unittest.path.TestInfo;

/**
 * 接入DTS抽象语法树的工程级函数调用图
 * 使用前请设置好TestInfo、InterCallGraph2、ASTList、cgraphList
 * 路径生成genPath();
 * 溯源deepChain();
 * */
public class PFCG {

	public static TestInfo ti=null;
	public static InterCallGraph interCallGraph=null;
	public static HashMap<String, ASTTranslationUnit> ASTList=new HashMap<>();
	public static HashMap<String, CGraph> cgraphList=new HashMap<>();
	public static void main(String[] args) {

		CGFromProject cgFromProject=new CGFromProject();
		String projectPath="F:\\613\\testcase\\spell-1.0";
		String desPath="F:\\613\\testresult\\callgraph";
		TestInfo testInfo=new TestInfo();
		ti=testInfo;
		ti.project="spell-1.0";
		ti.targetLineNum=371;
		ti.func="_getopt_internal";
		try{
			cgFromProject.selectProject2(projectPath, desPath);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		genPath();
//		deepChain();
	
	}
	
	public static void genPath() {
		FunctionCallingGraph pFunctionCallingGraph=new FunctionCallingGraph();
		

		pFunctionCallingGraph.ASTList=ASTList;
		
		pFunctionCallingGraph.cgraphList=cgraphList;
		pFunctionCallingGraph.ti=ti;
		pFunctionCallingGraph.type=1;
		
		pFunctionCallingGraph.interCallGraph=interCallGraph;
		pFunctionCallingGraph.generateCallGraph();
	}
	public static void deepChain() {
		FunctionCallingGraph pFunctionCallingGraph=new FunctionCallingGraph();
		
		pFunctionCallingGraph.ASTList=ASTList;
		
		pFunctionCallingGraph.cgraphList=cgraphList;
		pFunctionCallingGraph.ti=ti;
		
		pFunctionCallingGraph.pathSetDTS=ti.pathSetDTS;		
//		List< String> a1=new ArrayList<>();
//		a1.add("F:\\613\\testcase\\testcase\\2.c");
//		a1.add("f4");
//		a1.add("29");
//		a1.add("5:stmt_5");
//		ti.list_out=new ArrayList<>();
//		ti.list_out.add(a1);
		pFunctionCallingGraph.genListOut2(ti.list_out);		
		pFunctionCallingGraph.type=0;
		
		pFunctionCallingGraph.interCallGraph=interCallGraph;
		pFunctionCallingGraph.generateCallGraph();
	}
}
