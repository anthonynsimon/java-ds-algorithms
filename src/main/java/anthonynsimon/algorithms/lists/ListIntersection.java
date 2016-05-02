package anthonynsimon.algorithms.lists;

import anthonynsimon.datastructures.SinglyNode;

public class ListIntersection<E> {
  
  // Returns the node where two singly linked lists intersect, if any
  // Time complexity O(N + M), space: O(1)
  public SinglyNode<E> getIntersectionNode(SinglyNode<E> headListA, SinglyNode<E> headListB) {
    // Each list should have at least one node to intersect
    if (headListA == null || headListB == null) {
        return null;
    }
    
    SinglyNode<E> pointerA = headListA;
    SinglyNode<E> pointerB = headListB;
    
    int lenA = 1;
    int lenB = 1;
    
    // Find last node of each and count
    while (pointerA.getNext() != null) {
        pointerA = pointerA.getNext();
        lenA++;
    }
    
    while (pointerB.getNext() != null) {
        pointerB = pointerB.getNext();
        lenB++;
    }
    
    // Return null if last nodes don't match (lists don't intersect)
    if (pointerA != pointerB) {
        return null;
    }
    
    // Find which list is longer and pick head of that
    SinglyNode<E> longerListHead = lenA > lenB ? headListA : headListB;
    SinglyNode<E> shorterListHead = lenA > lenB ? headListB : headListA;
    
    // Calculate the difference in list length for the offset
    int lengthDiff = Math.abs(lenA - lenB);
    
    // Offset the longer list pointer
    while (lengthDiff > 0) {
        longerListHead = longerListHead.getNext();
        lengthDiff--;
    }
    
    // Move the pointers to where both lists have the same number
    // of remaining nodes
    pointerA = longerListHead;
    pointerB = shorterListHead;
    
    // Move through the lists until intersection is found
    while (pointerA != null) {
        if (pointerA == pointerB) {
            return pointerA;
        }
        pointerA = pointerA.getNext();
        pointerB = pointerB.getNext();
    }

    return null;
  }
}