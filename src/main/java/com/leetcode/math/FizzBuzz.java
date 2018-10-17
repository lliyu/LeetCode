package com.leetcode.math;

import java.util.LinkedList;
import java.util.List;

/**
 *   Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(100));
    }

    public static List<String> fizzBuzz(int n) {
        int n3 = 3,n5 = 5;
        List<String> list = new LinkedList<String>();
        String[] res = new String[n];
        for(int i=1;i<=n;i++){
            if(i==n3&&i==n5){
                list.add("FizzBuzz");
                n3 += 3;
                n5 += 5;
            }else if(i==n3){
                list.add("Fizz");
                n3 += 3;
            }else if(i==n5){
                list.add("Buzz");
                n5 += 5;
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
