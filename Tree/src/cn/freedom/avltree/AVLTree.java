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
			// ����������ɾ��
			tree.setRight(delete(num, tree.getRight()));
			// �ж����������ĸ߶ȲΪ2ʱ������ת
			if(getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
				TreeNode left = tree.getLeft();
				if(getHigh(left.getLeft()) >= getHigh(left.getRight())) {
					// ���������� �������߶ȴ��ڵ��������������е�����ת
					tree = singleRotateWithLeft(tree);
				}else {
					// ���������� �������߶�С��������������˫����ת
					tree = doubleRotateWithLeft(tree);
				}
			}
		} else if (num < tree.getValue()) {
			// ����������ɾ��
			tree.setLeft(delete(num, tree.getLeft()));
			// �ж����������ĸ߶ȲΪ2ʱ������ת
			if(getHigh(tree.getRight()) - getHigh(tree.getLeft()) == 2) {
				TreeNode right = tree.getRight();
				if(getHigh(right.getRight()) >= getHigh(right.getLeft())) {
					// ���������� �������߶ȴ��ڵ��������������е�����ת
					tree = singleRotateWithRight(tree);
				}else {
					// ���������� �������߶�С��������������˫����ת
					tree = doubleRotateWithRight(tree);
				}
			}
		} else {
			if(tree.getLeft() != null && tree.getRight() != null) {
				TreeNode min = findMin(tree.getRight());
				tree.setValue(min.getValue());
				
				// ����������ɾ��
				tree.setRight(delete(min.getValue(), tree.getRight()));
				// �ж����������ĸ߶ȲΪ2ʱ������ת
				if(getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
					TreeNode left = tree.getLeft();
					if(getHigh(left.getLeft()) >= getHigh(left.getRight())) {
						// ���������� �������߶ȴ��ڵ��������������е�����ת
						tree = singleRotateWithLeft(tree);
					}else {
						// ���������� �������߶�С��������������˫����ת
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

		// ���¼���߶�
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
			// ���������в���
			tree.setRight(insert(value, tree.getRight()));
			// �ж����������ĸ߶ȲΪ2ʱ������ת
			if (getHigh(tree.getRight()) - getHigh(tree.getLeft()) == 2) {
				if (value < tree.getRight().getValue()) {
					// ���뵽����������������������˫����ת
					tree = doubleRotateWithRight(tree);
				} else {
					// ���뵽���������������������е�����ת
					tree = singleRotateWithRight(tree);
				}
			}
		} else if (value < tree.getValue()) {
			// ���������в���
			tree.setLeft(insert(value, tree.getLeft()));
			// �ж����������ĸ߶ȲΪ2ʱ������ת
			if (getHigh(tree.getLeft()) - getHigh(tree.getRight()) == 2) {
				if (value < tree.getLeft().getValue()) {
					// ���뵽���������������������е�����ת
					tree = singleRotateWithLeft(tree);
				} else {
					// ���뵽����������������������˫����ת
					tree = doubleRotateWithLeft(tree);
				}
			}
		}

		// ���¼���߶�
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
