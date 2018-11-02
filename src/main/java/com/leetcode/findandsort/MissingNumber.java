package com.leetcode.findandsort;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }

    //n * (n + 1)/2为等差数列公式  算出0-n的和
    //用算出的值减去实际的总和即为不存在的数
    public static int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int a : nums) {
            sum += a;
        }
        return n * (n + 1)/2 - sum;
    }
}
