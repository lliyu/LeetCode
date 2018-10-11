package com.leetcode.array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 0};
        int[] nums2 = new int[]{2};
        merge(nums1, 1, nums2, 1);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //o(n)的时间复杂度
        int[] num = new int[m + n];
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; ) {
            if (nums1[i] > nums2[j]) {
                num[k++] = nums2[j++];
            } else {
                num[k++] = nums1[i++];
            }
        }
        if (i < m) {
            for (; i < m; i++) {
                num[k++] = nums1[i];
            }
        }
        if (j < n) {
            for (; j < n; j++) {
                num[k++] = nums2[j];
            }
        }

        for (i = 0; i < num.length; i++) {
            nums1[i] = num[i];
        }

    }

}
