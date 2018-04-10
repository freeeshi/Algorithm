package cn.algo.test;

import cn.algo.common.AdjTable;
import cn.algo.common.StatusTable;
import cn.algo.shorestpath.NoPowerSide;
import cn.algo.topsort.TopSort;

public class TestGraph {
	
	private static int NODENUM = 7; 
	
	public static void main(String[] args) {
		// ��ʼ���ڽ�ͼ����ӡ��Ϣ
		AdjTable adjTable = new AdjTable();
		adjTable.init(NODENUM, 12);
		adjTable.print();
		
		// �������򣬲��ö��кͲ����ö���
//		TopSort topSort = new TopSort();
//		int[] array = topSort.sortByQueue(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
//		array = topSort.sort(adjTable);
//		ArrayUtils.printArray(array);
//		System.out.println();
		
		// ��Ȩͼ���·�������ö��кͲ����ö���
		StatusTable[] table = StatusTable.createTable(NODENUM);
		NoPowerSide noPowerSide = new NoPowerSide();
//		noPowerSide.shortestPath(adjTable, table, 3);
		noPowerSide.shortestPathByQueue(adjTable, table, 3);
		StatusTable.print(table); 
		System.out.println(StatusTable.showShortestPath(table, 7));
		
	}

}

/*
��Ȩ����ͼ���·����������
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


��Ȩ����ͼ���������������
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