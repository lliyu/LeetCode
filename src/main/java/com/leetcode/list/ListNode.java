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

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val + "";
    }
}