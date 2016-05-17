package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.BinaryNode;

public class BinarySearchTree<T extends Comparable<T>> {
  
  protected BinaryNode<T> root;
  protected int size;
  
  public BinarySearchTree() {
    this.size = 0;
  }
  
  public void insert(T data) {
    BinaryNode<T> current = this.root;
    BinaryNode<T> newNode = new BinaryNode<>(data);
    
    if (size() == 0) {
      this.root = new BinaryNode<T>(data);
      this.size++;
      return;
    }
    
    while (current != null) {
      if (current.getData().compareTo(data) < 0) {
        if (current.getRight() == null) {
          current.setRight(newNode);
          this.size++;
          return;
        }
        current = current.getRight();
      }
      else {
        if (current.getLeft() == null) {
          current.setLeft(newNode);
          this.size++;
          return;
        }
        current = current.getLeft();
      }
    }
  }
  
  public T find(T data) {
    if (isEmpty()) {
      return null;
    }
    
    BinaryNode<T> current = this.root;
    
    while (current != null) {
      if (current.getData() == data) {
        return current.getData();
      }
      
      if (current.getData().compareTo(data) < 0) {
        current = current.getRight();
      }
      else {
        current = current.getLeft();
      }
    }
    
    return null;
  }
  
  public void remove(T data) {
    if (isEmpty()) {
      return;
    }
    
    BinaryNode<T> current = this.root;
    BinaryNode<T> previous = null;
    
    while (current != null) {
      if (current.getData() == data) {
        if (current.hasBothChildren()) {
          BinaryNode<T> maxChildLeft = findMaxChild(current.getLeft());
          remove(maxChildLeft.getData());
          current.setData(maxChildLeft.getData());
        }
        else if (current.hasAnyChildren()){
          if (current.getLeft() != null) {
            if (previous == null) {
              this.root = current.getLeft();
            }
            else {
              if (previous.getLeft() == current) {
                previous.setLeft(current.getLeft());
              }
              else {
                previous.setRight(current.getLeft());
              }
            }
          }
          else if (current.getRight() != null) {
            if (previous == null) {
              this.root = current.getRight();
            }
            else {
              if (previous.getLeft() == current) {
                previous.setLeft(current.getRight());
              }
              else {
                previous.setRight(current.getRight());
              }
            }
          }
        }
        else {
          if (previous == null) {
            this.root = null;
          }
          else {
            if (previous.getLeft() == current) {
              previous.setLeft(null);
            }
            else {
              previous.setRight(null);
            }
          }
        }
        
        this.size--;
        return;
      }
      
      previous = current;
      if (current.getData().compareTo(data) < 0) {
        current = current.getRight();
      }
      else {
        current = current.getLeft();
      }
    }
  }
  
  public int size() {
    return this.size;
  }
  
  public void clear() {
    this.root = null;
    this.size = 0;
  }
  
  public boolean isEmpty() {
    return this.size == 0;
  }
  
  public String toString() {
    return toString(", ");
  }
  
  public String toString(String separator) {
    StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append("[");
    stringBuilder = toStringWorker(this.root, separator, stringBuilder);
    stringBuilder.setLength(stringBuilder.length() - separator.length());
    stringBuilder.append("]");
    
    
    return stringBuilder.toString();
  }
  
  private StringBuilder toStringWorker(BinaryNode<T> node, String separator, StringBuilder stringBuilder) {
    if (node == null) {
      return stringBuilder;
    }
    
    if (node.getLeft() != null) {
      stringBuilder = toStringWorker(node.getLeft(), separator, stringBuilder);
    }
    
    stringBuilder.append(node.getData());
    stringBuilder.append(separator);
    
    if (node.getRight() != null) {
      stringBuilder = toStringWorker(node.getRight(), separator, stringBuilder);
    }
    
    return stringBuilder;
  }
  
  private BinaryNode<T> findMaxChild(BinaryNode<T> node) {
    if (node == null) {
      return null;
    }
    
    while (node.hasRightChild()) {
      node = node.getRight();
    }
    
    return node;
  }
}