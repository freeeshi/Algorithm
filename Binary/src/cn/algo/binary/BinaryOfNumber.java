package cn.algo.binary;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * @author ʯ����
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
