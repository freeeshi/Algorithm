package cn.algo.binary;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author 石龙飞
 *
 */
public class BinaryOfNumber {
	
	public static void main(String[] args) {
		System.out.println(numberOf1(-8));
	}
	
	public static int numberOf1(int n) {
		int count = 0;
		if(n >= 0) {
			while(n != 0) {
				count += n % 2;
				n /= 2;
			}
		}else {
			count = 32 - numberOf1(Math.abs(n+1));
		}
		
		return count;
    }

}
