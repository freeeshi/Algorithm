package cn.algo.test;

import cn.algo.common.AdjTable;
import cn.algo.common.StatusTable;
import cn.algo.shorestpath.Dijkstra;
import cn.algo.shorestpath.NoPowerSide;
import cn.algo.topsort.TopSort;

public class TestGraph {
	
	private static int NODENUM = 7; 
	
	public static void main(String[] args) {
		// 初始化邻接图，打印信息
		AdjTable adjTable = new AdjTable();
		adjTable.init(NODENUM, 12);
		adjTable.print();
		
		// 拓扑排序，采用队列和不采用队列
//		TopSort topSort = new TopSort();
//		int[] array = topSort.sortByQueue(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
//		array = topSort.sort(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
		
		// 无权有向图最短路径，采用队列和不采用队列
//		StatusTable[] table = StatusTable.createTable(NODENUM);
//		NoPowerSide noPowerSide = new NoPowerSide();
////		noPowerSide.shortestPath(adjTable, table, 3);
//		noPowerSide.shortestPathByQueue(adjTable, table, 3);
//		StatusTable.print(table);
//		System.out.println(StatusTable.showShortestPath(table, 7));
		
		// 有权有向图最短路径
		StatusTable[] table = StatusTable.createTable(NODENUM);
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.shortestPath(adjTable, table, 1);
		StatusTable.print(table);
		System.out.println(StatusTable.showShortestPath(table, 3));
	}

}

/*
有权有向图最短路径测试数据（Dijkstra）
1 2 2
1 4 1
2 4 3
2 5 10
3 1 4
3 6 5
4 3 2
4 5 2
4 6 8
4 7 4
5 7 6
7 6 1



无权有向图最短路径测试数据
1 4 1
1 2 1
2 4 1
2 5 1
3 1 1
3 6 1
4 3 1
4 5 1
4 6 1
4 7 1
5 7 1
7 6 1


无权有向图拓扑排序测试数据
1 2 1
1 3 1
1 4 1
2 4 1
2 5 1
3 6 1
4 3 1
4 6 1
4 7 1
5 4 1
5 7 1
7 6 1


1 4 9
4 3 8
1 2 5
2 4 6
1 3 7
*/