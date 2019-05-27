package com.leetcode.array;

/**
 * @Auther: Administrator
 * @Date: 2019-05-14 09:57
 * @Description: 递归求解全排列
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String str = "1234";
        permutation.permutation(str.toCharArray(), 0, str.length()-1);
    }

    public void permutation(char[] chars, int begin, int len){
        if(begin == len){
            System.out.println(chars);
            return;
        }
        for(int i=begin;i<=len;i++){
            swap(chars, i,begin);
            permutation(chars, begin+1, len);
            swap(chars,i, begin);
        }
    }

    private void swap(char[] chars, int i, int begin) {
        char temp = chars[i];
        chars[i] = chars[begin];
        chars[begin] = temp;
    }

}
