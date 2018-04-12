package cn.algo.common;

public class Edge {

	private int power;
	private int start;
	private int end;
	
	public static void printEdges(Edge[] edges) {
		for(int i = 0; i < edges.length; i++) {
			System.out.println("(" + edges[i].getStart() + "," + edges[i].getEnd() + ")" + " " + edges[i].getPower());
		}
		
	}
	
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	
	public Edge(int power, int start, int end) {
		this.power = power;
		this.start = start;
		this.end = end;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
