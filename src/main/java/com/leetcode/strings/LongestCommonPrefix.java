package com.leetcode.strings;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null ||strs.length==0)
            return "";
        StringBuilder sb = new StringBuilder();
        int min = 0;

        for(int i=1;i<strs.length;i++){
            if(strs[i].length() < strs[min].length()){
                min = i;
            }
        }
        boolean isTrue = false;
        for(int i=0;i<strs[min].length();i++){
            char ch = strs[min].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i) != ch){
                    isTrue = true;
                    break;
                }
            }
            if(isTrue)
                break;
            sb.append(ch);
        }
        return sb.toString();
    }
}
