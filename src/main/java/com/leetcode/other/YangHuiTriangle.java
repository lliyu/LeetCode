package com.leetcode.other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class YangHuiTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> box = new ArrayList<List<Integer>>();
        if(numRows <= 0)return box;
        box.add(Arrays.asList(1));
        if(numRows == 1){
            return box;
        }
        box.add(Arrays.asList(1,1));
        if(numRows == 2){
            return box;
        }
        for(int i=3;i<=numRows;i++){
            int[] data = new int[i];
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            for(int j=1;j<i-1;j++){
                temp.add(box.get(i-2).get(j-1)+box.get(i-2).get(j));
            }
            temp.add(1);
            box.add(temp);
        }
        return box;
    }
}
