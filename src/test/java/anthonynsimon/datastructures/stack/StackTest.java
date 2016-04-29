package anthonynsimon.datastructures.stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
  
  private Stack<String> classUnderTest = new Stack<>();
  
  @Test
  public void testEmptyStack() {
    assertEquals(classUnderTest.size(), 0);
    assertEquals(classUnderTest.pop(), null);
  }
  
  @Test
  public void testPushingElements() {
    classUnderTest.push("there");
    
    assertEquals(classUnderTest.size(), 1);
    
    classUnderTest.push("hello");
    
    assertEquals(classUnderTest.size(), 2);

  }
  
  @Test
  public void testPoppingElements() {
    classUnderTest.push("there");    
    classUnderTest.push("hello");
    
    assertEquals(classUnderTest.pop(), "hello");  
    assertEquals(classUnderTest.pop(), "there");  
    assertEquals(classUnderTest.pop(), null);  
  }
  
  @Test
  public void testPeeking() {
    classUnderTest.clear();
    classUnderTest.push("some");    
    classUnderTest.push("people");
    
    assertEquals(classUnderTest.peek(), "people");
    
    classUnderTest.pop(); 
    
    assertEquals(classUnderTest.peek(), "some");
    
    classUnderTest.pop(); 
    
    assertEquals(classUnderTest.peek(), null);
  }
  
  @Test
  public void testClear() {
    classUnderTest.clear();

    assertEquals(classUnderTest.size(), 0);
    
    classUnderTest.push("this");
    classUnderTest.push("that");
    classUnderTest.push("some");
  
    assertEquals(classUnderTest.size(), 3);
    
    classUnderTest.clear();

    assertEquals(classUnderTest.size(), 0);
  }
}