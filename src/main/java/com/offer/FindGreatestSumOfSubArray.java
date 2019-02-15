package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-29 17:35
 * @Description:连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        System.out.println(findMaxSumNumInSubarray(new int[]{6, -4, -2, 5, -15, 1, 2, 2}));
    }

    public static int findMaxSumNumInSubarray(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = 0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum<=0){
                //表示加了一个负数
                sum = 0;
            }else if(sum>max) {
                max = sum;
            }
        }

        return max;
    }
}
