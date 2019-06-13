package com.leetcode.dynamic;

/**
 * @Auther: Administrator
 * @Date: 2019-06-10 16:11
 * @Description:
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
//        int[][] grid = new  int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = new  int[][]{{0,0,0,0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int res = visitLand(i, j, grid, isVisited);
                if(res > max)
                    max = res;
            }
        }
        return max;
    }

    private static int visitLand(int x, int y, int[][] grid, boolean[][] isVisited) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length  || grid[x][y]==0 || isVisited[x][y])
            return 0;
        isVisited[x][y] = true;
        //遍历四个方向
        int area = 1;
        //上方
        area += visitLand(x-1, y, grid, isVisited);
        //下
        area += visitLand(x+1, y, grid, isVisited);
        //左
        area += visitLand(x, y-1, grid, isVisited);
        //右
        area += visitLand(x, y+1, grid, isVisited);
        return area;
    }

}
