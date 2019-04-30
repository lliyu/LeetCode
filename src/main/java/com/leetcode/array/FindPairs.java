package com.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-04-29 16:50
 * @Description:
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 * 示例 1:
 *
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 *
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 *
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 */
public class FindPairs {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0,result;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length;j++){
                result = nums[j]-nums[i];
                if(result == k){
                    count++;
                    break;
                }
                else if(result>k)
                    break;
            }
        }
        return count;
    }

}
