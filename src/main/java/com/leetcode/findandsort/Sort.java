package com.leetcode.findandsort;

/**
 * @Auther: Administrator
 * @Date: 2018-11-08 14:36
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums =new int[]{4,1,2,3,87,9,2,1,5,7,8,6,4,3};
        bubbleSort(nums);
        for (int i:nums) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
