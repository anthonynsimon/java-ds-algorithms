package com.anthonynsimon.algorithms.lists;

import com.anthonynsimon.datastructures.util.SinglyNode;

public final class ListIntersection<E> {

    // Returns the node where two singly linked lists intersect, if any
    // Time complexity O(N + M), space: O(1)
    public SinglyNode<E> getIntersectionNode(SinglyNode<E> headListA, SinglyNode<E> headListB) {
        // Each list should have at least one node
        if (headListA == null || headListB == null) {
            return null;
        }

        // Traverse both lists to get last node and count
        Result resultA = getLastNodeAndSize(headListA);
        Result resultB = getLastNodeAndSize(headListB);

        // Return null if last nodes don't match (lists don't intersect)
        if (resultA.node != resultB.node) {
            return null;
        }

        // Find which list is longer and which is shorter
        SinglyNode<E> longer = resultA.size > resultB.size ? headListA : headListB;
        SinglyNode<E> shorter = resultA.size > resultB.size ? headListB : headListA;

        // Calculate the difference in list length for the offset
        int difference = Math.abs(resultA.size - resultB.size);

        // Offset the longer list pointer
        while (difference > 0) {
            longer = longer.getNext();
            difference--;
        }

        // Now both pointers have the same number of next nodes
        // Move through the lists until intersection is found
        while (longer != shorter) {
            longer = longer.getNext();
            shorter = shorter.getNext();
        }

        return longer;
    }

    // Traverses the list until last node is found while counting
    // the number of nodes touched
    private Result<E> getLastNodeAndSize(SinglyNode<E> start) {
        if (start == null) {
            return new Result<>(null, 0);
        }

        int size = 1;
        SinglyNode<E> current = start;
        while (current.getNext() != null) {
            current = current.getNext();
            size++;
        }

        return new Result<>(current, size);
    }

    // Helper class for finding last node of list while counting
    // the number of nodes touched
    class Result<E> {
        SinglyNode<E> node;
        int size;

        public Result(SinglyNode<E> node, int size) {
            this.node = node;
            this.size = size;
        }
    }
}