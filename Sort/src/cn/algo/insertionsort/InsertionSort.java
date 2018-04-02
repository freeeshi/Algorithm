package cn.algo.insertionsort;

public class InsertionSort {
	
	
	public void sort(int[] array) {
		int len = array.length;
		for(int i = 1; i < len; i++) {
			int tmp = array[i];
			int j = i;
			for(; j > 0 && tmp < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = tmp;
		}
	}
	
	public void sort(int[] array, int left, int right) {
		for(int i = left; i < right+1; i++) {
			int tmp = array[i];
			int j = i;
			for(; j > left && tmp < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = tmp;
		}
	}

}
