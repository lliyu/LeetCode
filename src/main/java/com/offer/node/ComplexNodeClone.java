package com.offer.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019-01-24 18:53
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 */
public class ComplexNodeClone {

    public static void main(String[] args) {
        ComplexListNode node = new ComplexListNode();
        node.setValue(1);
        ComplexListNode node1 = new ComplexListNode();
        node1.setValue(2);
        node.setNext(node1);
        node.setSibling(node1);
        ComplexListNode clone = clone1(node);
        System.out.println(clone);
    }

    //O(n)的时间复杂度和O(n)的空间复杂度
    public static ComplexListNode clone(ComplexListNode head){
        ComplexListNode root = new ComplexListNode();
        ComplexListNode temp = head, node = root;
        Map<ComplexListNode, ComplexListNode> map = new HashMap<>();
        //先通过next将原节点的next连起来
        while(temp != null){
            node.setValue(temp.getValue());
            map.put(temp, node);
            temp = temp.getNext();
            node.setNext(new ComplexListNode());
            node = node.getNext();
        }

        //复制sibing
        temp = head;node = root;
        while(temp!=null){
            ComplexListNode sibling = temp.getSibling();
            if(sibling==null){
                node.setSibling(null);
            }else {
                node.setSibling(map.get(temp.getSibling()));
            }
            temp = temp.getNext();
            node = node.getNext();
        }

        return root;
    }

    //不借助辅助空间
    public static ComplexListNode clone1(ComplexListNode head){
        ComplexListNode root = new ComplexListNode();
        ComplexListNode temp = head, node = root;
        //复制后链在原节点后面 A->A'->B->B'
        while(temp != null){
            node.setValue(temp.getValue());
            ComplexListNode next = temp.getNext();
            temp.setNext(node);
            node.setNext(next);
            temp = temp.getNext().getNext();
            if(next!=null){
                node = new ComplexListNode();
            }
        }
        //移动
        temp = head;
        while(temp!=null){
            ComplexListNode sibling = temp.getSibling();
            ComplexListNode next = temp.getNext();
            if(sibling!=null){
                next.setSibling(sibling.getNext());
            }
            temp = temp.getNext().getNext();
        }
        root = head.getNext();
        temp = head.getNext();
        node = root;
        while(temp.getNext()!=null){
            temp = temp.getNext();
            node.setNext(temp);
            node = node.getNext();
        }
        return root;
    }
}
