package com.structure.lru;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;

public class LRU {


    public static void main(String[] args) {
        LRUImplByLinkedList<Integer> list = new LRUImplByLinkedList<Integer>();
        list.put(1);
        list.put(2);
        list.put(3);
        list.put(4);
        list.put(5);

        list.get(2);
        int size = list.size();
        for(int i=0;i<size;i++){
            System.out.println(list.get(i));
        }

        Lists.newArrayList().ensureCapacity(2);

    }
}

/**
 * 通过链表实现lru
 */
class LRUImplByLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private volatile int size = 0;

    public LRUImplByLinkedList() {
    }

    public int size(){
        return size;
    }

    public void put(T value){
        Node pre = tail;
        Node<T> node = new Node<>(pre, null, value);
        tail = node;
        if(pre == null){
            head = node;
        }else {
            pre.next = node;
        }
        size++;
    }

    public T get(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            if(node == null)
                throw new ArrayIndexOutOfBoundsException();
            node = node.next;
        }
        //将最近使用的放到最前面
        lru(node);
        return (T) node.value;
    }

    private void lru(Node node) {
        Node pre = node.pre;
        if(pre == null)//表示当前节点已经在head处
            return;
        Node temp = head;
        pre.next = node.next;
        head.pre = node;
        node.pre = null;
        node.next = temp;
        head = node;
    }


}

class Node<T> {
    Node pre;
    Node next;
    T value;

    public Node(Node pre, Node next, T value) {
        this.pre = pre;
        this.next = next;
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}