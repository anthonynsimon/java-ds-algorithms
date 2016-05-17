package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.BinaryNode;

public class BinarySearchTree<T extends Comparable<T>> {
  
  protected BinaryNode<T> root;
  protected int size;
  
  public BinarySearchTree() {
    this.size = 0;
  }
  
  public void insert(T data) {
    insertWorker(data, this.root);
  }
  
  public T find(T data) {
    return findWorker(data, this.root);
  }
  
  public void remove(T data) {
    removeWorker(data, this.root);
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
  
  private void insertWorker(T data, BinaryNode<T> node) {
    if (node == null) {
      this.root = new BinaryNode<T>(data, null);
      this.size++;
    }
    else if (node.getData().compareTo(data) < 0) {
      if (node.hasRightChild()) {
        insertWorker(data, node.getRight());
      }
      else {
        node.setRight(new BinaryNode<T>(data, node));
        this.size++;
      }
    }
    else {
      if (node.hasLeftChild()) {
        insertWorker(data, node.getLeft());
      }
      else {
        node.setLeft(new BinaryNode<T>(data, node));
        this.size++;
      }
    }
  }
  
  private T findWorker(T data, BinaryNode<T> node) {
    if (node == null) {
      return null;
    }
    
    if (node.getData() == data) {
      return data;
    }
    else if (node.getData().compareTo(data) < 0) {
      return findWorker(data, node.getRight());
    }
    else {
      return findWorker(data, node.getLeft());
    }
  }
  
  private void removeWorker(T data, BinaryNode<T> node) {
    if (node == null) {
      return;
    }
    
    if (node.getData() == data) {
      if (node.hasAnyChildren()) {
        if (node.hasBothChildren()) {
          BinaryNode<T> maxChildLeft = findMaxChild(node.getLeft());
          removeWorker(maxChildLeft.getData(), node.getLeft());
          node.setData(maxChildLeft.getData());
        }
        else {
          if (node.hasLeftChild()) {
            if (node.isRoot()) {
              this.root = node.getLeft();
            }
            else if (node.isLeftChild()) {
              node.getParent().setLeft(node.getLeft());
            }
            else {
              node.getParent().setRight(node.getLeft());
            }
          }
          else {
            if (node.isRoot()) {
              this.root = node.getRight();
            }
            else if (node.isLeftChild()) {
              node.getParent().setLeft(node.getRight());
            }
            else {
              node.getParent().setRight(node.getRight());
            }
          }
        }
      }
      else {
        if (node.isRoot()) {
          this.root = null;
        }
        else if (node.isLeftChild()) {
          node.getParent().setLeft(null);
        }
        else {
          node.getParent().setRight(null);
        }
      }
      
      this.size--;
    }
    else if (node.getData().compareTo(data) < 0){
      removeWorker(data, node.getRight());
    }
    else {
      removeWorker(data, node.getLeft());
    }
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
    else if (node.hasRightChild()) {
      return findMaxChild(node.getRight());
    }
    
    return node;
  }
}