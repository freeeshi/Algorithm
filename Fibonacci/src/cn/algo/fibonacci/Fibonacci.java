package cn.algo.fibonacci;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * @author 石龙飞
 *
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fibonacciN2(5));
	}
	
	public static int fibonacciN1(int n) {
		
		if(n == 0)
			return 0;
		else if(n == 1 || n == 2){
			return 1;
		}else {
			return fibonacciN1(n-1) + fibonacciN1(n-2);
		}
		
	}
	
	public static int fibonacciN2(int n) {
		
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
