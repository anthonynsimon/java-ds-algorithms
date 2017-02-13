package com.anthonynsimon.algorithms.stacksqueues;

import com.anthonynsimon.datastructures.Stack;

// Uses two stacks to implement a queue
public class QueueViaStacks<E> {

    private Stack<E> newestStack;
    private Stack<E> oldestStack;

    public QueueViaStacks() {
        this.newestStack = new Stack<>();
        this.oldestStack = new Stack<>();
    }

    // Enqueues a new element by shifting all elements to
    // a "newest at top" stack, and pushing to it the item
    public void enqueue(E item) {
        shiftToNewest();
        this.newestStack.push(item);
    }

    // Dequeue by shifting all elements to
    // an "oldest at top" stack, and popping the top item
    public E dequeue() {
        if (size() == 0) {
            return null;
        }

        shiftToOldest();

        return this.oldestStack.pop();
    }

    // Peeks by shifting all elements to
    // an "oldest at top" stack, and peeking the top item
    public E peek() {
        if (size() == 0) {
            return null;
        }

        shiftToOldest();

        return this.oldestStack.peek();
    }

    public int size() {
        return this.oldestStack.size() + this.newestStack.size();
    }

    private void shiftToNewest() {
        while (oldestStack.size() != 0) {
            newestStack.push(oldestStack.pop());
        }
    }

    private void shiftToOldest() {
        while (newestStack.size() != 0) {
            oldestStack.push(newestStack.pop());
        }
    }
}