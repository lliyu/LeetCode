package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class Trap {


    /**
     * 双指针 时间复杂度O(N) 空间复杂度O(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {
//        Arrays.sort();
        return 0;
    }

    /**
     * 动态规划 时间复杂度O(N) 空间复杂度O(N)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        // 每一个位置能够存储的雨水量
        // 应该是该位置左右两边高度最大值的最小值减去当前位置的高度 就可以计算出当前位置可以接多少雨水
        // 然后计算出每一个位置的雨水 求和就是最终结果
        int len = height.length;
        if(len == 0) return 0;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for(int i=1; i<len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        //计算每个位置能够接的雨水量
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
