package cn.algo.quicksort;

import cn.algo.insertionsort.InsertionSort;

public class QuickSort {

	private int cutOff = 7;

	public void sort(int[] array) {
		sort(array, 0, array.length-1);
	}

	private void sort(int[] array, int left, int right) {
		if(right-left+1 > cutOff) {
			int center = midValue(array, left, right);
			int i = left, j = right-1;
			
			while(true) {
				while(array[++i] < center);
				while(array[--j] > center);
				if(i < j) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}else
					break;
			}
			
			int tmp = array[i];
			array[i] = array[right-1];
			array[right-1] = tmp;
			
			sort(array, left, i-1);
			sort(array, i+1, right);
		}else {
			new InsertionSort().sort(array, left, right);
		}
	}

	private int midValue(int[] array, int left, int right) {
		int center = (left + right) / 2;
		if (array[left] > array[right]) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
		}
		if (array[left] > array[center]) {
			int tmp = array[left];
			array[left] = array[center];
			array[center] = tmp;
		}
		if (array[center] > array[right]) {
			int tmp = array[center];
			array[center] = array[right];
			array[right] = tmp;
		}
		
		int tmp = array[center];
		array[center] = array[right-1];
		array[right-1] = tmp;
		
		return array[right-1];
	}

	public int getCutOff() {
		return cutOff;
	}

	public void setCutOff(int cutOff) {
		this.cutOff = cutOff;
	}

}
