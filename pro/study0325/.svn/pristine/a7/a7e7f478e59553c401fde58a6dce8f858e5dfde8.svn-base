package com.imooc.leetCode.question005;

/**
 * 动态规划法， 
　　假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出： 
　　dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。 
　　这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式： 
　　a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true; 
　　b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。 
　　有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
 * @author Administrator
 *
 */
public class LongestPalidromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String longestPalindrome(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		
		int maxLen = 0;
		String longest = null;
		
		int len = str.length();
		boolean[][] table = new boolean[len][len];
		// 单个字符都是回文字符
		for(int i=0; i < len; i++) {
			table[i][i] = true;longest = str.substring(i, i + 1);
            maxLen = 1;
        }

        // 判断两个字符是否是回文
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = str.substring(i, i + 2);
                maxLen = 2;
            }
        }


        // 求长度大于2的子串是否是回文串
        for (int leng = 3; leng <= len; len++) {
            for (int i = 0, j; (j = i + len - 1) <= len - 1; i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLen < len) {
                        longest = str.substring(i, j + 1);
                        maxLen = len;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }
        return longest;
	}
	
	

}
