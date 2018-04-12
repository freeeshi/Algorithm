package cn.algo.common;

public class Disjset {

	private int[] set;
	private int size;

	public Disjset(int size) {
		this.size = size;
		this.set = new int[size + 1];
	}
	
	public void union(int node1, int node2) {
		if(set[node1] < set[node2]) {
			set[node2] = node1;
		}else if(set[node1] > set[node2]) {
			set[node1] = node2;
		}else {
			set[node1] = node2;
			set[node2]--;
		}
	}

	public int find(int node) {
		if (set[node] <= 0) {
			return node;
		} else {
			return find(set[node]);
		}
	}

	public void init() {
		for (int i = 0; i <= size; i++) {
			set[i] = -1;
		}
	}

	public int[] getSet() {
		return set;
	}

	public void setSet(int[] set) {
		this.set = set;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
