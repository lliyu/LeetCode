package com.leetcode.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  字符串转整数 (atoi)
 * 实现 atoi，将字符串转为整数。
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
 * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi2("+9128"));
    }

    /**
     * LeetCode不支持Pattern等类
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        String regex = "^[+-]{0,1}[0-9]+",num;
        int res = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            num = matcher.group();
        }else {
            return 0;
        }
        try{
            res = Integer.parseInt(num);
        }catch (Exception e){
            if(num.startsWith("-")){
                res = Integer.MIN_VALUE;
            }else {
                res = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    /**
     * leetcode对空串""判断有点问题 这种解法空串始终无法通过
     * @param str
     * @return
     */
    public static int myAtoi2(String str) {
        if(str=="" || str==null)
            return 0;
        int res = 0;
        if(str.charAt(0)>'0'+9 || str.charAt(0)<'0')
            if(!(str.charAt(0)=='-'||str.charAt(0)=='+'))
                return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)>'0'+9 || str.charAt(i)<'0')
                break;
            sb.append(str.charAt(i));
        }
        if(sb.toString().length() == 1)
            return 0;
        str = sb.toString();
        try{
            res = Integer.parseInt(str);
        }catch (Exception e){
            if(str.startsWith("-")){
                res = Integer.MIN_VALUE;
            }else {
                res = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    public static int myAtoi3(String str) {
        str = str.trim();
        int result = 0;
        boolean addOrSub = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+')){
                addOrSub = c=='+'?true:false;
            } else if (c>='0' && c<='9'){
                // 检查是否溢出
                if(result>(Integer.MAX_VALUE - (c - '0'))/10){
                    return addOrSub? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return addOrSub?result:-result;
            }
        }
        return addOrSub?result:-result;
    }
}
