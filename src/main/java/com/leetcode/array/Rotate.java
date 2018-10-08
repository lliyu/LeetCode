package com.leetcode.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums =new int[]{1,2,3,4,5,6,7};
        rotate(nums,10);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        //空间复杂度O(1)  时间复杂度O(n2)
        if(nums == null|| nums.length==0 || k <= 0){
            return;
        }
        int len = k % nums.length, temp=0;
        int length = nums.length-1;
        for(int i=0; i<len; i++){
            temp = nums[length];
            for(int j=length;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public void rotate1(int[] nums, int k) {
        //空间复杂度O(n)
        k = k % nums.length;
        if (k == 0)
            return;
        int leftLen = nums.length - k;
        int rightLen = k;
        int[] tmp = new int[leftLen];
        System.arraycopy(nums, 0, tmp, 0, leftLen);
        System.arraycopy(nums, nums.length - rightLen, nums, 0, rightLen);
        System.arraycopy(tmp, 0, nums, rightLen, leftLen);
    }
}
