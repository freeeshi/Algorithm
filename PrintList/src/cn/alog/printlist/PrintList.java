package cn.alog.printlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author 石龙飞
 *
 */
public class PrintList {
	
	public static void main(String[] args) {
		ListNode listNode = null;
		
		for(int i = 0; i < 5; i++) {
			int num = (int) (Math.random()*100);
			System.out.println(num);
			ListNode node = new ListNode(num);
			node.setNext(listNode);
			listNode = node;			
		}
		
		System.out.println(printListFromTailToHead(listNode).toString());
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		ArrayList<Integer> list = null;
		
		if(listNode == null)
			list = new ArrayList<>();
		else {
			if(listNode.next == null) {
				list = new ArrayList<>();
				list.add(listNode.val);
			}else {
				list = printListFromTailToHead(listNode.next);
				list.add(listNode.val);
			}
				
		}
        
		return list;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    
    public void setNext(ListNode next) {
		this.next = next;
	}
}
