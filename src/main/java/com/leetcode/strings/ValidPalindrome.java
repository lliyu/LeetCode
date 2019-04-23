package com.leetcode.strings;

/**
 * @Auther: Administrator
 * @Date: 2019-04-22 16:13
 * @Description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(validPalindrome("eecccbebaeeabebccceea"));
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length-1;
        int left = 0, right = len;
        boolean isSub = false, result = true;
        while(left<=right){
            if(chars[left]==chars[right]){
                left++;right--;
            }else if(!isSub){
                //进行减一操作
                isSub = true;
                if(chars[left+1]==chars[right]){
                    left++;
                }else{
                    result = false;
                    break;
                }
            }else{
                result = false;
                break;
            }
        }
        if(result){
            return true;
        }

        left = 0;right = len;
        result = true;isSub=false;
        while(left<=right){
            if(chars[left]==chars[right]){
                left++;right--;
            }else if(!isSub){
                //进行减一操作
                isSub = true;
                if(chars[left]==chars[right-1]){
                    right--;
                }else{
                    result = false;
                    break;
                }
            }else{
                result = false;
                break;
            }
        }
        return result;
    }
}
