package anthonynsimon.algorithms.stacksqueues;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

public class MinStackTest {
  
  private MinStack classUnderTest;
  
  @Before 
  public void setUp() {
    classUnderTest = new MinStack();
  }
    
  @Test(expected=EmptyStackException.class)
  public void testEmpty() {
    assertEquals(classUnderTest.min(), Integer.MAX_VALUE);
    classUnderTest.pop();
  }
  
  @Test
  public void testOneElement() {
    classUnderTest.push(5);
    
    assertEquals(classUnderTest.min(), 5);
    assertEquals(classUnderTest.pop(), 5);
    assertEquals(classUnderTest.min(), Integer.MAX_VALUE);
  }
  
  @Test
  public void testTwoElementsOneMin() {
    classUnderTest.push(1);
    classUnderTest.push(5);
    
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 5);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
  }
  
  @Test(expected=EmptyStackException.class)
  public void testTwoElementsTwoMin() {
    classUnderTest.push(5);
    classUnderTest.push(1);
    
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
    assertEquals(classUnderTest.min(), 5);
    assertEquals(classUnderTest.pop(), 5);
    assertEquals(classUnderTest.min(), Integer.MAX_VALUE);
    
    // Pop empty stack, exception expected
    classUnderTest.pop();
  }
  
  @Test
  public void testLongerStackOneMin() {
    classUnderTest.push(5);
    classUnderTest.push(1);
    classUnderTest.push(3);
    classUnderTest.push(3);
    classUnderTest.push(7);
    classUnderTest.push(3);
    
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 3);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 7);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 3);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 3);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
    assertEquals(classUnderTest.min(), 5);
    assertEquals(classUnderTest.pop(), 5);
  }

  @Test
  public void testLongerStackMultipleMins() {
    classUnderTest.push(5);
    classUnderTest.push(1);
    classUnderTest.push(3);
    classUnderTest.push(1);
    classUnderTest.push(7);
    classUnderTest.push(1);
    
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 7);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 3);
    assertEquals(classUnderTest.min(), 1);
    assertEquals(classUnderTest.pop(), 1);
    assertEquals(classUnderTest.min(), 5);
    assertEquals(classUnderTest.pop(), 5);
  }
}