package cn.algo.fibonacci;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 * @author ʯ����
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
