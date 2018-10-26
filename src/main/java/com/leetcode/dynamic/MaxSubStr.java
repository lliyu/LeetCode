package com.leetcode.dynamic;

/**
 *  最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubStr {

    public static void main(String[] args) {
        int[] nums =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }


    //暴力解法 LeetCode会超时
    public static int maxSubArray1(int[] nums) {
        int count = 0;
        for(int i=1;i<=nums.length;i++){
            count+=i;
        }
        int[] data = new int[count];
        int sum=0,k=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                for(int n=i;n<=j;n++){
                    sum += nums[n];
                }
                data[k++] = sum;
                sum=0;
            }
        }
        int max = data[0];
        for(int i=1;i<data.length;i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

    //暴力求解  少一层循环 能通过LeetCode
    public static int maxSubArray2(int[] nums) {
        int sum = 0,max = nums[0];
        for(int i=0;i<nums.length;i++){
            sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum > max)
                    max = sum;
            }

        }
        return max;
    }

    //O(n)的解法
    public static int maxSubArray(int[] nums) {
        int sum = nums[0],num = nums[0];//-2,1,-3,4,-1,2,1,-5,4}
        for(int i=1;i<nums.length;i++){
            if(num > 0){
                num += nums[i];
            }else {
                num = nums[i];
            }
            if(sum < num)
                sum = num;
        }
        return sum;
    }
}
