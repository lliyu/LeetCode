package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-01-23 16:16
 * @Description:顺时针打印矩阵
 */
public class OrderPrintMatrix {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> integers = printMatrix(nums);
        System.out.println(integers);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0)
            return list;

        int count = matrix.length%2==0?matrix.length/2:matrix.length/2+1;
        for (int i=0;i<count;i++){
            orderPrintMatrix(matrix, i,list);
        }
        return list;
    }

    private static void orderPrintMatrix(int[][] nums, int index, ArrayList<Integer> list) {
        //打印最外层
        //上方
        int[] out = nums[index];
        for(int i=index;i<out.length-index;i++){
            list.add(out[i]);
        }
        //右边
        int length = nums.length - index;
        if(nums[0].length-index > index){
            for(int i=index+1;i<length;i++){
                list.add(nums[i][nums[i].length-1-index]);
            }
        }
        //下边
        length = nums[nums.length-1].length-2-index;
        if(length <nums[nums.length-1].length && length>=0){
            for(int i=length;i>=index;i--){
                list.add(nums[nums.length-1-index][i]);
            }
        }
        //左边
        length = nums.length - index -2;
        if(index<nums[0].length-1){
            for(int i=length;i>index;i--){
                list.add(nums[i][index]);
            }
        }
    }
}
