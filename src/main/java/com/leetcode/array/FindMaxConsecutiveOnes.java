package com.leetcode.array;

/**
 * @Auther: Administrator
 * @Date: 2019-03-22 16:57
 * @Description:
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums =new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    //O(n)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,len = 0;
        for(int num:nums){
            if(num==1){
                len++;
            }else {
                if(max<len){
                    max = len;
                }
                len=0;
            }
        }
        return max>len?max:len;
    }

}
