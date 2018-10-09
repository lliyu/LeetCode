package com.leetcode.list;

public class ListNode {
    int val;
    ListNode next;

    public static ListNode createList(){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}