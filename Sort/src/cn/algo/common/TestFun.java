package cn.algo.common;

import java.util.Arrays;

import cn.algo.heapsort.HeapSort;
import cn.algo.insertionsort.InsertionSort;
import cn.algo.shellsort.ShellSort;

public class TestFun {

	public static void main(String[] args) {
		long start = 0;
		int[] array1 = ArrayUtils.createArray(10);
		int[] array2 = Arrays.copyOf(array1, array1.length);
		int[] array3 = Arrays.copyOf(array1, array1.length);
		int[] array4 = Arrays.copyOf(array1, array1.length);
		
		start = System.currentTimeMillis();
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(array1);
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		ShellSort shellSort = new ShellSort();
		shellSort.sort(array2);
		System.out.println(System.currentTimeMillis() - start);
		
		HeapSort heapSort = new HeapSort();
		heapSort.sort(array3);
		ArrayUtils.printArray(array3);
		
	}
}
