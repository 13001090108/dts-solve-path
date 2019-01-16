package softtest.PFCGandCFG;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.CompositeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.jaxen.JaxenException;

import CTSsofttest.ast.c.ASTFunctionDefinition;
import CTSsofttest.ast.c.ASTPostfixExpression;
import CTSsofttest.ast.c.ASTPrimaryExpression;
import CTSsofttest.ast.c.SimpleNode;
import CTSsofttest.cfg.c.VexNode;
import CTSsofttest.symboltable.c.MethodNameDeclaration;
import softtest.ast.c.ASTTranslationUnit;
import softtest.callgraph.c.CGraph;
import softtest.cfg.c.ControlFlowData;
import softtest.cfg.c.ControlFlowVisitor;
import softtest.interpro.c.InterCallGraph;
import softtest.interpro.c.InterCallGraph2;
import softtest.interpro.c.MethodNode;
import unittest.callinggraph.FunctionItem;
import unittest.gui.UATSourceCodeWindow;
import unittest.module.seperate.TestModule;
import unittest.path.TestInfo;
import unittest.pathchoose.util.path.OnePath;
import unittest.util.AnalysisFile;
import unittest.util.Project;

public class FunctionCallingGraph {

	
	public TestInfo ti;
	/**0 用于 deepchain 1用于路径  2用于生成测试用例*/
	public  int type=-1;
	public static HashMap<String, Set<String>> deepchainLineNum=new HashMap<>();
	public  HashMap<String, CGraph> cgraphList=null;
	public  HashMap<String, ASTTranslationUnit> ASTList=null;
	public  InterCallGraph interCallGraph=null;
//	public static HashMap<AnalysisElement, String> element2file=null;
	// 存放函数头部到函数调用关系图节点（FunctionItem）的映射
	private Map<String, List<FCGNode>> table = new HashMap<String, List<FCGNode>>();
	private Map<String, List<FCGNode>> table2 = new HashMap<String, List<FCGNode>>();
	private Display display = Display.getDefault();
	public Shell shell = null;
	private Graph graph = null;
	// 存放所有函数定义节点
	private Map<FCGNode, GraphNode> funcdefmap = new HashMap<FCGNode, GraphNode>();
	// 解决重名函数
	private Map<GraphNode, FCGNode> graphNodeMap = new HashMap<GraphNode, FCGNode>();
	// 存放所有函数定义节点的函数头部,这里去掉了重名main函数
	private Map<String, GraphNode> funcdefmap1 = new HashMap<String, GraphNode>();
	private Map<String, GraphNode> funcdefmap2 = new HashMap<String, GraphNode>();
	private Map<GraphNode, Color> oldColorMap = new HashMap<GraphNode, Color>();
	// 存放所有非函数定义节点的函数名
	private Map<String, GraphNode> nonfuncdefmap = new HashMap<String, GraphNode>();
	
	private GraphNode node = null;
	private GraphNode node1 = null;
	private GraphNode node2 = null;
	private GridData gd_graph = null;
	private Project currentProject;
	private Composite composite;
	private Composite bottomComposite;
	private Group group;
	private org.eclipse.swt.widgets.List list;
	private Color redColor = new Color(Display.getCurrent(), 238,99,99);
	private Color greenColor = new Color(Display.getCurrent(), 0,255,127);
	private Color blueColor = new Color(Display.getCurrent(), 216, 228, 248);
	private Color darkBlueColor = new Color(Display.getCurrent(), 100,149,237);
	private Color yelloColor = Display.getCurrent().getSystemColor(
			SWT.COLOR_YELLOW);
	private Color whiteColor = Display.getCurrent().getSystemColor(
			SWT.COLOR_WHITE);
	private Color darkColor = new Color(Display.getCurrent(), 0, 0, 0);
	
	private static Color color1=new Color(Display.getCurrent(), 255,105,180);//HotPink热情的粉红,与覆盖率不足300接近
	private static Color color2=new Color(Display.getCurrent(), 255,0,255);//Magenta洋红
	private static Color color3=new Color(Display.getCurrent(), 0,0,255);//Blue纯蓝
	private static Color color4=new Color(Display.getCurrent(), 0,191,255);//DeepSkyBlue深天蓝
	private static Color color5=new Color(Display.getCurrent(), 255,255,0);//Yellow纯黄，与高亮接近
	private static Color color6=new Color(Display.getCurrent(), 255,215,0);//Gold金
	private static Color color7=new Color(Display.getCurrent(), 255,165,0);//Orange橙色
	private static Color color8=new Color(Display.getCurrent(), 0,255,127);//MediumSpringGreen适中的春天的绿色
	private static Color color9=new Color(Display.getCurrent(), 0,255,0);//Lime酸橙色
	// private Map<String, Color> childColorMap = new HashMap<String, Color>();
	private Map<GraphNode, Color> childColorMap = new HashMap<GraphNode, Color>();
	private Map<GraphNode, Color> parentColorMap = new HashMap<GraphNode, Color>();
	private HashSet<GraphNode> visited = new HashSet<GraphNode>();
	/**选路路径集合*/
	public HashMap<String, Set<OnePath>> pathSet=new HashMap<String, Set<OnePath>>();
	
	public static HashSet<String> pathSetDTS =new HashSet<String>();
	private java.util.Queue<String> nodeListQueue=new LinkedList<String>();
	private GraphNode target=null;
	private HashMap<GraphNode, HashSet<GraphNode>> father=new HashMap<GraphNode, HashSet<GraphNode>>();
	private HashMap<GraphNode, HashSet<GraphNode>> childs=new HashMap<GraphNode, HashSet<GraphNode>>();
	private ArrayList<String> basicPath=new ArrayList<String>();
	
	
	
	/**613-基本路径
	 * @author fkx-cts
	 * */
	public void genbasicPath(){
		basicPath.clear();
		if(type==1){
			HashSet<String> Path=new HashSet<String>();
			//目标节点输入、输出路径连接
//			for(String a:fatherbasicPath()){
//				for(String b:childbasicPath()){
//					String c=b.substring(b.indexOf(target.getText())+target.getText().length());
//					Path.add(a+c);
//				}
//			}
			//目标节点输入路径
			for(String a:fatherbasicPath()){
				Path.add(a);
			}
			
			basicPath.addAll(Path);
			
			if(basicPath.size()==0||basicPath==null){
				listtemp.add("路径生成失败");
				listtemp.setEnabled(false);
				groupTemp.setText("路径列表(共"+0+"条)");
			}else{
				groupTemp.setText("路径列表(共"+basicPath.size()+"条)");
				for(int i=0;i<basicPath.size();i++){
					int b=i+1;
					listtemp.add("基本路径"+b);
				}
			}
		}else if(type==0){
			
			if(ti.pathSetDTS!=null)
			pathSetDTS.addAll(ti.pathSetDTS);
			if(pathSetDTS==null||pathSetDTS.size()==0){
//				listtemp.add("溯源失败");
				listtemp.setEnabled(false);
				groupTemp.setText("路径列表(共"+0+"条)");
			}else{
				basicPath.addAll(pathSetDTS);
				groupTemp.setText("路径列表(共"+basicPath.size()+"条)");
				for(int i=0;i<basicPath.size();i++){
					int b=i+1;
					listtemp.add("溯源路径"+b);
				}
			}
		}
		
		
	}
	private HashSet<String>  fatherbasicPath(){
		String string="";
		HashSet<String> basicPath=new HashSet<String>();
		if(target!=null){
			basicPathbase(target,string,basicPath);
//			for(GraphNode n:father.get(target)){
//				System.out.println(n.getText());
//			}
			
		}
		System.out.println(basicPath.size());
		System.out.println(basicPath);
		return basicPath;
		
	}
	private void basicPathbase(GraphNode node,String s,HashSet<String> basicPath){
		String s2="-->"+node.getText()+s;
		
	
		if(father.get(node)==null){

			System.out.println(s2);
		
			basicPath.add(s2);
		}else{
			for(GraphNode n:father.get(node)){
				if(!s2.contains(n.getText()+"-->")){
					basicPathbase(n,s2,basicPath);
				}else if(!s2.substring(0, n.getText().length()+3).equals(n.getText()+"-->")){
					if(!s2.contains("-->"+n.getText()+"-->")){
						basicPathbase(n,s2,basicPath);
					}
				}
				
			}
		}
	}
	private HashSet<String> childbasicPath(){
		String string="";
		HashSet<String> basicPath=new HashSet<String>();
		if(target!=null){
			basicPathbase2(target,string,basicPath);
		}
		System.out.println(basicPath.size());
		System.out.println(basicPath);
		return basicPath;		
	}
	private void basicPathbase2(GraphNode node,String s,HashSet<String> basicPath){
		String s2=s+"-->"+node.getText();	
		if(childs.get(node)==null){
			System.out.println(s2);		
			basicPath.add(s2);
		}else{
			for(GraphNode n:childs.get(node)){
				if(!s2.contains(n.getText()))
				basicPathbase2(n,s2,basicPath);
			}
		}
	}
	/**用于存储外部输入源*/
	protected static HashMap<String, HashMap<String,Set<Integer>>> listOut=new HashMap<>();
	/**用于着色外部输入源*/
	private void colorNodeOut(){
		if(type!=0||ti.list_out==null||ti.list_out.isEmpty())
			return;
//		System.out.println(funcdefmap2.keySet());
		for(List<String> node:ti.list_out){
			funcdefmap2.get(node.get(1)).setBackgroundColor(color2);
		}
	}
	
