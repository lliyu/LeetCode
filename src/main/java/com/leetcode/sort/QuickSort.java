package com.leetcode.sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.sortArray(new int[]{-1,2,-8,-10});


//        for (int i = 0; i < 10; i++) {
//            int left = new Random().nextInt(100);
//            int right = new Random().nextInt(100);
//            System.out.println("(left+right)/2     =" + (left+right)/2 );
//            System.out.println("right-(right-left)/2=" + (left + (right-left)/2));
//        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if(right<=left) return;
        int mid = partation(nums, left, right);
        quickSort(nums, left, mid-1);
        quickSort(nums, mid+1, right);
    }

    public int partation(int[] nums, int left, int right){

        int index = left;
        int mid = nums[index];
        while(left < right) {
            while(left<right && nums[right]>mid) right--;
            while(left<right && nums[left]<=mid) left++;
            swap(nums, left, right);
        }
        swap(nums, index, left);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
        System.out.println();
        return left;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
