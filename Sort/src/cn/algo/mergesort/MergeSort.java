package cn.algo.mergesort;

public class MergeSort {
	
	public void sort(int[] array) {
		sort(array, new int[array.length], 0, array.length-1);
	}

	private void sort(int[] array, int[] tmp, int left, int right) {
		if (left < right) {
			int center = (right + left) / 2;
			sort(array, tmp, left, center);
			sort(array, tmp, center+1, right);
			merge(array, tmp, left, center + 1, right);
		}
	}

	private void merge(int[] array, int[] tmp, int leftCurr, int rightCurr, int rightEnd) {
		int leftEnd = rightCurr - 1;
		int tmpCurr = leftCurr;
		int len = rightEnd - leftCurr + 1;

		while (leftCurr <= leftEnd && rightCurr <= rightEnd) {
			if (array[leftCurr] < array[rightCurr]) {
				tmp[tmpCurr++] = array[leftCurr++];
			} else {
				tmp[tmpCurr++] = array[rightCurr++];
			}
		}

		while (leftCurr <= leftEnd) {
			tmp[tmpCurr++] = array[leftCurr++];
		}

		while (rightCurr <= rightEnd) {
			tmp[tmpCurr++] = array[rightCurr++];
		}

		for (int i = 0; i < len; i++, rightEnd--) {
			array[rightEnd] = tmp[rightEnd];
		}
	}

}
