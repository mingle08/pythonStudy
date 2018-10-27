package com.imooc.leetCode.question003;

import java.util.Arrays;
import java.util.HashMap;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String str = "abcabcbbb";
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(lengthOfLongestSubstring2(str));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		int maxLen = 0;
		int len = 0;
//		char[] ch = s.toCharArray();
		for(int i=0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				len++;
			}else {
				// 若map中已经包含该字符，分为二种情况
				Integer index = map.get(s.charAt(i));
				// 情况1：上次出现的该字符并不在当前所统计的最长字符串中，只需要更新位置信息，并且统计len++
				if(i-index > len) {
					len++;
					map.put(s.charAt(i), i);
					continue;
				}
				// 情况2：上次出现的该字符影响了当前最长不重复的子字符串，则更新位置信息、max变量和len计数
				map.put(s.charAt(i), i);
				if(len > maxLen) {
					maxLen = len;
				}
				
				len = i - index;
			}
		}
		
		return maxLen > len ? maxLen : len;
	}

	public static int lengthOfLongestSubstring2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
}
