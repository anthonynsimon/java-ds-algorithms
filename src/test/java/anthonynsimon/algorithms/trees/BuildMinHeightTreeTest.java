package anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

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
    
    BinarySearchTree<Integer> expected = new BinarySearchTree<>();
    
    assertEquals(expected.toString(), actual.toString());
  }
  
  @Test
  public void testOne() {
    BinarySearchTree<Integer> actual = classUnderTest.build(new int[]{7});
    
    BinarySearchTree<Integer> expected = new BinarySearchTree<>();
    expected.insert(7);
    
    assertEquals(expected.toString(), actual.toString());
  }
  
  //TODO(anthonynsimon): assert by height once the calc height algorithm is ready
  
  @Test
  public void testEvenNumber() {
    BinarySearchTree<Integer> actual = classUnderTest.build(new int[]{1, 2, 3, 4, 5, 6});
    
    BinarySearchTree<Integer> expected = new BinarySearchTree<>();
    expected.insert(3);
    expected.insert(1);
    expected.insert(5);
    expected.insert(2);
    expected.insert(4);
    expected.insert(6);
    
    assertEquals(expected.toString(), actual.toString());
  }

  @Test
  public void testOddNumber() {
    BinarySearchTree<Integer> actual = classUnderTest.build(new int[]{1, 2, 3, 4, 5});
    
    BinarySearchTree<Integer> expected = new BinarySearchTree<>();
    expected.insert(3);
    expected.insert(1);
    expected.insert(5);
    expected.insert(2);
    expected.insert(4);
    
    assertEquals(expected.toString(), actual.toString());
  }
  
  @Test
  public void testUnsorted() {
    BinarySearchTree<Integer> actual = classUnderTest.build(new int[]{5, 4, 1, 2, 3});
    
    BinarySearchTree<Integer> expected = new BinarySearchTree<>();
    expected.insert(3);
    expected.insert(1);
    expected.insert(5);
    expected.insert(2);
    expected.insert(4);
    
    assertEquals(expected.toString(), actual.toString());
  }
}