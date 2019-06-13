package com.leetcode.heap;

import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2019-06-04 15:31
 * @Description:
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*)())"
 * 输出: True
 */
public class CheckValidString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)(*))"));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        for(;index<chars.length;index++){
            if(chars[index] == ')'){
                if(!stack.isEmpty() && (stack.peek().equals('(') || stack.peek().equals('*')))
                    stack.pop();
                else
                    return false;
            }
        }

        return true;
    }


//    public static boolean checkValidString(String s) {
//        Stack<Character> characters = new Stack<>();
//        char[] chars = s.toCharArray();
//        int index = 0;
//        for(;index<chars.length/2;index++){
//            characters.push(chars[index]);
//        }
//        if(chars.length%2 != 0){
//            if(chars[index] != '*')
//                return false;
//            else
//                index++;
//        }
//        Character pop;
//        for(;index<chars.length;index++){
//            pop = characters.pop();
//
//        }
//
//        return false;
//    }
}
