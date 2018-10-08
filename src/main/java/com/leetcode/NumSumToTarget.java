package com.leetcode;

import java.util.*;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class NumSumToTarget {
    public static void main(String[] args) throws Exception {
        int[] rows = new int[]{3,2,4};
        int[] data = twoSum(rows,6);
        for (int row:data) {
            System.out.println(row);
        }
    }

    public static int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for (int num:nums) {
            map.put(num,i);
            i++;
        }

        for(int j=0; j<nums.length;j++){
            int source = target - nums[j];
            if(map.containsKey(source) && map.get(source)!=j){
                return new int[]{j,map.get(source)};
            }
        }

        throw new Exception("not");
    }
}
