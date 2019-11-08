package com.offer.backtracking;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {

    public static void main(String[] args) {

        LetterCombinations letterCombinations = new LetterCombinations();
        Set<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(strings);
    }

    public Set<String> letterCombinations(String digits) {
        char[][] chars = toStringArray(digits);
        int length = chars[0].length;

        Set<String> strings = new HashSet<>();
        for(int i=0;i<length;i++){
            fullStrings(strings, chars, 0, 0, String.valueOf(chars[0][i]));
        }
        return strings;
    }

    private void fullStrings(Set<String> strings, char[][] chars, int x, int y, String str) {

        if(str.length() == chars.length){
            strings.add(str);
        }

        if(x>=chars.length-1 || y>=chars[x].length-1) {
            return;
        }


        //将字符添加到字符串中

        fullStrings(strings, chars, x++, y, str.concat(String.valueOf(chars[x][y])));

        fullStrings(strings, chars, x, y++, str.concat(String.valueOf(chars[x][y])));

    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {

        if (next_digits.length() == 0) {
            output.add(combination);
        } else {

            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


    private char[][] toStringArray(String digits) {
        Map<Character, String> maps = new HashMap<>();
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wxyz");
        char[][] chars = new char[digits.length()][];
        for(int i=0;i<digits.length();i++){
            chars[i] = maps.get(digits.toCharArray()[i]).toCharArray();
        }

        return chars;
    }


}
