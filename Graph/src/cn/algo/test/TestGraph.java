package cn.algo.test;

import cn.algo.common.AdjTable;
import cn.algo.common.DfsTable;
import cn.algo.common.Edge;
import cn.algo.common.StatusTable;
import cn.algo.dfs.DFS;
import cn.algo.minispanningtree.Kruskal;
import cn.algo.minispanningtree.Prim;
import cn.algo.shorestpath.Dijkstra;
import cn.algo.shorestpath.NoPowerSide;
import cn.algo.topsort.TopSort;

public class TestGraph {
	
	private static int NODENUM = 7; 
	
	public static void main(String[] args) {
		// ��ʼ���ڽ�ͼ����ӡ��Ϣ
		AdjTable adjTable = new AdjTable();
		// ����ͼ��ʼ��
//		adjTable.init(NODENUM, 12);
		// ����ͼ��ʼ��
		adjTable.init(NODENUM, 16);
		adjTable.print();
		
		// �������򣬲��ö��кͲ����ö���
//		TopSort topSort = new TopSort();
//		int[] array = topSort.sortByQueue(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
//		array = topSort.sort(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
		
		// ��Ȩ����ͼ���·�������ö��кͲ����ö���
//		StatusTable[] table = StatusTable.createTable(NODENUM);
//		NoPowerSide noPowerSide = new NoPowerSide();
////		noPowerSide.shortestPath(adjTable, table, 3);
//		noPowerSide.shortestPathByQueue(adjTable, table, 3);
//		StatusTable.print(table);
//		System.out.println(StatusTable.showShortestPath(table, 7));
		
		// ��Ȩ����ͼ���·��
//		StatusTable[] table = StatusTable.createTable(NODENUM);
//		Dijkstra dijkstra = new Dijkstra();
//		dijkstra.shortestPath(adjTable, table, 1);
//		StatusTable.print(table);
//		System.out.println(StatusTable.showShortestPath(table, 3));
		
		// ��С������Prim
//		StatusTable[] table = StatusTable.createTable(NODENUM);
//		Prim prim = new Prim();
//		prim.spanningTree(adjTable, table, 1);
//		StatusTable.print(table);
		
		// ��С������Kruskal
//		Kruskal kruskal = new Kruskal();
//		Edge[] edges = kruskal.spanningTree(adjTable);
//		Edge.printEdges(edges);
		
		// DFS
		DfsTable dfsTable = new DfsTable(NODENUM);
		DFS dfs = new DFS();
//		dfs.assignRank(adjTable, dfsTable, 1);
//		dfs.assinLow(adjTable, dfsTable, 1);
		dfs.findArticulation(adjTable, dfsTable, 1);
		dfsTable.print();
		
	}
	
}

/*
DFS����ͼ��������
1 2 1 1 4 1 2 1 1 2 3 1 3 2 1 3 4 1 3 7 1 4 1 1
4 3 1 4 5 1 4 6 1 5 4 1 5 6 1 6 4 1 6 5 1 7 3 1

Kruskal��С��������������
1 2 2 1 4 1 2 4 3 2 5 10 3 1 4 3 6 5 4 3 2 4 5 7 4 6 8 4 7 4 5 7 6 7 6 1

Prim��С��������������(����ͼ)
1 2 2 2 1 2 1 4 1 4 1 1 2 4 3 4 2 3 2 5 10 5 2 10
3 1 4 1 3 4 3 6 5 6 3 5 4 3 2 3 4 2 4 5 7 5 4 7
4 6 8 6 4 8 4 7 4 7 4 4 5 7 6 7 5 6 7 6 1 6 7 1

��Ȩ����ͼ���·���������ݣ�Dijkstra��
1 2 2 1 4 1 2 4 3 2 5 10 3 1 4 3 6 5 4 3 2 4 5 2 4 6 8 4 7 4 5 7 6 7 6 1

��Ȩ����ͼ���·����������
1 4 1 1 2 1 2 4 1 2 5 1 3 1 1 3 6 1 4 3 1 4 5 1 4 6 1 4 7 1 5 7 1 7 6 1

��Ȩ����ͼ���������������
1 2 1 1 3 1 1 4 1 2 4 1 2 5 1 3 6 1 4 3 1 4 6 1 4 7 1 5 4 1 5 7 1 7 6 1

*/