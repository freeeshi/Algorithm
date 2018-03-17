package cn.algo.frogjump;

/**
 * 1、一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 2、一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author 石龙飞
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
