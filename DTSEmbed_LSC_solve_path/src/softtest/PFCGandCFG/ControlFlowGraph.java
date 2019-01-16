package softtest.PFCGandCFG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.DoubleClickEvent;
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
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.jaxen.JaxenException;
import org.omg.CORBA.PRIVATE_MEMBER;

import softtest.ast.c.ParseException;
import softtest.cfg.c.Edge;
import softtest.cfg.c.VexNode;
import softtest.domain.c.analysis.SpecificFuncIntervalGraphGen;
import unittest.callinggraph.Client;
//import unittest.module.seperate.TestModule;
//import unittest.path.PathChooseTest4Project;
import unittest.path.TestInfo;
//import unittest.pathchoose.util.path.OnePath;
import unittest.util.AnalysisFile;

public class ControlFlowGraph {

	/** 用于接收刘思伟的信息 */
	private Map<Integer, String> infoMap;
	public TestInfo ti;
	
	public int type=-1;
	public FCGNode node=null;
	public HashSet<Integer> listOut = new HashSet<Integer>();
	/** 用于标记是否验证测试用例 */
	private boolean verify = false;
	/** 路径上的下一个节点 */
	public String nextNodeName = "";
	/** 调用下一个节点的位置 */
	private List<GraphNode> next = new ArrayList<GraphNode>();
	private String fileName;
	private Display display = Display.getDefault(); // 该方法会返回用户图形界面线程中的Display实例,不管当前线程是否是用户图形界面线程.如果这个实例不存在,默认创建一个用户图形界面线程中的Display实例.
	public Shell shell = null;
	private Graph graph = null;
	private softtest.cfg.c.Graph cfgGraph = null;// 控制流图对象
//	TestModule tm = null;
	private softtest.cfg.c.VexNode target = null;
	private GridData gd_graph = null;
	static Map<String, List<String>> table = new HashMap<String, List<String>>();
	static Map<String, String> mapColor = new HashMap<String, String>();
	static Map<String, String> mapInfo = new HashMap<String, String>();
	private Color greenColor = new Color(Display.getCurrent(), 124, 252, 0); // 草坪绿
	private Color blueColor = new Color(Display.getCurrent(), 216, 228, 248);
	private static Color color1 = new Color(Display.getCurrent(), 255, 105, 180);// HotPink热情的粉红,与覆盖率不足300接近
	private static Color color2 = new Color(Display.getCurrent(), 255, 0, 255);// Magenta洋红
	private static Color color3 = new Color(Display.getCurrent(), 0, 0, 255);// Blue纯蓝
	private static Color color4 = new Color(Display.getCurrent(), 0, 191, 255);// DeepSkyBlue深天蓝
	private static Color color5 = new Color(Display.getCurrent(), 255, 255, 0);// Yellow纯黄，与高亮接近
	private static Color color6 = new Color(Display.getCurrent(), 255, 215, 0);// Gold金
	private static Color color7 = new Color(Display.getCurrent(), 255, 165, 0);// Orange橙色
	private static Color color8 = new Color(Display.getCurrent(), 0, 255, 127);// MediumSpringGreen适中的春天的绿色
	private static Color color9 = new Color(Display.getCurrent(), 0, 255, 0);// Lime酸橙色

	private Map<String, GraphNode> nodeMap = new HashMap<String, GraphNode>();
	private List<String> path = new ArrayList<String>();
	/** 用于存储所有的边 add by fkx 2018-9-14 */
	private Hashtable<String, GraphConnection> edgeMap = new Hashtable<String, GraphConnection>();
	private HashMap<String, GraphConnection> edgeMap2 = new HashMap<String, GraphConnection>();
	/** CFG是否需要高亮 add by fkx 2018-9-21 */
	private boolean highlight = false;
	/** vetnode to graphnode */
	public HashMap<softtest.cfg.c.VexNode, GraphNode> vexTographNode = new HashMap<softtest.cfg.c.VexNode, GraphNode>();

//	public static Set<OnePath> set = new HashSet();
//	private ArrayList<OnePath> opQueue = new ArrayList<OnePath>();

//	public static PathChooseTest4Project pctp = null;
	private HashMap<GraphNode, Color> nodeColor = new HashMap<GraphNode, Color>();
	private Color edgeColor = null;
	/** 此节点的函数名，去掉参数表和返回值声明 */
	private String funcName = "";
	org.eclipse.swt.widgets.Button bt2 = null;

