package cn.algo.reorderarray;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author 石龙飞
 *
 */
public class ReOrderArray {

	public static void main(String[] args) {
		int array1[] = new int[100000];
		int array2[] = new int[100000];
		
		for (int i = 0; i < 100000; i++) {
			array1[i] = (int) (Math.random() * 100);
		}
		array2 = array1.clone();

		long start = System.currentTimeMillis();
		order1(array1);
		System.out.println("Time:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		order2(array2);
		System.out.println("Time:" + (System.currentTimeMillis() - start));
		
	}

	public static void order2(int[] a) {
		if (a == null || a.length == 0)
			return;
		int i = 0, j;
		while (i < a.length) {
			while (i < a.length && !isEven(a[i]))
				i++;
			j = i + 1;
			while (j < a.length && isEven(a[j]))
				j++;
			if (j < a.length) {
				int tmp = a[j];
				for (int j2 = j - 1; j2 >= i; j2--) {
					a[j2 + 1] = a[j2];
				}
				a[i++] = tmp;
			} else {// 查找失敗
				break;
			}
		}
	}

	public static boolean isEven(int n) {
		if (n % 2 == 0)
			return true;
		return false;
	}

	public static void order1(int[] array) {

		int a1[] = new int[array.length];
		int a2[] = new int[array.length];
		int n1 = 0, n2 = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				a1[n1++] = array[i];
			} else {
				a2[n2++] = array[i];
			}
		}

		for (int i = 0; i < n2; i++) {
			array[i] = a2[i];
		}

		for (int i = n2; i < n1 + n2; i++) {
			array[i] = a1[i - n2];
		}

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
