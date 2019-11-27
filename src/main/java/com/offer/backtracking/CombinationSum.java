package com.offer.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    private static List<List<Integer>> lists = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //leetcode中测试用例应该是在一个主函数中提交所有的用例
        //这样就会导致一个共享变量会存储所有的结果 使得后一个用例的结果包含了前一个用例的结果
        // 判定时就会判定解答错误 所以这里每一次重新初始化 保证每次拿到的都是一个完全新的变量
        lists = new ArrayList<>();
        int len = (int) Math.ceil(target*1.0/candidates[0]);
        int[] temp = new int[len];
        backtrace(candidates, target, 0, temp, 0, 0);
        return lists;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param sum
     * @param temp
     * @param index index用来保存temp记录到具体哪一个位置了 在取结果时根据index的大小从temp数组中取
     * @param k k用来记录迭代循环时从哪一个位置开始  保证不会重复取前面的数
     */
    private void backtrace(int[] candidates, int target, int sum, int[] temp, int index, int k) {
        if (target<sum){
            return;
        }else if(target == sum){
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                integers.add(temp[i]);
            }
            lists.add(integers);
        }else {
            //每个数都可能重复 所以这里不能用index 使用一个新的变量保证当前数可以重复取 但是如果索引到了后面 就不能再取前面的数了 这样将会导致重复
            for (int i = k; i < candidates.length; i++) {
                temp[index] = candidates[i];
                //因为可以重复取当前数 所以这里传递i 而不是i+1
                backtrace(candidates, target, sum + candidates[i], temp, index+1, i);
                temp[index] = 0;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(lists);
        combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(lists);
    }
}
