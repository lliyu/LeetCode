package com.leetcode.list;

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode between = reverseBetween(listNode, 2, 4);
        ListNode.print(between);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        // 找到left
        ListNode node = head;

        while(node.next!=null && node.next.val != left){
            node = node.next;
        }
        //此时node的next就是第一个需要开始反转的节点
        ListNode temp = node;
        node = node.next;

        while(node!=null) {
            ListNode next = node.next;
            ListNode current = temp.next;
            if (current.val == right) break;
            if(next != null){
                node.next = next.next;
                temp.next = next;
                next.next = current;
            }
        }
        return head;
    }
}
