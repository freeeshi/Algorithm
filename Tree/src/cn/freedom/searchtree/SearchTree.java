package cn.freedom.searchtree;

import cn.algo.common.TreeNode;
import cn.algo.common.TreeUtils;

public class SearchTree {

	public static void main(String[] args) {
		SearchTree searchTree = new SearchTree();
		TreeNode root = searchTree.createSearchTree(new int[] {3,62,8,12,13,92,16,45,67});
		TreeUtils.printTreeByPost(root);
		System.out.println();
		
		System.out.println(searchTree.findMax(root).getValue());
		System.out.println(searchTree.findMaxByCycle(root).getValue());
		System.out.println(searchTree.findMin(root).getValue());
		
		root = searchTree.delete(3, root);
		TreeUtils.printTreeByPost(root);
		System.out.println();
		
	}
	
	public TreeNode createSearchTree(int[] values) {
		int len = values.length;
		TreeNode root = null;
		
		for(int i = 0; i < len; i++) {
			root = insert(values[i], root);
		}
		
		return root;
	}
	
	public TreeNode delete(int num, TreeNode tree) {
		
		if(tree == null) {
			throw new RuntimeException("Not Exist The Num!");
		}else if(num < tree.getValue()) {
			tree.setLeft(delete(num, tree.getLeft()));
		}else if(num > tree.getValue()) {
			tree.setRight(delete(num, tree.getRight()));
		}else if(tree.getLeft() != null && tree.getRight() != null) {
			TreeNode min = findMin(tree.getRight());
			tree.setValue(min.getValue());
			delete(min.getValue(), tree.getRight());
		}else {
			if(tree.getRight() == null) {
				tree = tree.getLeft();
			}else if(tree.getLeft() == null) {
				tree = tree.getRight();
			}
		}
		
		return tree;
	}
	
	public TreeNode insert(int value, TreeNode tree) {
		
		if(tree == null) {
			tree = new TreeNode(value, null, null);
		}else if(value < tree.getValue()){
			tree.setLeft(insert(value, tree.getLeft()));
		}else if(value > tree.getValue()) {
			tree.setRight(insert(value, tree.getRight()));
		}
		
		return tree;
	}
	
	public TreeNode findMax(TreeNode tree) {
		TreeNode result = null;
		
		if(tree != null) {
			if(tree.getRight() == null) {
				result = tree;
			}else {
				result = findMax(tree.getRight());
			}
		}
		
		return result;
	}
	
	public TreeNode findMaxByCycle(TreeNode tree) {
		if(tree != null) {
			while(tree.getRight() != null)
				tree = tree.getRight();
		}
		return tree;
	}
	
	public TreeNode findMin(TreeNode tree) {
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
	
	public TreeNode find(int num, TreeNode tree) {
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
	
	public TreeNode makeEmpty(TreeNode tree) {
		
		if(tree != null) {
			makeEmpty(tree.getLeft());
			makeEmpty(tree.getRight());
		}
		
		return null;
	}
	
}