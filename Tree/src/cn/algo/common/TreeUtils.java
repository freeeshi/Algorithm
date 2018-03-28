package cn.algo.common;

public class TreeUtils {
	
	public static void Mirror(TreeNode root) {
		if(root != null) {
			TreeNode tmp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(tmp);
			Mirror(root.getLeft());
			Mirror(root.getRight());
		}
	}

	public static int[] printTreeByPost(TreeNode treeNode) {
		
		if(treeNode != null) {
			int[] left = printTreeByPost(treeNode.getLeft());
			int[] right = printTreeByPost(treeNode.getRight());
			System.out.print(treeNode.getValue() + " ");
			
			int[] all = new int[left.length + right.length + 1];
			System.arraycopy(left, 0, all, 0, left.length);
			System.arraycopy(right, 0, all, left.length, right.length);
			all[left.length + right.length] = treeNode.getValue();
			
			return all;
		}else
			return new int[0];
	}

	public static int[] printTreeByIn(TreeNode treeNode) {
		if(treeNode != null) {
			int[] left = printTreeByIn(treeNode.getLeft());
			System.out.print(treeNode.getValue() + " ");
			int[] right = printTreeByIn(treeNode.getRight());
			
			
			int[] all = new int[left.length + right.length + 1];
			System.arraycopy(left, 0, all, 0, left.length);
			all[left.length] = treeNode.getValue();
			System.arraycopy(right, 0, all, left.length+1, right.length);
			
			return all;
		}else
			return new int[0];
	}

	public static int[] printTreeByPre(TreeNode treeNode) {
		if(treeNode != null) {
			System.out.print(treeNode.getValue() + " ");
			int[] left = printTreeByPre(treeNode.getLeft());
			int[] right = printTreeByPre(treeNode.getRight());
			
			int[] all = new int[left.length + right.length + 1];
			all[0] = treeNode.getValue();
			System.arraycopy(left, 0, all, 1, left.length);
			System.arraycopy(right, 0, all, left.length+1, right.length);
			
			return all;
		}else
			return new int[0];
	}

}
