package com.leetcode.list;

public class ListNode {
    int val;
    ListNode next;

    public static ListNode createList(int[] nums){
        ListNode head = new ListNode(0);
        ListNode next = head;
        for(int num:nums){
            ListNode node = new ListNode(num);
            head.next = node;
            head = head.next;
        }

        return next.next;
    }

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + "";
    }
}