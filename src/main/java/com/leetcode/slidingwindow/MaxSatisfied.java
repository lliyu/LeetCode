package com.leetcode.slidingwindow;

/**
 * @author ly
 * @create 2019-06-09 15:17
 *
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 

示例：

输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 **/
public class MaxSatisfied {


    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(maxSatisfied(new int[]{2,6,6,9},new int[]{0,0,1,1}, 1));
        System.out.println(maxSatisfied(new int[]{1},new int[]{0}, 1));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int startIndex = 0;//每一次开始计算的下标
        int useIndex = 0;//每一次开始使用的下标
        long max = 0;
        long sum = 0;
        int length = customers.length;
        for(int i=0;i<length;i++)
            if(grumpy[i] == 1){
                useIndex = i;
                break;
            }

        while(startIndex < length){
            for (int i = 0; i < length; i++) {
                if((i>=startIndex && i<useIndex+X) || grumpy[i]==0){
                    sum += customers[i];
                }
            }
            if(max<sum)
                max = sum;
            sum = 0;
            //重新计算startIndex和useIndex

            useIndex++;
            for (int i = useIndex; i < length; i++) {
                if(grumpy[i] == 1){
                    useIndex = i;
                    break;
                }
            }
            startIndex++;
            for (int i = useIndex-1; i >= 0 && i<length; i--) {
                if(grumpy[i] == 1){
                    startIndex = i+1;
                    break;
                }
            }
        }
        return (int) max;
    }

    public int secondResolve(int[] customers, int[] grumpy, int X){
        //存储第I位维持X位的满意数，防止重复计算
        int[] dp = new int[customers.length + 1];
        //存储不生气的满意总和数
        int[] zoreDp = new int[customers.length + 1];
        //初始化
        int max = X > customers.length ? customers.length : X;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < X) {
                dp[i + 1] = sum += customers[i];
            }
            zoreDp[i + 1] = (grumpy[i] == 0) ? customers[i] + zoreDp[i] : zoreDp[i];
        }
        int retMax = dp[max] + zoreDp[customers.length] - zoreDp[max];
        for (int i = X; i < customers.length; i++) {
            dp[i + 1] = dp[i] - customers[i - X] + customers[i];
            int otherZore = zoreDp[customers.length] - zoreDp[i + 1] + zoreDp[i - X + 1];
            retMax = Math.max(retMax, dp[i + 1] + otherZore);
        }

        return retMax;
    }
}
