package anthonynsimon.algorithms.trees;

import anthonynsimon.datastructures.BinarySearchTree;
import anthonynsimon.datastructures.util.BinaryNode;
import anthonynsimon.datastructures.Queue;
import java.util.ArrayList;

public class BinaryTreeToLists<T> {
  
  public ArrayList<ArrayList<BinaryNode<T>>> treeToListsByLevel(BinarySearchTree tree) {
    ArrayList<ArrayList<BinaryNode<T>>> results = new ArrayList<>();
    
    if (tree.size() == 0) {
      return results;
    }
    
    Queue<BinaryNode<T>> queue = new Queue<>();
    
    queue.enqueue(tree.getRootNode());
    
    while (!queue.isEmpty()) {
      ArrayList<BinaryNode<T>> level = new ArrayList<>();
      
      while (!queue.isEmpty()) {
        level.add(queue.dequeue());
      }
      
      results.add(level);
      
      for (BinaryNode<T> node : level) {
        if (node.hasLeftChild()) {
          queue.enqueue(node.getLeft());
        }
        if (node.hasRightChild()) {
          queue.enqueue(node.getRight());
        }
      }
    }
    
    return results;
  }
}