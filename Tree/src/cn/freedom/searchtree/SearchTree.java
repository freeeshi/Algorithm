package cn.freedom.searchtree;

public class SearchTree {

	public static void main(String[] args) {
		
	}
	
	private static SearchTreeNode delete(int num, SearchTreeNode tree) {
		
		if(tree != null) {
			throw new RuntimeException("Not Exist The Num!");
		}else if(num < tree.getValue()) {
			tree.setLeft(delete(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(delete(num, tree.getRight()));
		}else if(tree.getLeft() != null && tree.getRight() != null) {
			SearchTreeNode min = findMin(tree.getRight());
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
	
	private static SearchTreeNode insert(int num, SearchTreeNode tree) {
		
		if(tree == null) {
			tree = new SearchTreeNode(num, null, null);
		}else if(num < tree.getValue()){
			tree.setLeft(insert(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(insert(num, tree.getRight()));
		}
		
		return tree;
	}
	
	private static SearchTreeNode findMax(SearchTreeNode tree) {
		SearchTreeNode result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMax(tree.getRight());
			}
		}
		
		return result;
	}
	
	private static SearchTreeNode findMin(SearchTreeNode tree) {
		SearchTreeNode result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMin(tree.getLeft());
			}
		}
		
		return result;
	}
	
	private static SearchTreeNode find(int num, SearchTreeNode tree) {
		SearchTreeNode result = null;
		
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
	
	private static SearchTreeNode makeEmpty(SearchTreeNode tree) {
		
		if(tree != null) {
			makeEmpty(tree.getLeft());
			makeEmpty(tree.getRight());
		}
		
		return null;
	}
	
}

class SearchTreeNode{
	int value;
	SearchTreeNode left;
	SearchTreeNode right;
	
	public SearchTreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public SearchTreeNode(int value, SearchTreeNode left, SearchTreeNode right) {
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
	public SearchTreeNode getLeft() {
		return left;
	}
	public void setLeft(SearchTreeNode left) {
		this.left = left;
	}
	public SearchTreeNode getRight() {
		return right;
	}
	public void setRight(SearchTreeNode right) {
		this.right = right;
	}
	
}