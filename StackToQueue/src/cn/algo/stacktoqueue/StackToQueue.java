package cn.algo.stacktoqueue;

import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * @author ʯ����
 *
 */
public class StackToQueue {
	
	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(pop());
		push(4);
		System.out.println(pop());
		push(5);
		System.out.println(pop());
		System.out.println(pop());
	}
	
	public static void push(int node) {
		stack1.push(node);
	}
	
	public static int pop() {
		int result = 0;
		boolean isEmpty = false;
		
		if(stack2.isEmpty() == true) {
			if(stack1.isEmpty() == true) {
				isEmpty = true;
			}else {
				int size = stack1.size();
				for(int i = 0; i < size; i++) {
					stack2.push(stack1.pop());
				}
			}
			
		}
		
		if(isEmpty == false)
			result = stack2.pop();
		
		return result;
		
	}

}
