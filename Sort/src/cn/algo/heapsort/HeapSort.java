package cn.algo.heapsort;

public class HeapSort {
	
	public void sort(int[] array) {
		int len = array.length;
		
		for(int i = len/2; i >= 0; i--) {
			percDown(array, i);
		}
		
		for(int i = len-1; i > 0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			percDown(array, 0);
		}
	}
	
	public void percDown(int[] array, int i) {
		int child = 0;
		int tmp = 0;
		int len = array.length;
		
		for(tmp = array[i]; (2*i+1) < len; i = child) {
			child = (2*i+1);
			if(child != len-1 && array[child+1] > array[child]) {
				child++;
			}
			if(tmp < array[child])
				array[i] = array[child];
			else
				break;
		}
		array[i] = tmp;
	}

}
