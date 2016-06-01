package anthonynsimon.algorithms.trees;

import anthonynsimon.datastructures.BinarySearchTree;
import anthonynsimon.datastructures.util.BinaryNode;

public class CheckBst<T extends Comparable<T>> {
  // Helper class to keep track of the tree's properties
  class Result<T> {
    public boolean isBst = true;
    public T lastValue = null;
  }
  
  // Returns if the provided tree fulfills the BST property
  public boolean isBst(BinarySearchTree<T> tree) {
    if (tree == null) {
      return false;
    }
    
    BinaryNode root = tree.getRootNode();
    Result<T> result = new Result<>();
    
    recursivelyCheck(root, result);
    
    return result.isBst;
  }
  
  // Traverses the tree in-order, keeping track of the values and checking if they are sequential
  private void recursivelyCheck(BinaryNode<T> node, Result<T> result) {
    if (node == null) {
      return;
    }
    
    recursivelyCheck(node.getLeft(), result);
    
    if (result.lastValue == null || node.getData().compareTo(result.lastValue) >= 0) {
      result.lastValue = node.getData();
    }
    else {
      result.isBst = false;
      return;
    }
    
    recursivelyCheck(node.getRight(), result);
  }
}