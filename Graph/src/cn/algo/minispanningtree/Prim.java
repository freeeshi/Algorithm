package cn.algo.minispanningtree;

import cn.algo.common.AdjTable;
import cn.algo.common.Node;
import cn.algo.common.StatusTable;

public class Prim {

	public void spanningTree(AdjTable adjTable, StatusTable[] statusTable, int start) {
		statusTable[start - 1].setD(0);

		while (true) {
			int currNode = findSmallestUnknomnNode(statusTable);
			if (currNode == 0)
				break;

			statusTable[currNode - 1].setKnown(true);
			for (Node p = adjTable.getList()[currNode - 1].getNode(); p != null; p = p.getNode()) {
				int cost = statusTable[currNode - 1].getD() + p.getCost();
				if (!statusTable[p.getValue() - 1].isKnown() && statusTable[p.getValue() - 1].getD() > p.getCost()) {
					statusTable[p.getValue() - 1].setD(p.getCost());
					statusTable[p.getValue() - 1].setP(currNode);
				}
			}
		}

	}

	private int findSmallestUnknomnNode(StatusTable[] table) {
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < table.length; i++) {
			if (!table[i].isKnown() && table[i].getD() < min) {
				result = i + 1;
				min = table[i].getD();
			}
		}

		return result;
	}

}
