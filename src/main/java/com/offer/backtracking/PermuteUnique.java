package com.offer.backtracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique unique = new PermuteUnique();
        List<List<Integer>> lists = unique.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);

    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>(nums.length);
        boolean[] isVisit = new boolean[nums.length];

        backtrace(nums, integers, lists, isVisit);
        return lists;
    }

    /**
     * 全排列问题都可以用回溯的模版解决
     * 区别在于如果有额外的条件 需要根据这些条件添加相应的过滤结果的代码
     * @param nums
     * @param path
     * @param lists
     * @param isVisit
     */
    public void backtrace(int[] nums, List<Integer> path, List<List<Integer>> lists, boolean[] isVisit){

        if(path.size() == nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }


        for(int i=0;i<nums.length;i++){
            /**
             * (i>0 && nums[i-1]==nums[i] && isVisit[i-1])用于保证之前已经访问过的再次遍历到相同的数字后直接跳过
             * 上面的i>0会跳过每次进入循环时的判断 所以需要加上单独的isVisit[i]来判断第一个数字是否被访问过来
             */
            if(isVisit[i] || (i>0 && nums[i-1]==nums[i] && isVisit[i-1]))
                continue;
            isVisit[i] = true;
            path.add(nums[i]);
            backtrace(nums, path, lists, isVisit);
            path.remove(path.size()-1);
            isVisit[i] = false;
        }

    }

}
