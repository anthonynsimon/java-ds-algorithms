package anthonynsimon.algorithms.lists;

import anthonynsimon.datastructures.common.SinglyNode;
import anthonynsimon.datastructures.linkedlist.LinkedList;

public class ListPalindromeChecker<E> extends LinkedList<E> {
  
  public boolean isPalindrome() {
    if (this.head == null) {
      return false;
    }
    
    SinglyNode<E> current = this.head;
    for (int i = 0; i < size() / 2; i++) {
      if (current.getData() != this.get(size() -1 -i)) {
        return false;
      }
      current = current.getNext();
    }
    return true;
  }
}