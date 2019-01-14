package com.leetcode.math;

import java.math.BigInteger;

/**
 * @Auther: Administrator
 * @Date: 2019-01-09 10:46
 * @Description: 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(numberOf11(-8));
    }

    //当输入负数时出现死循环
    //因为对于负数进行一位操作要保证结果仍未负数 所以最左边的1是不变的
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

    //固定的经过32次循环
    public static int numberOf11(int num){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            int res = num & flag;
            if(res == flag){
                count++;
            }
            flag =flag << 1;
        }
        return count;
    }
}
