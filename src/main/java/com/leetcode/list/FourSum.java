package com.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
//        FourSum sum = new FourSum();
//        //[1,-2,-5,-4,-3,3,3,5]
//        //-11
//        List<List<Integer>> lists = sum.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
//        lists.stream().forEach(item -> {
//            item.stream().forEach(System.out::print);
//            System.out.println();
//        });
        char[] s = new char[]{'1','2','3','4'};

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        List<String> strings = new ArrayList<>();
        for(int i=0;i<length-3;i++){
            sum += nums[i];
            for(int j=i+1;j<length-2;j++){
                sum += nums[j];
                for(int k=j+1;k<length-1;k++){
                    sum += nums[k];
                    for(int l=k+1;l<length;l++){
                        sum += nums[l];
                        if(sum == target && !strings.contains("" + nums[i] + nums[j] + nums[k] + nums[l])){
                            strings.add("" + nums[i] + nums[j] + nums[k] + nums[l]);
                            List<Integer> integers = new ArrayList<>();
                            integers.add(nums[i]);
                            integers.add(nums[j]);
                            integers.add(nums[k]);
                            integers.add(nums[l]);
                            lists.add(integers);
                        }
                        sum -= nums[l];
                    }
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
            sum -= nums[i];
        }
        return lists;
    }
}
