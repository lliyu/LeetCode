package com.leetcode;

import java.util.Random;

/**
 * Shuffle an Array
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class Shuffle {

    private int[] orgn;
    private int[] nums;

    public Shuffle(int[] nums) {
        orgn = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orgn;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = orgn.length;
        nums = new int[len];
        for(int i=0;i<len;i++)
            nums[i] = orgn[i];
        int pos;//记录要交换元素的位置
        int temp; //记录要交换的值
        Random ran = new Random();
        for(int i=len-1;i>=0;i--){
            pos = ran.nextInt(i+1);
            temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }
        return nums;

    }
}
