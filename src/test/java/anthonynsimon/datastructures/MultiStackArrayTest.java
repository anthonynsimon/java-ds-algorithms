package anthonynsimon.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiStackArrayTest {  

  @Test
  public void testEmptyStacks() {
    MultiStackArray multiStack = new MultiStackArray(3, 256);
    
    assertEquals(multiStack.sizeOfStack(0), 0);
    assertEquals(multiStack.sizeOfStack(1), 0);
    assertEquals(multiStack.sizeOfStack(2), 0);
    assertEquals(multiStack.stackCount(), 3);
  }
  
  @Test
  public void testStackCounts() {
    MultiStackArray multiStack = new MultiStackArray(1, 128);
    assertEquals(multiStack.stackCount(), 1);
    assertEquals(multiStack.sizeOfStack(0), 0);
    
    MultiStackArray multiStack2 = new MultiStackArray(5, 64);
    assertEquals(multiStack2.stackCount(), 5);
    assertEquals(multiStack2.sizeOfStack(0), 0);
    assertEquals(multiStack2.sizeOfStack(1), 0);
    assertEquals(multiStack2.sizeOfStack(2), 0);
    assertEquals(multiStack2.sizeOfStack(3), 0);
    assertEquals(multiStack2.sizeOfStack(4), 0);
  }
  
  @Test
  public void testPushingElements() {
    MultiStackArray multiStack = new MultiStackArray(3, 256);
    
    multiStack.push(0, 152);
    multiStack.push(0, 355);
    multiStack.push(0, 722);
    
    assertEquals(multiStack.peek(0), 722);
    assertEquals(multiStack.sizeOfStack(0), 3);
    
    multiStack.push(2, 22);
    multiStack.push(2, 888);
    
    assertEquals(multiStack.peek(2), 888);
    assertEquals(multiStack.sizeOfStack(2), 2);
    
    multiStack.push(1, 45);
    
    assertEquals(multiStack.peek(1), 45);
    assertEquals(multiStack.sizeOfStack(1), 1);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testPushingOutOfRange() {
    MultiStackArray multiStack = new MultiStackArray(3, 3);
    
    multiStack.push(0, 152);
    multiStack.push(0, 355);
    multiStack.push(0, 355);
    multiStack.push(0, 355);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testPoppingOutOfRange() {
    MultiStackArray multiStack = new MultiStackArray(3, 3);
    
    multiStack.push(1, 152);
    multiStack.push(1, 355);
    
    multiStack.pop(1);
    multiStack.pop(1);
    multiStack.pop(1);
  }
  
  @Test
  public void testPoppingElements() {
    MultiStackArray multiStack = new MultiStackArray(4, 128);
    
    multiStack.push(0, 152);
    multiStack.push(0, 355);
    multiStack.push(0, 722);
    
    multiStack.push(2, 12);
    multiStack.push(2, 7);
    multiStack.push(2, 5);
    multiStack.push(2, 435);
    multiStack.push(2, 855);
    
    multiStack.push(1, 89);
    
    multiStack.push(3, 44);
    multiStack.push(3, 72);
    
    assertEquals(multiStack.sizeOfStack(0), 3);
    assertEquals(multiStack.pop(0), 722);
    assertEquals(multiStack.peek(0), 355);
    assertEquals(multiStack.sizeOfStack(0), 2);
    
    assertEquals(multiStack.sizeOfStack(1), 1);
    assertEquals(multiStack.pop(1), 89);
    assertEquals(multiStack.sizeOfStack(1), 0);
    
    assertEquals(multiStack.sizeOfStack(2), 5);
    assertEquals(multiStack.pop(2), 855);
    assertEquals(multiStack.peek(2), 435);
    assertEquals(multiStack.sizeOfStack(2), 4);
    
    assertEquals(multiStack.sizeOfStack(3), 2);
    assertEquals(multiStack.pop(3), 72);
    assertEquals(multiStack.peek(3), 44);
    assertEquals(multiStack.sizeOfStack(3), 1);
  }
}