	static {
		try {
			Class.forName("org.eclipse.swt.SWT");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Color yelloColor = new Color(Display.getCurrent(), 255, 255, 0);
	private Map<GraphNode, Color> childColorMap = new HashMap<GraphNode, Color>();
	private Map<GraphNode, Color> parentColorMap = new HashMap<GraphNode, Color>();

	private Composite composite;
	private Composite bottomComposite;
	private Group group;
	private org.eclipse.swt.widgets.List list;

	/** 用于存储所有的节点 add by fkx 2018-9-14 */

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	private void colorNodeOut() {
		if (type != 0)
			return;
		String file = node.srcfile;
		ti.filePath=file;
		Set<Integer> num;
		System.out.println("输出控制流节点号集合");
		System.out.println(num2Graphnode.keySet());
		try {
			
			num = FunctionCallingGraph.listOut.get(file).get(node.funcName);
//			System.out.println(num);
			GraphNode gNode=null;
			ti.outNum.clear();
			softtest.ast.c.SimpleNode sNode=null;
//			System.out.println("输出该节点外部输入源");
//			System.out.println(num);
//			for(Integer number:num2Graphnode.keySet()){
//				System.out.println(number+"    "+num2Graphnode.get(number).getText()+"              "+graphNode2Vex.get(num2Graphnode.get(number)).getName());
//				
//			}
			for (Integer node : num) {
//				for (GraphNode n : nodeMap.values()) {
//					if (n.getText().endsWith("_" + node.toString()))
//						n.setBackgroundColor(color2);
//					
//				}
				gNode=num2Graphnode.get(node);
				gNode.setBackgroundColor(color2);
				sNode=graphNode2Vex.get(gNode).getTreenode();
				ti.outNum.add(sNode.getBeginLine());
				ti.outNum.add(sNode.getEndLine());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("无外部输入源！");
		}

	}
	



	/**
	 * 找到调用下一个点的出口
	 */
	private void findNext() {
		if(node.funcRoot==null){
			return;
		}
		softtest.ast.c.ASTFunctionDefinition def =  node.funcRoot;
		String xpathString = ".//PrimaryExpression[@Image='" + nextNodeName + "']";
		softtest.cfg.c.Graph cfg = def.getGraph();
		softtest.cfg.c.VexNode entryNode = cfg.getEntryNode();
		softtest.ast.c.SimpleNode entry_astnode = entryNode.getTreenode();
		List<softtest.ast.c.ASTPostfixExpression> xList = null;
		try {
			xList = entry_astnode.findChildNodesWithXPath(xpathString);
		} catch (JaxenException e) {
			e.printStackTrace();
		}

		for (softtest.ast.c.SimpleNode node : xList) {
			int begin = node.getBeginLine();
			int end = node.getEndLine();
			int a = -999999, b = 999999;
			softtest.cfg.c.VexNode target = null;
			for (softtest.cfg.c.VexNode v : vexTographNode.keySet()) {
				if (a <= v.getTreenode().getBeginLine() && b >= v.getTreenode().getEndLine()) {
					if (v.getTreenode().getBeginLine() <= begin && v.getTreenode().getEndLine() >= end) {
						target = v;
						a = v.getTreenode().getBeginLine();
						b = v.getTreenode().getEndLine();
					}

				}

			}
			if (target != null)
				next.add(vexTographNode.get(target));

		}
	}

	/**
	 * 生成以出口为目标的路径
	 */
	private void findPath() {
		if (!funcName.equals(ti.func)) {
			findNext();
			System.out.println("打印next");
			for(GraphNode n:next){
				System.out.println(n.getText());
				n.setBorderWidth(3);
				n.setBorderColor(color1);
			}
			if (next.size() != 0 && target == null) {
				for (GraphNode node : next) {
					String path = "";
					findPathBasic(path, node);
				}
			}
			groupTemp.setText("路径列表(共" + path.size() + ")条");
			for (int i = 1; i <= path.size(); i++) {
				listtemp.add("基本路径" + i);
			}
		} else {
			String s = "";
			GraphNode node = nodeMap.get(nextNodeName);
			findPathBasic(s, node);
			groupTemp.setText("路径列表(共" + path.size() + ")条");
			for (int i = 1; i <= path.size(); i++) {
				listtemp.add("基本路径" + i);
			}
		}

	}

	private void findPathBasic(String old, GraphNode next) {
		String nString = next.getText() + "-->" + old;
		if (next.getTargetConnections() == null || next.getTargetConnections().size() == 0) {
			path.add(nString);
		} else {
			List<GraphConnection> gcList = next.getTargetConnections();
			for (GraphConnection gc : gcList) {
				if (!nString.contains(gc.getSource().getText()+"-->"))
					findPathBasic(nString, gc.getSource());
			}
		}

	}

	/**
	 * 初始化主窗体
	 */
	private void initShell() {
		shell = new Shell(display); // shell是程序的主窗体
		shell.setText("函数控制流图(" + node.funcName + ")");
		GridLayout gridLayout = new GridLayout();// 创建网格布局对象
		gridLayout.numColumns = 5; // 设置网格布局列数为1
		shell.setLayout(gridLayout); // 将shell设置为指定的网格布局式样
		shell.setSize(800, 800); // 设置主窗体的大小
		// shell居中
		Rectangle bounds = display.getPrimaryMonitor().getBounds();
		Rectangle rect = shell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		shell.setLocation(x, y);
	}

	/**
	 * 创建Graph
	 */
//	private void createGraph(int val) {
//		gd_graph = new GridData(); // 创建网格布局数据对象
//		gd_graph.horizontalSpan = 4; // 水平方向跨4列
//		gd_graph.verticalSpan = 1; // 垂直方向跨1行
//		gd_graph.horizontalAlignment = GridData.FILL; // 水平方向充满
//		gd_graph.grabExcessVerticalSpace = true; // 抢占垂直方向额外空间
//		gd_graph.verticalAlignment = GridData.FILL; // 垂直方向充满
//		gd_graph.grabExcessHorizontalSpace = true; // 抢占水平方向额外空间
//		graph = new Graph(shell, SWT.NONE);
//		graph.setLayout(new FillLayout());
//		graph.applyLayout();
//		graph.setLayoutData(gd_graph);
//		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED); // 设置节点间连线为带箭头的直线
//
//		AntiAliasing(); // 图像抗锯齿
////		String string = tm.getFuncName().substring(0, tm.getFuncName().indexOf("("));
////		string = string.substring(string.lastIndexOf(" ") + 1);
////		funcName = string;
//		try {
//			System.out.println("从Client接收以下节点区间信息：" + tm.getFuncName() + "文件：" + tm.getBelongToFile().getFile());
//			infoMap = Client.getInfoMap(tm.getBelongToFile().getFile(), funcName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		creatFuncdefNodesAndConnections(val); // 创建节点和连线
//
//		layoutSet(); // 布局设置
//
//		Menu menu = new Menu(graph); // 创建右键菜单
//		graph.setMenu(menu);
//		mouseListener(); // 鼠标事件
//		selectionListener(); // 注册对象选择侦听事件
//		creatFuncList(); // 创建函数列表
//
//		if (type == 1) {
//
//			if (funcName.equals(ti.func)) {
//				creatPathText();
//				creatNotes();
//				genPath(ti.targetLineNum);
//				System.out.println(tm.opToTc);
//			} else {
//				creatPathText();
//				creatNotes();
//				if (nextNodeName.length() > 0)
//					findPath();
//			}
//
//		} else if (type == 0) {
//			// createNote(); // 创建图例
//			// hightLightTarget(ti.targetLineNum);
//			
//			if (funcName.equals(ti.func)) {
//				creatPathText();
//				creatNotes();
//				genNextNode(ti.targetLineNum);
//				try {
//					nodeMap.get(target.getName()).setBackgroundColor(color4);
//				} catch (NullPointerException e1) {
//					e1.printStackTrace();
//				}
//				findPath();
//			} else {
//				creatPathText();
//				creatNotes();
//				if (nextNodeName.length() > 0)
//					findPath();
//			}
//			colorNodeOut();
//		}
//
//	}
	private void createGraph(softtest.cfg.c.Graph cfg) {
		cfgGraph=cfg;
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
		graph.setLayoutData(gd_graph);
		graph.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED); // 设置节点间连线为带箭头的直线

		AntiAliasing(); // 图像抗锯齿
//		String string = tm.getFuncName().substring(0, tm.getFuncName().indexOf("("));
//		string = string.substring(string.lastIndexOf(" ") + 1);
		funcName =node.funcName;
		
			System.out.println("从Client接收以下节点区间信息：" + funcName + "文件：" + node.srcfile);
			
			SpecificFuncIntervalGraphGen graphGen = new SpecificFuncIntervalGraphGen(node.srcfile,node.funcName);
			try {
				
				infoMap = graphGen.retrievefuncDomainInfo();
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		creatFuncdefNodesAndConnections(cfg); // 创建节点和连线

		layoutSet(); // 布局设置

		Menu menu = new Menu(graph); // 创建右键菜单
		graph.setMenu(menu);
		mouseListener(); // 鼠标事件
		selectionListener(); // 注册对象选择侦听事件
		creatFuncList(); // 创建函数列表

		if (type == 1) {

			if (funcName.equals(ti.func)) {
				creatPathText();
				creatNotes();
				genPath(ti.targetLineNum);
//				System.out.println(tm.opToTc);
			} else {
				creatPathText();
				creatNotes();
				if (nextNodeName.length() > 0)
					findPath();
			}

		} else if (type == 0) {
			// createNote(); // 创建图例
			// hightLightTarget(ti.targetLineNum);
			
			if (funcName.equals(ti.func)) {
				creatPathText();
				creatNotes();
				genNextNode(ti.targetLineNum);
				try {
					nodeMap.get(target.getName()).setBackgroundColor(color4);
				} catch (NullPointerException e1) {
					e1.printStackTrace();
				}
				findPath();
			} else {
				creatPathText();
				creatNotes();
				if (nextNodeName.length() > 0)
					findPath();
			}
			colorNodeOut();
		}

	}

	private void creatPathText() {
		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1);
		// gd_composite.widthHint = 200;
		gd_composite.heightHint = 100;
		composite.setLayoutData(gd_composite);

		group = new Group(composite, SWT.NONE);
		group.setText("路径输出");
		group.setLayout(new FillLayout(SWT.HORIZONTAL));

		text = new Text(group, SWT.LEFT | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);

		text.setEditable(false);

	}

	private Text text = null;
	private GraphNode temp;
	private Color color;

	/** 创建图例 */
	private void creatNotes() {
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

		Composite composite1 = new Composite(bottomComposite, SWT.NONE);
		rowLayout.spacing = 10;
		rowLayout.justify = true;
		rowLayout.center = true;
		composite1.setLayout(rowLayout);
		CLabel CoverCLabel;
		if (type == 0) {
			CoverCLabel = new CLabel(composite1, SWT.BORDER);
			CoverCLabel.setText("       ");
			CoverCLabel.setBackground(color2);
			CoverCLabel = new CLabel(composite1, SWT.NONE);
			CoverCLabel.setText("外部输入源");
			composite1.pack();
		}
		CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(color9);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("预选路径节点");
		composite1.pack();

//		if (TestModule.generateTestCase) {
//			CoverCLabel = new CLabel(composite1, SWT.BORDER);
//			CoverCLabel.setText("       ");
//			CoverCLabel.setBackground(color6);
//			CoverCLabel = new CLabel(composite1, SWT.NONE);
//			CoverCLabel.setText("验证成功节点");
//			composite1.pack();
//			CoverCLabel = new CLabel(composite1, SWT.BORDER);
//			CoverCLabel.setText("       ");
//			CoverCLabel.setBackground(color2);
//			CoverCLabel = new CLabel(composite1, SWT.NONE);
//			CoverCLabel.setText("实际执行节点");
//			composite1.pack();
//		}

		// composite1 = new Composite(bottomComposite, SWT.NONE);
		// composite1.setLayout(rowLayout);
		CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(color4);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("目标节点");
		composite1.pack();

		// bt1.setLayoutData(rowLayout);
		// bt1.pack();

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

	/**
	 * 布局设置
	 */
	private void layoutSet() {
		// 布局设置
		CompositeLayoutAlgorithm compositeLayoutAlgorithm = new CompositeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING,
				new LayoutAlgorithm[] { new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new DirectedGraphLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING),
						new HorizontalShift(LayoutStyles.NO_LAYOUT_NODE_RESIZING) });
		graph.setLayoutAlgorithm(compositeLayoutAlgorithm, true);
		graph.setLayoutData(gd_graph);

	}

	/**
	 * 创建节点和连线
	 */
	private void creatFuncdefNodesAndConnections(int val) {
		vexTographNode.clear();
		
		Map<String, GraphNode> nameToNode = new HashMap<String, GraphNode>();
		// 创建节点
		Iterator<Map.Entry<String, List<String>>> it = table.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<String>> entry = it.next();
			String nodeName = entry.getKey();
			List<String> cons = entry.getValue();
			GraphNode node;
			if (nameToNode.containsKey(nodeName)) {// 已经创建节点
				node = nameToNode.get(nodeName);

				nodeMap.put(node.getText(), node);
				nodeColor.put(node, node.getBackgroundColor());
				vexTographNode.put(cfgGraph.nodes.get(node.getText()), node);

			} else {
				node = new GraphNode(graph, SWT.NONE, nodeName);
				nameToNode.put(nodeName, node);
				nodeMap.put(node.getText(), node);
				nodeColor.put(node, node.getBackgroundColor());
				vexTographNode.put(cfgGraph.nodes.get(node.getText()), node);
			}

			for (String conName : cons) {
				String nodename = conName.substring(0, conName.indexOf('$'));
				String context = "";
				if (val == 0) { // 控制流图
					if (conName.contains("#")) {
						context = "          " + conName.substring(conName.indexOf('$') + 2, conName.length() - 2);
					} else {
						context = "          " + conName.substring(conName.indexOf('$') + 2, conName.length() - 1);
					}
					
				} 

				GraphNode node2;
				if (nameToNode.containsKey(nodename)) {// 已经创建节点
					node2 = nameToNode.get(nodename);
					nodeMap.put(node2.getText(), node2);
					nodeColor.put(node2, node2.getBackgroundColor());
					vexTographNode.put(cfgGraph.nodes.get(node2.getText()), node2);
				} else {
					node2 = new GraphNode(graph, SWT.NONE, nodename);
					nodeMap.put(node2.getText(), node2);
					nameToNode.put(nodename, node2);
					nodeColor.put(node2, node2.getBackgroundColor());
					vexTographNode.put(cfgGraph.nodes.get(node2.getText()), node2);
				}

				GraphConnection temp = new GraphConnection(graph, SWT.RIGHT, node, node2);
				temp.setText(context);
				edgeMap.put(node.getText() + "--" + node2.getText(), temp);
				// String text=new String(context);
				edgeMap2.put(temp.getText() + "", temp);

				edgeColor = temp.getLineColor();
				// temp=null;
			}

		}
		int height, width;
		for (GraphNode node : nodeColor.keySet()) {

			height = node.getSize().height;
			width = node.getSize().width;
			node.setSize(width * 1.3, height * 1.3);
		}
	}
	private HashMap<Integer, GraphNode> num2Graphnode=new HashMap<>();
	private HashMap<GraphNode , softtest.cfg.c.VexNode>graphNode2Vex =new HashMap<>();
	private void creatFuncdefNodesAndConnections(softtest.cfg.c.Graph cfg) {
		vexTographNode.clear();
		Map<String, GraphNode> nameToNode = new HashMap<String, GraphNode>();
		// 创建节点
		
		for(softtest.cfg.c.VexNode VexNode:cfg.nodes.values()){
			
			String nodeName = VexNode.getName();
			HashSet<Edge> cons = new HashSet<>();
			cons.addAll(VexNode.getOutedges().values());
			GraphNode node;
			if (nameToNode.containsKey(nodeName)) {// 已经创建节点
				node = nameToNode.get(nodeName);
				Integer num=Integer.valueOf(node.getText().substring(node.getText().lastIndexOf("_")+1));
				num2Graphnode.put(num, node);
				graphNode2Vex.put(node, VexNode);
				nodeMap.put(node.getText(), node);
				nodeColor.put(node, node.getBackgroundColor());
				vexTographNode.put(VexNode, node);

			} else {
				node = new GraphNode(graph, SWT.NONE, nodeName);
				Integer num=Integer.valueOf(node.getText().substring(node.getText().lastIndexOf("_")+1));
				nameToNode.put(nodeName, node);
				nodeMap.put(node.getText(), node);
				num2Graphnode.put(num, node);
				graphNode2Vex.put(node, VexNode);
				nodeColor.put(node, node.getBackgroundColor());
				vexTographNode.put(VexNode, node);
			}

			for (Edge conName : cons) {
				String nodename = conName.getHeadNode().getName();
				String context = conName.getName();
				
//					if (conName.contains("#")) {
//						context = "          " + conName.substring(conName.indexOf('$') + 2, conName.length() - 2);
//					} else {
//						context = "          " + conName.substring(conName.indexOf('$') + 2, conName.length() - 1);
//					}
					
				

				GraphNode node2;
				if (nameToNode.containsKey(nodename)) {// 已经创建节点
					node2 = nameToNode.get(nodename);
					Integer num=Integer.valueOf(node2.getText().substring(node2.getText().lastIndexOf("_")+1));
					num2Graphnode.put(num, node2);
					graphNode2Vex.put(node2, conName.getHeadNode());
					nodeMap.put(node2.getText(), node2);
					nodeColor.put(node2, node2.getBackgroundColor());
//					vexTographNode.put(cfgGraph.nodes.get(node2.getText()), node2);
				} else {
					node2 = new GraphNode(graph, SWT.NONE, nodename);
					Integer num=Integer.valueOf(node2.getText().substring(node2.getText().lastIndexOf("_")+1));
					nodeMap.put(node2.getText(), node2);
					nameToNode.put(nodename, node2);
					num2Graphnode.put(num, node2);
					graphNode2Vex.put(node2,conName.getHeadNode());
					nodeColor.put(node2, node2.getBackgroundColor());
					vexTographNode.put( conName.getHeadNode(), node2);
				}

				GraphConnection temp = new GraphConnection(graph, SWT.RIGHT, node, node2);
				temp.setText(context);
				edgeMap.put(node.getText() + "--" + node2.getText(), temp);
				// String text=new String(context);
				edgeMap2.put(temp.getText() + "", temp);

				edgeColor = temp.getLineColor();
				// temp=null;
			}

		}
		int height, width;
		for (GraphNode node : nodeColor.keySet()) {

			height = node.getSize().height;
			width = node.getSize().width;
			node.setSize(width * 1.3, height * 1.3);
		}
	}

