package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: Administrator
 * @Date: 2019-01-24 16:51
 * @Description:
 */
public class MinStack {
    private List<Integer> stack = new ArrayList<>();
    private Integer min;
    private List<Integer> minStack = new ArrayList<>();

    public Integer getMinNum(){
        return min;
    }
    public void push(Integer t){
        if(stack.size() == 0){
            min = t;
            stack.add(t);
            minStack.add(t);
            return;
        }
        stack.add(t);
        if(t < min){
            min = t;
            minStack.add(t);
        }else {
            minStack.add(min);
        }
    }

    public Integer pop(){
        Integer remove = stack.remove(stack.size() - 1);
        minStack.remove(minStack.size()-1);
        min = minStack.get(stack.size()-1);
        return remove;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(5);
        minStack.push(3);
        minStack.pop();
        System.out.println(minStack.getMinNum());
        minStack.pop();
        System.out.println(minStack.getMinNum());
    }
}
