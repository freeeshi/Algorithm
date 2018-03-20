package cn.algo.reverselist;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author 石龙飞
 *
 */
public class ReverseList {
	
	public static void main(String[] args) {
		ListNode head = creatList(10000);

		long start = System.currentTimeMillis();
		printList(reserve1(head));
		System.out.println("reserve1:" + (System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		printList(reserve2(head));
		System.out.println("reserve2:" + (System.currentTimeMillis()-start));
	}
	
	public static ListNode reserve2(ListNode head) {
		ListNode left = null;
		ListNode right = head;
		ListNode tmp = head;
		
		while(right != null) {
			tmp = right;
			right = right.getNext();
			tmp.setNext(left);
			left = tmp;
		}
		
		return left;
	}
	
	public static ListNode reserve1(ListNode head) {
		ListNode result = null;
		
		while(head != null) {
			ListNode node = new ListNode();
			node.setVal(head.getVal());
			node.setNext(result);
			result = node;
			head = head.getNext();
		}
		
		
		return result;
	}
	
	public static ListNode creatList(int length) {
		ListNode listNode = null;

		for (int i = 0; i < length; i++) {
			int num = (int) (Math.random() * 100);
			ListNode node = new ListNode();
			node.setVal(num);
			node.setNext(listNode);
			listNode = node;
		}
		
		return listNode;
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

