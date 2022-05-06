package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

    /**
     * 这一类的求子集或者全排列的题目 有这统一的解题套路
     * 主要思路就是通过回溯
     * 如果是求子序列 那么backtrace的for循环i=index
     * 如果是求全排列，那么每一次for循环的i都应该从0开始
     * 并且回溯过程中需要改变元素的为止 swap
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrace(lists, nums, 0, path);
        return lists;
    }

    public void backtrace(List<List<Integer>> lists, int[] nums, int index, List<Integer> path) {
        if(index > nums.length) return;
        lists.add(new ArrayList<Integer>(path));
        for(int i=index; i< nums.length; i++) {
            path.add(nums[i]);
            // 注意这里如果要求按原来的序列有序 那么这里index = i+1
            // 但是如果是求子元素的组合那么这里index = index+1
            backtrace(lists, nums, i+1, path);
            path.remove(path.size()-1);
        }
    }

}
