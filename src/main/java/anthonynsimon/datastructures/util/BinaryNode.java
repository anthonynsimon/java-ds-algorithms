package anthonynsimon.datastructures.util;

public class BinaryNode<T> {
  protected T data;
  protected BinaryNode<T> left;
  protected BinaryNode<T> right;
  
  public BinaryNode(T data) {
    this.data = data;
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
  
  public void setData(T data) {
    this.data = data;
  }
  
  public void setLeft(BinaryNode<T> newNode) {
    this.left = newNode;
  }
  
  public void setRight(BinaryNode<T> newNode) {
    this.right = newNode;
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
}