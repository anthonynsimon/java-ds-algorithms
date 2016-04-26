package anthonynsimon.datastructures.linkedlist;

public class LinkedList<E> {
  
  private int size;
  private Node<E> head;
  private Node<E> tail;
  
  public LinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }
  
  public int size() {
    return this.size;
  }
  
  public E peek() {
    if (size() == 0) {
      return null;
    }
    
    return this.head.getData();
  }
  
  public void add(E item) {
    // If list is empty, setup initial nodes
    if (size() == 0) {
      this.head = new Node<E>(item);
      this.tail = this.head;
    }
    // If the list is not empty, add new node with item as tail
    else {
      this.tail.setNext(new Node<E>(item));
      this.tail = this.tail.getNext();
    }
    this.size++;
  }
  
  public E get(int index) {
    if (isOutOfRange(index)) {
      return null;
    }
    
    // Iterate over list and return when found
    int i = 0;
    Node<E> current = this.head;
    while (current != null) {
      if (i == index) {
        return current.getData();
      }
      current = current.getNext();
      i++;
    }
    
    return null;
  }
  
  public void set(int index, E item) {
    if (isOutOfRange(index)) {
      return; // TODO(anthonynsimon): raise error instead and update tests
    }
    
    // Iterate over list and set
    int i = 0;
    Node<E> current = this.head;
    while (current != null) {
      if (i == index) {
        current.setData(item);
        return;
      }
      current = current.getNext();
      i++;
    }
  }
  
  public void insert(int index, E item) {
    if (isOutOfRange(index)) {
      return; // TODO(anthonynsimon): raise error instead and update tests
    }
    
    // Iterate over list and insert
    // We need to keep track of the previous node
    int i = 0;
    Node<E> current = this.head;
    Node<E> previous = null;
    while (current != null) {
      if (i == index) {
        Node<E> newNode = new Node<E>(item);
        
        // If previous node is null, then we are inserting as first element
        if (previous == null) {
          this.head = newNode;
        }
        // If not, then connect previous node with new node
        else {
          previous.setNext(newNode);
        }
        // And reconnect following node
        newNode.setNext(current);
        this.size++;
        return;
      }
      previous = current;
      current = current.getNext();
      i++;
    }
  }
  
  // TODO(anthonynsimon)
  public void remove(int index) {
    
  }
  
  public boolean contains(E item) {
    Node<E> current = this.head;
    while (current != null) {
      if (current.getData() == item) {
        return true;
      }
      current = current.getNext();
    }    
    
    return false;
  }
  
  // TODO(anthonynsimon)
  public E pop() {
    return null;
  }
  
  // TODO(anthonynsimon)
  public void clear() {
    
  }
  
  // TODO(anthonynsimon)
  public <E> E[] toArray() {
    return null;
  }
  
  // TODO(anthonynsimon): add toString method
  
  private boolean isOutOfRange(int index) {
    return index < 0 || size() <= index;
  }
}