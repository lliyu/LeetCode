package com.leetcode.math;

/**
 * @Auther: Administrator
 * @Date: 2019-01-09 10:46
 * @Description: 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(numberOf1(8));
        System.out.println(0x55555555);
    }

    public static int numberOf1(int num){
        int count = 0;
        while(num != 0){
            int res = num & 1;
            if(res == 1){
                count++;
            }
            num = num>>1;
        }
        return count;
//        return Integer.bitCount(num);
    }
}
