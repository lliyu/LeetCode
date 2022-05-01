package com.newcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * input:
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 *
 * output:
 * [1,2,3]
 * [6,9,8]
 * [7,4,5]
 */
public class SpiralOrder {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        boolean[][] isVisit = new boolean[x][y];

        int level1 = 0;
        int level2 = 0;
        List<Integer> nums = new ArrayList<>();
        while (!isVisit[level1][level2]){
            //从左到右
            for (int i = 0; 0 < y-level2; i++) {
                nums.add(matrix[i][level2]);
            }
            level2++;
            //从上到下
            for (int i=0; i < x; i++) {
                nums.add(matrix[level1][i]);
            }
            //从右到左
            for (int i=y-1; i>=0; i--) {
                nums.add(matrix[level1][level2]);
            }
        }

        return null;
    }
}
