package com.newcode;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 */
public class MergeNode {

    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode root = head;
        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                root.next = new ListNode(list2.val);
                root = root.next;
                list2 = list2.next;
            }else if(list1.val < list2.val){
                root.next = new ListNode(list1.val);
                root = root.next;
                list1 = list1.next;
            }else {
                root.next = new ListNode(list2.val);
                root = root.next;
                root.next = new ListNode(list2.val);
                root = root.next;
                list2 = list2.next;
                list1 = list1.next;
            }
        }

        while(list1!=null){
            root.next = list1;
        }
        while(list2!=null){
            root.next = list2;
        }
        return head.next;
    }

}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}