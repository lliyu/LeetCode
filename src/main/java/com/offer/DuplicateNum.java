package com.offer;

/**
 * 找出数组中重复的数字
 *
 * @author ly
 * @create 2019-01-06 20:46
 **/
public class DuplicateNum {

    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5,0};
        int duplicate = duplicate(arrs);
        if(duplicate>=0){
            System.out.println(duplicate);
        }else {
            System.out.println("未找到");
        }
    }

    //时间复杂度 O(n) 空间复杂度O(1)
    //这里虽然有着两个循环 但是如果在内循环找到自己的位置后就不需要再次交换了 实际上整个过程相当于最坏情况下执行2n次
    //所以时间复杂度 O(n)
    public static int duplicate(int[] arrs){
        if(arrs==null || arrs.length==0){
            return -1;
        }
        int temp = 0;
        for(int i=0;i<arrs.length;i++){
            while(arrs[i] != i){
                if(arrs[arrs[i]] == arrs[i]){
                    return arrs[i];
                }
                temp = arrs[i];
                arrs[i]= arrs[arrs[i]];
                arrs[temp] = temp;
            }
        }
        return -1;
    }
}
