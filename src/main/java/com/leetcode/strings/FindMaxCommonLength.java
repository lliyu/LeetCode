package com.leetcode.strings;

/**
 * @Auther: Administrator
 * @Date: 2019-06-12 09:53
 * @Description: 718
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 */
public class FindMaxCommonLength {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];//db[i][j]表示A[i]和B[j]所表示的值在(i,j)位置已经重合了多少
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i] != B[j]){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = 1 + (i>0 && j>0?dp[i-1][j-1]:0);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
