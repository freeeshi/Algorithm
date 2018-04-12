package cn.algo.common;

public class PriorityQueue {

	private Edge[] queue;
	private int size;

	public void init(AdjTable adjTable) {
		this.queue = new Edge[adjTable.getEdgeNum() + 1];
		this.queue[0] = new Edge(0, 0, 0);

		for (int i = 0; i < adjTable.getTableSize(); i++) {
			for (Node p = adjTable.getList()[i].getNode(); p != null; p = p.getNode()) {
				put(new Edge(p.getCost(), i + 1, p.getValue()));
			}
		}
	}

	public Edge deleteMinEdge() {
		if (size == 0)
			return null;
		int i = 0, child = 0;
		Edge root = queue[1];
		Edge last = queue[size--];

		for (i = 1; i * 2 < size; i = child) {
			child = i * 2;
			if (child != size && queue[child + 1].getPower() < queue[child].getPower()) {
				child++;
			}
			if (last.getPower() > queue[child].getPower()) {
				queue[i] = queue[child];
			} else {
				break;
			}
		}
		queue[i] = last;

		return root;
	}

	private void put(Edge edge) {
		int i = 0;
		for (i = ++size; queue[i / 2].getPower() > edge.getPower(); i /= 2) {
			queue[i] = queue[i / 2];
		}
		queue[i] = edge;
	}

}
