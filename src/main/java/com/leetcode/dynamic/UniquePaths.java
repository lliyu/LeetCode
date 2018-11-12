package com.leetcode.dynamic;

/**
 * @author ly
 * @create 2018-11-10 17:35
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 **/
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    //递归方式  超出时间限制
    public static int uniquePaths1(int m, int n) {
        if(m<=1 && n<=1)
            return 1;
        if(m<=1 && n>1)
            return uniquePaths(m,n-1);
        if(m>1 && n<=1)
            return uniquePaths(m-1,n);
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }

    //递归转化为循环方式
    //使用额外的空间来记录每一步可能的次数
    public static int uniquePaths2(int m, int n) {
        int[][] map = new int[m][n];

        for(int i=0;i<m;i++){
            map[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            map[0][i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    //查看解题榜单是看到的解答方法 很有意思
    public static int uniquePaths(int m,int n){
        int total = m + n -2; //一共要走的步数
        int down = m - 1;  //向下要走的步数
        int res = 1;
        for(int i = 1 ; i <= down; i++){
            res =res * (total - down + i) / i;
        }
        return res;
    }

}
