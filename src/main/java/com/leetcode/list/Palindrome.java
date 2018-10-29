package com.leetcode.list;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode node = ListNode.createList(new int[]{-1,2,2,-1});
        System.out.println(isPalindrome(node));
    }

    //普通解法
    public static boolean isPalindrome1(ListNode head) {
        if(head==null || head.next==null)
            return true;
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val + ",");
            head = head.next;
        }
        String[] split = sb.toString().split(",");
        String[] strs = new String[split.length];
        for(int i=0,j=split.length-1;i<strs.length;i++,j--){
            strs[i] = split[j];
        }
        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals(split[i])){
                return false;
            }
        }
        return true;
    }

    //O(n)
    // todo
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;

        return true;
    }
}
