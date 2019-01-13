package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-11 17:50
 * @Description:
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class RobotMovingCount {

    public static void main(String[] args) {
        System.out.println(movingCount(4, 4, 4));
    }

    public static int movingCount(int m, int n, int k){

        if(m<0 || n<0 || k<0)
            return 0;

        int count = 0;

        boolean[][] visited = new boolean[m][n];

        return caclulateCount(m, n, visited, count, 0, 0, k);
    }

    private static int caclulateCount(int m, int n, boolean[][] visited, int count, int row, int col, int k) {
        //越界判断
        if(row<0 || col<0 || row>=m || col>=n ||visited[row][col])
            return count;

        //是否可以前进
        if(isCount(k, row, col)){
            count++;
        }

        //后面不在计数
        visited[row][col] = true;

        //是否已经遍历完成
//        if(isRetrun(visited)){
//            finish = true;
//            return count;
//        }
        //向下
        count = caclulateCount(m, n, visited, count, row+1, col, k);

        count = caclulateCount(m, n, visited, count, row, col+1, k);

        count = caclulateCount(m, n, visited, count, row-1, col, k);

        count = caclulateCount(m, n, visited, count, row, col-1, k);

        return count;
    }

    private static boolean isRetrun(boolean[][] visited) {
        for(int i=0;i<visited.length;i++)
            for(int j=0;j<visited[0].length;j++)
                if(!visited[i][j])
                    return false;
        return true;
    }

    private static boolean isCount(int k, int row, int col) {
        int num = 0;
        while(row!=0){
            num+=row%10;
            row/=10;
        }
        while(col!=0){
            num+=col%10;
            col/=10;
        }
        return k>=num;
    }
}
