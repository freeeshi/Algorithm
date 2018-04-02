package cn.algo.common;

import java.util.Arrays;

import cn.algo.heapsort.HeapSort;
import cn.algo.insertionsort.InsertionSort;
import cn.algo.mergesort.MergeSort;
import cn.algo.quicksort.QuickSort;
import cn.algo.shellsort.ShellSort;

public class TestFun {

	public static void main(String[] args) {
		long start = 0;
		int[] array1 = ArrayUtils.createArray(1000);
		int[] array2 = Arrays.copyOf(array1, array1.length);
		int[] array3 = Arrays.copyOf(array1, array1.length);
		int[] array4 = Arrays.copyOf(array1, array1.length);
		int[] array5 = Arrays.copyOf(array1, array1.length);
		
		start = System.currentTimeMillis();
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(array1);
		System.out.println("InsertionSort:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		ShellSort shellSort = new ShellSort();
		shellSort.sort(array2);
		System.out.println("ShellSort:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		HeapSort heapSort = new HeapSort();
		heapSort.sort(array3);
		System.out.println("HeapSort:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array4);
		System.out.println("MergeSort:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		QuickSort quickSort = new QuickSort();
		quickSort.sort(array5);
		System.out.println("QuickSort:" + (System.currentTimeMillis() - start));
		
	}
}
