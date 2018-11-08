package com.leetcode.array;

/**
 * @Auther: Administrator
 * @Date: 2018-11-06 14:15
 * @Description:
 * 两个排序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 =new int[]{-2,-1};
        int[] nums2 =new int[]{3};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }


    //O(n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;

        boolean isOdd = false;
        if((len1+len2)%2 != 0)
            isOdd = true;
        int[] arr = new int[len1+len2];
        int k=0;
        int i=0,j=0;
        for(;i<len1&&j<len2;){
            if(nums1[i]<nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }

        if(i<len1){
            for(;i<len1;i++){
                arr[k++] = nums1[i];
            }
        }

        if(j<len2){
            for(;j<len2;j++){
                arr[k++] = nums2[j];
            }
        }

        double res = 0;
        if(isOdd){
            res = arr[(len1+len2)/2];
        }else{
            res = (arr[(len1+len2)/2]+arr[(len1+len2)/2-1])*1.0/2;
        }

        return res;
    }
}
