package com.anthonynsimon.algorithms.lists;

import com.anthonynsimon.datastructures.LinkedList;
import com.anthonynsimon.datastructures.util.SinglyNode;

public final class FindKthToLast<E> extends LinkedList<E> {

    // Finds the kth to last element and returns it.
    // Assume that list size is unknown, otherwise it would be
    // a trivial (size -1 -Kth) search
    public E findKthToLast(int kth) {
        // Make sure value is positive, we cannot have a value that is '-1th' before the last
        kth = Math.abs(kth);

        SinglyNode<E> runner = this.head;
        SinglyNode<E> laggard = this.head;

        for (int i = 0; i <= kth; i++) {
            // If runner is null before reaching kth index,
            // return null as list is smaller than K
            if (runner == null) {
                return null;
            }
            runner = runner.getNext();
        }

        while (runner != null) {
            runner = runner.getNext();
            laggard = laggard.getNext();
        }

        return laggard.getData();
    }
}