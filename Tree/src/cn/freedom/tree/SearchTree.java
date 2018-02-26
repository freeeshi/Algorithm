package cn.freedom.tree;

public class SearchTree {

	public static void main(String[] args) {
		
	}
	
	private static Tree delete(int num, Tree tree) {
		
		if(tree != null) {
			throw new RuntimeException("Not Exist The Num!");
		}else if(num < tree.getValue()) {
			tree.setLeft(delete(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(delete(num, tree.getRight()));
		}else if(tree.getLeft() != null && tree.getRight() != null) {
			Tree min = findMin(tree.getRight());
			tree.setValue(min.getValue());
			tree.setRight(delete(min.getValue(), tree.getRight()));
		}else {
			if(tree.getRight() == null) {
				tree = tree.getLeft();
			}else if(tree.getLeft() == null) {
				tree = tree.getRight();
			}
		}
		
		return tree;
	}
	
	private static Tree insert(int num, Tree tree) {
		
		if(tree == null) {
			tree = new Tree(num, null, null);
		}else if(num < tree.getValue()){
			tree.setLeft(insert(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(insert(num, tree.getRight()));
		}
		
		return tree;
	}
	
	private static Tree findMax(Tree tree) {
		Tree result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMax(tree.getRight());
			}
		}
		
		return result;
	}
	
	private static Tree findMin(Tree tree) {
		Tree result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMin(tree.getLeft());
			}
		}
		
		return result;
	}
	
	private static Tree find(int num, Tree tree) {
		Tree result = null;
		
		if(tree != null) {
			if(num < tree.getValue()) {
				result = find(num, tree.getRight());
			}else if(num > tree.getValue()){
				result = find(num, tree.getLeft());
			}else {
				result = tree;
			}
		}
		
		return result;
	}
	
	private static Tree makeEmpty(Tree tree) {
		
		if(tree != null) {
			makeEmpty(tree.getLeft());
			makeEmpty(tree.getRight());
		}
		
		return null;
	}
	
}

class Tree{
	int value;
	Tree left;
	Tree right;
	
	public Tree() {
		// TODO Auto-generated constructor stub
	}
	
	public Tree(int value, Tree left, Tree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Tree getLeft() {
		return left;
	}
	public void setLeft(Tree left) {
		this.left = left;
	}
	public Tree getRight() {
		return right;
	}
	public void setRight(Tree right) {
		this.right = right;
	}
	
}