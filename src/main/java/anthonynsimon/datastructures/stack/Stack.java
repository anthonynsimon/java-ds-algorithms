package anthonynsimon.datastructures.stack;

import anthonynsimon.datastructures.common.SinglyNode;

public class Stack<E> {
  
  protected int size;
  protected SinglyNode<E> top;
  
  public Stack() {
    this.size = 0;
    this.top = null;
  }
  
  public int size() {
    return this.size;
  }
  
  public E peek() {
    return this.top != null ? this.top.getData() : null;
  }
  
  public void push(E data) {
    SinglyNode<E> newNode = new SinglyNode<E>(data);
    
    if (this.top == null) {
      this.top = newNode;
    }
    else {
      newNode.setNext(this.top);
      this.top = newNode;
    }
    
    this.size++;
  }
  
  public E pop() {
    if (size() == 0) {
      return null;
    }
    
    E data = this.top.getData();
    this.top = this.top.getNext();
    this.size--;
    
    return data;
  }
  
  public void clear() {
    this.top = null;
    this.size = 0;
  }
}