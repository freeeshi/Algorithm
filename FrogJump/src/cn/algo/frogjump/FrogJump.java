package cn.algo.frogjump;

/**
 * 1��һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * 2��һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * 
 * @author ʯ����
 *
 */
public class FrogJump {
	
	public static void main(String[] args) {
		System.out.println(jumpFloor1(20));
		System.out.println(jumpFloor2(20));
	}
	
	public static int jumpFloor2(int target) {
        if(target == 0)
            return 1;
        else
            return (int)Math.pow(2, target-1);
    }
	
	public static int jumpFloor1(int target) {
		int n = target + 1;
        int result = 0;
        int[] win = {0, 1, 1};

        if(n < 3)
            result = win[n];
        else {
            int i = 3;
            while(i <= n) {
                win[0] = win[1];
                win[1] = win[2];
                win[2] = win[1] + win[0];			

                i++;
            }

            result = win[2];
        }

        return result;

	 }
	
}
