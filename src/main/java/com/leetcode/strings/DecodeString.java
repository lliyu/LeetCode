package com.leetcode.strings;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        int index = 0;
        StringBuilder rst = new StringBuilder();
        while(index<len){
            if(!(s.charAt(index)== ']')){
                stack.push(s.charAt(index));
            }else {
                StringBuilder subStr = new StringBuilder();
                //取出最近的子字符串
                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch == '['){
                        int count = Integer.valueOf(stack.pop());
                        for(int i=0;i<count;i++){
                            for(int j=0;j<subStr.length();j++){
                                stack.push(subStr.charAt(j));
                            }
                        }
                        break;
                    }
                    subStr.append(ch);
                }
            }
        }
        while(!stack.isEmpty()){
            rst.append(stack.pop());
        }
        return rst.toString();
    }
}
