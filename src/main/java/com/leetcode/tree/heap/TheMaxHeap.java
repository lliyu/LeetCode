package com.leetcode.tree.heap;

import com.google.common.collect.Maps;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-05-06 09:51
 * @Description: 大根堆
 * 堆为完全二叉树所以可以用数组来实现
 */
public class TheMaxHeap {

    public static void main(String[] args) {
        consMaxHeap(new int[]{5,3,2,8,7,4,9});
    }

    public static void consMaxHeap(int[] nums){
        int[] heaps = new int[nums.length + 1];
        heaps[0] = nums.length;
        for(int i=0;i<nums.length;i++){
            heaps[i+1] = nums[i];
        }
        //调整数组中的位置构建为大根堆
        for(int i=nums.length/2;i>=0;i--){
            adjustToMaxHeaps(heaps, i+1);
        }
        for (int num:heaps){
            System.out.print(num + " ");
        }
    }

    //构建适应大根堆
    private static void adjustToMaxHeaps(int[] heaps, int index) {
        int temp = heaps[index];
        for(int i=index*2;i<heaps.length;i = 2*i){
            if(i<heaps.length && heaps[i]<heaps[i+1]){
                i++;//取左右子节点中大的节点下标
            }
            if(heaps[index]>=heaps[i]){//如果index位的值大于左右子树最大的 那么就代表本次循环中已经满足条件 结束循环
                break;
            }else {
                //否则将大的index位置的值交换
                heaps[index] = heaps[i];
                heaps[i] = temp;
            }
        }
    }
}
