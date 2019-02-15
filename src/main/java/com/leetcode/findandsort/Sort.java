package com.leetcode.findandsort;

/**
 * @Auther: Administrator
 * @Date: 2018-11-08 14:36
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums =new int[]{0,4,1,2,3,87,9,2,1,5,7,8,6,4,3};
        shellSort(nums);
        for (int i:nums) {
            System.out.print(i + " ");
        }
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //一趟之后最小的数到了下标为i的位置
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            int temp = nums[i];
            //将元素后移
            for(j=i-1;j>=0&&temp<nums[j];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }

    //带哨兵的插入排序
    public static void insertWithSentinelSort(int[] nums){
        int i,j;
        for(i=1;i<nums.length;i++){
            //将第一个元素指定为哨兵
            //要求传入的数组比原数组长度大1
            nums[0] = nums[i];
            //将元素后移
            for(j=i-1;nums[j]>nums[0];j--){
                nums[j+1] = nums[j];
            }
            nums[j+1] = nums[0];
        }
    }

    //希尔排序
    public static void shellSort(int[] nums){
        int size = nums.length/2;
        int i,j;
        while(size>=1){
            for(i=0;i<nums.length;i++){
                for(j=i;j+size<nums.length;j+=size){
                    if(nums[j]>nums[j+size]){
                        swap(nums, j, j+size);
                    }
                }
            }
            size/=2;
        }
    }



    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }


    //交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
