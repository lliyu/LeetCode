package com.leetcode.strings;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 判断是否是字母异位词即判断字符串中是否只有字符的位置不同，也就是判断两个字符串中包含的字符以及这些字符出现的次数是否相同
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("",""));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        if(s == null || t==null || (s.length()!=t.length())){
            return false;
        }
        int num1 = 0,num2 = 0;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        // 这种情况下虽然时间复杂度为O(n)，但是因为外层固定循环26次
        // 所以会浪费掉不少时间
        //第二种方法循环次数最大也只为2n
        for (char i = 'a'; i <= 'z'; i++) {
            for(int j=0;j<chars.length;j++){
                if(chars[j] == i){
                    num1++;
                }
                if(chars1[j] == i){
                    num2++;
                }
            }
            if(num1 != num2){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t){
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] record = new int[26];

        for (char c : sArr) {
            record[c - 'a']++;
        }

        for (char c : tArr) {
            if (record[c - 'a']-- == 0) return false;
        }

        return true;
    }
}
