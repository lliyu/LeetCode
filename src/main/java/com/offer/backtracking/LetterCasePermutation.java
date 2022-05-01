package com.offer.backtracking;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 *  
 *
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
//        char ch = 'a';
//        System.out.println((int)ch);
        LetterCasePermutation permutation = new LetterCasePermutation();
        List<String> strings = permutation.letterCasePermutation("a1B2");
        System.out.println(strings);
    }

    private String replaceIndex(String s, int index, char ch) {
        return s.substring(0, index) + ch + s.substring(index+1);
    }


    public List<String> letterCasePermutation(String S) {

        if(S==null)
            return Collections.emptyList();
        String pattern = "\\d+";
        if (S.matches(pattern)) {
            return Arrays.asList(S);
        }

        List<String> strings = new ArrayList<>();

        backtrace(new StringBuilder(), S, strings, 0);

        return strings;
    }

    public void backtrace(StringBuilder path, String S, List<String> lists, int index){
        if(S.length()==path.length()){
            lists.add(path.toString());
            return;
        }

        path.append(S.charAt(index));
        backtrace(path, S, lists, index+1);
        path.deleteCharAt(path.length()-1);
        if(Character.isLetter(S.charAt(index))){
            path.append((char) (S.charAt(index)^(1<<5)));
            backtrace(path, S, lists, index+1);
            path.deleteCharAt(path.length()-1);
        }

    }

    private boolean filter(char ch, String letters, int index, boolean[] isVisit) {

        if(ch>=65 && ch<=90){
            //比较index前面的是否是
        }else {

        }

        return false;
    }

}
