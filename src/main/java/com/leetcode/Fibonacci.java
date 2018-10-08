package com.leetcode;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    /**
     * 动态规划解决斐波拉契数列
     * @param n
     * @return
     */
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for(int i=2; i<n;i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }
}
