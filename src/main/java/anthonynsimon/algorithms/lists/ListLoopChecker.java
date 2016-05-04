package anthonynsimon.algorithms.lists;

import anthonynsimon.datastructures.SinglyNode;
import java.util.HashSet;

public class ListLoopChecker<E> {
  
  public SinglyNode<E> listHasLoopAt(SinglyNode<E> head) {
    HashSet<SinglyNode<E>> seenNodes = new HashSet<>();
    SinglyNode<E> current = head;
    
    // Traverse the list
    while (current != null) {
      // If node has already been seen (reference), then this is
      // the start of the loop
      if (seenNodes.contains(current)) {
        return current;
      }
      
      // If this is the first time seen the node, then add to 
      // seen nodes and keep moving
      seenNodes.add(current);
      current = current.getNext();
    }
    
    // If we got out of the loop then we reached the end of 
    // the linked list and so there is no loop
    return current;
  }
}