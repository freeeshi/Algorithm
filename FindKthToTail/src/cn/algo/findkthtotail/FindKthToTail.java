package cn.algo.findkthtotail;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author 石龙飞
 *
 */
public class FindKthToTail {

	public static void main(String[] args) {
		ListNode listNode = null;

		for (int i = 0; i < 10000000; i++) {
			int num = (int) (Math.random() * 100);
			ListNode node = new ListNode(num);
			node.setNext(listNode);
			listNode = node;
		}
		int num = 9000000;
		
		long start = System.currentTimeMillis();
		find1(listNode, num);
		System.out.println("find1 time:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		find2(listNode, num);
		System.out.println("find2 time:" + (System.currentTimeMillis() - start));
	}
	
	public static ListNode find2(ListNode head, int k) {
		ListNode left = head;
		ListNode right = head;
		if(k > 0) {
			int i = 0;
			for(i = 0; i < k && right != null; i++, right = right.getNext());
			
			if(right != null) {
				while(right != null) {
					right = right.getNext();
					left = left.getNext();
				}
			}else {
				if(i != k)
					left = null;
			}
		}else {
			left = null;
		}
		
		return left;
	}

	public static ListNode find1(ListNode head, int k) {
		ListNode tmp = head;
		ListNode result = null;

		int count = 0;
		for (count = 0; tmp != null; tmp = tmp.getNext(), count++);
		
		if(k > 0 && count-k >= 0 && head != null) {
			tmp = head;
			for(int i = 0; i < count-k; tmp = tmp.getNext(), i++);
			result = tmp;
		}
		
		return result;
	}
	
	public static void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.getVal() + " ");
			head = head.getNext();
		}
		System.out.println();
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}