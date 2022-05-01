package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = spiralOrder(nums);
        System.out.println(integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int t=0, b = matrix.length-1;
        int l = 0, r = matrix[0].length-1;

        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(t<=b && l<=r){
            //向右
            i = t; j = l;
            while(j<=r){
                if (isVisited[i][j]) break;
                isVisited[i][j] = true;
                res.add(matrix[i][j++]);
            }
            j--; t++;

            //向下
            i++;
            while(i<=b){
                if (isVisited[i][j]) break;
                isVisited[i][j] = true;
                res.add(matrix[i++][j]);
            }
            i--;r--;

            //向左
            j--;
            while(j>=l){
                if (isVisited[i][j]) break;
                isVisited[i][j] = true;
                res.add(matrix[i][j--]);
            }
            j++;b--;

            //向上
            i--;
            while(i>=t){
                if (isVisited[i][j]) break;
                isVisited[i][j] = true;
                res.add(matrix[i--][j]);
            }
            i++;l++;
        }
        return res;
    }
}
