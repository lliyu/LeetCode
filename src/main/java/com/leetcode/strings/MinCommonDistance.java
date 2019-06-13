package com.leetcode.strings;

/**
 * @Auther: Administrator
 * @Date: 2019-06-13 09:50
 * @Description: 583
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例 1:
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */
public class MinCommonDistance {

    public static void main(String[] args) {
        //"intention"
        //"execution"
        System.out.println(minDistance("intention", ""));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = 1 + (i>0&&j>0?dp[i-1][j-1]:0);
                else
                    dp[i][j] = Math.max(i>0?dp[i-1][j]:dp[i][j], j>0?dp[i][j-1]:dp[i][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        return word1.length() + word2.length() - dp[word1.length()>0?word1.length()-1:0][word2.length()>0?word2.length()-1:0]*2;
    }
}
