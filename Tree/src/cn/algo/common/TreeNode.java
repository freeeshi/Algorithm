package cn.algo.common;

public class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;
	private int height;

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int value, TreeNode left, TreeNode right, int height) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.height = height;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
