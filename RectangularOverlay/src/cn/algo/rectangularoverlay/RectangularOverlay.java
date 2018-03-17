package cn.algo.rectangularoverlay;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author 石龙飞
 *
 */
public class RectangularOverlay {
	
	public static void main(String[] args) {
		System.out.println(rectCover(20));
	}
	
	public static int rectCover(int target) {
		int n = target + 1;
        int result = 0;
        int[] win = {0, 1, 1};

        if(n < 3)
            result = win[n-1];
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
