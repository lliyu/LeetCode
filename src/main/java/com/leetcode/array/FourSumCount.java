package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 454 四数相加
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 示例 1：
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 *
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 */
public class FourSumCount {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(10, (float) 0.8);
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        hashMap.put(5, 1);
        hashMap.put(6, 1);
        hashMap.put(7, 1);
        hashMap.put(8, 1);
        hashMap.put(9, 1);
        hashMap.put(10, 1);
        hashMap.put(11, 1);
        hashMap.put(12, 1);
        hashMap.put(13, 1);
        hashMap.put(14, 1);
        hashMap.put(15, 1);
        hashMap.put(16, 1);
    }

    //对于这种的参数较多的场景
    //可以将不同的参数组合 只要保证最后的结果没问题即可
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num1 :nums1) {
            for (int num2 :nums2) {
                int num = num1 + num2;
                if(countMap.containsKey(num)){
                    countMap.put(num, countMap.get(num)+1);
                }else {
                    countMap.put(num, 1);
                }
            }
        }

        for (int num1 :nums3) {
            for (int num2 :nums4) {
                int num = - (num1 + num2);
                if(countMap.containsKey(num)){
                    count += countMap.get(num);
                }
            }
        }

        return count;
    }

}
