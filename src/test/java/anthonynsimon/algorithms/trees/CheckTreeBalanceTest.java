package anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

import anthonynsimon.datastructures.BinarySearchTree;

public class CheckTreeBalanceTest {
  
  private CheckTreeBalance classUnderTest;
  private BinarySearchTree<String> tree;
  
  @Before
  public void setUp() {
    classUnderTest = new CheckTreeBalance();
    tree = new BinarySearchTree<>();
  }
  
  @Test
  public void testEmpty() {
    assertTrue(classUnderTest.isTreeBalanced(tree));
  }
  
  @Test
  public void testOneNode() {
    tree.insert("a");
    
    assertTrue(classUnderTest.isTreeBalanced(tree));
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
    
    assertTrue(classUnderTest.isTreeBalanced(tree));
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
    
    assertTrue(classUnderTest.isTreeBalanced(tree));
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
    
    assertFalse(classUnderTest.isTreeBalanced(tree));
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
    
    assertTrue(classUnderTest.isTreeBalanced(tree));
  }
  
  /*
  *
  *         d
  *       /   \
  *      c     e
  *     /       \
  *    b         f
  *   /           \
  *  a             g
  *
  */
  @Test
  public void testIncompleteUnbalanced() {
    tree.insert("d");
    tree.insert("c");
    tree.insert("e");
    tree.insert("b");
    tree.insert("f");
    tree.insert("a");
    tree.insert("g");
    
    assertFalse(classUnderTest.isTreeBalanced(tree));
  }
}