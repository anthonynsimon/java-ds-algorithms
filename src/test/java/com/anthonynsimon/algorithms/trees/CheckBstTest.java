package com.anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

import com.anthonynsimon.datastructures.BinarySearchTree;
import com.anthonynsimon.datastructures.util.BinaryNode;

public class CheckBstTest {
  
  private CheckBst<String> classUnderTest;
  private BinarySearchTree<String> tree;
  
  @Before
  public void setUp() {
    classUnderTest = new CheckBst<>();
    tree = new BinarySearchTree<>();
  }
  
  @Test
  public void testEmpty() {
    assertTrue(classUnderTest.isBst(tree));
  }
  
  @Test
  public void testOneNode() {
    tree.insert("a");
    
    assertTrue(classUnderTest.isBst(tree));
  }
  
  
  /*
  *
  *    a
  *      \
  *       b
  *
  */
  @Test
  public void testTwoNodes() {
    tree.insert("a");
    tree.insert("b");
    
    assertTrue(classUnderTest.isBst(tree));
  }
  
  /*
  *
  *        b
  *      /   \
  *     a     c
  *
  */
  @Test
  public void testThreeNodes() {
    tree.insert("b");
    tree.insert("a");
    tree.insert("c");
    
    assertTrue(classUnderTest.isBst(tree));
  }
  
  @Test
  public void testUnbalancedSmall() {
    tree.insert("b");
    tree.insert("a");
    tree.insert("c");
    tree.insert("d");
    tree.insert("e");
    
    /*
    *
    *        b
    *      /   \
    *     a     c
    *            \
    *             d
    *              \
    *               e
    *
    */
    assertTrue(classUnderTest.isBst(tree));
    
    // Corrupt tree
    BinaryNode<String> root = tree.getRootNode();
    String leftData = root.getRight().getData();
    root.getLeft().setData(root.getRight().getData());
    root.getRight().setData(leftData);
    
    /*
    *
    *        b
    *      /   \
    *     c     a
    *            \
    *             d
    *              \
    *               e
    *
    */
    assertFalse(classUnderTest.isBst(tree));
    
    
  }
  
  
  @Test
  public void testPerfectBalanced() {
    tree.insert("d");
    tree.insert("b");
    tree.insert("f");
    tree.insert("a");
    tree.insert("c");
    tree.insert("e");
    tree.insert("g");
    
    /*
    *
    *        d
    *      /   \
    *     b     f
    *    / \   / \
    *   a   c e   g
    *
    */
    
    assertTrue(classUnderTest.isBst(tree));
    
    // Corrupt tree
    BinaryNode<String> node = tree.getRootNode().getRight();
    String leftData = node.getRight().getData();
    node.getLeft().setData(node.getRight().getData());
    node.getRight().setData(leftData);
    
    /*
    *
    *        d
    *      /   \
    *     b     f
    *    / \   / \
    *   a   c g   e
    *
    */
    
    assertFalse(classUnderTest.isBst(tree));
  }
}