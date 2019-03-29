package com.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-03-27 14:54
 * @Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    //暴力解法 时间复杂度过高
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();
        //对数据进行排序
        Arrays.sort(nums);
        List<Integer> existNum = new ArrayList<>();
        List<String> order = new ArrayList<>();
        int temp;
        for(int i=0;i<nums.length-2;i++){
            temp = nums[i];
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(temp + nums[j] + nums[k] == 0){
                        if(order.contains("" + temp + nums[j] + nums[k])){
                            continue;
                        }
                        threeSums.add(Arrays.asList(temp, nums[j], nums[k]));
                        order.add("" + temp + nums[j] + nums[k]);
                    }
                }
            }
            existNum.add(temp);
        }
        return threeSums;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();
        //对数据进行排序
        Arrays.sort(nums);
        List<String> order = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j=i+1,k=nums.length-1;
            while (j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    if(order.contains("" + nums[i] + nums[j] + nums[k])){
                        j++;k--;
                        continue;
                    }
                    threeSums.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    order.add("" + nums[i] + nums[j] + nums[k]);
                    j++;k--;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    //表示正值过大
                    k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    //表示负值过小
                    j++;
                }
            }
        }
        return threeSums;
    }
}
