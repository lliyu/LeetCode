package com.leetcode.array;

/**
 * �ƶ���
 ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

 ʾ��:

 ����: [0,1,0,3,12]
 ���: [1,3,12,0,0]
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
