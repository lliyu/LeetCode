package com.leetcode.math;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例:
 *
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
 *      返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            result = result<<1;//将渠道的数左移一位
            result+= n&1;//加上前一位的数
            n = n>>1;//n右移 将已经读取的位消掉
        }
        return result;
    }
}
