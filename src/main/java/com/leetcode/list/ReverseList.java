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
        ListNode node = ListNode.createList(new int[]{1, 2, 3, 4, 5, 6});
        node = reverseBetween(node, 2, 4);
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right)
            return head;

        ListNode node = head;
        int count = 1;
        ListNode leftHead = null;
        while(count < right && node!=null){
            if(count<left){
                if(count == left-1){
                    //记录下需要转换的前一个位置的节点
                    leftHead = node;
                }
                node = node.next;
                count++;
                continue;
            }else {
                //转换
                ListNode next = node.next;
                ListNode leftNext = leftHead.next;
                leftHead.next = node.next;
                node.next = next.next;
                next.next = leftNext;


//                if(node != null)
//                    node = node.next;
                count++;
            }
        }


        return head;
    }


    public static ListNode reverse(ListNode pre, ListNode curr){
        if(curr == null){
            // 已经遍历到最后一位了
            return pre;
        }

        ListNode next = curr.next;
        curr.next = pre;
        return reverse(curr, next);
    }

    public static ListNode reverseList1(ListNode head) {
        if(head.next == null || head==null)
            return head;
        ListNode newN = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newN;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


}
