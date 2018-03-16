package cn.algo.arrayfind;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author ʯ����
 *
 */
public class ArrayFindTest {
	
	public static void main(String[] args) {
		int[][] array = {{1,5,6,23,49},{3,12,18,31,51},{8,21,46,47,80}};
		boolean f = ArrayFindTest.Find(12, array);
		System.out.println(f);
		
	}

    public static boolean Find(int target, int [][] array) {
        
        if(array[0].length == 0)
            return false;
        
        int i = 0;
        int j = array.length - 1;
        boolean find = false;
        boolean finish = false;
        
        
        while(find == false && finish == false){
            if(target > array[i][j])
                i++;
            else if(target < array[i][j])
                j--;
            else
                find = true;
            
            if(i == array[0].length || j == -1)
                finish = true;
        }
        
        return find;
    }

}
