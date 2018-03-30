package cn.algo.shellsort;

public class ShellSort {
	
	public static void main(String[] args) {
		
	}
	
	public void sort(int[] array) {
		int len = array.length;
		for(int increment = len/2; increment > 0; increment /= 2) {
			for(int i = increment; i < len; i++) {
				int tmp = array[i];
				int j = i;
				for(; j >= increment && tmp < array[j-increment]; j -= increment) {
					array[j] = array[j-increment];
				}
				array[j] = tmp;
			}
		}
	}

}
