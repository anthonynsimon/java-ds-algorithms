package anthonynsimon.datastructures.util;

public class BinaryNode<T> {
  protected T data;
  protected BinaryNode<T> left;
  protected BinaryNode<T> right;
  protected BinaryNode<T> parent;
  
  public BinaryNode(T data, BinaryNode<T> parent) {
    this.data = data;
    this.parent = parent;
  }
  
  public T getData() {
    return this.data;
  }
  
  public BinaryNode<T> getLeft() {
    return this.left;
  }
  
  public BinaryNode<T> getRight() {
    return this.right;
  }
  
  public BinaryNode<T> getParent() {
    return this.parent;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public void setLeft(BinaryNode<T> newNode) {
    this.left = newNode;
  }
  
  public void setRight(BinaryNode<T> newNode) {
    this.right = newNode;
  }
  
  public void setParent(BinaryNode<T> newParent) {
    this.parent = newParent;
  }
  
  public boolean hasAnyChildren() {
    return this.left != null || this.right != null;
  }
  
  public boolean hasBothChildren() {
    return this.left != null && this.right != null;
  }

  public boolean hasLeftChild() {
    return this.left != null;
  }

  public boolean hasRightChild() {
    return this.right != null;
  }
  
  public boolean isLeftChild() {
    if (this.parent != null) {
      return this.parent.getLeft() == this;
    }
    return false;
  }
  
  public boolean isRightChild() {
    if (this.parent != null) {
      return this.parent.getRight() == this;
    }
    return false;
  }
  
  public boolean isRoot() {
    return this.parent == null;
  }
}