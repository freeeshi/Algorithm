package cn.algo.changespace;

/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author ʯ����
 *
 */
public class ChangeSpace {
	
	public static void main(String[] args) {
		StringBuffer strBuf = new StringBuffer(" hello ");
		String str = ChangeSpace.replaceSpace(strBuf);
		System.out.println(str);
	}
	
	public static String replaceSpace(StringBuffer str) {
        int index = 0;
        
        while((index = str.indexOf(" ")) != -1) {
            str.replace(index, index+1, "%20");
        }
        
        return str.toString();
    }
}
