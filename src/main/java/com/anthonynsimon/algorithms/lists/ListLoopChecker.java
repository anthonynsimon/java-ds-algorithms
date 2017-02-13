package com.anthonynsimon.algorithms.lists;

import com.anthonynsimon.datastructures.util.SinglyNode;

public final class ListLoopChecker<E> {

    // Returns the node where a loop starts, and null if no loop was found
    // Time complexity O(N), space complexity O(1)
    public SinglyNode<E> listHasLoopAt(SinglyNode<E> head) {
        SinglyNode<E> fast = head;
        SinglyNode<E> slow = head;

        int index = 0;
        while (true) {

            if (fast == null) {
                return null;
            }

            // Move the fast pointer on each iteration
            fast = fast.getNext();

            // Move the slow pointer every other iteration
            if (index % 2 == 1) {
                slow = slow.getNext();

                // Every time the slow pointer moves,
                // check to see if they meet and break the while loop if so
                if (fast == slow) {
                    break;
                }
            }

            index++;
        }

        // At this point we know that the list has a loop
        // Move the fast pointer to the head
        fast = head;

        // Move them at the same speed until they meet,
        // the meeting point is the start of the loop
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return fast;
    }
}