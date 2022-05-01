package com.leetcode.dynamic;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    /**
     * 当 2 \le i \le n2≤i≤n 时，可以从下标 i-1i−1 使用 \textit{cost}[i-1]cost[i−1] 的花费达到下标 ii，
     * 或者从下标 i-2i−2 使用 \textit{cost}[i-2]cost[i−2] 的花费达到下标 ii。
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {

        boolean[] isVisited = new boolean[cost.length+1];

        int[] dp = new int[cost.length+1]; //dp[i]表示跨过第i层需要的体力
        dp[0] = 0;
        dp[1] = cost[0];
        dp[2] = cost[1];
        for(int i=3;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-2] + cost[i-1], dp[i-1]);
        }
        return dp[cost.length];
    }
}
