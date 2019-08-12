package com.leetcode.strings;

/**
 * @author ly
 * @create 2019-08-11 22:10
 **/
public class NumMatchingSubseq {

    public static void main(String[] args) {
        NumMatchingSubseq subseq = new NumMatchingSubseq();
        System.out.println(subseq.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    /**
     *
     * 双指针的思路
     * 对words进行遍历，双指针一个指向S 一个指向word
     * 如果判断两个字符相同那么word的指针和S都前移一位
     * 如果不同就将S前移继续判断
     * 这样如果最后word的指针移到了最后(loc == str.length())就代表S中包含word
     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        int indexS = 0, loc = 0;
        for (String str:words){
            if(str.length()>S.length())
                continue;
            char[] chars = str.toCharArray();
            for (; loc < chars.length && indexS < S.length(); ) {
                if(chars[loc] == S.charAt(indexS)){
                    //字符相同 对比下一个字符
                    indexS++;
                    loc++;
                }else {
                    indexS++;
                }
            }
            if(loc == str.length())
                count++;
            loc = 0;
            indexS = 0;
        }
        return count;
    }
}
