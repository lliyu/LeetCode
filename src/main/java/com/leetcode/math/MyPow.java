package com.leetcode.math;

/**
 * @author ly
 * @create 2019-05-29 21:56
 * Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
 **/
public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }

    //暴力 超时
    public static double myPow(double x, int n) {

        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        double res = 1;
        for(int i=0;i<n;i++){
            res *= x;
        }
        return res;
    }

    public static double myPowOfRecur(double x, int n) {

        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        double res = 1;
        for(int i=0;i<n;i++){
            res *= x;
        }
        return res;
    }
}
