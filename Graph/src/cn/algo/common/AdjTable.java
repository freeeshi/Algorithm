package cn.algo.common;

import java.util.Scanner;

public class AdjTable {

	private int tableSize;
	private int edgeNum;
	private Node[] list;
	private int[] indegree;

	public void print() {
		for (int i = 0; i < tableSize; i++) {
			System.out.print("node" + (i + 1) + " indegree:" + indegree[i] + "  ");
			for (Node p = list[i].getNode(); p != null; p = p.getNode()) {
				System.out.print(p.getValue() + "(" + p.getCost() + ") ");
			}
			System.out.println();
		}
	}

	public void init(int size, int edgeNum) {
		this.tableSize = size;
		this.edgeNum = edgeNum;
		list = new Node[size];
		indegree = new int[size];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < size; i++) {
			list[i] = new Node();
			list[i].setValue(i + 1);
			list[i].setCost(0);
			list[i].setNode(null);
		}

		for (int i = 0; i < edgeNum; i++) {
			int n = in.nextInt();
			int d = in.nextInt();
			int c = in.nextInt();
			Node node = new Node();
			node.setValue(d);
			node.setCost(c);
			node.setNode(list[n - 1].getNode());
			list[n - 1].setNode(node);

			indegree[d - 1]++;
		}
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public Node[] getList() {
		return list;
	}

	public void setList(Node[] list) {
		this.list = list;
	}

	public int[] getIndegree() {
		return indegree;
	}

	public void setIndegree(int[] indegree) {
		this.indegree = indegree;
	}

	public int getEdgeNum() {
		return edgeNum;
	}

	public void setEdgeNum(int edgeNum) {
		this.edgeNum = edgeNum;
	}

}