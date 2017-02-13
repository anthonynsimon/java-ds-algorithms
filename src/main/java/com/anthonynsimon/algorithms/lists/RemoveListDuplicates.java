package com.anthonynsimon.algorithms.lists;

import com.anthonynsimon.datastructures.LinkedList;
import com.anthonynsimon.datastructures.util.SinglyNode;

import java.util.HashSet;

public final class RemoveListDuplicates<E> extends LinkedList<E> {

    // Modifies list in place by removing values that appear more than once.
    public void removeDuplicates() {
        // Prepare a simple hash table for keeping track of what
        // values we have already seen. Good for O(1) lookups.
        HashSet<Object> alreadySeen = new HashSet<>();

        SinglyNode<E> previous = null;
        SinglyNode<E> current = this.head;
        while (current != null) {
            E data = current.getData();

            // If we have already seen the current value, then remove it
            if (alreadySeen.contains(data)) {
                // We don't have to worry about the the case when previous
                // is null as we cannot have already "seen" the first node.
                previous.setNext(current.getNext());
                this.size--;
            }
            // If it's the first time we see the value, then add it to our hash table
            else {
                alreadySeen.add(data);
            }

            previous = current;
            current = current.getNext();
        }
    }
}