package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @create 2019-08-10 22:00
 * 自除数 是指可以被它包含的每一位数除尽的数。

例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

还有，自除数不允许包含 0 。

给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

示例 1：

输入：
上边界left = 1, 下边界right = 22
输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 **/
public class SelfDividingNumbers {

    public static void main(String[] args) {
        SelfDividingNumbers numbers = new SelfDividingNumbers();
        List<Integer> list = numbers.selfDividingNumbers(1, 22);
        list.stream().forEach(number -> {
            System.out.print(number + " ");
        });
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> lists = new ArrayList<>();
        int num=0, loc =0;
        boolean res = true;
        for (int i = left; i <= right; i++) {
            num = i;
            while (num!=0){
                loc = num%10;
                num = num/10;
                if(loc==0 || i%loc != 0){
                    res = false;
                    break;
                }
            }
            if(res){
                lists.add(i);
            }
            res = true;
        }
        return lists;
    }

    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> lists = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean res = judgeIsMatch(i);
            if(res){
                lists.add(i);
            }
        }
        return lists;
    }

    private boolean judgeIsMatch(int number) {
        String s = String.valueOf(number);
        if(s.contains("0"))
            return false;
        for (int i = 0; i < s.length(); i++) {
            if(!(number%(s.charAt(i) - 48)==0)){
                return false;
            }
        }
        return true;
    }
}
