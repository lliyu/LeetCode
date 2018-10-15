package com.leetcode.array;

/**
 * 移动零
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums =new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for(int num:nums){
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int loc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[loc++] = nums[i];
            }
        }

        for(int j=loc;j<nums.length;j++){
            nums[j] = 0;
        }
    }
}
