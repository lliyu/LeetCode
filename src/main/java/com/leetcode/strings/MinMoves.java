package com.leetcode.strings;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-04-26 15:16
 * @Description:
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * 示例:
 * 输入:
 * [1,2,3]
 * 输出:
 * 3
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinMoves {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,2,3}));
    }

    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for(int i=1;i<len;i++){
            count += nums[i] - nums[0];
        }
        return count;
    }

}
