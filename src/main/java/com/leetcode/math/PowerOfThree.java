package com.leetcode.math;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }

    //循环遍历
    public static boolean isPowerOfThree1(int n) {
        if(n <= 0)
            return false;
        int res = 0;
        while(n != 1){
            res = n % 3;
            if(res != 0){
                break;
            }
            n /= 3;
        }
        if(n == 1)
            return true;
        return false;
    }

    public static boolean isPowerOfThree(int n) {
        //换底公式 logab = logcb / logca
        double res = Math.log10(n)/Math.log10(3);
        //判断得到的结果是否为整数
        return  (res - (int)res)==0;
    }
}
