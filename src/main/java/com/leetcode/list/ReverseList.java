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
        ListNode node = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        node = reverseList(node);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    //递归
    public static ListNode reverseList(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        //翻转head和node
        // head.next.next一定不会为空，上面的终止条件保证这里head后一定有至少一个节点
        // 这一步将
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 迭代翻转
     **/
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        if(head.next == null) return head;
        ListNode dummp = new ListNode(0);
        ListNode node = head;
        dummp.next = node;
        ListNode next = node.next;
        while(next != null) {
            ListNode temp = dummp.next;
            node.next = next.next;
            dummp.next = next;
            next.next = temp;
            next = node.next;
        }
        return dummp.next;
    }

}
