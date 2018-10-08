package com.leetcode.list;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
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
        ListNode head = removeNthFromEnd(node, 2);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        int num = 1;
        while (next.next != null) {
            num++;
            next = next.next;
        }
        next = head;
        int rem = num - n;
        if (rem == 0) {
            head = head.next;
            return head;
        }
        rem--;
        for (int i = 0; i < num; i++) {

            if (i == rem) {
                if (next.next == null) {
                    next = null;
                    if (i == 0) head = next;
                    break;
                } else {
                    next.next = next.next.next;
                    break;
                }
            }
            next = next.next;
        }
        return head;
    }
}
