package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019-01-08 16:39
 * @Description:逆序遍历链表
 */
public class ReverseTraver {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ThreadLocal local = new ThreadLocal();
        traveral(list, 0);
    }

    //递归调用
    //还可以使用栈的后进先出的特性
    private static void traveral(List<Integer> list, int len) {
        if(list.size() <= len){
            return;
        }
        int res = len;
        traveral(list, ++len);
        System.out.println(list.get(res));
    }
}
