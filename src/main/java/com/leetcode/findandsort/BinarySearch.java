package com.leetcode.findandsort;

/**
 * @Auther: Administrator
 * @Date: 2018-11-12 09:08
 * @Description: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        System.out.println(search(arr,-2));
    }


    public static int search(int[] nums, int target) {

        int left = 0,right = nums.length-1,mid;
        while(left<=right){
            mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                right = mid-1;
            }
            if(nums[mid] < target){
                left = mid+1;
            }
        }
        return -1;
    }
}
