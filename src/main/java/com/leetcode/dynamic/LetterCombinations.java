package com.leetcode.dynamic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ly
 * @create 2018-11-11 13:39
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 **/
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations(""));
    }

    //暴力求解
    public static List<String> letterCombinations1(String digits) {
        List<String> fir = new LinkedList<>();
        if(digits.length() == 0) {
            return fir;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('1',"*");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        String first = map.get(digits.charAt(0));
        List<String> res = null;
        for(int i=0;i<first.length();i++){
            fir.add(String.valueOf(first.charAt(i)));
        }

        for(int i=1;i<digits.length();i++){
            if(map.containsKey(digits.charAt(i))){
                String str = map.get(digits.charAt(i));
                res = new LinkedList<>();
                for(int j=0;j<str.length();j++){
                    char ch = str.charAt(j);
                    for(int k=0;k<fir.size();k++){
                        res.add(fir.get(k) + ch);
                    }
                }
                fir = res;
            }

        }

        return fir;
    }

    List<String> fir = new LinkedList<>();
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

    public List<String> letterCombinations(String digits) {
        backTrace("",digits);
        return fir;
    }

    private void backTrace(String s, String digits) {
        if(digits.length() == 0){
            fir.add(s);
        }else {
            String str = phone.get(digits.substring(0, 1));
            for(char ch:str.toCharArray()){
                backTrace(s+ch, digits.substring(1));
            }
        }
    }
}
