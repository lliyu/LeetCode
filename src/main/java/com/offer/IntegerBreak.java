package com.offer;

/**
 * @Auther: Administrator
 * @Date: 2019-01-14 13:36
 * @Description: 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(4));
    }


    /**
     * 动态规划
     * @param len
     * @return
     */
    public static int integerBreak(int len){
        //对于长度为3及以下的绳子 最大值是可以确定的
        if(len<2)
            return 0;
        if(len == 2)
            return 1;
        if(len == 3)
            return 2;
        int[] products = new int[len+1];
        //这里长度为1的绳子实际上乘积应该是0，因为不能再分  但是这里是认为绳子已经被切割过了  1是切割后的长度 所以为1
        //2和3同理
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for(int i=4;i<=len;i++){
            for(int j=1;j<=i/2;j++){
                //计算长度为n的绳子的最大乘积
                products[i] = Math.max(products[i], products[j] * products[i-j]);
            }
        }
        return products[len];
    }


}
