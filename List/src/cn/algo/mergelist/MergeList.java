package cn.algo.mergelist;

import cn.algo.common.ListNode;
import cn.algo.common.ListUtils;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author 石龙飞
 *
 */
public class MergeList {

	public static void main(String[] args) {
		ListNode listNode1 = ListUtils.creatList(2);
		ListNode listNode2 = ListUtils.creatList(0);
		ListUtils.printList(listNode1);
		ListUtils.printList(listNode2);
		ListUtils.printList(merge(listNode1, listNode2));
	}

	public static ListNode merge(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		ListNode currNode = result;
		
		while (list1 != null || list2 != null) {
			if (list1 != null && list2 != null) {
				if (list1.getVal() > list2.getVal()) {
					currNode.setNext(list2);
					list2 = list2.getNext();
					currNode = currNode.getNext();
				} else if (list1.getVal() < list2.getVal()) {
					currNode.setNext(list1);
					list1 = list1.getNext();
					currNode = currNode.getNext();
				} else {
					currNode.setNext(list1);
					list1 = list1.getNext();
					currNode = currNode.getNext();
					currNode.setNext(list2);
					list2 = list2.getNext();
					currNode = currNode.getNext();
				}
				
			} else {
				if (list1 != null) {
					currNode.setNext(list1);
					list1 = null;
				}

				if (list2 != null) {
					currNode.setNext(list2);
					list2 = null;
				}
			}
		}

		return result.getNext();
	}

}
