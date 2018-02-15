package cn.freedom.algorithm.addtwonumbers;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		AddTwoNumbers t = new AddTwoNumbers();
		ListNode l1 = t.creatNumList("9");
		ListNode l2 = t.creatNumList("1999");
		ListNode l3 = t.addTwoNumbers(l1, l2);
		t.printList(l3);
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = l1, q = l2;
		int num1 = 0, num2 = 0, carry = 0, sum = 0;
		ListNode head = new ListNode(0);
		ListNode before = head;
		
		while(p != null || q != null || carry != 0) {
			num1 = p == null ? 0 : p.getVal();
			num2 = q == null ? 0 : q.getVal();
			sum = num1 + num2 + carry;
			
			carry = sum / 10;
			
			ListNode after = new ListNode(sum%10);
			before.setNext(after);
			before = after;
			
			if(p != null) p = p.getNext();
			if(q != null) q = q.getNext();
		}
		
		return head.getNext();
	}
	
	public void printList(ListNode listNode) {
		while(listNode != null) {
			System.out.print(listNode.getVal());
			listNode = listNode.getNext();
		}
	}
	
	public ListNode creatNumList(String nums) {
		ListNode head = new ListNode(0);
		ListNode before = head;
		for(int i = 0; i < nums.length(); i++) {
			ListNode after = new ListNode(nums.charAt(i)-48);
			before.setNext(after);
			before = after;
		}
		
		return head.getNext();
	}

}

class ListNode{
	
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
		this.next = null;
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
