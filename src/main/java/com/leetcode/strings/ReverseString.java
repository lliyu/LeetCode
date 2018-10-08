package com.leetcode.strings;

/**
 * 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }
    public static String reverseString(String s) {
        //这里调用了jdk的api
        // 如果要自己实现的话
        // 思路：位置调换 第一个到最后一个 第二个到倒数第二个...
        return new StringBuilder(s).reverse().toString();
    }
}
