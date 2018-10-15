package com.leetcode.list;

/**
 *   合并两个有序链表
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node = mergeTwoLists(ListNode.createList(new int[]{1}), ListNode.createList(new int[]{}));
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode next = head;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                head.next = l2;
                l2 = l2.next;
                head.next.next = l1;
                head = head.next;
            }else {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }
        }
        if (l2 != null){
            head.next = l2;
        }
        return next.next;
    }
}
