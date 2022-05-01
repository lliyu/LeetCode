package com.leetcode.array;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    Set<List<Integer>> lists = new HashSet<>();

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        for(int i=0;i<candidates.length;i++){
            backtrace(candidates, target, candidates[i], i, new ArrayList<>(), ""+candidates[i]);
        }
        return new ArrayList<>(lists);
    }

    public void backtrace(int[] candidates, int target,int sum, int index, List<Integer> integers, String str){
        if(sum == target){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                list.add(str.charAt(i) - '0');
            }
            lists.add(list);
            return;
        }
        if(index==candidates.length)
            return;
        str = str + candidates[index];
        sum += candidates[index];
        if(sum > target)
            return;

        backtrace(candidates, target, sum, index+1, integers, str);
        backtrace(candidates, target, sum, index, integers, str);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        List<List<Integer>> lists = sum.combinationSum1(new int[]{2,3,6,7}, 7);
        System.out.println(lists);


//        char c = '1';
//        System.out.println(c - '0');

    }



}
