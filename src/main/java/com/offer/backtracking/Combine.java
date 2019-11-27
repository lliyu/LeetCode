package com.offer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {

    private static List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrace(n, k, 0, "");
        return lists;
    }

    private void backtrace(int n, int k, int index, String nums){
        if(nums.length() == k){
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < nums.length(); i++) {
                integers.add(Integer.valueOf(nums.charAt(i) - '0'));
            }
            lists.add(integers);
        }else {
            for (int i = index; i < n; i++) {
                backtrace(n, k, i+1, nums + (i+1));
            }
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(1,1);
        System.out.println(lists);
    }

}
