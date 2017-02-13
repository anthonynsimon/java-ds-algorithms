package com.anthonynsimon.datastructures.util;

public class SinglyNode<T> {

    private T data;
    private SinglyNode<T> next;

    public SinglyNode(T data) {
        this.data = data;
        this.next = null;
    }

    public SinglyNode(T data, SinglyNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyNode<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }
}