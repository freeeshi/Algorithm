package cn.algo.minvalue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author 石龙飞
 *
 */
public class MinValue {
	
	private Stack<Integer> stack = new Stack<>(); 
	private Stack<Integer> minStack = new Stack<>();

	public void push(int node) {
		stack.push(node);
	}

	public int pop() {
		return stack.pop();
	}

	public int top() {
		return stack.size();
	}

	public int min() {
		int size = top();
		int min = stack.get(0);
		for(int i = 0; i < size; i++) {
			if(stack.get(i) < min)
				min = stack.get(i);
		}
		
		return min;
	}

}
