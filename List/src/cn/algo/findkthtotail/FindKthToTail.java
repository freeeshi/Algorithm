package cn.algo.findkthtotail;

import cn.algo.common.ListNode;
import cn.algo.common.ListUtils;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author 石龙飞
 *
 */
public class FindKthToTail {

	public static void main(String[] args) {
		int num = 1000000;
		ListNode listNode = ListUtils.creatList(num);
		
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

}