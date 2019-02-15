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
        int[] nums =new int[]{2,3,4,5,3,2,6,4};
        System.out.println();
        findOnlyShow1Sec(nums);
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


    //------------------------------------------------------------------------------------
    /**
     * 给定一个非空整数数组，除了两个个元素只出现一次以外，其余每个元素均出现两次。找出只出现了一次的两个元素。
     */

    public static void findOnlyShow1Sec(int[] nums){
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }
        //先对所有的数进行异或
        int res = 0;
        for(int n:nums){
            res ^= n;
        }

        //异或的结果一定是不为0的数，并且这个数字上某一位不为0表示两个只出现一次的数字在该位不同
        // 5 --> 101
        // 6 --> 110
        //res--> 011
        //res=11(2)的结果表示两个只出现一次的数字的第一位和第二位是不同的
        //任意选取一位(最好是低位)，遍历所有的数字，将该位为0和1 的数字分为两组，两个只出现一次的数字就分到两个数组中了
        // 然后分别异或

        //查找第一个不为0的位置
        int index = 0;
        while((res!=0)&&(res&1)==0){
            index++;
            res >>= 1;
        }

        //将结果还原为原来的位置 区分两组数
        res = 1<<index;
        //保证空间复杂度为O(1) 直接用连个数字保存相与结果
        int first=0,second=0;

        for(int n:nums){
            if((res&n)==res){
                first^=n;
            }else {
                second^=n;
            }
        }

        System.out.println(first+","+second);

    }

}
