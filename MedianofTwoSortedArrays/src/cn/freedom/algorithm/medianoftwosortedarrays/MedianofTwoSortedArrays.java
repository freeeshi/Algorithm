package cn.freedom.algorithm.medianoftwosortedarrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianofTwoSortedArrays {
	
	public static void main(String[] args) {
		
		MedianofTwoSortedArrays t = new MedianofTwoSortedArrays();
		
		int[] nums1 = t.createNums(10);
		int[] nums2 = t.createNums(10);
		
//		int[] nums1 = {1,3};
//		int[] nums2 = {2}; 
		
		t.printNums(nums1);
		t.printNums(nums2);
		
		double m = t.findMedian2(nums1, nums2);
		System.out.println("median:" + m);
		
	}
	
	public double findMedian2(int[] nums1, int[] nums2) {
		
		int m = nums1.length, n = nums2.length;
		if(m > n) {
			int[] tmp1 = nums1;
			nums1 = nums2;
			nums2 = tmp1;
			int tmp2 = n;
			n= m;
			m = tmp2;
		}
		
		// i分割的边界
		int i, j, iMax = m, iMin = 0;
		// 左边部长，若是奇数，左边多一
		int leftHalf = (m + n + 1) / 2; 
		
		while(iMin <= iMax) {
			i = (iMax + iMin) / 2; 	
			j = leftHalf - i;	
			
			if (i < iMax && nums1[i] < nums2[j-1]) {
				iMin = iMin + 1;
			}else if(i > iMin && nums1[i-1] > nums2[j]) {
				iMax = iMax - 1;
			}else {
				int leftMax = 0;
				if(i == 0) {
					leftMax = nums2[j-1];
				}else if(j == 0) {
					leftMax = nums1[i-1];
				}else {
					leftMax = Math.max(nums1[i-1], nums2[j-1]);
				}
				
				if((m + n) % 2 != 0) {
					return leftMax;
				}
				
				int rigthMin = 0;
				if(i == m) {
					rigthMin = nums2[j];
				}else if (j == n) {
					rigthMin = nums1[i];
				}else {
					rigthMin = Math.min(nums1[i], nums2[j]);
				}
				
				return (leftMax + rigthMin) / 2.0;
			}
		}
		
		return 0.0;
	}
	
	// 自己的  失败
	public double findMedian1(int[] nums1, int[] nums2) {
		int count = nums1.length + nums2.length;
		int times = (count - 1)/2;
		int p = 0, q = 0;
		int m1 = 0, m2 = 0;
		double m = 0;
		
		if (nums1.length == nums2.length) {
			if(nums1[nums1.length-1] < nums2[0]) {
				m = ((double) (nums1[nums1.length-1] + nums2[0])) / 2;
				System.out.println(m);
				return m;
			}else if(nums2[nums2.length-1] < nums1[0]){
				m = ((double) (nums2[nums2.length-1] + nums1[0])) / 2;
				System.out.println(m);
				return m;
			}else if(nums1[nums1.length-1] == nums2[0]) {
				m = nums2[0];
				System.out.println(m);
				return m;
			}else if(nums2[nums2.length-1] == nums1[0]) {
				m = nums1[0];
				System.out.println(m);
				return m;
			}
		}
		
		while(times > 0) {
			if(nums1[p] < nums2[q]) {
				p++; 
			}else if(nums1[p] > nums2[q]){
				q++;
			}else if(nums1[p] == nums2[q]){
				p++;
				q++;
				times--;
			}
			times--;
		}
		
		System.out.println("times:" + times);
		System.out.println(nums1[p]);
		System.out.println(nums2[q]);
		
		if(times == -1)
			q--;
		
		if(count%2 == 0) {
			m1 = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
			m2 = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
			m = ((double) (m1 + m2)) / 2.0;
			System.out.println(m1 + "  " + m2 + "  " + m);
		}else {
			m = nums1[p] < nums2[q] ? nums1[p] : nums2[q];
			System.out.println(m);
		}
		
		return m;
	}
	
	public void printNums(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "  ");
		}
		
		System.out.println();
	}
	
	public int[] createNums(int count) {
		if(count == 0)
			count = (int) (Math.random() * 100);
		
		int[] nums = new int[count];
		for(int i = 0; i < count; i++) {
			nums[i] = (int) (Math.random() * 100); 
		}
		
		for(int i = 0; i < count-1; i++) {
			for(int j = i + 1; j < count; j++) {
				if(nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		
		return nums;
	}
	
}

