package fault;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import softtest.fsm.c.FSMLoader;
import softtest.fsm.c.FSMMachine;
import softtest.fsmanalysis.c.FSMAnalysisVisitor;
import softtest.interpro.c.InterContext;
import softtest.symboltable.c.MethodNameDeclaration;
import softtest.test.c.rules.ModelTestBase;

@RunWith(Parameterized.class)
public class NPD_EXP extends ModelTestBase {
	public NPD_EXP(String source,String compiletype, String result)
	{
		super(source, compiletype, result);
	}

	@BeforeClass
	public static void setUpBaseChild()
	{
		fsmPath="softtest/rules/gcc/fault/NPD_EXP-0.1.xml";
		FSMMachine fsm = FSMLoader.loadXML(fsmPath);
		fsm.setType("fault");
		//每次加入自动机前都清空一下原来的fsms
		FSMAnalysisVisitor.clearFSMS();
		FSMAnalysisVisitor.addFSMS(fsm);
		
		//加载库函数摘要
		LIB_SUMMARYS_PATH="gcc_lib/npd_summary.xml";
		libManager.loadSingleLibFile(LIB_SUMMARYS_PATH);
		Set<MethodNameDeclaration> libDecls = libManager.compileLib(pre.getLibIncludes());
		interContext = InterContext.getInstance();
		interContext.addLibMethodDecl(libDecls);
	}
	
	 @Parameters
	 public static Collection<Object[]> testcaseAndResults()
	 {
		 return Arrays.asList(new Object[][] {

	/////////////////  1   ///////////////////	
		            {
		            "int * func1_1() "                                                     +"\n"+
		            "{"                                                                    +"\n"+
		            "	return (int*)0;"                                                     +"\n"+
		            "}"                                                                    +"\n"+
		            "void test1_1(int *p)"                                                 +"\n"+
		            "{"                                                                    +"\n"+
		            "	int a = 0;"                                                          +"\n"+
		            "	if (p) {"                                                            +"\n"+
		            "		a = 1;"                                                             +"\n"+
		            "	}"                                                                   +"\n"+
		            "	*(p+1) = 1;//NPD_EXP"                                                +"\n"+
		            "}"                                                                    
		            ,
		            "gcc"
		            ,
		            "NPD_EXP"
		            ,
		            },

	
	/////////////////  2   ///////////////////	
		            {
		            ""                                                                     
		            ,
		            "gcc"
		            ,
		            "NPD_EXP"
		            ,
		            },

	/////////////////  2   ///////////////////	
		            {
		            "int * func1_1() "                                                     +"\n"+
		            "{"                                                                    +"\n"+
		            "	return (int*)0;"                                                     +"\n"+
		            "}"                                                                    +"\n"+
		            "void test1_2(int *p)"                                                 +"\n"+
		            "{"                                                                    +"\n"+
		            "	int a = 0;"                                                          +"\n"+
		            "	a = *func1_1();//DEFECT, NPD_EXP,func1"                              +"\n"+
		            "}"                                                                    
		            ,
		            "gcc"
		            ,
		            "NPD_EXP"
		            ,
		            },

		            
		 });
	 }
}
