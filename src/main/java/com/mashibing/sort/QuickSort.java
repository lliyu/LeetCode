package com.mashibing.sort;


/**
 * 给定一个数组arr和一个数num，要求将数组中小于等于num的放左边，大于num的放右边
 * 时间复杂度为O(N),空间复杂度为O(1)
 */
public class QuickSort {


    public static void main(String[] args) {
//        seqment(new int[]{3,4,6,7,1}, 5);
        sort(new int[]{3,4,6,7,1}, 5);
    }

    /**
     * 给定一个数组arr和一个数num，要求将数组中小于等于num的放左边，大于num的放右边
     * 时间复杂度为O(N),空间复杂度为O(1)
     */
    public static void seqment(int[] arr, int num){
        int index = -1;//用于表示当前数组中经过交换后小雨num的数组最后一个数的位置，默认为-1
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num){
                //小于等于num 默认位置加1 并且将该数和i+1位置的数交换
                swap(arr, index++, i);
            }
        }
    }

    /**
     * 荷兰国旗问题
     * 给定一个数组arr和一个数num，要求将数组中小于num的放左边，等于num的放中间，大于num的放右边
     * 时间复杂度为O(N),空间复杂度为O(1)
     *
     * 不通与上面的是多了一个等于num的位置的要求，因为对于上面的来说num的位置其实并不去定,比如[5,4,6,3,7]和5 ==> [5,4,3,6,7]
     *
     * 基本思路就是将数组划分为大于和小于target的两部分 初始情况下小于部分从-1开始 大于部分从arr.length开始
     * @param arr
     * @param num
     */
    public void netherlandsFlags(int[] arr, int num){
        int left = -1;//用于表示当前数组中经过交换后小于num的数组最后一个数的位置，默认为-1
        int right = arr.length;//划分的大于num的区域
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < num){
                //小于等于num 默认位置加1 并且将该数和i+1位置的数交换
                swap(arr, left++, i);
            }else if(arr[i] > num){
                swap(arr, right--, i);
            }else {
                // ==num 这里不用进行交换 保持不动就可以了
                left++;
            }
        }
    }

    private static void swap(int[] arr, int left, int i) {
        int temp;
        temp = arr[left + 1];
        arr[left + 1] = arr[i];
        arr[i] = temp;
    }

    public static void sort(int[] nums, int target){
        if(nums== null || nums.length==0)
            return;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                index++;
            }else if(nums[i]<target) {
                swap(nums, i, index+1);
                index++;
            }
        }
        System.out.println(nums);
    }


}
