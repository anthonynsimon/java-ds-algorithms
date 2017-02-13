package com.anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

import com.anthonynsimon.datastructures.BinarySearchTree;

public class SuccessorFinderTest {
  
  private SuccessorFinder<String> classUnderTest;
  private BinarySearchTree<String> tree;
  
  @Before
  public void setUp() {
    classUnderTest = new SuccessorFinder<>();
    tree = new BinarySearchTree<>();
  }
  
  @Test
  public void testEmpty() {
    assertEquals(classUnderTest.findSuccessorOf("a", tree), null);
  }
  
  @Test
  public void testOneNode() {
    tree.insert("a");
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), null);
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
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), "b");
    assertEquals(classUnderTest.findSuccessorOf("b", tree), null);
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
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), "b");
    assertEquals(classUnderTest.findSuccessorOf("b", tree), "c");
    assertEquals(classUnderTest.findSuccessorOf("c", tree), null);
  }
  
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
  @Test
  public void testUnbalancedSmall() {
    tree.insert("b");
    tree.insert("a");
    tree.insert("c");
    tree.insert("d");
    tree.insert("e");
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), "b");
    assertEquals(classUnderTest.findSuccessorOf("b", tree), "c");
    assertEquals(classUnderTest.findSuccessorOf("c", tree), "d");
    assertEquals(classUnderTest.findSuccessorOf("e", tree), null);
  }
  
  /*
  *
  *        d
  *      /   \
  *     b     f
  *    / \   / \
  *   a   c e   g
  *
  */
  @Test
  public void testPerfectBalanced() {
    tree.insert("d");
    tree.insert("b");
    tree.insert("f");
    tree.insert("a");
    tree.insert("c");
    tree.insert("e");
    tree.insert("g");
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), "b");
    assertEquals(classUnderTest.findSuccessorOf("c", tree), "d");
    assertEquals(classUnderTest.findSuccessorOf("g", tree), null);
    assertEquals(classUnderTest.findSuccessorOf("e", tree), "f");
    assertEquals(classUnderTest.findSuccessorOf("f", tree), "g");
  }
  
  /*
  *
  *         f
  *       /   \
  *      c     g
  *     / \     \
  *    b   d     h
  *   /     \     \
  *  a       e     i
  *
  */
  @Test
  public void testIncompleteUnbalanced() {
    tree.insert("f");
    tree.insert("c");
    tree.insert("g");
    tree.insert("b");
    tree.insert("d");
    tree.insert("a");
    tree.insert("e");
    tree.insert("h");
    tree.insert("i");
    
    assertEquals(classUnderTest.findSuccessorOf("a", tree), "b");
    assertEquals(classUnderTest.findSuccessorOf("e", tree), "f");
    assertEquals(classUnderTest.findSuccessorOf("h", tree), "i");
    assertEquals(classUnderTest.findSuccessorOf("e", tree), "f");
  }
}