	private void hightLightTarget(Integer lineNum) {
		target = null;
		if (lineNum == null)
			return;

		int a = -999999, b = 999999;
		for (softtest.cfg.c.VexNode v : vexTographNode.keySet()) {

			System.out.println("===========================");
			System.out.println(v.getName());
			System.out.println("begin");
			System.out.println(v.getTreenode().getBeginLine());
			// System.out.println(v.getTreenode().getBeginFileLine());
			System.out.println("end");
			System.out.println(v.getTreenode().getEndLine());
			// System.out.println(v.getTreenode().getEndFileLine());
			System.out.println("===========================");
			int begin = v.getTreenode().getBeginLine();
			int end = v.getTreenode().getEndLine();

			if (begin <= lineNum.intValue() && end >= lineNum.intValue()) {
				if (a <= begin && b >= end) {
					target = v;
					a = begin;
					b = end;
				}

			}

		}

		if (target == null) {

			System.out.println("行号范围有误");
			return;
		} else {
			vexTographNode.get(target).setBackgroundColor(color4);
		}

	}

	private void genNextNode(Integer lineNum) {
		target = null;
		if (lineNum == null)
			return;

		int a = -999999, b = 999999;
		for (softtest.cfg.c.VexNode v : vexTographNode.keySet()) {

			int begin = v.getTreenode().getBeginLine();
			int end = v.getTreenode().getEndLine();

			if (begin <= lineNum.intValue() && end >= lineNum.intValue()) {
				if (a <= begin && b >= end) {
					target = v;
					a = begin;
					b = end;
				}

			}

		}

		if (target == null) {
			bt2.setEnabled(false);
			listtemp.add("行号有误");
			listtemp.setEnabled(false);
			System.out.println("行号范围有误");
			return;
		}
		// Pathchoose.targetNode=target;
		// for(VexNode v:vexTographNode.keySet()){
		// System.out.println("K:"+v.getName()+"
		// V:"+vexTographNode.get(v).getText());
		// }
		System.out.println(target.getName());
		nextNodeName = vexTographNode.get(target).getText();
	}

