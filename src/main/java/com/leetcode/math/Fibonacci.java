package com.leetcode.math;

import java.util.Arrays;

/**
 * @Auther: Administrator
 * @Date: 2019-01-09 14:19
 * @Description: 斐波那契数列
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci1(10));
    }

    //循环 时间复杂度O(n)  空间复杂度O(1)
    public static int fibonacci(int n){
        if(n<=2)
           return 1;
        int f1=1,f2=1,tmp=0;
        for(int i=3;i<=n;i++){
            tmp = f2;
            f2 = f1+f2;
            f1 = tmp;
        }
        return f2;
    }

    //递归
    public static int fibonacci1(int n){
        if(n<=2)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
