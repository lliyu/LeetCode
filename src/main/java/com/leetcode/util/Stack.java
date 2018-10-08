package com.leetcode.util;

import java.util.LinkedList;

public class Stack<T>  {
    private LinkedList<T> stack = new LinkedList<T>();

    public T push(T t){
        stack.addFirst(t);
        return t;
    }

    public T pop(){
        return stack.removeFirst();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public String toString(){
        return stack.toString();
    }

    public int size(){
        return stack.size();
    }
}

class Queue<T>  {
    private LinkedList<T> queue = new LinkedList<T>();

    public T push(T t){
        queue.addLast(t);
        return t;
    }

    public T pop(){
        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public String toString(){
        return queue.toString();
    }

    public int size(){
        return queue.size();
    }
}


