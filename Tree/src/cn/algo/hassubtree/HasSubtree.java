package cn.algo.hassubtree;

import cn.algo.common.TreeNode;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ
 * ps������Լ��������������һ�������ӽṹ
 * @author ʯ����
 * �ص㣺ע���ָ��͵ݹ�����
 */
public class HasSubtree {

	public boolean findNode(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.getValue() == root2.getValue()) {
				result = isSubTree(root1, root2);
			}
			if (!result)
				result = findNode(root1.getLeft(), root2);
			if (!result)
				result = findNode(root1.getRight(), root2);
		}

		return result;
	}

	public boolean isSubTree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.getValue() == root2.getValue())
				result = isSubTree(root1.getLeft(), root2.getLeft()) && isSubTree(root1.getRight(), root2.getRight());
		} else {
			if (root1 == null)
				result = false;
			if (root2 == null)
				result = true;
		}

		return result;
	}

}
