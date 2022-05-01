package com.offer.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class KthLargest {

    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }

    public int add(int val) {
        Arrays.sort(nums);
        nums = reverse(nums);
        int[] newNums = new int[nums.length+1];
        if(nums.length==0){
            newNums[0] = val;
            nums = newNums;
            return newNums[k-1];
        }
        if(val<=nums[0]){
            newNums[0] = val;
            System.arraycopy(nums, 0, newNums, 1, nums.length);
            return newNums[k-1];
        }
        for (int i = 0; i<nums.length; i++) {
            if(val>=nums[i]){
                newNums[i] = val;
                System.arraycopy(nums, i, newNums, i+1, nums.length-i);
                break;
            }
            newNums[i] = nums[i];
        }
        nums = newNums;
        return newNums[k-1];
    }

    public int[] reverse(int[] nums){
        int[] tmpNums = new int[nums.length];
        int index = 0;
        for (int i = nums.length-1; i >=0; i--) {
            tmpNums[index++] = nums[i];
        }


        return tmpNums;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        int num = kthLargest.add(-3);// return 4
        System.out.println(num);
//        num = kthLargest.add(5);// return 4
//        System.out.println(num);
//        num = kthLargest.add(10);// return 4
//        System.out.println(num);
//        num = kthLargest.add(9);// return 4
//        System.out.println(num);
//        num = kthLargest.add(4);// return 4
//        System.out.println(num);
    }
}