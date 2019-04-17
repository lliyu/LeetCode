package com.leetcode.dynamic;

import java.math.BigDecimal;

/**
 * @Auther: Administrator
 * @Date: 2019-04-17 09:45
 * @Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
//        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] arr = {{0,1}};
        System.out.println(uniquePathsWithObstacles(arr));
    }

    //递归求解 LeetCode超时
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        //count表示有多少条路径
        int count = 0;
        count = uniquePath(obstacleGrid, 0, 0, count);
        return count;
    }

    private static int uniquePath(int[][] obstacleGrid, int m, int n, int count) {
        if(m>=obstacleGrid.length || n>=obstacleGrid[0].length || obstacleGrid[m][n]==1)
            //走不通了
            return count;
        if(m==obstacleGrid.length-1 && n==obstacleGrid[0].length-1)
            return ++count;
        //向下查找
        count = uniquePath(obstacleGrid, m+1, n, count);
        //向右查找
        count = uniquePath(obstacleGrid, m, n+1, count);
        //如果递归结果需要返回就使用返回值接收递归函数
        //最后直接返回即可
        return count;
    }

    //dp
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j]表示从左上角走到第i行第i列的路径数
        //状态转移方程为dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[m][n];
        for(int i=0;i<obstacleGrid.length;i++){
            for (int j=0;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if(i==0&&j==0){
                    dp[i][j] = 1;
                }else {
                    if(i>0)
                        dp[i][j] += dp[i-1][j];
                    if(j>0)
                        dp[i][j] += dp[i][j-1];;
                }
            }
        }
        return dp[m-1][n-1];
    }

}
