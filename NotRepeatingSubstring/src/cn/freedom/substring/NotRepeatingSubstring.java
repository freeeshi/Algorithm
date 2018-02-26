package cn.freedom.substring;

import java.util.ArrayList;
import java.util.List;

public class NotRepeatingSubstring {
	
	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(findSubstring(s));
	}
	
	private static int findSubstring(String s) {
		List<String> str = new ArrayList<>();
		int n = 0;
		int maxLen = 0;
		int sLen = s.length();
		String currStr = null;
		
		while(n < sLen) {
			currStr = s.substring(n, n+1);
			
			if(str.contains(currStr) == true) {
				if(str.size() > maxLen) {
					maxLen = str.size();
				}
				
				int before = str.indexOf(currStr);
				for(int i = 0; i <= before; i++) {
					str.remove(0);
				}
			}
			
			str.add(currStr);
			n++;
		}
		
		if(str.contains(currStr) == true) {
			if(str.size() > maxLen) {
				maxLen = str.size();
			}
		}
		
		return maxLen;
	}

}
