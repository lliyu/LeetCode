package com.offer.sort;

/**
 * @Auther: Administrator
 * @Date: 2019-01-11 15:34
 * @Description:
 */
public class FindMinByBinary {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,1};
        System.out.println(find(nums, 0, nums.length-1));
    }

    //只能应对递增的数组 如果允许数字重复 就必须要进行顺序遍历 1,1,1,0,1
    public static int find(int[] nums,int left, int right){
        int middle = 0;
        while (left<right){
            middle = (left + right)/2;
            if(middle == left){
                return nums[right];
            }
            if(nums[left] >= nums[middle]){
                right = middle;
            }else if(nums[left] <= nums[middle]){

                left = middle;
            }
        }

        return nums[middle];
    }
}
