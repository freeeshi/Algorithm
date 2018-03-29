package cn.freedom.avltree;

import cn.algo.common.TreeNode;
import cn.algo.common.TreeUtils;
import cn.freedom.searchtree.SearchTree;

public class AVLTree extends SearchTree {
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		TreeNode tree = avlTree.createSearchTree(new int[] { 21, 34, 12, 7, 33, 20, 11, 2, 10, 29 });
		
		tree = avlTree.insert(19, tree);
		tree = avlTree.insert(18, tree);
		tree = avlTree.insert(1, tree);
		
		tree = avlTree.delete(2, tree);
		tree = avlTree.delete(12, tree);
		
		tree = avlTree.insert(118, tree);
		tree = avlTree.insert(13, tree);
		tree = avlTree.insert(49, tree);
		tree = avlTree.insert(0, tree);
		
		tree = avlTree.delete(49, tree);
		tree = avlTree.delete(33, tree);
		tree = avlTree.delete(34, tree);
		tree = avlTree.delete(20, tree);
		
		TreeUtils.printTreeByIn(tree);
		System.out.println();
		TreeUtils.printTreeByPre(tree);
		System.out.println();
		TreeUtils.printTreeByPost(tree);
		System.out.println();
		

	}

	@Override
	public TreeNode delete(int num, TreeNode tree) {

		if (tree == null) {
			throw new RuntimeException("Not Exist The Num!");
		} else if (num > tree.getValue()) {
			// 在右子树中删除
			tree.setRight(delete(num, tree.getRight()));
			// 判断左右子树的高度差，为2时进行旋转
			if(getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
				TreeNode left = tree.getLeft();
				if(getHigh(left.getLeft()) >= getHigh(left.getRight())) {
					// 若左子树的 左子树高度大于等于右子树，进行单左旋转
					tree = singleRotateWithLeft(tree);
				}else {
					// 若左子树的 左子树高度小于右子树，进行双左旋转
					tree = doubleRotateWithLeft(tree);
				}
			}
		} else if (num < tree.getValue()) {
			// 在左子树中删除
			tree.setLeft(delete(num, tree.getLeft()));
			// 判断左右子树的高度差，为2时进行旋转
			if(getHigh(tree.getRight()) - getHigh(tree.getLeft()) == 2) {
				TreeNode right = tree.getRight();
				if(getHigh(right.getRight()) >= getHigh(right.getLeft())) {
					// 若右子树的 右子树高度大于等于左子树，进行单右旋转
					tree = singleRotateWithRight(tree);
				}else {
					// 若右子树的 右子树高度小于左子树，进行双右旋转
					tree = doubleRotateWithRight(tree);
				}
			}
		} else {
			if(tree.getLeft() != null && tree.getRight() != null) {
				TreeNode min = findMin(tree.getRight());
				tree.setValue(min.getValue());
				
				// 在右子树中删除
				tree.setRight(delete(min.getValue(), tree.getRight()));
				// 判断左右子树的高度差，为2时进行旋转
				if(getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
					TreeNode left = tree.getLeft();
					if(getHigh(left.getLeft()) >= getHigh(left.getRight())) {
						// 若左子树的 左子树高度大于等于右子树，进行单左旋转
						tree = singleRotateWithLeft(tree);
					}else {
						// 若左子树的 左子树高度小于右子树，进行双左旋转
						tree = doubleRotateWithLeft(tree);
					}
				}
			}else {
				if(tree.getRight() == null) {
					tree = tree.getLeft();
				}else if(tree.getLeft() == null) {
					tree = tree.getRight();
				}
			}
		}

		// 重新计算高度
		if (tree != null)
			tree.setHeight(TreeUtils.max(getHigh(tree.getLeft()), getHigh(tree.getRight())) + 1);

		return tree;
	}

	public TreeNode createSearchTree(int[] values) {
		int len = values.length;
		TreeNode root = null;

		for (int i = 0; i < len; i++) {
			root = insert(values[i], root);
		}

		return root;
	}

	public TreeNode insert(int value, TreeNode tree) {

		if (tree == null) {
			tree = new TreeNode(value, null, null, 0);
		} else if (value > tree.getValue()) {
			// 向右子树中插入
			tree.setRight(insert(value, tree.getRight()));
			// 判断左右子树的高度差，为2时进行旋转
			if (getHigh(tree.getRight()) - getHigh(tree.getLeft()) == 2) {
				if (value < tree.getRight().getValue()) {
					// 插入到了右子树的左子树，进行双右旋转
					tree = doubleRotateWithRight(tree);
				} else {
					// 插入到了右子树的右子树，进行单右旋转
					tree = singleRotateWithRight(tree);
				}
			}
		} else if (value < tree.getValue()) {
			// 向左子树中插入
			tree.setLeft(insert(value, tree.getLeft()));
			// 判断左右子树的高度差，为2时进行旋转
			if (getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
				if (value < tree.getLeft().getValue()) {
					// 插入到了左子树的左子树，进行单左旋转
					tree = singleRotateWithLeft(tree);
				} else {
					// 插入到了左子树的右子树，进行双左旋转
					tree = doubleRotateWithLeft(tree);
				}
			}
		}

		// 重新计算高度
		tree.setHeight(TreeUtils.max(getHigh(tree.getLeft()), getHigh(tree.getRight())) + 1);

		return tree;
	}

	public TreeNode singleRotateWithLeft(TreeNode node1) {

		TreeNode node2 = node1.getLeft();
		node1.setLeft(node2.getRight());
		node2.setRight(node1);

		node1.setHeight(TreeUtils.max(getHigh(node1.getLeft()), getHigh(node1.getRight())) + 1);
		node2.setHeight(TreeUtils.max(getHigh(node2.getLeft()), getHigh(node2.getRight())) + 1);

		return node2;
	}

	public TreeNode singleRotateWithRight(TreeNode node1) {
		TreeNode node2 = node1.getRight();
		node1.setRight(node2.getLeft());
		node2.setLeft(node1);

		node1.setHeight(TreeUtils.max(getHigh(node1.getLeft()), getHigh(node1.getRight())) + 1);
		node2.setHeight(TreeUtils.max(getHigh(node2.getLeft()), getHigh(node2.getRight())) + 1);

		return node2;
	}

	public TreeNode doubleRotateWithLeft(TreeNode node1) {
		node1.setLeft(singleRotateWithRight(node1.getLeft()));
		return singleRotateWithLeft(node1);
	}

	public TreeNode doubleRotateWithRight(TreeNode node1) {
		node1.setRight(singleRotateWithLeft(node1.getRight()));
		return singleRotateWithRight(node1);
	}

	public int getHigh(TreeNode tree) {
		if (tree == null) {
			return -1;
		} else {
			return tree.getHeight();
		}

	}

}
