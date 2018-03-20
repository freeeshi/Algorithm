package cn.algo.reverselist;

import cn.algo.common.ListNode;
import cn.algo.common.ListUtils;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author 石龙飞
 *
 */
public class ReverseList {
	
	public static void main(String[] args) {
		ListNode head = ListUtils.creatList(10000);

		long start = System.currentTimeMillis();
		ListUtils.printList(reserve1(head));
		System.out.println("reserve1:" + (System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		ListUtils.printList(reserve2(head));
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

}