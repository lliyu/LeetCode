package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MinStackDemo {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();

//        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public void test(){
        LinkedList<Integer> stack = new LinkedList<Integer>();
    }

}

//未通过LeetCode
class MinStack1 {

    private static LinkedList<Integer> stack = new LinkedList<Integer>();
    private int min;

    public MinStack1() {

    }

    public void push(int x) {
        stack.addLast(x);
        if(x < min)min=x;
    }

    public void pop() {
        Integer res = stack.removeLast();
        if(res != min)
            return;
        min = stack.get(0);
        for(int i=1;i<stack.size();i++){
            if(min>stack.get(i))
                min = stack.get(i);
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}

class MinStack {

    private Node head;

    public void push(int x) {

        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {

        head = head.next;
    }

    public int top() {

        return head.val;
    }

    public int getMin() {

        return head.min;
    }

    private class Node {

        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {

            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
