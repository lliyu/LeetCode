package com.leetcode.list;

/**
 * @Auther: Administrator
 * @Date: 2018-11-07 14:42
 * @Description:
 * 两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode head = addTwoNumbers(node, node);
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    /**
     * 这里为了便于理解所以将步骤分开了 实际上这里很多操作可以在一起做的 比如计算链表值得几个while  计算长度也是可以不要的
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1,head2=l2;
        int len1=0,len2=0,k=0;
        //计算链表的长度
        while(head1 != null){
            len1++;
            head1 = head1.next;
        }
        while(head2 != null){
            len2++;
            head2 = head2.next;
        }

        int[] arr = new int[len1>len2?len1:len2];
        head1 = l1;head2=l2;
        //将两链表相加的值计算出来
        while(head1!=null && head2!=null){
            arr[k++] = head1.val + head2.val;
            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null){
            arr[k++] = head1.val;
            head1 = head1.next;
        }
        while(head2 != null){
            arr[k++] = head2.val;
            head2 = head2.next;
        }

        //做进位运算
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>=10){
                arr[i+1] += arr[i]/10;
                arr[i] = arr[i]%10;
            }
        }
        ListNode head = null;
        ListNode temp = new ListNode(-1);
        head = temp;
        //构造新的链表
        for(int i=0;i<arr.length-1;i++){
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = temp.next;
        }
        if(arr[arr.length-1]>=10){
            temp.next = new ListNode(arr[arr.length-1]%10);
            temp = temp.next;
            temp.next = new ListNode(arr[arr.length-1]/10);
        }else {
            temp.next = new ListNode(arr[arr.length-1]);
        }

        return head.next;
    }
}
