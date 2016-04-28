package anthonynsimon.algorithms.lists;

import org.junit.Test;
import static org.junit.Assert.*;

public class FindKthToLastTest {
    
  @Test
  public void testEmpty() {
    FindKthToLast<String> classUnderTest = new FindKthToLast<>();
    String[] data = {};
    classUnderTest.build(data);
    
    assertEquals(classUnderTest.findKthToLast(4), null);    
  }
  
  @Test
  public void testNotLongEnough() {
    FindKthToLast<String> classUnderTest = new FindKthToLast<>();
    
    String[] data = {
      "ab",
      "cd",
      "ef",
      "gh"
    };
    
    classUnderTest.build(data);
    
    assertEquals(classUnderTest.findKthToLast(4), null);
  }
  
  @Test
  public void testFindKthToLast() {
    FindKthToLast<String> classUnderTest = new FindKthToLast<>();
    
    String[] data = {
      "ab",
      "cd",
      "ef",
      "gh"
    };
    
    classUnderTest.build(data);
    
    assertEquals(classUnderTest.findKthToLast(2), "cd");
  }
}