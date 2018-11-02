package com.leetcode.list;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(10);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(hasCycle(node));
    }

    /**
     * 快慢指针
     * 使用两个链表 一个每次进一步 另一个每次进两步 如果两者相遇则表明存在环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode temp = head.next;
        boolean isCycle = false;
        while(head.next!=null && temp!=null){
            if(head==temp){
                isCycle=true;
                break;
            }
            head = head.next;
            if(temp.next==null){
                break;
            }
            temp = temp.next.next;
        }
        return isCycle;
    }

}
