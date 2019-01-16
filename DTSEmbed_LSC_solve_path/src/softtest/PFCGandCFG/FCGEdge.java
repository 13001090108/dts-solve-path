package softtest.PFCGandCFG;

public class FCGEdge {
	
	public FCGNode tailNode=null;
	public FCGNode headNode=null;
	public void FCGNode(){
		
	}
	public void FCGNode(FCGNode tailNode,FCGNode headNode){
		this.tailNode=tailNode;
		this.headNode=headNode;
	}
}

