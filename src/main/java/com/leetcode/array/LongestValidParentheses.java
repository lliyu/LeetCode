package com.leetcode.array;

public class LongestValidParentheses {
    public static void main(String[] args) {
        longestValidParentheses("()(())");
    }

    public static int longestValidParentheses(String s) {
        if (s == "") return 0;

        int count = 0, max = 0;
        int[] marks = new int[2];// marks[0]=( marks[0]=)
        boolean[] isVaild = new boolean[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(marks[0]==0 && marks[1]==0) {
                    marks[0]++;
                }else if(marks[0]==0 && marks[1]!=0){
                    //存在可以配对的
                    count += 2;
                    marks[1]--;
                    mark(isVaild, i, s);
                }else if(marks[0]!=0 && marks[1]==0){
                    marks[0]++;
                }
            } else if(s.charAt(i) == ')') {
                if(marks[0]!=0 && marks[1]==0){
                    //存在可以配对的
                    count += 2;
                    marks[0]--;
                    mark(isVaild, i, s);
                }
            }
        }

        count = 0;
        for(int i=0; i<isVaild.length; i++) {
            if(isVaild[i]){
                count++;
                max = Math.max(max, count);
            }else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return max;
    }

    public static void mark(boolean[] isVaild, int index, String s) {
        for(int i=index-1; i>=0; i--) {
            if(s.charAt(i) == '(' && !isVaild[i]){
                isVaild[index] = true;
                isVaild[i] = true;
                break;
            }
        }
    }
}
