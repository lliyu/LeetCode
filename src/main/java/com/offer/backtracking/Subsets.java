package com.offer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    private static List<List<Integer>> lists = null;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            int[] temp = new int[i];
            backtrace(nums, 0, temp, 0);
        }
        return lists;
    }

    /**
     * k如果我们需要对递归的值进行剪纸
     * 引入一个新的变量 根据不同的条件取值
     * @param nums
     * @param index
     * @param temp
     * @param k
     */
    public void backtrace(int[] nums, int index, int[] temp, int k){
        if(index == temp.length){
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                integers.add(temp[i]);
            }
            lists.add(integers);
        }else {
            for (int i = k; i < nums.length; i++) {
                temp[index] = nums[i];
                backtrace(nums, index+1, temp, i+1);
                temp[index] = 0;
            }
        }

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1,2,3});
        System.out.println(lists);
    }
}
