package com.leetcode.dynamic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ly
 * @create 2018-11-11 13:39
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�

�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��

ʾ��:

���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
˵��:
��������Ĵ��ǰ��ֵ������еģ��������������ѡ��������˳��
 **/
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(letterCombinations("1"));
    }

    //�������
    public static List<String> letterCombinations(String digits) {
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
}
