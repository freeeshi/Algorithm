package cn.algo.topsort;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import cn.algo.common.AdjTable;
import cn.algo.common.Node;

public class TopSort {
	
	public int[] sortByQueue(AdjTable adjTable) {
		int size = adjTable.getTableSize();
		int[] array = new int[size];
		int[] indegree = Arrays.copyOf(adjTable.getIndegree(), size);
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				queue.offer(i+1);
			}
		}
		
		int i = 0;
		while(queue.size() != 0) {
			int node = queue.poll();
			array[i++] = node;
			
			for(Node p = adjTable.getList()[node-1]; p != null; p = p.getNode()) {
				if(--indegree[p.getValue()-1] == 0) {
					queue.offer(p.getValue());
				}
			}
		}
		
		return array;
	}
	
	public int[] sort(AdjTable adjTable) {
		int size = adjTable.getTableSize();
		int[] array = new int[size];
		int[] indegree = Arrays.copyOf(adjTable.getIndegree(), size);
		
		for(int i = 0; i < size; i++) {
			int node = findZeroIndegree(indegree);
			if(node == 0) {
				throw new RuntimeException("¸ÃÍ¼ÓÐÈ¦£¡");
			}
			array[i] = node;
			for(Node p = adjTable.getList()[node-1]; p != null; p = p.getNode()) {
				indegree[p.getValue()-1]--;
			} 
		} 
		
		return array;
	}
	
	private int findZeroIndegree(int[] indegree) {
		int result = 0;
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				result = i+1;
				break;
			}
		}
		return result;
	}

}
