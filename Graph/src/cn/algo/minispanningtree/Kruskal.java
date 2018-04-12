package cn.algo.minispanningtree;

import cn.algo.common.AdjTable;
import cn.algo.common.Disjset;
import cn.algo.common.Edge;
import cn.algo.common.PriorityQueue;
import cn.algo.common.StatusTable;

public class Kruskal {

	public Edge[] spanningTree(AdjTable adjTable) {
		int nodeNum = adjTable.getTableSize();
		Edge[] edges = new Edge[nodeNum-1];
		Disjset disjset = new Disjset(nodeNum);
		disjset.init();
		PriorityQueue queue = new PriorityQueue();
		queue.init(adjTable);

		int currNodeNum = 1;
		while (currNodeNum < nodeNum) {
			Edge minEdge = queue.deleteMinEdge();
			int root1 = disjset.find(minEdge.getStart());
			int root2 = disjset.find(minEdge.getEnd());
			if (root1 != root2) {
				disjset.union(root1, root2);
				edges[currNodeNum-1] = minEdge;
				currNodeNum++;
			}
		}
		
		return edges;
	}

}