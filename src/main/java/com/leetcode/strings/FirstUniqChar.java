package com.leetcode.strings;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            if(s.indexOf(chars[i]) == s.lastIndexOf(chars[i])){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int res = -1;
        //此方法高效在于外层循环只循环26次
        // 当涉及到较长的字符串时会节省多次的循环次数
        for (char i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf(i);
            // 如果存在这个字母且唯一，需要更新res
            if (firstIndex != -1 && firstIndex == s.lastIndexOf(i)) {
                res = res == -1 ? firstIndex : Math.min(firstIndex, res);
            }
        }
        return res;
    }
}
