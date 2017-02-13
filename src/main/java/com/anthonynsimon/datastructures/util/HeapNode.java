package com.anthonynsimon.datastructures.util;

public class HeapNode<T> {

    public int priority;
    public T data;

    public HeapNode(int priority, T data) {
        this.priority = priority;
        this.data = data;
    }

    public String toString() {
        return "HeapNode priority: " + priority + " data: " + data;
    }
}