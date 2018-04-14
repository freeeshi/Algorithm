package cn.algo.common;

public class DfsTable {
	private DfsNode[] nodes;

	public DfsTable(int size) {
		this.nodes = new DfsNode[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new DfsNode();
			nodes[i].setVisited(false);
		}
	}
	
	public void print() {
		System.out.println("Node\tRank\tParent\tLow\tVisited");
		for(int i = 0; i < nodes.length; i++) {
			System.out.println((i+1) + "\t" + nodes[i].getRank() + "\t" + nodes[i].getParent() + "\t" + nodes[i].getLow() + "\t" + nodes[i].isVisited());
		}
	}

	public DfsNode[] getNodes() {
		return nodes;
	}

	public void setNodes(DfsNode[] nodes) {
		this.nodes = nodes;
	}

}
