package com.leetcode.list;

import java.util.Stack;
import java.util.concurrent.Executors;

/**
 * @Auther: Administrator
 * @Date: 2019-01-09 13:42
 * @Description: 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class StackToQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.queue(1);
        myQueue.queue(2);
        myQueue.queue(3);
        myQueue.queue(4);
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());

    }
}

class MyQueue<T> {
    //正常顺序
    Stack<T> stack1 = null;
    //倒序
    Stack<T> stack2 = null;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void queue(T obj){
        if(stack2.size()>0){
            //数据在stack2中需要重新转入stack1
            int size = stack2.size();
            for(int i=0;i<size;i++){
                T pop = stack2.pop();
                stack1.push(pop);
            }
            stack1.push(obj);
        }else {
            //stack1中有数据 可以直接入栈
            stack1.push(obj);
        }
    }

    public T deQueue(){
        if(stack2.size()>0){
            //stack2中有数据 可以直接出栈栈
            return stack2.pop();
        }else {
            //数据在stack2中需要重新转入stack1
            int size = stack1.size();
            for(int i=0;i<size;i++){
                T pop = stack1.pop();
                stack2.push(pop);
            }
            return stack2.pop();
        }
    }
}
