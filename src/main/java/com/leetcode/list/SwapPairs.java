package com.leetcode.list;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = swapPairs.swapPairs(node);
        System.out.println(listNode);
        String str = "";


    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        ListNode root = head;
        ListNode varb = head;
        if(head.next.next!=null)
            head = head.next;
        while(varb != null){
            root = varb;
            if(root.next != null){
                varb = root.next.next;
            }else {
                varb = null;
                continue;
            }

            ListNode temp1 = root;
            ListNode temp2 = root.next.next;
            root = root.next;
            root.next = temp1;
            root.next.next = temp2;
        }
        return head;
    }
}
