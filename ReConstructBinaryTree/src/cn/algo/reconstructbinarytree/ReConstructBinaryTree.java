package cn.algo.reconstructbinarytree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author 石龙飞
 *
 */
public class ReConstructBinaryTree {
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		reConstruct(pre, in);
	}
	
	public static TreeNode reConstruct(int [] pre,int [] in) {
		
		// 根节点
		TreeNode root = null;
		
		// 如果输入的数组长度为0，直接返回null
		// 如果长度为一，返回值为此值的节点
		// 如果长度为2，构造出一个有一个儿子的树
		// 如果长度大于2，递归调用此函数，构造树
		if(pre.length == 0) {
			return null;
		}else if(pre.length == 1) {
			root = new TreeNode(pre[0]);
		}else if(pre.length == 2) {
			root = new TreeNode(pre[0]);
			TreeNode node = new TreeNode(pre[1]);
			
			// 判断设置为左或右节点
			if(pre[0] == in[0])
				root.setRight(node);
			else
				root.setRight(node);
		}else {
			int rootValue = pre[0];
			int rootIndex = 0;
			
			// 构造出当前root节点
			root = new TreeNode(rootValue);

			// 计算出root在数组中的位置
			for(int i = 0; i < in.length; i++) {
				if(in[i] == rootValue) {
					rootIndex = i;
					break;
				}
			}
			
			// 分离出pre和in的左右子树
			int[] leftPre = new int[rootIndex];
			int[] rightPre = new int[pre.length - rootIndex - 1];
			int[] leftIn = new int[rootIndex];
			int[] rightIn = new int[pre.length - rootIndex - 1];
			for(int i = 0; i < rootIndex; i++) {
				leftPre[i] = pre[i+1];
				leftIn[i] = in[i];
			}
			for(int i = 0; i < pre.length-rootIndex-1; i++) {
				rightPre[i] = pre[rootIndex+i+1];
				rightIn[i] = in[rootIndex+i+1];
			}
			
			printArray(leftPre);
			printArray(leftIn);
			printArray(rightPre);
			printArray(rightIn);
			
			// 设置左右节点
			root.setLeft(reConstruct(leftPre, leftIn));
			root.setRight(reConstruct(rightPre, rightIn));
			
		}
		
		return root;
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}

 

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
