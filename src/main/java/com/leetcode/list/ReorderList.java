package com.leetcode.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReorderList {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
        }
        boolean isFull = false;
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            int key = it.next();
            int value = map.get(key);
            if(value == 1){
                if(!isFull){
                    num1[0] = key;
                    isFull = true;
                }else {
                    num2[0] = key;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{1,2,3,4,5,2,4,5}, new int[]{0}, new int[]{0});

    }

    public static void reorderList(ListNode head) {
        if(head.next == null) return;

        ListNode current = head;

        ListNode tailPre = getTailPre(current);
        ListNode tail = tailPre.next;

        // 如何确定最后一个节点？ 遍历？
        while(current.next != tail){
            //将tail节点移动到current的后面
            tailPre.next = null;
            ListNode next = current.next;
            current.next = tail;
            tail.next = next;
            current = next;
            tailPre = getTailPre(current);
            if(tailPre == null) return;
            tail = tailPre.next;
        }
    }

    public static ListNode getTailPre(ListNode node){
        while(node.next !=null){
            if(node.next.next == null) return node;
            node = node.next;
        }
        return null;
    }
}
