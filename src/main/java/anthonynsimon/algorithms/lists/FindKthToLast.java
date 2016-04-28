package anthonynsimon.algorithms.lists;

import anthonynsimon.datastructures.linkedlist.Node;
import anthonynsimon.datastructures.linkedlist.LinkedList;

public class FindKthToLast<E> extends LinkedList<E> {
  
  // Finds the kth to last element and returns it.
  // Assume that list size is unkown, otherwise it would be
  // a trivial (size -1 -Kth) search
  public E findKthToLast(int kth) {
    Node<E> runner = this.head;
    Node<E> laggard = this.head;
    
    for (int i = 0; i <= kth; i++) {
      // If runner is null before reaching kth index,
      // return null as list is smaller than K
      if (runner == null) {
        return null;
      }
      runner = runner.getNext();
    }
    
    while (runner != null) {
      runner  = runner.getNext();
      laggard = laggard.getNext();
    }
    
    return laggard.getData();
  }
  
}