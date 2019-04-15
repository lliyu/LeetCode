package com.leetcode.dynamic;

/**
 * @Auther: Administrator
 * @Date: 2019-04-15 15:08
 * @Description:
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 *
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 *
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class FindMaxForm {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0", "1", "0001", "11001"}, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]的值表示在使用使用i个0和j个1能够拼出符合条件字符串的最大数量
        int[][] dp = new int[m+1][n+1];
        int zero=0,one=0;
        for(int i=0;i<strs.length;i++){
            //统计一个字符串中0和1的个数
            zero=0;one=0;//归零
            for(int j=0;j<strs[i].length();j++){
                if('0' == strs[i].charAt(j))
                    zero++;
                else
                    one++;
            }

            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                    //dp[i - zero][j - one]表示如果取了当前的这个字符串 那么剩下的可以取的最多的数字
                    //所以dp[i - zero][j - one]+1就表示在取了当前字符串的情况下最多可以拼成多少个字符串
                    dp[j][k] = Math.max(dp[j][k], dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}
