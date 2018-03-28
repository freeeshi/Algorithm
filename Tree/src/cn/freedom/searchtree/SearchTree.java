package cn.freedom.searchtree;

import cn.algo.common.TreeNode;
import cn.algo.common.TreeUtils;

public class SearchTree {

	public static void main(String[] args) {
		TreeNode root = createSearchTree(new int[] {3,62,8,12,13,92,16,45,67});
		int[] arr = TreeUtils.printTreeByPre(root);
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		
		arr = TreeUtils.printTreeByPost(root);
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		arr = TreeUtils.printTreeByIn(root);
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static TreeNode createSearchTree(int[] values) {
		int len = values.length;
		TreeNode root = null;
		
		for(int i = 0; i < len; i++) {
			root = insert(values[i], root);
		}
		
		return root;
	}
	
	private static TreeNode delete(int num, TreeNode tree) {
		
		if(tree != null) {
			throw new RuntimeException("Not Exist The Num!");
		}else if(num < tree.getValue()) {
			tree.setLeft(delete(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(delete(num, tree.getRight()));
		}else if(tree.getLeft() != null && tree.getRight() != null) {
			TreeNode min = findMin(tree.getRight());
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
	
	private static TreeNode insert(int value, TreeNode tree) {
		
		if(tree == null) {
			tree = new TreeNode(value, null, null);
		}else if(value < tree.getValue()){
			tree.setLeft(insert(value, tree.getLeft()));
		}else if(value > tree.getValue()) {
			tree.setRight(insert(value, tree.getRight()));
		}
		
		return tree;
	}
	
	private static TreeNode findMax(TreeNode tree) {
		TreeNode result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMax(tree.getRight());
			}
		}
		
		return result;
	}
	
	private static TreeNode findMin(TreeNode tree) {
		TreeNode result = null;
		
		if(tree != null) {
			if(tree.getLeft() == null) {
				result = tree;
			}else {
				result = findMin(tree.getLeft());
			}
		}
		
		return result;
	}
	
	private static TreeNode find(int num, TreeNode tree) {
		TreeNode result = null;
		
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
	
	private static TreeNode makeEmpty(TreeNode tree) {
		
		if(tree != null) {
			makeEmpty(tree.getLeft());
			makeEmpty(tree.getRight());
		}
		
		return null;
	}
	
}