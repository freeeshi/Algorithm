package cn.algo.shorestpath;

import java.util.LinkedList;
import java.util.Queue;

import cn.algo.common.AdjTable;
import cn.algo.common.Node;
import cn.algo.common.StatusTable;

public class NoPowerSide {
	
	public void shortestPathByQueue(AdjTable adjTable, StatusTable[] statusTable, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		statusTable[start-1].setD(0);
		int currCost = 0;
		int size = adjTable.getTableSize();
		
		while(!queue.isEmpty()) {
			int currNode = queue.poll();
			statusTable[currNode-1].setKnown(true);
			for(Node p = adjTable.getList()[currNode-1].getNode(); p != null; p = p.getNode()) {
				if(statusTable[p.getValue()-1].getD() == StatusTable.INFINITY) {
					statusTable[p.getValue()-1].setD(statusTable[currNode-1].getD() + 1);
					statusTable[p.getValue()-1].setP(currNode);
					queue.offer(p.getValue());
				}
			}
		}
	}
	
	public void shortestPath(AdjTable adjTable, StatusTable[] statusTable, int start) {
		statusTable[start-1].setD(0);
		int currCost = 0;
		int size = adjTable.getTableSize();
		
		for(currCost = 0; currCost < size; currCost++) {
			for(int i = 0; i < size; i++) {
				if(!statusTable[i].isKnown() && statusTable[i].getD() == currCost) {
					statusTable[i].setKnown(true);
					for(Node p = adjTable.getList()[i].getNode(); p != null; p = p.getNode()) {
						if(statusTable[p.getValue()-1].getD() == StatusTable.INFINITY) {
							statusTable[p.getValue()-1].setD(currCost + 1);
							statusTable[p.getValue()-1].setP(i+1);
						}
					}
				}
			}
		}
	}

}