	public void genPath(Integer lineNum) {
		
		target = null;
		if (lineNum == null)
			return;
		if(lineNum<0)
			return;
		int a = -1, b = 999999;
		for (softtest.cfg.c.VexNode v : vexTographNode.keySet()) {

			System.out.println("===========================");
			System.out.println(v.getName());
			System.out.println("begin");
			System.out.println(v.getTreenode().getBeginLine());
			// System.out.println(v.getTreenode().getBeginFileLine());
			System.out.println("end");
			System.out.println(v.getTreenode().getEndLine());
			// System.out.println(v.getTreenode().getEndFileLine());
			System.out.println("===========================");
			int begin = v.getTreenode().getBeginLine();
			int end = v.getTreenode().getEndLine();

			if (begin <= lineNum.intValue() && end >= lineNum.intValue()) {
				if (a <= begin && b >= end) {
					target = v;
					a = begin;
					b = end;
				}

			}

		}

		if (target == null) {
			bt2.setEnabled(false);
			listtemp.add("行号有误");
			listtemp.setEnabled(false);
			System.out.println("行号范围有误");
			return;
		}
//		Pathchoose.targetNode = target;
//		TestInfo.node = target;
		// for(VexNode v:vexTographNode.keySet()){
		// System.out.println("K:"+v.getName()+"
		// V:"+vexTographNode.get(v).getText());
		// }
		System.out.println(target.getName());
		
		GraphNode  gNode=vexTographNode.get(target);
		gNode.setBackgroundColor(color4);
		path.clear();
				String s = "";
				findPathBasic(s, gNode);
		
		groupTemp.setText("路径列表(共" + path.size() + ")条");
		for (int i = 1; i <= path.size(); i++) {
			listtemp.add("基本路径" + i);
		}
		
		

		String targetFuncName =node.funcName;
		String targetFileName = node.srcfile.substring(node.srcfile.lastIndexOf("\\"));

//		for (int i = 1; i <= opQueue.size(); i++) {
//			
//				listtemp.add("路径" + i);
//			
//
//		}
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
			 if (o instanceof GraphNode) {
				 GraphNode gNode=(GraphNode)o;
				 System.out.println(gNode.getText()+"双击成功");
				 VexNode vexNode=graphNode2Vex.get(gNode);
				 int begin=0,end=0;
				 if(vexNode!=null){
					 begin=vexNode.getTreenode().getBeginLine();
					 end=vexNode.getTreenode().getEndLine();
					//在此添加节点行号标记方法，begin为该节点起始行，end为结束行  @陈璐璐
				 }
				 
			 }
			 }
			 }

			/**
			 * 鼠标右键事件
			 */
			// public void mouseDown(MouseEvent e) { // 监听鼠标按下
			// if (e.button == 3) {
			// List selection = ((Graph) e.widget).getSelection();
			// Menu m = graph.getMenu();
			// // 确认只选择了一个对象
			// if (selection.size() == 1) {
			// final Object o = selection.get(0);
			// // 图形节点对象
			// if (o instanceof GraphNode) {
			// // 高亮子节点
			// MenuItem mi_3 = new MenuItem(m, SWT.NONE);
			// mi_3.setText("高亮子节点");
			// mi_3.addListener(SWT.Selection, new Listener() {
			// public void handleEvent(Event arg0) {
			// List<GraphConnection> childs = ((GraphNode) o)
			// .getSourceConnections();
			// for (GraphConnection gc : childs) {
			// GraphNode childnode = gc
			// .getDestination();
			// if (!childColorMap
			// .containsKey(childnode)) {
			// Color oldColor = childnode
			// .getBackgroundColor();
			// RGB rgb = oldColor.getRGB();
			// childColorMap.put(
			// childnode,
			// new Color(Display
			// .getCurrent(), rgb));
			// }
			// childnode
			// .setBackgroundColor(yelloColor);
			// gc.setLineColor(yelloColor);
			// }
			// }
			// });
			//
			// // 取消高亮子节点
			// MenuItem mi_4 = new MenuItem(m, SWT.NONE);
			// mi_4.setText("取消高亮子节点");
			// mi_4.addListener(SWT.Selection, new Listener() {
			// public void handleEvent(Event arg0) {
			// List<GraphConnection> childs = ((GraphNode) o)
			// .getSourceConnections();
			// for (GraphConnection gc : childs) {
			// GraphNode childnode = gc
			// .getDestination();
			// childnode
			// .setBackgroundColor(childColorMap
			// .get(childnode));
			// gc.setLineColor(Display.getCurrent()
			// .getSystemColor(SWT.COLOR_GRAY));
			// }
			// }
			// });
			//
			// // 高亮父节点
			// MenuItem mi_5 = new MenuItem(m, SWT.NONE);
			// mi_5.setText("高亮父节点");
			// mi_5.addListener(SWT.Selection, new Listener() {
			// public void handleEvent(Event arg0) {
			// List<GraphConnection> parents = ((GraphNode) o)
			// .getTargetConnections();
			// for (GraphConnection gc : parents) {
			// GraphNode parentnode = gc.getSource();
			// if (!parentColorMap
			// .containsKey(parentnode)) {
			// Color oldColor = parentnode
			// .getBackgroundColor();
			// RGB rgb = oldColor.getRGB();
			// parentColorMap.put(
			// parentnode,
			// new Color(Display
			// .getCurrent(), rgb));
			// }
			// parentnode
			// .setBackgroundColor(yelloColor);
			// gc.setLineColor(yelloColor);
			// }
			//
			// }
			// });
			//
			// // 取消高亮父节点
			// MenuItem mi_6 = new MenuItem(m, SWT.NONE);
			// mi_6.setText("取消高亮父节点");
			// mi_6.addListener(SWT.Selection, new Listener() {
			// public void handleEvent(Event arg0) {
			// List<GraphConnection> parents = ((GraphNode) o)
			// .getTargetConnections();
			// for (GraphConnection gc : parents) {
			// GraphNode parentnode = gc.getSource();
			// parentnode
			// .setBackgroundColor(parentColorMap
			// .get(parentnode));
			// gc.setLineColor(Display.getCurrent()
			// .getSystemColor(SWT.COLOR_GRAY));
			// }
			// }
			// });
			// // 选此点为目标点
			// MenuItem mi_7 = new MenuItem(m, SWT.NONE);
			// mi_7.setText("选此点为目标点");
			// mi_7.addListener(SWT.Selection, new Listener() {
			// public void handleEvent(Event arg0) {
			// if(temp!=null)
			// temp.setBackgroundColor(color);
			// GraphNode gNode=(GraphNode)o;
			// temp=gNode;
			// color=temp.getBackgroundColor();
			// gNode.setBackgroundColor(color9);
			// target=cfgGraph.nodes.get(gNode.getText());
			// Pathchoose.targetNode=target;
			// try {
			// Backtrack4BlockCover.set.clear();
			// pctp.pathchoose();
			// set=Backtrack4BlockCover.set;
			// opQueue.clear();
			// for(OnePath op:set){
			// opQueue.add(op);
			// }
			// } catch (Throwable e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// String targetFuncName= tm.getFuncName();
			// String targetFileName = tm.getFileName();
			// }
			// });
			//
			// while (m.getItemCount() > 4) {
			// MenuItem mi = m.getItem(0);
			// mi.dispose();
			// }
			// }
			// } else {
			// while (m.getItemCount() > 0) {
			// MenuItem mi = m.getItem(0);
			// mi.dispose();
			// }
			// }
			// }
			// }
		});
	}

	/**
	 * 注册对象选择侦听事件
	 */
	private void selectionListener() {
		graph.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List selection = ((Graph) e.widget).getSelection();
				// 确认只选择了一个对象
				if (selection.size() == 1) {
					Object o = selection.get(0);
					// 图形节点对象
					if (o instanceof GraphNode) {
						insertData(list, (GraphNode) o);
						// 图形关联对象
					} else if (o instanceof GraphConnection) {
						// 改变连线宽度
						((GraphConnection) o).setLineWidth(3);
					}
				}
			}
		});
	}

	Group groupTemp = null;
	org.eclipse.swt.widgets.List listtemp = null;

	/**
	 * 创建函数列表
	 */
	private void creatFuncList() {

		composite = new Composite(shell, SWT.NONE);

		composite.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite.widthHint = 200;
		gd_composite.heightHint = 200;
		composite.setLayoutData(gd_composite);

		group = new Group(composite, SWT.NONE);
		group.setText("节点详细信息");

		group.setLayout(new FillLayout(SWT.HORIZONTAL));

		list = new org.eclipse.swt.widgets.List(group, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		// if(FileFunctionCallingGraph.type==1){
//		String string = tm.getFuncName().substring(0, tm.getFuncName().indexOf("("));
//		string = string.substring(string.lastIndexOf(" ") + 1);
//		System.out.println(string);

		group = new Group(composite, SWT.NONE);
		groupTemp = group;
//		group.setText("路径列表    " + "(共" + set.size() + "条)");

		GridLayout gridLayout = new GridLayout();
		group.setLayout(gridLayout);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		bt2 = new org.eclipse.swt.widgets.Button(group, SWT.NONE);
		bt2.setText("隐藏图中路径");
		bt2.setLayoutData(gd);

		bt2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				for (GraphNode node : nodeMap.values()) {
					node.setBackgroundColor(nodeColor.get(node));
					List<GraphConnection> gcList = node.getSourceConnections();
					for (GraphConnection gc : gcList) {
						gc.setLineColor(edgeColor);
						gc.setLineWidth(1);
					}
				}

				listtemp.deselectAll();// 移除全部选定
				try {
					nodeMap.get(target.getName()).setBackgroundColor(color4);
				} catch (NullPointerException e1) {
					e1.printStackTrace();
				}
				colorNodeOut();
				ti.lineNum.clear();
//				text.setText("路径结果已隐藏");

			}
		});
		

		final org.eclipse.swt.widgets.List list2 = new org.eclipse.swt.widgets.List(group,
				SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);

		listtemp = list2;

		gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		list2.setLayoutData(gd);

		list2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				System.out.println("双击成功！");
				
				System.out.println(list2.getSelectionIndex());

				// TODO Auto-generated method stub
				
				
				for (GraphNode node : nodeMap.values()) {
					node.setBackgroundColor(nodeColor.get(node));
					List<GraphConnection> gcList = node.getSourceConnections();
					for (GraphConnection gc : gcList) {
						gc.setLineColor(edgeColor);
						gc.setLineWidth(1);
					}
				}

				if (nextNodeName.length() > 0 && !funcName.equals(ti.func)) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("-->");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// if(a==b){
							// ti.lineNum.add(a+"");
							// ti.lineNum.add(b+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							father = child;
						}
						

						// nodeMap.get(target.getName()).setBackgroundColor(color4);

						ti.filePath = node.srcfile.substring(node.srcfile.indexOf("\\"));

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" +node.funcName+ "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				} else if (funcName.equals(ti.func) && type == 1) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("-->");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// if(a==b){
							// ti.lineNum.add(a+"");
							// ti.lineNum.add(b+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							father = child;
						}

						

						ti.filePath = node.srcfile.substring(node.srcfile.indexOf("\\"));
						vexTographNode.get(target).setBackgroundColor(color4);

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" +node.funcName+ "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				} else if (funcName.equals(ti.func) && type == 0) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("<-");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							father = child;
						}

						// nodeMap.get(target.getName()).setBackgroundColor(color4);
						try {
							nodeMap.get(target.getName()).setBackgroundColor(color4);
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						}

						ti.filePath = node.srcfile;

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				}
				colorNodeOut();
				if(target!=null)
					vexTographNode.get(target).setBackgroundColor(color4);
			//路径双击事件添加位置 @陈璐璐
			}
		});
		list2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				for (GraphNode node : nodeMap.values()) {
					node.setBackgroundColor(nodeColor.get(node));
					List<GraphConnection> gcList = node.getSourceConnections();
					for (GraphConnection gc : gcList) {
						gc.setLineColor(edgeColor);
						gc.setLineWidth(1);
					}
				}

				if (nextNodeName.length() > 0 && !funcName.equals(ti.func)) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("-->");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// if(a==b){
							// ti.lineNum.add(a+"");
							// ti.lineNum.add(b+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							father = child;
						}
						

						// nodeMap.get(target.getName()).setBackgroundColor(color4);

						ti.filePath = node.srcfile.substring(node.srcfile.indexOf("\\"));

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string +"\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" +node.funcName+ "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				} else if (funcName.equals(ti.func) && type == 1) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("-->");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// if(a==b){
							// ti.lineNum.add(a+"");
							// ti.lineNum.add(b+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							father = child;
						}

						

						ti.filePath = node.srcfile.substring(node.srcfile.indexOf("\\"));
						vexTographNode.get(target).setBackgroundColor(color4);

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" +node.funcName+ "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				} else if (funcName.equals(ti.func) && type == 0) {
					if (list2.getSelectionIndex() >= 0 && list2.getSelectionIndex() <= path.size()) {
						String string = path.get(list2.getSelectionIndex());
						String[] nodes = string.split("-->");
						int a, b;
						ti.lineNum.clear();
						GraphNode father = null;
						GraphNode child = null;
						for (String node : nodes) {
							nodeMap.get(node).setBackgroundColor(color9);
							child = nodeMap.get(node);
							if (father != null) {
								List<GraphConnection> list = father.getSourceConnections();
								for (GraphConnection gc : list) {
									if (gc.getDestination().equals(child)) {
										gc.setLineColor(color9);
										gc.setLineWidth(2);
									}
								}
							}
							softtest.cfg.c.VexNode node2 = cfgGraph.nodes.get(node);
							a = node2.getTreenode().getBeginLine();
							b = node2.getTreenode().getEndLine();
							// for(int i=a;i<=b;i++){
							// ti.lineNum.add(i+"");
							// }
							ti.lineNum.add(a + "");
							ti.lineNum.add(b + "");
							father = child;
						}

						// nodeMap.get(target.getName()).setBackgroundColor(color4);
						try {
							nodeMap.get(target.getName()).setBackgroundColor(color4);
						} catch (NullPointerException e1) {
							e1.printStackTrace();
						}

						ti.filePath =node.srcfile;

						if (funcName.equals( ti.func)) {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" + node.funcName + "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "\r\n");
						} else {
							text.setText("源文件：" + ti.filePath + "\r\n" + "函数：" +node.funcName+ "   目标点：" + ti.func
									+ "   行号：" + ti.targetLineNum + "\r\n" + "路径：" + string + "下一函数节点[" + nextNodeName
									+ "]" + "\r\n");
						}

					}
				}
				colorNodeOut();
				if(target!=null)
					vexTographNode.get(target).setBackgroundColor(color4);
			}
			

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		// }
	}

	/**
	 * 显示节点详细信息
	 */
	private void insertData(org.eclipse.swt.widgets.List list, GraphNode gn) {

		String info = mapInfo.get(gn.getText());
		// info = info.replaceAll("[\\\\n]+", "\\$");
		// System.out.println(info);
//		String[] infoStrings = info.split("(\\\\n)+");
		list.removeAll();
//		for (int i = 0; i < infoStrings.length; i++) {

			
			list.add("函数:" + node.funcName);
			list.add("文件:" + node.srcfile);
			// list.add("image:"+cfgGraph.nodes.get(gn.getText()).getTreenode().getOperators());
			list.add("开始行:" + cfgGraph.nodes.get(gn.getText()).getTreenode().getBeginLine());
			list.add("结束行:" + cfgGraph.nodes.get(gn.getText()).getTreenode().getEndLine() + "");
			String temp = gn.getText().substring(gn.getText().lastIndexOf("_") + 1);
			Integer num = -1;
			if (temp != null) {
				num = Integer.valueOf(temp);
			}

			if (infoMap != null && infoMap.get(num) != null)
				list.add("变量区间：" + infoMap.get(num));
//		}

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

		Composite composite1 = new Composite(bottomComposite, SWT.NONE);
		rowLayout.spacing = 10;
		rowLayout.justify = true;
		rowLayout.center = true;
		composite1.setLayout(rowLayout);
		CLabel CoverCLabel = new CLabel(composite1, SWT.BORDER);
		CoverCLabel.setText("       ");
		CoverCLabel.setBackground(color4);
		CoverCLabel = new CLabel(composite1, SWT.NONE);
		CoverCLabel.setText("目标节点");
		composite1.pack();

		// composite1 = new Composite(bottomComposite, SWT.NONE);
		// composite1.setLayout(rowLayout);
		// CoverCLabel = new CLabel(composite1, SWT.BORDER);
		// CoverCLabel.setText(" ");
		// CoverCLabel.setBackground(greenColor);
		// CoverCLabel = new CLabel(composite1, SWT.NONE);
		// CoverCLabel.setText("目标节点");
		// composite1.pack();

		bottomComposite.pack();
	}

	/**
	 * 打开主窗体
	 */
	public void openShell() {
		shell.open(); // 打开主窗体

		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

//	public void doShowControlFlowGraph(TestModule tm, AnalysisFile af) {
//		final TestModule currentFunc = tm;
//		final AnalysisFile currentFile = af;
//		try {
//			if (currentFunc == null)
//				return;
//			currentFunc.generateCFG(currentFile.getCFGPicDir());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * 生成函数控制流图
	 */
//	public void generate(int val) {
//
//		// 初始化主窗体
//		initShell();
//		// 创建函数调用关系图
//
//		createGraph(val);
//
//		// 打开主窗体
//		openShell();
//
//	}
	public void generate(softtest.cfg.c.Graph graph) {
		// 初始化主窗体
		initShell();
		// 创建函数调用关系图

		createGraph(graph);
		node.openCFG=true;
		// 打开主窗体
		openShell();

	}

//	public void initControlFlowGraph(String fileName, int val, TestModule tm) {
//		this.setFileName(fileName);
//		ReadGraphFile file = new ReadGraphFile();
//		file.setFileName(this.getFileName());
//		this.table = file.getGraphItem(val);
//		this.mapColor = file.getGraphNodeColor();
//		this.mapInfo = file.getGraphNodeInfo();
//		this.cfgGraph = tm.getGraph();
//		this.tm = tm;
//		generate(val);
//	}
	public void initControlFlowGraph(softtest.cfg.c.Graph graph) {
		this.setFileName(fileName);
		this.cfgGraph = graph;
		
		generate(graph);
	}

	public void getPath(List<String> path) {
		this.path = path;
		System.out.println(path);
	}
	// public void highlightPath(){
	// Iterator<String> nodeIt=null;
	// String node=null;
	// String node2=null;
	// if(path!=null){
	// try{
	// nodeIt=path.iterator();
	//
	// while(nodeIt.hasNext()){
	// node=nodeIt.next();
	// if(nodeMap.get(node)!=null)
	// nodeMap.get(node).highlight();
	//
	// }
	// }catch (NullPointerException e){
	// e.printStackTrace();
	// System.out.println(path);
	// System.out.println(nodeMap.keySet());
	// }
	//
	// nodeIt=path.iterator();
	// node=nodeIt.next();
	// while(nodeIt.hasNext()){
	// node2=nodeIt.next();
	// edgeMap.get(node+"--"+node2).highlight();
	// node=node2;
	// }
	// }
	// }

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public softtest.cfg.c.VexNode getTarget() {
		return target;
	}

	public void setTarget(softtest.cfg.c.VexNode target) {
		this.target = target;
	}


}
