package cn.algo.common;

public class ArrayUtils {
	
	public static int[] createArray() {
		return createArray(10, 100);
	}
	
	public static int[] createArray(int size) {
		return createArray(size, 100);
	}
	
	public static int[] createArray(int size, int max) {
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * max);
		}
		
		return array;
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
