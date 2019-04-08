package com.leetcode.strings;

/**
 * @Auther: Administrator
 * @Date: 2019-03-29 17:11
 * @Description:
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 示例:
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        nextGreatestLetter(new char[]{'1','2'}, 'a');
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int tar = target;
        int max=Integer.MAX_VALUE,min=0,res = 0;
        for(char letter : letters){
            res = letter - tar;
            if(res>0){
                if(res < max){
                    max = res;
                }
            }else if(res<0){

            }
        }
        return '1';
    }
}
