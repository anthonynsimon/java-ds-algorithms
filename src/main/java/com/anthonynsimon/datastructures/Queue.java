package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.SinglyNode;

public class Queue<E> {

    protected int size;
    protected SinglyNode<E> head;
    protected SinglyNode<E> tail;

    public Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (size() == 0) {
            return null;
        }

        return this.head.getData();
    }

    // Append element to the tail (back) of the queue.
    // Move tail pointer to this new element.
    public void enqueue(E item) {
        SinglyNode<E> newNode = new SinglyNode<>(item);

        if (size() == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    // Pop and return element from the head (front) of the queue.
    // Move head pointer to next element in line.
    public E dequeue() {
        if (size() == 0) {
            return null;
        }

        E temp = this.head.getData();

        if (size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
        }

        this.size--;

        return temp;
    }

    public void clear() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}