package cn.algo.minnumberInrotatearray;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author 石龙飞
 *
 */
public class MinNumberInRotateArray {
	
	public static void main(String[] args) {
		int mini = minNumberInRotateArray(new int[] {3,4,5,6,7,2});
		System.out.println(mini);
	}
	
	public static int minNumberInRotateArray(int [] array) {
        int result = 0;
        if(array.length == 0)
            result = 0;
        else if(array.length == 1)
            result = array[0];
        else{
            result = array[0];
            for(int i = 0; i < array.length-1; i++){
                if(array[i] > array[i+1])
                    result = array[i+1];
            }
        }
        
        return result;
    }

}
