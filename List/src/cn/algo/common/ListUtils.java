package cn.algo.common;

public class ListUtils {
	
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
