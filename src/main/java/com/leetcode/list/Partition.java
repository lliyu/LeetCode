package com.leetcode.list;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class Partition {

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 2;
        ListNode r1 = new ListNode();
        r1.val = 1;
        root.next = r1;
        ListNode partition = partition(root, 2);
        System.out.println(partition);

    }

    /**
     * 双指针法，left 链表存放比 x 小的节点，right 链表存放比 x 大于或等于的节点，
     * 我们分别用 before 和 after 来前面两个链表添加节点，用 head 来遍历原始链表。
     * 当原始链表遍历完成时，我们需要将 left 链表连接上 right 链表，
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode root = head;
        ListNode rightHead = null;

        ListNode left = new ListNode();
        ListNode right = new ListNode();
        //存放两个链表的头节点
        head = left;
        rightHead = right;

        //找到第一个大于x的节点的前一个节点
        while(root != null){
            if(root.val<x){
                left.next = root;
                left = left.next;
            }else {
                right.next = root;
                right = right.next;
            }
            root = root.next;
        }

        if(rightHead.next != null){
            left.next = rightHead.next;
            right.next = null;//这里记得需要清除掉后面不需要的引用 否则会导致大量的重复引用
        }

        return head.next;
    }

}
