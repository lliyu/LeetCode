package com.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: Administrator
 * @Date: 2019-05-27 09:20
 * @Description: 数据流中的第K大元素
 */
public class KthLargest {

    //优先队列解题
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue();
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        if(queue.size()<k){
            queue.add(val);
        }else if(queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {4,5,8,2};
        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(3);
        System.out.println(param_1);
    }
}

class KthLargest1 {

    private int[] nums;
    private int k;

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }

    public int add(int val) {
        //扩容
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length-1] = val;
        //查找第k大元素

        return findMaxOfK(k, nums);
    }

    public int findMaxOfK(int k, int[] nums){
        k = nums.length - k;
        int index = partition(nums, 0, nums.length-1);
        int low = 0, high = nums.length-1;
        while(index != k){
            if(index > k){
                index = partition(nums, low, index-1);
            }else if(index < k){
                index = partition(nums, index+1, high);
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int low, int high){
        //选取第一个值为枢纽值
        int pivo = nums[low];
        while(low<high){
            while(low<high&&nums[high]>=pivo){
                high--;
            }
            nums[low] = nums[high];
            while(low<high&&nums[low]<=pivo){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low] = pivo;

        return low;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest1 obj = new KthLargest1(k, nums);
        int maxOfK = obj.add(3);
        System.out.println(maxOfK);
    }
}