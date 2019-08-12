package com.leetcode.strings;

/**
 * @author ly
 * @create 2019-08-12 21:32
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
示例 1：

输入："ab-cd"
输出："dc-ba"
示例 2：

输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：

输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
 **/
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters letters = new ReverseOnlyLetters();
        System.out.println(letters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        char[] temp = new char[chars.length];
        int len = chars.length-1;
        int index = 0;
        //设置非字母的值
        for (int i = 0; i < chars.length; i++) {
            if(!isLetter(chars[i])){
                //不是字母
                temp[i] = chars[i];
            }
        }
        while (len>=0){
            if(isLetter(chars[len])){
                //是字母
                //判断替换的位置是否已经被占了
                //如果当前位置不为空为非字符则直接跳过
                while (temp[index] > 0)index++;
                temp[index++] = chars[len--];
            }else {
                len--;
            }

        }
        return new String(temp);
    }

    /**
     * 判断传入字符是否为字母
     * @param ch
     * @return
     */
    public boolean isLetter(char ch){
        return (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z');
    }
}
