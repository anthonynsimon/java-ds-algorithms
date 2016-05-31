package anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;

import anthonynsimon.datastructures.BinarySearchTree;

public class BuildMinHeightTreeTest {
  
  private BuildMinHeightTree classUnderTest;
  
  @Before
  public void setUp() {
    classUnderTest = new BuildMinHeightTree();
  }
  
  @Test
  public void testEmpty() {
    BinarySearchTree<Integer> actual = classUnderTest.build(new int[]{});   
     
    assertEquals(actual.getHeight(), calculateMinHeight(0));
  }
  
  @Test
  public void testOne() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateOrderedArray(1));
    
    assertEquals(actual.getHeight(), calculateMinHeight(1));
  }
    
  @Test
  public void testEvenNumber() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateOrderedArray(4));
    
    assertEquals(actual.getHeight(), calculateMinHeight(4));
  }

  @Test
  public void testOddNumber() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateOrderedArray(5));
    
    assertEquals(actual.getHeight(), calculateMinHeight(5));
  }
  
  @Test
  public void testUnsorted() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateRandomArray(5));
    
    assertTrue(calculateMinHeight(5) - actual.getHeight() <= 1);
  }
  
  @Test
  public void testUnsortedLarge() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateRandomArray(2048));
    
    int actualHeight = actual.getHeight();
    
    assertTrue(calculateMinHeight(2048) < actualHeight);
    assertTrue(actualHeight < calculateMaxHeight(2048));
  }
  
  @Test
  public void testSortedLarge() {
    BinarySearchTree<Integer> actual = classUnderTest.build(generateOrderedArray(2048));
    
    assertEquals(actual.getHeight(), calculateMinHeight(2048));
  }
  
  // Helper method to calculate minimum possible height for complete BST
  private int calculateMinHeight(int n) {
    if (n <= 0) {
      return 0;
    }
    
    return (int)(Math.log(n) / Math.log(2));
  }
  
  private int calculateMaxHeight(int n) {
    return n - 1;
  }
  
  private int[] generateOrderedArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = i;
    }
    return result;
  }
  
  private int[] generateRandomArray(int size) {
    int[] result = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
      result[i] = rand.nextInt(size);
    }
    return result;
  }
}