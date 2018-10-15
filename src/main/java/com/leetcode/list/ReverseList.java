package com.leetcode.list;

/**
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node = ListNode.createList(new int[]{1, 4, 5, 6});
        node = reverseList(node);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head.next == null || head==null)
            return head;
        ListNode newN = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newN;
    }
}
