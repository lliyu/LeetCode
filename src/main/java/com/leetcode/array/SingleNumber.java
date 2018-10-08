package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums =new int[]{};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(map.get(num) == null){
                map.put(num,1);
            }else{
                map.put(num,2);
            }
        }

        for(int num:nums){
            if(map.get(num)==1){
                return num;
            }
        }
        return 0;
    }

    public static int singleNumber2(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            //异或操作：一个数字对两个相同的数字进行异或结果还是原值
            //a^b^b=a
            temp^=nums[i];
        }
        return temp;
    }


}
