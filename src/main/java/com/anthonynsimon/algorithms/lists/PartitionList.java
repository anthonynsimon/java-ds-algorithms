package com.anthonynsimon.algorithms.lists;

public final class PartitionList {

    // Partitions the list so that all elements smaller than
    // the pivot appear before any other element.
    // Unstable, order is not guaranteed
    public Node partition(Node head, int pivot) {
        Node partitionHead = head;
        Node tail = head;

        // Setup our runner reference
        Node current = head;
        while (current != null) {
            // Keep a reference to the next node in line
            Node next = current.next;

            // If it matches the partition criteria, then point the
            // current node to the first element and make it the new head
            if (current.value < pivot) {
                current.next = partitionHead;
                partitionHead = current;
            }
            // If not, then set it as the new tail
            else {
                tail.next = current;
                tail = tail.next;
            }

            // Continue with the next node to be evaluated
            current = next;
        }

        // Once we are done, the tail node could be pointing back into the list
        // disconnect it to avoid circular references
        tail.next = null;

        // Return the new head
        return partitionHead;
    }

    public void traverse(Node head) {
        Node current = head;

        while (current != null) {
            System.out.printf("%d -> ", current.value);
            current = current.next;
        }

        System.out.println("null");
    }

    // Helper class
    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}