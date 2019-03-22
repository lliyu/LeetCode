package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-03-20 14:44
 * @Description:
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] nums =new int[]{8, 2, 6, 4, 8, 10, 9, 15};
        int res = findMaxOfK(nums, 1, nums.length-1, 1);
        System.out.println(res);
//        int len = findUnsortedSubarray(nums);
//        System.out.println(len);
    }

    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length<=1)
            return 0;
        int len = nums.length;
        int[] res = Arrays.copyOf(nums, nums.length);
        //从左边开始比较
        int min = -999999999;
        int i = 0;
        for(i=0;i<nums.length;i++){
            min = findMaxOfK(res, i, res.length-1, i);
            if(min==nums[i]){
                len--;
            }else {
                break;
            }
        }
        //从右边开始比
        int max = -999999999;
        int size = nums.length - i - 1;
        for(i=nums.length-1;i>0&&size>0;i--,size--){
            max = findMaxOfK(res, 0, i, i);
            if(max==nums[i]){
                len--;
            }else {
                break;
            }
        }
        return len;
    }

    public static int findMaxOfK(int[] nums, int low, int high, int k){
        int piv = nums[low];
        int left=low,right=high;
        while(left<right){
            while (left<right&&nums[right]>=piv) {
                right--;
            }
            nums[left] = nums[right];
            while(left<right&&nums[left]<piv){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = piv;
        if(left>k) return findMaxOfK(nums, 0, left-1, k);
        if(left<k) return findMaxOfK(nums, left+1, k, k);
        return nums[left];
    }

    public static int findUnsortedSubarray1(int[] nums) {
        int[] numsClone = nums.clone();

        Arrays.sort(numsClone);

        int left = 0, right = nums.length - 1;

        while (left <= right && nums[left] == numsClone[left]) left++;
        while (left <= right && nums[right] == numsClone[right]) right--;

        return right - left + 1;
    }
}

