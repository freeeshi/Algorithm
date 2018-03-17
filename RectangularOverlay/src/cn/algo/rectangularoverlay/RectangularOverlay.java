package cn.algo.rectangularoverlay;

/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * @author ʯ����
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