	private String HighlightFunction="";
	private void colorHighlightFunction(Set<String> list){
		if(type!=0||list==null||list.isEmpty())
			return;
//		System.out.println(funcdefmap2.keySet());
		HighlightFunction=list.toString();
		for(String node:list){
			funcdefmap2.get(node).setBackgroundColor(greenColor);
			try{
				if(type==0&&ti.map2!=null){
					for(Integer I:ti.map2.get(node)){
						ti.lineNum.add(I.toString());
					}
				
				}
				
			}catch(NullPointerException e){
				e.printStackTrace();
				System.out.println("获取函数行号失败");
			}
		}
	}
	
	/**用于转换外部输入源*/
	public void genListOut(List<List<String>> list_out){
		if(list_out==null)
			return;
		for(List<String> node:list_out){
			if(listOut.get(node.get(0))!=null){
				HashMap<String,Set<Integer>> file=listOut.get(node.get(0));
				if(file.get(node.get(1))!=null){
					if(node.get(2)!=null)
						file.get(node.get(1)).add(Integer.valueOf(node.get(2)));
				}else{
					HashSet<Integer> func=new HashSet<>();
					func.add(Integer.valueOf(node.get(2)));
					file.put(node.get(1),func);
				}
					
			}else{
				HashMap<String,Set<Integer>> file=new HashMap<>();
				listOut.put(node.get(0), file);
				if(file.get(node.get(1))!=null){
					if(node.get(2)!=null)
						file.get(node.get(1)).add(Integer.valueOf(node.get(2)));
				}else{
					HashSet<Integer> func=new HashSet<>();
					func.add(Integer.valueOf(node.get(2)));
					file.put(node.get(1),func);
				}
			}
		}
	}
	public void genListOut2(List<List<String>> list_out){
		listOut.clear();
		if(list_out==null)
			return;
		for(List<String> node:list_out){
			if(listOut.get(node.get(0))!=null){
				HashMap<String,Set<Integer>> file=listOut.get(node.get(0));
				if(file.get(node.get(1))!=null){
					if(node.get(3)!=null)
						file.get(node.get(1)).add(Integer.valueOf(node.get(3).substring(0, node.get(3).indexOf(":"))));
				}else{
					HashSet<Integer> func=new HashSet<>();
					func.add(Integer.valueOf(node.get(3).substring(0, node.get(3).indexOf(":"))));
					file.put(node.get(1),func);
				}
					
			}else{
				HashMap<String,Set<Integer>> file=new HashMap<>();
				listOut.put(node.get(0), file);
				if(file.get(node.get(1))!=null){
					if(node.get(2)!=null)
						file.get(node.get(1)).add(Integer.valueOf(node.get(3).substring(0, node.get(3).indexOf(":"))));
				}else{
					HashSet<Integer> func=new HashSet<>();
					func.add(Integer.valueOf(node.get(3).substring(0, node.get(3).indexOf(":"))));
					file.put(node.get(1),func);
				}
			}
		}
		System.out.println("输出外部输入源");
		System.out.println(listOut);
	}
	/**
	 * 生成整个文件的函数调用关系
	 * @param pro
	 * @param file
	 */
//	public void generateCallGraph(Project pro, AnalysisFile file) {
//		long startTime = System.currentTimeMillis(); // 获取开始时间
//		currentProject = pro;
//		AnalysisFile af = file;	
//		ArrayList<TestModule> funcList = af.getFunctionList();
//		for (TestModule tm : funcList) {
//			addTable(table, generateFunctionItem(af, tm));
//		}	
//
//		// 初始化主窗体
//		initShell();
//		// 创建函数调用关系图
//		createGraph();
//		// 打开主窗体
//		openShell();
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("文件级函数调用关系图运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
//	}
	/**
	 * 生成整个文件的函数调用关系for 613
	 *
	 * @param file
	 * @author fkx-cts
	 */
//	public void generateCallGraph(AnalysisFile file) {
//		long startTime = System.currentTimeMillis(); // 获取开始时间
////		currentProject = null;
//		AnalysisFile af = file;	
//		ArrayList<TestModule> funcList = af.getFunctionList();
//		for (TestModule tm : funcList) {
//			addTable(table, generateFunctionItem(af, tm));
//		}	
//		
//		
//
//		// 初始化主窗体
//
//		initShell();
//		// 创建函数调用关系图
//		createGraph();
//		// 打开主窗体
//		openShell();
//		
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("文件级函数调用关系图运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
//	}
	HashMap<MethodNode, FCGNode> MN2FCGNodeMap=new HashMap<>();
	String projectpath="";
	public void generateCallGraph() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		
		List<MethodNode> list=interCallGraph.getMethodTopoOrder();
		//创建函数调用图节点对象
		for(MethodNode mn:list){
			FCGNode node=new FCGNode();
			node.aElement=mn.getElement();
			try{
				node.srcfile=mn.getFileName().substring(mn.getFileName().indexOf(ti.project));
			}catch(Exception e){
				System.out.println("工程外函数"+mn.getFileName());
				node.srcfile=mn.getFileName();
				node.flag=true;
			}
			
//			node.srcfile=mn.getFileName().substring(mn.getFileName().indexOf(ti.project));
//			node.srcfile=mn.getFileName().substring(mn.getFileName().indexOf(ti.project));
//			node.cVexNode=cgraphList.get(node.srcfile).nodes.get(mn.getMethod().getName());
			node.methodNode=mn;
			node.funcName=mn.getMethod().getName();
			node.aElement=mn.getElement();

			
			MN2FCGNodeMap.put(mn, node);
		}
		for(String st:cgraphList.keySet()){
			if(st.contains(ti.project)){
				projectpath=st.substring(0,st.indexOf(ti.project));
				break;
			}
		}
		FCGNode caller,callee;
		for(MethodNode mn:list){
			for(MethodNode mn2:mn.getOrderCalls()){
				caller=MN2FCGNodeMap.get(mn);
				callee=MN2FCGNodeMap.get(mn2);
				caller.childs.add(callee);
				caller.outDegree++;
				callee.parents.add(caller);
				callee.inDegree++;
				
			}
		}
		System.out.println(PFCG.ASTList);
		for(FCGNode node:MN2FCGNodeMap.values()){
			if(node.srcfile.contains(ti.project)){
				node.flag=false;
			}
			try{
				if(node.methodNode.getFileName().contains(ti.project)){
					node.srcfile=projectpath+node.srcfile;
					for(String temp:cgraphList.get(node.srcfile).nodes.keySet()){
						String name=temp.substring(0,temp.lastIndexOf("_"));
						name=name.substring(0, name.lastIndexOf("_"));
						if(name.equals(node.funcName)){
							node.cVexNode=cgraphList.get(node.srcfile).nodes.get(temp);
							
							break;
						}
					}
				}
			}catch(Exception e){
				
				System.out.println("没找到cvexnode"+node.srcfile+"---"+node.funcName);
			}
			node.fileRoot=PFCG.ASTList.get(node.srcfile);
			if(node.fileRoot!=null){
				String xpath="//FunctionDefinition[@Image='"+node.funcName+"']";
				List<softtest.ast.c.ASTFunctionDefinition> list2=null;
				try {
					list2=node.fileRoot.findChildNodesWithXPath(xpath);
				} catch (JaxenException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!list2.isEmpty()){
					try{
						node.funcRoot=(softtest.ast.c.ASTFunctionDefinition)list2.get(0);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			}
			System.out.println(node.funcName+"  "+node.srcfile+"   "+node.fileRoot+"     "+node.funcRoot);
			
			
			if(table2.keySet().contains(node.funcName)){
				table2.get(node.funcName).add(node);
			}else{
				List<FCGNode> list2=new ArrayList<>();
				list2.add(node);
				table2.put(node.funcName, list2);
			}
		}

		

		// 初始化主窗体

		initShell();
		// 创建函数调用关系图
//		check();//用于调试重名函数
		createGraph();
		// 打开主窗体
		openShell();
		
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("文件级函数调用关系图运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
	}
	/**检查是否存在冲突函数
	 * 
	 * */
	private void check(){
		String erromessage="";
		for(List<FCGNode> list:table2.values()){
			if(list.size()>1){
				for(FCGNode node:list){
					erromessage=erromessage+node.funcName+"  in:"+node.srcfile+"\r\n";
				}
				erromessage=erromessage+"---------------------------------------------------------------------------\r\n";
			}
		}
		if(erromessage.length()>0){
//			MessageBox mBox=new MessageBox(shell);
//			mBox.setText("注意");
//			mBox.setMessage("C语言仅允许静态函数重名，以下函数可能存在重名冲突：\r\n"+erromessage);
//			mBox.open();
//			Display display=new Display(); // 创建 Display 类对象
			Shell shell=new Shell(display,SWT.NO); //建立 shell 主窗体，风格
			shell.setSize(600,400); //设置窗体大小
			int width = shell.getMonitor().getClientArea().width;
			int height = shell.getMonitor().getClientArea().height;
			int x = shell.getSize().x;
			int y = shell.getSize().y;
			if (x > width) {
			    shell.getSize().x = width;
			}
			if (y > height) {
			    shell.getSize().y = height;
			}
			shell.setLocation((width - x) / 2, (height - y) / 2);
//			shell.setLocation(200, 200); //设置窗体的位置
			
			shell.setText("警告"); //设置窗体标题
			shell.setLayout(new FillLayout());
			Group group = new Group(shell, SWT.NONE);
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			group.setLayout(new FillLayout());
			group.setText("C语言仅允许静态函数重名，以下函数可能存在重名冲突：");
			
			Text text=new Text(group,SWT.NONE|SWT.V_SCROLL|SWT.H_SCROLL); //构造 Text 对象，设置样式
			
//			text.setLocation(50,0); //设置 Text 的位置
//			text.setSize(100,50); //设置 Text 大小
//			text.setLayoutData(new FillLayout());
			text.setText(erromessage); //设置 Text 标题
			text.setEditable(false);
			shell.open(); //显示窗体
			while (!shell.isDisposed()) //检验窗体是非关闭
			{
			if (!display.readAndDispatch()) //检验 Display 线程状态是非忙
			display.sleep (); //Display 类线程休眠
			}
			
//			display.dispose (); //注销 Display 对象资源
			
		}
	}
//	public void generateCallGraph(List<AnalysisFile> filelist) {
//		System.out.println("开始生成函数单元");
//		long startTime = System.currentTimeMillis(); // 获取开始时间
////		currentProject = null;
//		for(AnalysisFile af:filelist){
//			ArrayList<TestModule> funcList = af.getFunctionList();
//			for (TestModule tm : funcList) {
//				addTable(table, generateFunctionItem(af, tm));
//			}	
//		}
//		
//		// 初始化主窗体
//		initShell();
//		check();
//		// 创建函数调用关系图
//		createGraph();
//		// 打开主窗体
//		openShell();
//		
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("文件级函数调用关系图运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
//	}
	

	/**
	 * 从数据库读取覆盖率信息
	 * 
	 * @param fileName
	 * @param funcName
	 * @return
	 */
//	public ResultSet getCovInfoFromDB(String fileName, String funcName) {
//		DBinterfaceNew myDBDBinterface = DBinterfaceNew.getInstance();
//		myDBDBinterface.openDataBase(currentProject.getTestCaseDBname());
//		Statement stmt;
//		ResultSet result = null;
//		try {
//			stmt = myDBDBinterface.getDbcon().createStatement();
//			result = stmt
//					.executeQuery("SELECT * FROM TestResultLib where File_Name='"
//							+ fileName + "' and Func_Name='" + funcName + "'");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return result;
//	}
	

	public FunctionItem generateFunctionItem(AnalysisFile af, TestModule tm) {

		String funcHead = tm.getFuncName();// 函数头部
		String funcHead1 = tm.getFuncName2();
		String file = af.getFile().trim();// 文件名
		int startp = funcHead.indexOf('(');
		String parameters = funcHead.substring(startp);// 参数列表
		String typeAndName = funcHead.substring(0, startp);
		int startf = typeAndName.indexOf(" ");
		String returnType = typeAndName.substring(0, startf);// 返回值类型
		//String funcName1 = typeAndName.substring(startf + 1).trim();// 函数名
		String funcName1 = tm.getUniqueFuncName();
		String funcName;

		// 如果为指针函数，去掉前面的“*”
		if (funcName1.contains("*")) {
			int i = funcName1.indexOf('*');
			funcName = funcName1.substring(i + 1).trim();
		} else {
			funcName = funcName1;
		}

		// 生成一个函数调用关系节点
		FunctionItem item = new FunctionItem();
		Set<ASTPostfixExpression> set = new HashSet<ASTPostfixExpression>();
		List<ASTPostfixExpression> xlist = new ArrayList<ASTPostfixExpression>();
		item.setTm(tm);
		item.setAf(af);
		item.setFuncHead(funcHead);
		item.setFuncHead1(funcHead1);
		item.setFile(file);
		item.setFuncName(funcName);
		item.setParameters(parameters);
		item.setReturnType(returnType);
		item.setDef((ASTFunctionDefinition) tm.getFuncRoot());
		xlist = getCalleeNodesFromFunction(item.getDef());
		for (ASTPostfixExpression x : xlist) {
			set.add(x);
		}
		item.setSet(set);

		// 覆盖率
//		ResultSet result = getCovInfoFromDB(file, funcName1);
//		try {
//			while (result.next()) {
//				String[] covInfo = result.getString("Cov_Info").split(";");
//				for (int i = 0; i < covInfo.length; i++) {
//					String[] covInfoDetail = covInfo[i].split(":");
//					if (covInfoDetail[0].equals("语句覆盖")) {
//						if (item.getStmtCovInfo() != null) {
//							NumberFormat nf = NumberFormat.getPercentInstance();
//							try {
//								Number m1 = nf.parse(item.getStmtCovInfo());
//								Number m2 = nf.parse(covInfoDetail[1]);
//								if (m2.doubleValue() > m1.doubleValue()) {
//									item.setStmtCovInfo(covInfoDetail[1]);
//								}
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						} else {
//							item.setStmtCovInfo(covInfoDetail[1]);
//						}
//					} else if (covInfoDetail[0].equals("分支覆盖")) {
//						if (item.getBlockCovInfo() != null) {
//
//							NumberFormat nf = NumberFormat.getPercentInstance();
//							try {
//								Number m1 = nf.parse(item.getBlockCovInfo());
//								Number m2 = nf.parse(covInfoDetail[1]);
//								if (m2.doubleValue() > m1.doubleValue()) {
//									item.setBlockCovInfo(covInfoDetail[1]);
//								}
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						} else {
//							item.setBlockCovInfo(covInfoDetail[1]);
//						}
//					} else if (covInfoDetail[0].equals("MC/DC覆盖")) {
//						if (item.getMcdcCoverInfo() != null) {
//							NumberFormat nf = NumberFormat.getPercentInstance();
//							try {
//								Number m1 = nf.parse(item.getMcdcCoverInfo());
//								Number m2 = nf.parse(covInfoDetail[1]);
//								if (m2.doubleValue() > m1.doubleValue()) {
//									item.setMcdcCoverInfo(covInfoDetail[1]);
//								}
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						} else {
//							item.setMcdcCoverInfo(covInfoDetail[1]);
//						}
//					}
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return item;
	}

	/**
	 * 从函数定义节点获取调用语句节点，可以从ASTPostfixExpression.getImage()获取调用函数的函数名
	 * 
	 * @param def
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ASTPostfixExpression> getCalleeNodesFromFunction(
			ASTFunctionDefinition def) {
		String xpathString = ".//PostfixExpression[@Operators='(']";
		CTSsofttest.cfg.c.Graph cfg = def.getGraph();
		VexNode entryNode = cfg.getEntryNode();
		SimpleNode entry_astnode = entryNode.getTreenode();
		List<ASTPostfixExpression> xList = null;
		try {
			xList = entry_astnode.findChildNodesWithXPath(xpathString);
		} catch (JaxenException e) {
			e.printStackTrace();
		}
		return xList;
	}

	/**
	 * 生成函数头部与函数节点（FunctionItem）的映射关系
	 * 
	 * @param table
	 * @param item
	 */
	public void addTable(Map<String, List<FunctionItem>> table,
			FunctionItem item) {
		// 如果table中不包含item.getFuncHead()，就把item.getFuncHead()放进table，新建一个FunctionItem类型的链表
		if (!table.containsKey(item.getFuncHead1()))
			table.put(item.getFuncHead1(), new ArrayList<FunctionItem>());
		List<FunctionItem> list = table.get(item.getFuncHead1()); // 取item.getFuncName()的FunctionItem类型的链表
		list.add(item); // 把item加入list
	}

	/**
	 * 初始化主窗体
	 */
	private void initShell() {
		shell = new Shell(display); // shell是程序的主窗体
		shell.setText("函数调用图");
		shell.setBounds(50, 50, 800, 600);
		GridLayout gridLayout = new GridLayout();// 创建网格布局对象
		gridLayout.numColumns = 5; // 设置网格布局列数为1
		shell.setLayout(gridLayout); // 将shell设置为指定的网格布局式样
		shell.setSize(1400, 750); // 设置主窗体的大小
//		shell.setMaximized(true); //设置窗口最大化
//		shell.setSize(1500, 850); // 设置主窗体的大小
		//shell居中
		Rectangle bounds = display.getPrimaryMonitor().getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);    
	}
	

	/**
	 * 创建Graph
	 */
	private void createGraph() {
		gd_graph = new GridData(); // 创建网格布局数据对象
		gd_graph.horizontalSpan = 4; // 水平方向跨4列
		gd_graph.verticalSpan = 1; // 垂直方向跨1行
		gd_graph.horizontalAlignment = GridData.FILL; // 水平方向充满
		gd_graph.grabExcessVerticalSpace = true; // 抢占垂直方向额外空间
		gd_graph.verticalAlignment = GridData.FILL; // 垂直方向充满
		gd_graph.grabExcessHorizontalSpace = true; // 抢占水平方向额外空间
		graph = new Graph(shell, SWT.NONE);
		graph.setLayout(new FillLayout());
		graph.applyLayout();
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED); // 设置节点间连线为带箭头的直线
		Menu menu = new Menu(graph); // 创建右键菜单
		graph.setMenu(menu);
		AntiAliasing(); // 图像抗锯齿
		creatFuncdefNodesAndConnections(); // 创建节点和连线
//		target=funcdefmap2.get("asctoe113");
		target=funcdefmap2.get(ti.func);
		if(target!=null)
		target.setBackgroundColor(darkBlueColor);//设置目标节点
//		System.out.println(father);
		layoutSet(); // 布局设置
		mouseListener(); // 鼠标事件
		selectionListener(); // 注册对象选择侦听事件
		creatFuncList(); // 创建函数列表
		creatPathText();
		genbasicPath();				
		createNote(); // 创建图例
		colorNodeOut();
//		creatButton();
			
				
	}
	private Text text=null;
	private void creatPathText(){
		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true,false ,
				5, 1);
//		gd_composite.widthHint = 200;
		gd_composite.heightHint=100;
		composite.setLayoutData(gd_composite);

		group = new Group(composite, SWT.NONE);
		group.setText("路径输出");
		group.setLayout(new FillLayout(SWT.HORIZONTAL));

		
		text=new Text(group, SWT.LEFT|SWT.WRAP|SWT.V_SCROLL|SWT.BORDER);

		text.setEditable(false);

	}
	private void creatButton(){

		Composite bComposite = new Composite(shell, SWT.NONE);
		bComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData();
		
		gd_composite.widthHint = 200;
		bComposite.setLayoutData(gd_composite);
		gd_composite.verticalSpan = 1; // 跨1行
		gd_composite.horizontalSpan = 5; // 跨5列
		gd_composite.verticalAlignment = GridData.FILL; // 垂直方向充满
		gd_composite.horizontalAlignment = GridData.FILL;// 水平方向充满

		bottomComposite = new Composite(bComposite, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 20;
		rowLayout.justify = true;
		bottomComposite.setLayout(rowLayout);
		org.eclipse.swt.widgets.Button bt1=new org.eclipse.swt.widgets.Button(bottomComposite,  SWT.NONE);
		bt1.setText("显示溯源结果");
		
//		[f6, f6<-f4<-f3<-f2<-f1, f6<-f4<-f3, f6<-f4, f6<-f4<-f3<-f2]
//		pathSetDTS .add("f6");
//		pathSetDTS .add("f6<-f4<-f3<-f2<-f1");
//		pathSetDTS .add("f6<-f4<-f3");
//		pathSetDTS .add("f6<-f4");
//		pathSetDTS .add("f6<-f4<-f3<-f2");
		
		nodeListQueue.clear();
		if(pathSetDTS==null||pathSetDTS.isEmpty()){
			System.out.println("溯源结果为空");
			bt1.setEnabled(false);
		}else{
			bt1.setEnabled(true);
			for(String s:pathSetDTS){
				nodeListQueue.add(s);
			}
		}
		
		bt1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				String s = nodeListQueue.poll();
				nodeListQueue.add(s);
				System.out.println("11");
				for(GraphNode node:oldColorMap.keySet()){
					node.setBackgroundColor(oldColorMap.get(node));
				}
				String[] nodeList=s.split("<-");
				for(String node:nodeList){
					if(funcdefmap2.containsKey(node)){
						funcdefmap2.get(node).setBackgroundColor(greenColor);
					}else if(nonfuncdefmap.containsKey(node)){
						nonfuncdefmap.get(node).setBackgroundColor(greenColor);
					}
				}
				funcdefmap2.get(ti.func).setBackgroundColor(darkBlueColor);
			}
		});



		bottomComposite.pack();
	
	}
	/**
	 * 图像抗锯齿
	 */
	private void AntiAliasing() {
		Listener[] listeners = graph.getListeners(SWT.Paint);
		for (int i = 0; i < listeners.length; i++) {
			graph.removeListener(SWT.Paint, listeners[i]);
		}
		graph.addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.gc.setAntialias(SWT.ON);
				event.gc.setTextAntialias(SWT.ON);
			}
		});
		for (int i = 0; i < listeners.length; i++) {
			graph.addListener(SWT.Paint, listeners[i]);
		}
	}
	
	private Color lineColor=null;
	private  int lineWidth=-1;
	private HashMap<String, String> funcLineNum=new HashMap<>();
	/**
	 * 创建节点和连线
	 */
	private void creatFuncdefNodesAndConnections() {
		FCGNode item;
		
		/**
		 * 创建起始节点
		 */
		Iterator<String> it = table2.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			List<FCGNode> val = (List<FCGNode>) table2.get(key);

				for (FCGNode i : val) {
					if(!i.flag){
						node = new GraphNode(graph, ZestStyles.NODES_FISHEYE,
								i.funcName);
						if(i.flag){
							node.setBackgroundColor(whiteColor);
							node.setForegroundColor(darkColor);
						}
							
						funcdefmap.put(i, node);
						graphNodeMap.put(node, i);
						funcdefmap1.put(i.funcName, node);
						funcdefmap2.put(i.funcName, node);
//						funcLineNum.put(i.getFuncName(),i.getTm().getBeginLine()+"--"+i.getTm().getEndLine());
						oldColorMap.put(node, node.getBackgroundColor());
					}
					
				}

		}

		/**
		 * 创建终止节点和连线
		 */
		Iterator<String> it1 = table2.keySet().iterator();
		while (it1.hasNext()) {
			String key = (String) it1.next();
			List<FCGNode> val = (List<FCGNode>) table2.get(key);
			if (val.size() == 1) {
				item = val.get(0);
				Set<FCGNode> set = item.childs;
				// 创建一个节点，此节点在funcdefmap中
				node1 = funcdefmap.get(item);
				if (set.size() != 0) {
					for (FCGNode s : set) {
						// 如果这个函数节点是外部函数
						if (s.flag&& !nonfuncdefmap.containsKey(s.funcName)) {

//							 创建另一个节点
							if(type!=0){
								if(!s.flag){
									node2 = new GraphNode(graph,
											ZestStyles.NODES_FISHEYE, s.funcName);
									if(s.flag){
										node2.setBackgroundColor(whiteColor);
										node2.setForegroundColor(darkColor);
									}
										
									node2.setBackgroundColor(whiteColor);
									node2.setForegroundColor(darkColor);
									graphNodeMap.put(node2, s);
									oldColorMap.put(node2, node2.getBackgroundColor());
								}else{
									node2=null;
								}
								
							}
							
//							 创建节点关联
							if(node1 != node2&&node1!=null&&node2!=null)
							{
								if(type!=0){
									GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
									if(lineWidth==-1){
										lineColor=gcConnection.getLineColor();
										lineWidth=gcConnection.getLineWidth();
									}
									nonfuncdefmap.put(s.funcName, node2);
									if(father.keySet().contains(node2)){
										father.get(node2).add(node1);
									}else{
										father.put(node2, new HashSet<GraphNode>());
										father.get(node2).add(node1);
									}
									if(childs.keySet().contains(node1)){
										childs.get(node1).add(node2);
									}else{
										childs.put(node1, new HashSet<GraphNode>());
										childs.get(node1).add(node2);
									}
									
//									graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
								}
								
							}else if(node1!=null&&node2!=null){
								graphNodeMap.get(node1).isRecursion=1; //存在函数递归调用
//								node1.setBackgroundColor(darkBlueColor);
								System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
							}
						} else if (funcdefmap1.containsKey(s.funcName)) {
							node2 = funcdefmap1.get(s.funcName);
							oldColorMap.put(node2, node2.getBackgroundColor());
							if(node1!=null&&node2!=null&&node1 != node2)
							{
								GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
								if(lineWidth==-1){
									lineColor=gcConnection.getLineColor();
									lineWidth=gcConnection.getLineWidth();
								}
								if(father.keySet().contains(node2)){
									father.get(node2).add(node1);
								}else{
									father.put(node2, new HashSet<GraphNode>());
									father.get(node2).add(node1);
								}
								if(childs.keySet().contains(node1)){
									childs.get(node1).add(node2);
								}else{
									childs.put(node1, new HashSet<GraphNode>());
									childs.get(node1).add(node2);
								}
//								graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
							}else if(node1!=null){
								FCGNode fitem = graphNodeMap.get(node1);
								fitem.isRecursion=1; //存在函数递归调用
//								node1.setBackgroundColor(darkBlueColor);
								System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
							}
						} else {
							node2 = nonfuncdefmap.get(s.funcName);
							oldColorMap.put(node2, node2.getBackgroundColor());
							if(node1!=null&&node2!=null&&node1 != node2)
							{
								GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
								if(lineWidth==-1){
									lineColor=gcConnection.getLineColor();
									lineWidth=gcConnection.getLineWidth();
								}
								if(father.keySet().contains(node2)){
									father.get(node2).add(node1);
								}else{
									father.put(node2, new HashSet<GraphNode>());
									father.get(node2).add(node1);
								}
								if(childs.keySet().contains(node1)){
									childs.get(node1).add(node2);
								}else{
									childs.put(node1, new HashSet<GraphNode>());
									childs.get(node1).add(node2);
								}
//								graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
							}else if(node1!=null){
								FCGNode fitem = graphNodeMap.get(node1);
								fitem.isRecursion=1; //存在函数递归调用
//								node1.setBackgroundColor(darkBlueColor);
								System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
							}
						}
					}
				}
			} else {
				for (FCGNode i : val) {
					Set<FCGNode> set = i.childs;
					// 创建一个节点
					node1 = funcdefmap.get(i);
					oldColorMap.put(node1, node1.getBackgroundColor());

					if (set.size() != 0) {
						for (FCGNode s : set) {

							if (s.flag&& !nonfuncdefmap.containsKey(s.funcName)) {
								// 创建另一个节点
								if(!s.flag){
									GraphNode node2 = new GraphNode(graph,
											SWT.NONE, s.funcName);
									graphNodeMap.put(node2, s);
									node2.setBackgroundColor(whiteColor);
									node2.setForegroundColor(darkColor);
									nonfuncdefmap.put(s.funcName, node2);
									oldColorMap.put(node2, node2.getBackgroundColor());
								}else{
									node2=null;
								}
								
								// 创建节点关联
								if(node1 != node2&&node1!=null&&node2!=null)
								{
									GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
									if(lineWidth==-1){
										lineColor=gcConnection.getLineColor();
										lineWidth=gcConnection.getLineWidth();
									}
									if(father.keySet().contains(node2)){
										father.get(node2).add(node1);
									}else{
										father.put(node2, new HashSet<GraphNode>());
										father.get(node2).add(node1);
									}
									if(childs.keySet().contains(node1)){
										childs.get(node1).add(node2);
									}else{
										childs.put(node1, new HashSet<GraphNode>());
										childs.get(node1).add(node2);
									}
//									graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
								}else if(node1!=null){
									FCGNode fitem = graphNodeMap.get(node1);
									fitem.isRecursion=1; //存在函数递归调用
//									node1.setBackgroundColor(darkBlueColor);
									System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
								}
							} else if (funcdefmap1.containsKey(s.funcName)) {
								node2 = funcdefmap1.get(s.funcName);
								oldColorMap.put(node2, node2.getBackgroundColor());
								if(node1!=null&&node2!=null&&node1 != node2)
								{
									GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
									if(lineWidth==-1){
										lineColor=gcConnection.getLineColor();
										lineWidth=gcConnection.getLineWidth();
									}
									if(father.keySet().contains(node2)){
										father.get(node2).add(node1);
									}else{
										father.put(node2, new HashSet<GraphNode>());
										father.get(node2).add(node1);
									}
									if(childs.keySet().contains(node1)){
										childs.get(node1).add(node2);
									}else{
										childs.put(node1, new HashSet<GraphNode>());
										childs.get(node1).add(node2);
									}
//									graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
								}else if(node1!=null){
									FCGNode fitem = graphNodeMap.get(node1);
									fitem.isRecursion=1; //存在函数递归调用
//									node1.setBackgroundColor(darkBlueColor);
									System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
								}
							} else {
								node2 = nonfuncdefmap.get(s.funcName);
								oldColorMap.put(node2, node2.getBackgroundColor());
								if(node1!=null&&node2!=null&&node1 != node2)
								{
									GraphConnection gcConnection=new GraphConnection(graph, SWT.NONE, node1, node2);
									if(lineWidth==-1){
										lineColor=gcConnection.getLineColor();
										lineWidth=gcConnection.getLineWidth();
									}
									if(father.keySet().contains(node2)){
										father.get(node2).add(node1);
									}else{
										father.put(node2, new HashSet<GraphNode>());
										father.get(node2).add(node1);
									}
									if(childs.keySet().contains(node1)){
										childs.get(node1).add(node2);
									}else{
										childs.put(node1, new HashSet<GraphNode>());
										childs.get(node1).add(node2);
									}
//									graphNodeMap.get(node1).setIsRecursion(0); //不存在函数递归调用
								}else if(node1!=null){
									FCGNode fitem = graphNodeMap.get(node1);
									fitem.isRecursion=1; //存在函数递归调用
//									node1.setBackgroundColor(darkBlueColor);
									System.out.println(node1.getText() + "-----------------------------Exiting recusive calling!");
								}
							}
						}
					}
				}
			}
		}
		int height,width;
		for(GraphNode node:oldColorMap.keySet()){
			
			height =node.getSize().height;
			width=node.getSize().width;
			node.setSize(width*1.3, height*1.3);
		}
		System.out.println(nonfuncdefmap.size());
		System.out.println(nonfuncdefmap.keySet());
		System.out.println(funcdefmap2.size());
		System.out.println(funcdefmap2.keySet());
	}

	/**
	 * 布局设置
	 */
	private void layoutSet() {
		// 布局设置
//		 graph.setLayoutAlgorithm(new GridLayoutAlgorithm(
//		 LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
//		 graph.setLayoutData(gd_graph);

		CompositeLayoutAlgorithm compositeLayoutAlgorithm = new CompositeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING, new LayoutAlgorithm[] {
//						new GridLayoutAlgorithm(
//								LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new DirectedGraphLayoutAlgorithm(
								LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(
								LayoutStyles.NO_LAYOUT_NODE_RESIZING) });
		graph.setLayoutAlgorithm(compositeLayoutAlgorithm, true);
		graph.setLayoutData(gd_graph);

	}

	/**
	 * 鼠标事件
	 */
	private void mouseListener() {
		graph.addMouseListener(new MouseAdapter() { // 采用鼠标监听适配器
			@Override
			/**
			 * 鼠标双击事件
			 */
			public void mouseDoubleClick(MouseEvent e) { // 监听鼠标双击事件的方法
				List selection = ((Graph) e.widget).getSelection();
				// 确认只选择了一个对象
				if (selection.size() == 1) {
					Object o = selection.get(0);
					// 图形节点对象
					if ((o instanceof GraphNode)
							&& !(((GraphNode) o).getBackgroundColor()
									.equals(whiteColor))) {
						// 如果为main函数怎么办？？？
						// String func = ((GraphNode) o).getText();
						FCGNode node = graphNodeMap.get((GraphNode) o);
						if(!node.openCFG){
//							AnalysisFile af = graphNodeMap.get((GraphNode) o).getAf();
							// add by liuwenjing 用zest显示函数的控制流图
							
							HashSet<Integer> copyOutNum=new HashSet<>(ti.outNum);//储存工程级的外部输入源用于以后恢复
								softtest.PFCGandCFG.ControlFlowGraph cfg = new softtest.PFCGandCFG.ControlFlowGraph();
								cfg.ti=ti;
								cfg.type=type;
								if(next.get((GraphNode) o)!=null)
									cfg.nextNodeName=next.get((GraphNode) o).getText();
								if(node.cVexNode!=null&&node.graph==null){
									ControlFlowVisitor cfv = new ControlFlowVisitor(node.srcfile);
									ControlFlowData flow = new ControlFlowData();
									softtest.ast.c.SimpleNode node2 = node.cVexNode.getMethodNameDeclaration().getNode();
									if (node2 instanceof softtest.ast.c.ASTFunctionDefinition){
									cfv.visit((softtest.ast.c.ASTFunctionDefinition)node2, flow);
									softtest.cfg.c.Graph graph = ((softtest.ast.c.ASTFunctionDefinition) node2).getGraph();
									node.graph=graph;								
									}
								}
								cfg.node=node;
								
								try{
									cfg.generate(node.graph);
								}catch(Exception e2){
									e2.printStackTrace();
									node.openCFG=false;
								}
								node.openCFG=false;
								ti.outNum.clear();
								ti.outNum.addAll(copyOutNum);//恢复外部输入源
						}
	
					}
				}
			}

			/**
			 * 鼠标右键事件
			 */
//			public void mouseDown(MouseEvent e) { // 监听鼠标按下
//				if (e.button == 3) {
//					List selection = ((Graph) e.widget).getSelection();
//					Menu m = graph.getMenu();
//					// 确认只选择了一个对象
//					if (selection.size() == 1) {
//						final Object o = selection.get(0);
//						// 图形节点对象
//						if ((o instanceof GraphNode) && !((GraphNode) o).getBackgroundColor().equals(whiteColor)) {
//							final String funcString = ((GraphNode) o).getText();
							// final String fNameString =
							// graphNodeMap.get((GraphNode) o).getFuncHead();
							// final TestModule tm =
							// graphNodeMap.get((GraphNode) o).getTm();
							// final AnalysisFile af =
							// graphNodeMap.get((GraphNode) o).getAf();
//
//							// 查看源代码
//							MenuItem mi_1 = new MenuItem(m, SWT.NONE);
//							mi_1.setText("查看源代码");
//							mi_1.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event e) { // 向指定用户发送消息!
//									showSourceCodeWindow(graphNodeMap.get(
//											(GraphNode) o).getTm());
//								}
//							});
//							// 控制流图
//							MenuItem mi_9 = new MenuItem(m, SWT.NONE);
//							mi_9.setText("查看控制流图");
//							mi_9.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
////									doShowSimpleCFG(
////											graphNodeMap.get((GraphNode) o)
////													.getTm(),
////											graphNodeMap.get((GraphNode) o)
////													.getAf());
////									ControlFlowGraph cfg = new ControlFlowGraph();
////									cfg.initControlFlowGraph(
////											graphNodeMap.get((GraphNode) o)
////											.getAf().getCFGPicDir()
////											+ graphNodeMap.get((GraphNode) o).getFile().substring(graphNodeMap.get((GraphNode) o).getFile().lastIndexOf('/'), graphNodeMap.get((GraphNode) o).getFile().length() - 2) + "_"
////											+ graphNodeMap
////													.get((GraphNode) o)
////													.getTm()
////													.getUniqueFuncName()
////											+ "_simple" + ".dot", 0); // 0代表控制流图
//									TestModule tm = graphNodeMap.get((GraphNode) o).getTm();
//									AnalysisFile af = graphNodeMap.get((GraphNode) o).getAf();
//									doShowControlFlowGraph(tm, af);
//									ControlFlowGraph cfg = new ControlFlowGraph();
//									
//									
//									cfg.initControlFlowGraph(af.getCFGPicDir()
//											+ File.separator + tm.getUniqueFuncName()
//											+ ".dot", 0,graphNodeMap.get((GraphNode)o).getTm()); //0代表控制流图
////									cfg.setPctp(pctp);
//								}
//							});
//							// 简化的控制流图
//							MenuItem mi_0 = new MenuItem(m, SWT.NONE);
//							mi_0.setText("查看简化的控制流图");
//							mi_0.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									doShowSimpleCFG(
//											graphNodeMap.get((GraphNode) o)
//													.getTm(),
//											graphNodeMap.get((GraphNode) o)
//													.getAf());
//									ControlFlowGraph cfg = new ControlFlowGraph();
//									cfg.initControlFlowGraph(
//											graphNodeMap.get((GraphNode) o)
//											.getAf().getCFGPicDir()
//											+ graphNodeMap.get((GraphNode) o).getFile().substring(graphNodeMap.get((GraphNode) o).getFile().lastIndexOf('/'), graphNodeMap.get((GraphNode) o).getFile().length() - 2) + "_"
//											+ graphNodeMap
//													.get((GraphNode) o)
//													.getTm()
//													.getUniqueFuncName()
//											+ "_simple" + ".dot", 1,graphNodeMap.get((GraphNode)o).getTm()); // 1代表简化的控制流图
//								}
//							});
//
//							// 高亮子节点
//							MenuItem mi_3 = new MenuItem(m, SWT.NONE);
//							mi_3.setText("高亮子节点");
//							mi_3.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									List<GraphConnection> childs = ((GraphNode) o)
//											.getSourceConnections();
//									for (GraphConnection gc : childs) {
//										GraphNode childnode = gc
//												.getDestination();
//										if (!childColorMap
//												.containsKey(childnode)) {
//											Color oldColor = childnode
//													.getBackgroundColor();
//											RGB rgb = oldColor.getRGB();
//											childColorMap.put(
//													childnode,
//													new Color(Display
//															.getCurrent(), rgb));
//										}
//										childnode
//												.setBackgroundColor(yelloColor);
//										gc.setLineColor(yelloColor);
//									}
//								}
//							});
//							// 取消高亮子节点
//							MenuItem mi_4 = new MenuItem(m, SWT.NONE);
//							mi_4.setText("取消高亮子节点");
//							mi_4.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									List<GraphConnection> childs = ((GraphNode) o)
//											.getSourceConnections();
//									for (GraphConnection gc : childs) {
//										GraphNode childnode = gc
//												.getDestination();
//										childnode
//												.setBackgroundColor(childColorMap
//														.get(childnode));
//										gc.setLineColor(Display.getCurrent()
//												.getSystemColor(SWT.COLOR_GRAY));
//									}
//								}
//							});
//							// 高亮父节点
//							MenuItem mi_5 = new MenuItem(m, SWT.NONE);
//							mi_5.setText("高亮父节点");
//							mi_5.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									List<GraphConnection> parents = ((GraphNode) o)
//											.getTargetConnections();
//									for (GraphConnection gc : parents) {
//										GraphNode parentnode = gc.getSource();
//										if (!parentColorMap
//												.containsKey(parentnode)) {
//											Color oldColor = parentnode
//													.getBackgroundColor();
//											RGB rgb = oldColor.getRGB();
//											parentColorMap.put(
//													parentnode,
//													new Color(Display
//															.getCurrent(), rgb));
//										}
//										parentnode
//												.setBackgroundColor(yelloColor);
//										gc.setLineColor(yelloColor);
//									}
//
//								}
//							});
//							// 取消高亮父节点
//							MenuItem mi_6 = new MenuItem(m, SWT.NONE);
//							mi_6.setText("取消高亮父节点");
//							mi_6.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									List<GraphConnection> parents = ((GraphNode) o)
//											.getTargetConnections();
//									for (GraphConnection gc : parents) {
//										GraphNode parentnode = gc.getSource();
//										parentnode
//												.setBackgroundColor(parentColorMap
//														.get(parentnode));
//										gc.setLineColor(Display.getCurrent()
//												.getSystemColor(SWT.COLOR_GRAY));
//									}
//								}
//							});
//							
//							// 高亮函数闭包
//							MenuItem mi_7 = new MenuItem(m, SWT.NONE);
//							mi_7.setText("高亮函数闭包");
//							mi_7.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									Queue<GraphNode> queue = new LinkedList<GraphNode>();
//									queue.offer((GraphNode)o);
//									visited.clear();
//									visited.add((GraphNode)o);
//									
//									while(!queue.isEmpty()) {
//										GraphNode next = queue.poll();
//										if (!childColorMap.containsKey(next)) {
//											Color oldColor = next.getBackgroundColor();
//											RGB rgb = oldColor.getRGB();
//											childColorMap.put(next, new Color(Display.getCurrent(), rgb));
//										}
////										next.setBackgroundColor(yelloColor);
//										List<GraphConnection> childs = next.getSourceConnections();//取孩子节点
//										for (GraphConnection gc : childs) {
//											GraphNode child = gc.getDestination();
//											
//											if (!visited.contains(child)) {
//												//修改颜色	
//												if (!childColorMap.containsKey(child)) {
//													Color oldColor = child.getBackgroundColor();
//													RGB rgb = oldColor.getRGB();
//													childColorMap.put(child, new Color(Display.getCurrent(), rgb));
//												}
//												child.setBackgroundColor(yelloColor);
//												gc.setLineColor(yelloColor);	
//											
//												visited.add(child);
//												queue.offer(child);
//											}
//										}
//									}	
//								}
//							});
							// 取消高亮函数闭包
//							MenuItem mi_8 = new MenuItem(m, SWT.NONE);
//							mi_8.setText("取消高亮函数闭包");
//							mi_8.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									for (GraphNode child : visited) {
//										child.setBackgroundColor(childColorMap.get(child));	
//										List<GraphConnection> gcs = child.getTargetConnections();//取与父节点的连线
//										for(GraphConnection gc : gcs){
//											gc.setLineColor(Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
//										}										
//									}
//								}
//							});
							
							// 函数属性
//							MenuItem mi_2 = new MenuItem(m, SWT.NONE);
//							mi_2.setText(GUILanguageResource
//									.getProperty("FuncAttribute"));
//							mi_2.addListener(SWT.Selection, new Listener() {
//								public void handleEvent(Event arg0) {
//									// update analysis file
//									currentProject.updateFileList(graphNodeMap
//											.get((GraphNode) o).getAf());
//
//									UATAttributeGUI funcAttributeGUI = new UATAttributeGUI(
//											currentProject);
//									funcAttributeGUI
//											.showFunctionAttribute(graphNodeMap
//													.get((GraphNode) o)
//													.getFuncHead());
//								}
//							});
//							
//							while (m.getItemCount() > 10) {
//								MenuItem mi = m.getItem(0);
//								mi.dispose();
//							}
//						} else if (o instanceof GraphNode) {
//							if (((GraphNode) o).getBackgroundColor().equals(whiteColor)) {
//								// 高亮子节点
//								MenuItem mi_3 = new MenuItem(m, SWT.NONE);
//								mi_3.setText("高亮子节点");
//								mi_3.addListener(SWT.Selection, new Listener() {
//									public void handleEvent(Event arg0) {
//										List<GraphConnection> childs = ((GraphNode) o)
//												.getSourceConnections();
//										for (GraphConnection gc : childs) {
//											GraphNode childnode = gc
//													.getDestination();
//											if (!childColorMap
//													.containsKey(childnode)) {
//												Color oldColor = childnode
//														.getBackgroundColor();
//												RGB rgb = oldColor.getRGB();
//												childColorMap.put(
//														childnode,
//														new Color(Display
//																.getCurrent(),
//																rgb));
//											}
//											childnode
//													.setBackgroundColor(yelloColor);
//											gc.setLineColor(yelloColor);
//										}
//									}
//								});
//								// 取消高亮子节点
//								MenuItem mi_4 = new MenuItem(m, SWT.NONE);
//								mi_4.setText("取消高亮子节点");
//								mi_4.addListener(SWT.Selection, new Listener() {
//									public void handleEvent(Event arg0) {
//										List<GraphConnection> childs = ((GraphNode) o)
//												.getSourceConnections();
//										for (GraphConnection gc : childs) {
//											GraphNode childnode = gc.getDestination();
//											childnode.setBackgroundColor(childColorMap.get(childnode));
//											gc.setLineColor(Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
//										}
//									}
//								});
//								// 高亮父节点
//								MenuItem mi_5 = new MenuItem(m, SWT.NONE);
//								mi_5.setText("高亮父节点");
//								mi_5.addListener(SWT.Selection, new Listener() {
//									public void handleEvent(Event arg0) {
//										List<GraphConnection> parents = ((GraphNode) o)
//												.getTargetConnections();
//										for (GraphConnection gc : parents) {
//											GraphNode parentnode = gc
//													.getSource();
//											if (!parentColorMap
//													.containsKey(parentnode)) {
//												Color oldColor = parentnode
//														.getBackgroundColor();
//												RGB rgb = oldColor.getRGB();
//												parentColorMap.put(
//														parentnode,
//														new Color(Display
//																.getCurrent(),
//																rgb));
//											}
//											parentnode
//													.setBackgroundColor(yelloColor);
//											gc.setLineColor(yelloColor);
//										}
//
//									}
//								});
//								// 取消高亮父节点
//								MenuItem mi_6 = new MenuItem(m, SWT.NONE);
//								mi_6.setText("取消高亮父节点");
//								mi_6.addListener(SWT.Selection, new Listener() {
//									public void handleEvent(Event arg0) {
//										List<GraphConnection> parents = ((GraphNode) o)
//												.getTargetConnections();
//										for (GraphConnection gc : parents) {
//											GraphNode parentnode = gc.getSource();
//											parentnode.setBackgroundColor(parentColorMap.get(parentnode));
//											gc.setLineColor(Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
//										}
//									}
//								});
//								
//								while (m.getItemCount() > 4) {
//									MenuItem mi = m.getItem(0);
//									mi.dispose();
//								}
//							}
//						} else {
//							while (m.getItemCount() > 0) {
//								MenuItem mi = m.getItem(0);
//								mi.dispose();
//							}
//						}
//					} else {
//						//排除库函数
//						MenuItem mi_1 = new MenuItem(m, SWT.NONE);
//						mi_1.setText("排除库函数");
//						mi_1.addListener(SWT.Selection, new Listener() {
//
//							@Override
//							public void handleEvent(Event arg0) {
//								// TODO Auto-generated method stub
//								for(String s :nonfuncdefmap.keySet()){
//									GraphNode curr = nonfuncdefmap.get(s);
//								    curr.setVisible(false);
//								    List<GraphConnection> sourcegcs = curr.getSourceConnections();
//								    for(GraphConnection gc : sourcegcs){
//								    	gc.setVisible(false);
//								    }
//								    List<GraphConnection> targets = curr.getTargetConnections();
//								    for(GraphConnection gc1 : targets){
//								    	gc1.setVisible(false);
//								    }
//								}
//							}
//						});
//						//包含库函数
//						MenuItem mi_2 = new MenuItem(m, SWT.NONE);
//						mi_2.setText("包含库函数");
//						mi_2.addListener(SWT.Selection, new Listener() {
//
//							@Override
//							public void handleEvent(Event arg0) {
//								// TODO Auto-generated method stub
//								for(String s :nonfuncdefmap.keySet()){
//									GraphNode curr = nonfuncdefmap.get(s);
//								    curr.setVisible(true);
//								    List<GraphConnection> sourcegcs = curr.getSourceConnections();
//								    for(GraphConnection gc : sourcegcs){
//								    	gc.setVisible(true);
//								    }
//								    List<GraphConnection> targets = curr.getTargetConnections();
//								    for(GraphConnection gc1 : targets){
//								    	gc1.setVisible(true);
//								    }
//								}
//							}
//						});
//						while (m.getItemCount() > 2) {
//							MenuItem mi = m.getItem(0);
//							mi.dispose();
//						}
//					}
//				}
//			}
		});
	}

	/**
	 * 注册对象选择侦听事件
	 */
	private void selectionListener() {
		graph.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// ystem.out.println(e);
				List selection = ((Graph) e.widget).getSelection();
				// 确认只选择了一个对象
				if (selection.size() == 1) {
					Object o = selection.get(0);
					// 图形节点对象
					if (o instanceof GraphNode) {
						insertData(list, (GraphNode) o);
						GraphNode node=(GraphNode) o;
//						if(type==0){
//							try{
//								ti.filePath=graphNodeMap.get(node).methodNode.getFileName();
//								ti.outNum.clear();
//								ti.outNum.addAll(listOut.get(graphNodeMap.get(node).methodNode.getFileName()).get(node.getText()));
//							}catch(NullPointerException e2){
//								System.out.println("该节点无高亮内容");
//								e2.printStackTrace();
//								
//							}
//						}
						
						// 图形关联对象
					} else if (o instanceof GraphConnection) {
						// 改变连线宽度
						((GraphConnection) o).setLineWidth(3);
					}
				}
			}
		});
	}

	private org.eclipse.swt.widgets.List listtemp=null;
	private Group groupTemp = null;
	private HashMap<GraphNode, GraphNode> next=new HashMap<GraphNode,GraphNode>();
	/**
	 * 创建函数列表
	 */
	private void creatFuncList() {

		composite = new Composite(shell, SWT.NONE);

		composite.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false,
				1, 1);
		gd_composite.widthHint = 200;
		gd_composite.heightHint=200;
		composite.setLayoutData(gd_composite);

		group = new Group(composite, SWT.NONE);
		group.setText("节点详细信息");
		
		group.setLayout(new FillLayout(SWT.HORIZONTAL));

		list = new org.eclipse.swt.widgets.List(group, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL);
		
		
		
			group = new Group(composite, SWT.NONE);
			groupTemp=group;
			
			
			GridLayout gridLayout= new GridLayout();
			group.setLayout(gridLayout);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			
			
			
			org.eclipse.swt.widgets.Button bt2=new org.eclipse.swt.widgets.Button(group,  SWT.NONE);
			if(type==1)
				bt2.setText("隐藏路径分析结果");
			if(type==0)
				bt2.setText("隐藏溯源结果");
			bt2.setLayoutData(gd);
			
			
			
			final org.eclipse.swt.widgets.List list2 = new org.eclipse.swt.widgets.List(group, SWT.SINGLE|SWT.BORDER|SWT.V_SCROLL);
			
			listtemp=list2;
			
			gd = new GridData(GridData.FILL_BOTH);
			gd.grabExcessHorizontalSpace=true;
			gd.grabExcessVerticalSpace=true;
			list2.setLayoutData(gd);
			bt2.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
						ti.lineNum.clear();
						for(GraphNode node:oldColorMap.keySet()){
							node.setBackgroundColor(oldColorMap.get(node));
							List<GraphConnection> gcList=node.getSourceConnections();
							for(GraphConnection gc:gcList){
								gc.setLineColor(lineColor);
								gc.setLineWidth(lineWidth);
							}
						}
						if(type==1){
							text.setText("路径分析结果已隐藏");
							target.setBackgroundColor(darkBlueColor);
						}
							
						if(type==0){
							text.setText("溯源结果已隐藏");
							target.setBackgroundColor(darkBlueColor);
						}
							colorNodeOut();
						listtemp.deselectAll();
				}
			});
			list2.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
						
					if(list2.getSelectionIndex()>=0&&list2.getSelectionIndex()<basicPath.size()){
						for(GraphNode node:oldColorMap.keySet()){
							node.setBackgroundColor(oldColorMap.get(node));
							List<GraphConnection> gcList=node.getSourceConnections();
							for(GraphConnection gc:gcList){
								gc.setLineColor(lineColor);
								gc.setLineWidth(lineWidth);
							}
						}
						next.clear();
						String string=basicPath.get(list2.getSelectionIndex());
						String[] nodes={};
						if(type==1){
							nodes=string.split("-->");
						}else if (type==0) {
							String[] temp=string.split("<-");
							int b=0;
							nodes=temp.clone();
							for(int i=temp.length-1;i>=0;i--){								
								nodes[b]=temp[i];
								b++;
							}
						}
						GraphNode father=null;
						GraphNode child=null;
//						ti.lineNum.clear();
						HighlightFunction="";
						
						
						String[] temp;
						int begin,end;
						FCGNode tempNode=null;
						deepchainLineNum.clear();
						for(String node:nodes){
							if(funcdefmap2.containsKey(node)){
								funcdefmap2.get(node).setBackgroundColor(greenColor);
								tempNode=graphNodeMap.get(funcdefmap2.get(node));
								child=funcdefmap2.get(node);
								
								try{
									if(type==0&&ti.map2!=null){
										for(Integer I:ti.map2.get(node)){
//											ti.lineNum.add(I.toString());
											if(deepchainLineNum.values().contains(tempNode.srcfile)){
												deepchainLineNum.get(tempNode.srcfile).add(I.toString());
											}else{
												HashSet<String> tempSet=new HashSet<>();
												tempSet.add(I.toString());
												deepchainLineNum.put(tempNode.srcfile, tempSet);
											}
										}
									}else{
										temp=funcLineNum.get(node).split("--");
										begin=Integer.parseInt(temp[0]);
										end=Integer.parseInt(temp[1]);
										for(int i=begin;i<=end;i++){
											ti.lineNum.add(i+"");
										}
									}
									
								}catch(NullPointerException e){
									e.printStackTrace();
									System.out.println("获取函数行号失败");
								}
								
							}else if(nonfuncdefmap.containsKey(node)){
								nonfuncdefmap.get(node).setBackgroundColor(greenColor);
								child=nonfuncdefmap.get(node);
							}
							if(father!=null){
								List<GraphConnection>list=father.getSourceConnections();
								for(GraphConnection gc:list){
									if(gc.getDestination().equals(child)){
										gc.setLineColor(greenColor);
										gc.setLineWidth(3);
									}
								}
								next.put(father, child);
							}
							father=child;
						}
//						ti.HighlightFunction=new ArrayList<>();
//						ti.HighlightFunction.add(new HashSet<String>());
//						ti.HighlightFunction.get(0).add("pop_ovs");
						if(type==0&&ti.HighlightFunction!=null&&list2.getSelectionIndex()<ti.HighlightFunction.size()){
							colorHighlightFunction(ti.HighlightFunction.get(list2.getSelectionIndex()));
						}
						
						if(type==0){
							text.setText("文件："+ti.projectPath+"\\"+ti.objectFile+"\r\n目标点："+ti.func+"\r\n"+"路径："+string+"\r\n"+"相关函数："+HighlightFunction);
							
						}else{
							text.setText("文件："+ti.projectPath+"\\"+ti.objectFile+"\r\n目标点："+ti.func+"\r\n"+"路径："+string);
						}
						target.setBackgroundColor(darkBlueColor);
						
					}

					
					colorNodeOut();
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
		
		
//		gd_composite = new GridData();
//		gd_composite.widthHint = 200;
//		
//		gd_composite.verticalSpan = 1; // 跨1行
//		gd_composite.horizontalSpan = 5; // 跨5列
//		gd_composite.verticalAlignment = GridData.FILL; // 垂直方向充满
//		gd_composite.horizontalAlignment = GridData.FILL;// 水平方向充满
//
//		bottomComposite = new Composite(composite, SWT.NONE);
//		RowLayout rowLayout = new RowLayout();
//		rowLayout.spacing = 20;
//		rowLayout.justify = true;
//		bottomComposite.setLayout(rowLayout);
//
//		Composite composite1 = new Composite(bottomComposite, SWT.NONE);
//		rowLayout.spacing = 10;
//		rowLayout.justify = true;
//		rowLayout.center = true;
//		composite1.setLayout(rowLayout);
//		CLabel CoverCLabel = new CLabel(composite1, SWT.BORDER);
//		CoverCLabel.setText("       ");
//		CoverCLabel.setBackground(color9);
//		CoverCLabel = new CLabel(composite1, SWT.NONE);
//		CoverCLabel.setText("目标节点");
//		composite1.pack();
	}

	private void insertData(org.eclipse.swt.widgets.List list, GraphNode gn) {
		FCGNode funci = graphNodeMap.get(gn);
		if (funci == null) {
			list.removeAll();
			list.add("库函数节点");
		} else {
			list.removeAll();
//			list.add("文件名："
//					+ funci.methodNode.getFileName().substring(
//							funci.methodNode.getFileName().lastIndexOf('/') + 1));
			list.add("文件名："
					+funci.srcfile);
//			list.add(funci.cVexNode.toString());
			try{
				list.add(funci.aElement.getFileName());
			}catch(Exception e){
				
			}
			
			list.add("函数头部：");
			list.add(funci.methodNode.getMethod().getReturnType().toString());
			list.add("函数名：" + funci.funcName);
			list.add("参数列表:" + funci.methodNode.getMethod().getParameters());
			list.add("返回值类型：" + funci.methodNode.getMethod().getReturnType());
			list.add("逻辑父节点："+funci.parents);
			list.add("父节点：");
			// 找到所有父节点
			Set<String> parentSet = new HashSet<String>();
			List<GraphConnection> parents = gn.getTargetConnections();
			for (GraphConnection gc : parents) {
				GraphNode parentnode = gc.getSource();
				parentSet.add(graphNodeMap.get(parentnode).funcName);
			}
			list.add(parentSet.toString());
			list.add("子节点：");
			// 找到所有子节点
			Set<String> childSet = new HashSet<String>();
			for (FCGNode s : funci.childs) {
				if (s.funcName != "") {
					childSet.add(s.funcName);
				} 
			}
			list.add(childSet.toString());
//			if (funci.getStmtCovInfo() == null) {
//				list.add("语句覆盖率：未测试");
//			} else {
//				list.add("语句覆盖率：" + funci.getStmtCovInfo());
//			}
//			if (funci.getBlockCovInfo() == null) {
//				list.add("分支覆盖率：未测试");
//			} else {
//				list.add("分支覆盖率：" + funci.getBlockCovInfo());
//			}
//			if (funci.getMcdcCoverInfo() == null) {
//				list.add("MC/DC覆盖率：未测试");
//			} else {
//				list.add("MC/DC覆盖率：" + funci.getMcdcCoverInfo());
//			}
			if(funci.isRecursion == 1)
				list.add("是否存在函数递归调用：是" );
			else
				list.add("是否存在函数递归调用：否");
		}
	}

	/**
	 * 生成图例
	 */
	private void createNote() {
		Composite bComposite = new Composite(shell, SWT.NONE);
		bComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData();
		gd_composite.widthHint = 200;
		bComposite.setLayoutData(gd_composite);
		gd_composite.verticalSpan = 1; // 跨1行
		gd_composite.horizontalSpan = 5; // 跨5列
		gd_composite.verticalAlignment = GridData.FILL; // 垂直方向充满
		gd_composite.horizontalAlignment = GridData.FILL;// 水平方向充满

		bottomComposite = new Composite(bComposite, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 20;
		rowLayout.justify = true;
		bottomComposite.setLayout(rowLayout);

//		Composite composite1 = new Composite(bottomComposite, SWT.NONE);
//		rowLayout.spacing = 10;
//		rowLayout.justify = true;
//		rowLayout.center = true;
//		composite1.setLayout(rowLayout);
//		CLabel CoverCLabel = new CLabel(composite1, SWT.BORDER);
//		CoverCLabel.setText("       ");
//		CoverCLabel.setBackground(whiteColor);
//		CoverCLabel = new CLabel(composite1, SWT.NONE);
//		CoverCLabel.setText("库函数节点");
//		
//		composite1.pack();
		CLabel CoverCLabel = null;
		Composite composite1 = new Composite(bottomComposite, SWT.NONE);
		composite1.setLayout(rowLayout);
		CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(blueColor);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("函数定义节点");
		composite1.pack();
		
//		composite1 = new Composite(bottomComposite, SWT.NONE);
//		composite1.setLayout(rowLayout);
//		CoverCLabel = new CLabel(composite1, SWT.NONE);
//		CoverCLabel.setText("       ");
//		CoverCLabel.setBackground(darkBlueColor);
//		CoverCLabel = new CLabel(composite1, SWT.NONE);
//		CoverCLabel.setText("函数递归调用");
//		composite1.pack();

		composite1 = new Composite(bottomComposite, SWT.None);
		composite1.setLayout(rowLayout);
		CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(greenColor);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("路径覆盖节点");
		composite1.pack();

		composite1 = new Composite(bottomComposite, SWT.None);
		composite1.setLayout(rowLayout);
		CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(darkBlueColor);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("目标节点");
		composite1.pack();
		if(type==0){
			composite1 = new Composite(bottomComposite, SWT.None);
			composite1.setLayout(rowLayout);
			CoverCLabel = new CLabel(composite1, SWT.BORDER);
			CoverCLabel.setText("       ");
			CoverCLabel.setBackground(color2);
			CoverCLabel = new CLabel(composite1, SWT.NONE);
			CoverCLabel.setText("存在外部输入源");
			composite1.pack();
		}
		

		bottomComposite.pack();
	}

	/**
	 * 打开主窗体
	 */
	public void openShell() {
//		shell.open(); // 打开主窗体
		shell.open(); // 打开主窗体
		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	/**
	 * 为一个函数生成控制流图
	 */
	private void doShowControlFlowGraph(TestModule tm, AnalysisFile af) {
		final TestModule currentFunc = tm;
		final AnalysisFile currentFile = af;
		try {
			if (currentFunc == null)
				return;
			currentFunc.generateCFG(currentFile.getCFGPicDir());
		} catch (IOException e) {
			addOutputMessage("生成控制流图时发生异常 " + e.getMessage());
		}
	}

	private void doShowSimpleCFG(TestModule tm, AnalysisFile af) {
		final TestModule currentFunc = tm;
		final AnalysisFile currentFile = af;
		try {
			if (currentFunc == null)
				return;
			currentFunc.printCFG(currentFile.getCFGPicDir());
		} catch (Exception e) {
			addOutputMessage("生成简化的控制流图时发生异常 " + e.getMessage());
		}
	}

	private void addOutputMessage(String msg) {
		String timeMsg = new String();
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd" + " "
				+ "HH:mm:ss");
		String datetime = tempDate.format(new java.util.Date());
		timeMsg += datetime;
	}

	/**
	 * 查看函数的源代码
	 * 
	 * @param tm
	 */
	private void showSourceCodeWindow(TestModule tm) {

		final TestModule currentFunc = tm;
		if (currentFunc == null)
			return;
		UATSourceCodeWindow coverageWin;
		try {
			if (currentFunc != null) {
				coverageWin = new UATSourceCodeWindow(currentFunc);
				coverageWin.go();
			}
		} catch (IOException e) {

		} catch (Exception e) {
			addOutputMessage("显示覆盖率信息时发生异常");
		}
	}

	/**
	 * 根据被调用函数节点取它的函数声明
	 * 
	 * @param s
	 * @return
	 */
	private String getFunHead(ASTPostfixExpression s) {
		Object o = s.getChildofType(ASTPrimaryExpression.class);
		if (o instanceof ASTPrimaryExpression) {
			ASTPrimaryExpression astnode = (ASTPrimaryExpression) o;
			if (astnode.isMethod()) {
				MethodNameDeclaration decl = astnode.getMethodDecl();
				return decl.getFullName();

			} else {
				return "";
			}
		} else {
			return "";
		}
	}

}
