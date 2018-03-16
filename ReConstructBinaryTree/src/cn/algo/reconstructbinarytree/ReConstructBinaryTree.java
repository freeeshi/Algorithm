package cn.algo.reconstructbinarytree;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author ʯ����
 *
 */
public class ReConstructBinaryTree {
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		reConstruct(pre, in);
	}
	
	public static TreeNode reConstruct(int [] pre,int [] in) {
		
		// ���ڵ�
		TreeNode root = null;
		
		// �����������鳤��Ϊ0��ֱ�ӷ���null
		// �������Ϊһ������ֵΪ��ֵ�Ľڵ�
		// �������Ϊ2�������һ����һ�����ӵ���
		// ������ȴ���2���ݹ���ô˺�����������
		if(pre.length == 0) {
			return null;
		}else if(pre.length == 1) {
			root = new TreeNode(pre[0]);
		}else if(pre.length == 2) {
			root = new TreeNode(pre[0]);
			TreeNode node = new TreeNode(pre[1]);
			
			// �ж�����Ϊ����ҽڵ�
			if(pre[0] == in[0])
				root.setRight(node);
			else
				root.setRight(node);
		}else {
			int rootValue = pre[0];
			int rootIndex = 0;
			
			// �������ǰroot�ڵ�
			root = new TreeNode(rootValue);

			// �����root�������е�λ��
			for(int i = 0; i < in.length; i++) {
				if(in[i] == rootValue) {
					rootIndex = i;
					break;
				}
			}
			
			// �����pre��in����������
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
			
			// �������ҽڵ�
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
