package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-04-19 13:54
 * @Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = {1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(arr, 82));
    }

    //暴力解法
    public static int threeSumClosest1(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target) < Math.abs(sum-target))
                        sum = nums[i]+nums[j]+nums[k];
                }
            }
        }
        return sum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        //排序是必须的 后面是根据大小移动下标
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int len = nums.length-1;
        int low = 0,high = 0;
        for(int i=0;i<nums.length-2;i++){
            low = i+1;high = len;
            for(;low<high;){
                if(Math.abs(nums[i]+nums[low]+nums[high]-target) < Math.abs(sum-target))
                    sum = nums[i]+nums[low]+nums[high];
                if(nums[i]+nums[low]+nums[high] == target)
                    return sum;
                else if(nums[i]+nums[low]+nums[high]>target)
                    high--;
                else
                    low++;
            }
        }
        return sum;
    }
}
