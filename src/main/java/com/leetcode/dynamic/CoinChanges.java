package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class CoinChanges {

    public static void main(String[] args) {
        CoinChanges coinChanges = new CoinChanges();
        coinChanges.coinChange(new int[]{1,2,5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // dp[i]表示凑齐i需要的最少硬币数
        Arrays.fill(dp, amount+1);
        Arrays.sort(coins);
        dp[0] = 0;
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<coins.length; j++) {
                if (i>=coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

}
