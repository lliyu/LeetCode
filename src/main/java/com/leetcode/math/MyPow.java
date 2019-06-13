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
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(myPow(2.00000,-2147483648));
        System.out.println(Math.sqrt(4444));
    }

    //暴力 超时
    public static double myPow1(double x, int n) {

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

    public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1)
            return x;
        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        return recur(x, n);
    }

    public static double recur(double x, int n){

        if(n==1)
            return x;
        if(n == Integer.MIN_VALUE){//Integer.MIN_VALUE需要单独处理 因为该值取负结果依旧不变
            return recur(x*x, -(n/2));
        }
        if(n%2!=0){
            //奇数
            return recur(x*x, n/2) * x;
        }else {
            return recur(x*x, n/2);
        }
    }

    //会超时
    public static int mySqrt1(int x) {
        int index = 0;
        for(index=0;index*index<=x;index++){
            if(index * index == x)
                return index;
        }
        return index-1;
    }

    public static int mySqrt(int x) {
        long temp = x;
        long index = temp/2;
        long min = 0,max = x;
        long res = index * index;
        while (res != x){
            if(res>x){
                temp = temp/2;
                index = temp/2;
                max = temp;
                res = index*index;
            }else if(res < x){
                min = index;
                break;
            }
        }
        if(res == x)
            return (int) index;
        for(long i=min+1;i<=max;i++){
            if(i*i == x)
                return (int) i;
            if(i*i < x)
                continue;
            if(i*i>x)
                return (int) (i-1);
        }
        return (int) index;
    }
}
