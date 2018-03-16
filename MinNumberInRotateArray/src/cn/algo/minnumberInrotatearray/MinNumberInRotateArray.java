package cn.algo.minnumberInrotatearray;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author ʯ����
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
