package com.leetcode.strings;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Damosel, a poem? A carol? Or a cameo pale? (So mad!)"));
    }

    public static boolean isPalindrome(String s) {
        //使用正则匹配出字母和数字 ^(A-Za-z0-9)这种情况下会匹配出括号
        s = s.replaceAll("[^A-Za-z0-9]", "");
        StringBuilder sb = new StringBuilder(s);
        //重新创建一个字符串 为该字符串反向赋值  比较两个字符串是否相同
        String str = sb.reverse().toString();
        return str.equalsIgnoreCase(s);
    }
}
