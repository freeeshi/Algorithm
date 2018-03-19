package cn.algo.power;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author 石龙飞
 *
 */
public class Power {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(Math.pow(3, 37));
		System.out.println("Time:" + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		System.out.println(pow1(3, 37));
		System.out.println("Time:" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		System.out.println(pow2(3, 37));
		System.out.println("Time:" + (System.currentTimeMillis() - start));
	}

	public static double pow2(double base, int n) {
		double res = 1, curr = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("分母不能为0");
			exponent = -n;
		} else {// n==0
			return 1;// 0的0次方
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= curr;
			curr *= curr;// 翻倍
			exponent >>= 1;// 右移一位
		}
		return n >= 0 ? res : (1 / res);
	}

	public static double pow1(double base, int exponent) {
		double result = 0.0;
		int flag = 1;

		if (exponent != 0)
			flag = Math.abs(exponent) / exponent;

		if (base == 0) {
			if (exponent < 0)
				throw new RuntimeException("分母不能为0");
			else
				result = 0.0;
		} else {
			if (exponent == 0) {
				result = 1.0;
			} else {
				result = 1.0;
				for (int i = 0; i < Math.abs(exponent); i++) {
					result *= base;
				}

				if (flag == -1)
					result = 1 / result;
			}
		}

		return result;
	}

}
