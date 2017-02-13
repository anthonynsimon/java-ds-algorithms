package com.anthonynsimon.algorithms.stacksqueues;

import com.anthonynsimon.datastructures.Stack;

import java.util.EmptyStackException;

public final class MinStack<T extends Comparable<T>> {

    // Keep two stacks, one for the data and one for the current min
// Keeps a history of min elements so we always have O(1) time complexity
// for the push, pop and min methods as we don't have to search for the next
// min every time we pop a data element which is also a min.
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        dataStack.push(item);
        // If the new item is <= to previous min push it to minStack
        if (minStack.size() == 0 || item.compareTo(min()) <= 0) {
            minStack.push(item);
        }
    }

    public T pop() throws EmptyStackException {
        T temp = dataStack.pop();

        if (temp == null) {
            throw new EmptyStackException();
        }

        // If the popped data element is the current min element, then
        // pop from the minStack to sync them
        if (min().compareTo(temp) == 0) {
            minStack.pop();
        }

        return temp;
    }

    public T min() throws EmptyStackException {
        if (minStack.size() == 0) {
            throw new EmptyStackException();
        }

        return minStack.peek();
    }
}