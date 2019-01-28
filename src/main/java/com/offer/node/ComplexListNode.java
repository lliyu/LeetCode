package com.offer.node;

/**
 * @Auther: Administrator
 * @Date: 2019-01-24 18:52
 * @Description:
 */
public class ComplexListNode<T> {
    private T value;
    private ComplexListNode next;
    private ComplexListNode sibling;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getSibling() {
        return sibling;
    }

    public void setSibling(ComplexListNode sibling) {
        this.sibling = sibling;
    }
}
