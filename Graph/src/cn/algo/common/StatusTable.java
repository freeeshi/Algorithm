package cn.algo.common;

public class StatusTable {
	public static final int INFINITY = Integer.MAX_VALUE;

	private int node;
	private boolean known;
	private int d;
	private int p;
	
	public static String  showShortestPath(StatusTable[] table, int end) {
		int currNode = end;
		String path = "";
		for(; table[currNode-1].getD() != 0; currNode = table[currNode-1].getP()) {
			path = currNode + " " + path;
		}
		return currNode + " " + path;
	}

	public static void print(StatusTable[] table) {
		System.out.println("Node\tKnown\td\tp\t");
		for (int i = 0; i < table.length; i++) {
			System.out.println(table[i].getNode() + "\t" + table[i].isKnown() + "\t" + table[i].getD() + "\t"
					+ table[i].getP());
		}
	}

	public static StatusTable[] createTable(int size) {
		StatusTable[] table = new StatusTable[size];
		for (int i = 0; i < size; i++) {
			table[i] = new StatusTable();
			table[i].setNode(i + 1);
			table[i].setKnown(false);
			table[i].setD(StatusTable.INFINITY);
			table[i].setP(0);
		}
		return table;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public boolean isKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

}
