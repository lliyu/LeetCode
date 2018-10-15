package com.leetcode.list;

/**
 *   �ϲ�������������
 ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�

 ʾ����

 ���룺1->2->4, 1->3->4
 �����1->1->2->3->4->4
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
