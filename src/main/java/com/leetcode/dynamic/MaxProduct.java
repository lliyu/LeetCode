package com.leetcode.dynamic;

public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct product = new MaxProduct();
        System.out.println(product.maxProduct(new  int[]{2,3,-2,4}));
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            max = max>temp?max:temp;
            for(int j=i+1;j<nums.length;j++){
                temp = temp * nums[j];
                max = max>temp?max:temp;
            }
        }

        return max;
    }
}
