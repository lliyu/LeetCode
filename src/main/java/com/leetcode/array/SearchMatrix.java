package com.leetcode.array;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,5,9,9,9,11},
                {5,8,13,13,16,17},
                {10,10,14,14,16,19},
                {15,18,20,24,26,26},
                {20,24,29,32,37,41}};
//        int[][] matrix = new int[][]{{1},{2},{3},{4},{5}};
        //[[3,5,9,9,9,11],[5,8,13,13,16,17],[10,10,14,14,16,19],[15,18,20,24,26,26],[20,24,29,32,37,41]]
        //32
        System.out.println(searchMatrix(matrix, 2));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length-1;
        while(x<matrix.length && y>=0){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) y--;
            else x++;
        }
        return false;
    }
}
