package com.leetcode.list;

/**
 * 链表排序
 */
public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode list = ListNode.createList(new int[]{4, 2, 1, 3});
        sortList.sortList(list);
    }

    //-------------------------------------/
    // 归并排序
    public ListNode sortList(ListNode head) {

        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode end) {
        //终止条件
        if (head == null) {
            return head;
        }
        if (head.next == end) {
            head.next = null;
            return head;
        }

        //通过快慢指针查找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end){
            slow = slow.next;
            if(fast.next != end)
                fast = fast.next.next;
            else
                fast = fast.next;
        }

        //确定快慢指针后就进行归并排序
        ListNode listNode1 = sortList(head, slow); //head~slow 排序好的部分
        ListNode listNode2 = sortList(slow.next, end);
        ListNode node = merge(listNode1, listNode2);
        return node;
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (listNode1!=null && listNode2!=null){
            if(listNode1.val > listNode2.val){
                node.next = new ListNode(listNode2.val);
                node = node.next;
                listNode2 = listNode2.next;
            }else if(listNode1.val < listNode2.val){
                node.next = new ListNode(listNode1.val);
                node = node.next;
                listNode1 = listNode1.next;
            }else {
                node.next = new ListNode(listNode2.val);
                node = node.next;
                listNode2 = listNode2.next;
                node.next = new ListNode(listNode1.val);
                node = node.next;
                listNode1 = listNode1.next;
            }
        }
        if (listNode1 != null){
            node.next = listNode1;
        }
        if (listNode2 != null){
            node.next = listNode2;
        }
        return dummy.next;
    }

    //-------------------------------------/
}
