package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * "bbaaacbd"
 */
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();
        int aaabb = substring.longestSubstring("ababbc", 2);
        System.out.println(aaabb);
    }

    public int longestSubstring(String s, int k) {

        if(s.length()<k)
            return 0;

        //计算字符串中每一个字符出现的次数
        Map<Character, Integer> nums = count(s);

        //是否满足所有出现的字符次数大于等于k
        if(isContinue(nums, k)){
            return s.length();
        }

        //遍历去掉出现次数小于k的字符
        char[] chars = s.toCharArray();
        int first=0,last=chars.length-1;
        //从头遍历
        while(nums.get(chars[first])<k){
            first++;
        }

        //从尾遍历
        while(nums.get(chars[last])<k){
            last--;
        }

        //一轮遍历后得到的字符串 但并不是最终结果
        //递归调用查找
        s = s.substring(first, last+1);
        if(s.length()<k)
            return 0;
        //得到的字符可能是aabbcba这种
        //需要单独遍历
        //分治的思想
        for(int i=0;i<s.toCharArray().length; i++){
            if(nums.get(s.charAt(i))<k)
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(i+1), k));
        }

        return s.length();
    }


    /**
     * 计算给定字符s中每一个字符出现的次数
     * @param s
     * @return
     */
    public Map<Character, Integer> count(String s){
        Map<Character, Integer> nums = new HashMap<>();
        //首先计算每个字符串出现的次数
        for(char ch: s.toCharArray()){
            if(nums.get(ch) != null){
                nums.put(ch, nums.get(ch) + 1);
            }else {
                nums.put(ch, 1);
            }
        }

        return nums;
    }

    /**
     * 计算map中每一个字符串出现次数是否大于k
     * 只有全部字符次数大于等于k返回true
     * 只要一个字符次数小于k则返回false
     * @param nums
     * @param k
     * @return
     */
    public boolean isContinue(Map<Character, Integer> nums, int k){
        for(char ch:nums.keySet()){
            if(nums.get(ch)<k)
                return false;
        }

        return true;
    }

}
