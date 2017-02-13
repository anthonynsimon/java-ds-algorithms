package com.anthonynsimon.algorithms.stacksqueues;

import com.anthonynsimon.datastructures.Stack;

// Sorts a Stack with the constraint of using only one additional Stack
// For exercise purposes, no other data structure is used
// For that reason this algorithm is of O(N2) time complexity
public final class StackSorter<T extends Comparable<T>> {

    public void sort(Stack<T> originalStack) {
        Stack<T> helperStack = new Stack<>();

        // Move elements to helper stack while sorting them
        // Will move elements back and forth between the original stack
        // and the helper stack
        while (originalStack.size() > 0) {
            // Hold the current element to sort
            T temp = originalStack.pop();

            // Push into our original stack any items from the helper stack that
            // are larger than the current one
            while ((helperStack.size() > 0) && (helperStack.peek().compareTo(temp) > 0)) {
                originalStack.push(helperStack.pop());
            }

            // Place the current element where it belongs
            helperStack.push(temp);
        }

        // Move the now ordered elements back to original stack
        // Reverses the order, top of original stack has smallest element
        while (helperStack.size() > 0) {
            originalStack.push(helperStack.pop());
        }
    }
}