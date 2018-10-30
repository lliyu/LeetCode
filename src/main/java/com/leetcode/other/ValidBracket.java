package com.leetcode.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidBracket {

    public static void main(String[] args) {
        System.out.println(isValid("]["));
    }

    public static boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        if(s.length()%2 == 1)
            return false;
        Map<Character, Character> maps = new HashMap<>();
        maps.put('(',')');
        maps.put('[',']');
        maps.put('{','}');
        List<Character> list = new LinkedList<>();
        list.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(list.size() == 0){
                list.add(s.charAt(i));
            }else{
                if(maps.containsKey(((LinkedList<Character>) list).getLast())){
                    if(s.charAt(i) == maps.get(((LinkedList<Character>) list).getLast())){
                        ((LinkedList<Character>) list).removeLast();
                    }else{
                        list.add(s.charAt(i));
                    }
                }else {
                    return false;
                }
            }
        }
        return list.size() == 0;
    }

}
