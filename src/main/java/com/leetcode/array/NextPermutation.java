package com.leetcode.array;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{4,3,2,1});
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length-1);// 此时leftIndex～rightIndex一定是降序的
    }

    private void reverse(int[] nums, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex){
            swap(nums, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    private void swap(int[] nums, int leftIndex, int rightIndex) {
        int temp = nums[rightIndex];
        nums[rightIndex] = nums[leftIndex];
        nums[leftIndex] = temp;
    }
}
