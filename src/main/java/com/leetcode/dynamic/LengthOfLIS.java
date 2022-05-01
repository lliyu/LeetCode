package com.leetcode.dynamic;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    /**
     * 求最值问题一般都是可以用动态规划来进行解决的
     * 动态规划首先就要想到自底向上 不能一上来久考虑题目最终怎么解
     * 然后开始划分子问题 以及定义好状态转移方程
     * 后续才开始考虑通过去掉重复的过程对解法进行优化
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];//dp[i]表示从0～i最大的递增序列长度 但需要注意nums[i] 必须被选取。 因为定值保证序列最大的是nums[i]所以dp[nums.length-1]并不一定是最大的
                                        //所以需要使用一个max变量来记录
        int max = 1;//记录最长子序列长度
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {//从第二个数开始
            dp[i] = 1;//开始时都只有一个元素 然后开始遍历
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    //表示nums[i]可以跟在nums[j]的后面 这里要注意我们不用考虑nums[j]之前是否和nums[i]匹配
                    //因为这个问题已经由之前的子问题保证来
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}
