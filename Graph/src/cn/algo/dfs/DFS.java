package cn.algo.dfs;

import cn.algo.common.AdjTable;
import cn.algo.common.DfsNode;
import cn.algo.common.DfsTable;
import cn.algo.common.Node;

public class DFS {

	private int counter = 0;

	public void assignRank(AdjTable adjTable, DfsTable dfsTable, int start) {
		dfsTable.getNodes()[start - 1].setVisited(true);
		dfsTable.getNodes()[start - 1].setRank(++counter);
		for (Node p = adjTable.getList()[start - 1].getNode(); p != null; p = p.getNode()) {
			if (!dfsTable.getNodes()[p.getValue() - 1].isVisited()) {
				dfsTable.getNodes()[p.getValue() - 1].setParent(start);
				assignRank(adjTable, dfsTable, p.getValue());
			}
		}
	}

	public void assinLow(AdjTable adjTable, DfsTable dfsTable, int start) {
		DfsNode[] nodes = dfsTable.getNodes();
		nodes[start - 1].setLow(nodes[start - 1].getRank());
		for (Node p = adjTable.getList()[start - 1].getNode(); p != null; p = p.getNode()) {
			if (nodes[p.getValue() - 1].getRank() >= nodes[start - 1].getRank()) {
				assinLow(adjTable, dfsTable, p.getValue());
				if (nodes[p.getValue() - 1].getLow() >= nodes[start - 1].getRank()) {
					if (nodes[start - 1].getParent() != 0)
						System.out.println(start + "是割点");
				}
				nodes[start - 1].setLow(
						nodes[p.getValue() - 1].getLow() < nodes[start - 1].getLow() ? nodes[p.getValue() - 1].getLow()
								: nodes[start - 1].getLow());
			} else if (nodes[start - 1].getParent() != p.getValue()) {
				nodes[start - 1].setLow(
						nodes[p.getValue() - 1].getLow() < nodes[start - 1].getRank() ? nodes[p.getValue() - 1].getLow()
								: nodes[start - 1].getRank());
			}
		}
	}

	public void findArticulation(AdjTable adjTable, DfsTable dfsTable, int start) {
		DfsNode[] nodes = dfsTable.getNodes();

		nodes[start - 1].setVisited(true);
		nodes[start - 1].setRank(++counter);
		nodes[start - 1].setLow(counter);

		for (Node p = adjTable.getList()[start - 1].getNode(); p != null; p = p.getNode()) {
			int v = start;
			int w = p.getValue();

			if (!nodes[w - 1].isVisited()) {
				nodes[w - 1].setParent(v);
				findArticulation(adjTable, dfsTable, w);
 
				if (nodes[w - 1].getLow() >= nodes[v - 1].getRank()) {
					if (nodes[v - 1].getParent() != 0)
						System.out.println(v + "是割点");
				}
				
				nodes[v - 1].setLow(nodes[w - 1].getLow() < nodes[v - 1].getLow() ? nodes[w - 1].getLow()
						: nodes[v - 1].getLow());
			} else if (nodes[v - 1].getParent() != w) {
				nodes[v - 1].setLow(nodes[w - 1].getLow() < nodes[v - 1].getRank() ? nodes[w - 1].getLow()
						: nodes[v - 1].getRank());
			}
		}
	}

}
