package com.anthonynsimon.algorithms.stacksqueues;

import com.anthonynsimon.datastructures.Stack;

// Holds multiple stacks in one stack
// Will push elements to a new stack if current stack
// is larger than the defined cap per stack
public class StackOfStacks<E> {

    private int size;
    private int cap;
    private Stack<Stack<E>> master;

    public StackOfStacks(int cap) {
        if (cap <= 0) {
            throw new IndexOutOfBoundsException("Must be of at least 1 slot cap per stack");
        }

        this.cap = cap;
        this.master = new Stack<>();
    }

    // Adds a new item to the top stack
    public void push(E item) {
        // Ensure we have a stack with enough space before pushing item
        ensureCapacity();
        getCurrentStack().push(item);
        this.size++;
    }

    // Pops and returns top item from top stack
    public E pop() {
        E temp = getCurrentStack().pop();
        // Cleanup master stack if necessary
        settle();
        this.size--;
        return temp;
    }

    // Returns top item of top stack
    public E peek() {
        return getCurrentStack().peek();
    }

    // Returns number of items held across all stacks
    public int size() {
        return this.size;
    }

    // Returns the number of stacks being managed
    public int stackCount() {
        return this.master.size();
    }

    private Stack<E> getCurrentStack() {
        return this.master.peek();
    }

    // Check if we already filled the current stack,
    // if so then create new stack and push it to master
    private void ensureCapacity() {
        if (master.size() == 0) {
            addStackToMaster();
        }

        if (getCurrentStack().size() == cap) {
            addStackToMaster();
        }
    }

    // Check if we already emptied the current stack,
    // if so then pop it from the master
    private void settle() {
        if (getCurrentStack().size() == 0) {
            this.master.pop();
        }
    }

    private void addStackToMaster() {
        Stack<E> newStack = new Stack<>();
        this.master.push(newStack);
    }
}