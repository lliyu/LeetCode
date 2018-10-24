package com.leetcode.math;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public static void main(String[] args) {
//        System.out.println(countPrimes(10));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    //会超时，最后一个用例时间过不去
    public static int countPrimes(int n) {
        if(n<=2)return 0;
        int count = 0;
        boolean flag = true;
        for(int i=3;i<n;i+=2){
            int res = (int) Math.sqrt(i);
            for(int j=2;j<=res;j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
                i= i*2;
            }
            flag = true;
        }
        return count+1;
    }

    //进行标记
    //如果该数为质数,则所有倍数都不为质数-2为质数,4,6,8,10....不为质数,置为false就行
    //3为质数,6,9,12,15...不为质数
    public int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

}

