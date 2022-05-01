package com.leetcode.array;

import java.util.Arrays;

public class CanPartition {

    public static void main(String[] args) {
        CanPartition partition = new CanPartition();
        partition.canPartition(new int[]{14,9,8,4,3,2});
    }


    public boolean canPartition(int[] nums) {

        if(nums.length == 0)
            return true;
        if(nums.length == 1)
            return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;
        sum = sum/2;

        //找出数组中是否有组合的和为sum即可
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                if(count == sum)
                    return true;
                if(count>sum)
                    break;
            }
            count = 0;
        }

        return false;
    }
}
