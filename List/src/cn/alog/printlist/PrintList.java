package cn.alog.printlist;

import java.util.ArrayList;

import cn.algo.common.ListNode;
import cn.algo.common.ListUtils;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * @author ʯ����
 *
 */
public class PrintList {
	
	public static void main(String[] args) {
		ListNode listNode = ListUtils.creatList(10);
		
		System.out.println(printListFromTailToHead(listNode).toString());
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		ArrayList<Integer> list = null;
		
		if(listNode == null)
			list = new ArrayList<>();
		else {
			if(listNode.getNext() == null) {
				list = new ArrayList<>();
				list.add(listNode.getVal());
			}else {
				list = printListFromTailToHead(listNode.getNext());
				list.add(listNode.getVal());
			}
				
		}
        
		return list;
    }

}