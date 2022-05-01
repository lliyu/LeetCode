package com.leetcode.dynamic;

/**
 * 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] 表示以text1[i]和text2[j]结尾的具有相同子串的数量
        int[][] dp = new int[text1.length()][text2.length()];
        int max = 0;
        for(int i=0; i<text1.length(); i++) {
            for(int j=0; j<text2.length(); j++) {
                if (i==0 || j==0){
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }

                }else {
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j-1]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
