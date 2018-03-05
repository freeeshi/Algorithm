package cn.freedom.avltree;

public class AVLTreeTest {
	
	public static void main(String[] args) {
		
	}
	
	
	
	private static AVLTree makeEmpty(AVLTree tree) {
		
		if(tree != null) {
			makeEmpty(tree.getLeft());
			makeEmpty(tree.getRight());
		}
		
		return null;
	}

}

class AVLTree{
	int value;
	AVLTree left;
	AVLTree right;
	int height;
	
	public AVLTree() {
		// TODO Auto-generated constructor stub
	}
	
	public AVLTree(int value, AVLTree left, AVLTree right, int height) {
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

	public AVLTree getLeft() {
		return left;
	}

	public void setLeft(AVLTree left) {
		this.left = left;
	}

	public AVLTree getRight() {
		return right;
	}

	public void setRight(AVLTree right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}