package cn.algo.hassubtree;

import cn.algo.common.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构
 * ps：我们约定空树不是任意一个树的子结构
 * @author 石龙飞
 * 重点：注意空指针和递归条件
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
