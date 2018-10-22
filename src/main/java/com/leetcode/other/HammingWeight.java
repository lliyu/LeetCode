package com.leetcode.other;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 :
 *
 * 输入: 11
 * 输出: 3
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 *
 *
 * 示例 2:
 *
 * 输入: 128
 * 输出: 1
 * 解释: 整数 128 的二进制表示为 00000000000000000000000010000000
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(~1);
    }

    /**
     * 将自身与比自身小1的数字进行与操作 n&(n-1)
     * 作用为将n的最高位为1的消掉
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;
        for(;n!=0;n = n & (n-1)) {
            res++;
        }
        return res;
    }

}
