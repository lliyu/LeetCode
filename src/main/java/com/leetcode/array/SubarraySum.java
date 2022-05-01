package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumMap = new HashMap<>();

        int rnt = 0;
        int sum = 0;
        sumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sumMap.containsKey(sum-k))
                rnt += sumMap.get(sum-k);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);//统计sum在计算过程中出现的次数
        }

        return rnt;
    }

    public static int sum(int[] nums, int target, int index, int count){
        if(target == 0)count++;
        if(index==nums.length)return count;
        return sum(nums, target-nums[index], index+1, count);
    }
}
