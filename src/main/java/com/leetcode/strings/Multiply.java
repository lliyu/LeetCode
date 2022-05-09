package com.leetcode.strings;

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *  
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class Multiply {

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("123", "456"));
    }

    /**
     * 字符串的计算一类的题目主要注意几个点
     * 1。初始状态以及0值的特殊处理
     * 2。字符串大多需要进行翻转处理，模拟运算过程
     * 3。注意保存中间过程的状态，比如进位等
     * 4。流程最后要记得处理进位 防止少进一位导致结果出错
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        String rnt = "0";
        if (num1.length()==1&&num1.charAt(0)=='0') return rnt;
        if (num2.length()==1&&num2.charAt(0)=='0') return rnt;

        //翻转字符串
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        //模拟数字相乘的过程
        for (int i=0; i<num1.length(); i++) {
            StringBuilder sb = new StringBuilder();// 用于记录中间结果
            for (int j = 0; j < i; j++) {
                sb.append("0");
            }
            int temp = (num1.charAt(i) - '0');
            int pre = 0;// 记录进位
            for (int j = 0; j < num2.length(); j++) {
                int num = (num2.charAt(j) - '0') * temp + pre;
                pre = num / 10;
                sb.append(num % 10);
            }
            if (pre != 0) sb.append(pre);
            //将两数相加
            rnt = addStrings(rnt, sb.toString());
        }
        return new StringBuilder(rnt).reverse().toString();
    }

    public String addStrings(String num1, String num2) {

        int len = Math.max(num1.length(), num2.length());
        StringBuilder rnt = new StringBuilder();
        int pre = 0;//记录进位
        int num = 0;//记录中间相加结果
        for (int i = 0; i < len; i++) {
            if (i<num1.length()) {
                num += (num1.charAt(i)-'0');
            }
            if (i<num2.length()) {
                num += (num2.charAt(i)-'0');
            }
            num += pre;
            pre = num / 10;
            rnt.append(num%10);
            num = 0;
        }
        if (pre != 0) rnt.append(pre);
        return rnt.toString();
    }

}
