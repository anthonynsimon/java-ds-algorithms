package com.anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

import com.anthonynsimon.datastructures.BinarySearchTree;
import com.anthonynsimon.datastructures.util.BinaryNode;
import java.util.ArrayList;

public class BinaryTreeToListsTest {
  
  private BinarySearchTree<String> tree;
  private BinaryTreeToLists<String> classUnderTest;
  
  @Before
  public void setUp() {
    tree = new BinarySearchTree<>();
    classUnderTest = new BinaryTreeToLists<>();
  }
  
  @Test
  public void testEmpty() {
    ArrayList<ArrayList<BinaryNode<String>>> result = classUnderTest.treeToListsByLevel(tree);
    assertTrue(result.size() == 0);
  }
  
  @Test
  public void testOne() {
    tree.insert("hello");
    
    ArrayList<ArrayList<BinaryNode<String>>> result = classUnderTest.treeToListsByLevel(tree);
    
    assertTrue(result.size() == 1);
         
    assertTrue(result.get(0).get(0).getData() == "hello");
  }
    
  @Test
  public void testManyLevels() {
    tree.insert("hello");
    tree.insert("ab");
    tree.insert("cd");
    tree.insert("test");
    tree.insert("zat");
    tree.insert("taz");
    
    ArrayList<ArrayList<BinaryNode<String>>> result = classUnderTest.treeToListsByLevel(tree);
    
    assertTrue(result.size() == 3);
    assertTrue(result.get(0).get(0).getData() == "hello");
    assertTrue(result.get(1).get(0).getData() == "ab");
    assertTrue(result.get(1).get(1).getData() == "test");
    assertTrue(result.get(2).get(0).getData() == "cd");
    assertTrue(result.get(2).get(1).getData() == "taz");
    assertTrue(result.get(2).get(2).getData() == "zat");
  }

  @Test
  public void testOneChildPerLevel() {
    tree.insert("a");
    tree.insert("b");
    tree.insert("c");
    tree.insert("d");
    tree.insert("e");
    tree.insert("f");
    
    ArrayList<ArrayList<BinaryNode<String>>> result = classUnderTest.treeToListsByLevel(tree);
    
    assertTrue(result.size() == 6);
    assertTrue(result.get(0).get(0).getData() == "a");
    assertTrue(result.get(1).get(0).getData() == "b");
    assertTrue(result.get(2).get(0).getData() == "c");
    assertTrue(result.get(3).get(0).getData() == "d");
    assertTrue(result.get(4).get(0).getData() == "e");
    assertTrue(result.get(5).get(0).getData() == "f");
  }
}