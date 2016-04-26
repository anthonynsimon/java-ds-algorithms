package anthonynsimon.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class UrlifierTest {
  
  private Urlifier classUnderTest = new Urlifier();
  
  @Test
  public void testReplaceWhitespace() {
    assertEquals("the%20dog%20is%20happy", 
        classUnderTest.urlify("the dog is happy"));
    
    assertEquals("google.com/q?search=java%20data%20structures%20And%20algorithms", 
        classUnderTest.urlify("google.com/q?search=java data structures And algorithms"));
        
    assertEquals("http://google.com/asd%20tta%20%20asd", classUnderTest.urlify("http://google.com/asd tta  asd"));
        
    assertEquals("http://google.com/", classUnderTest.urlify("http://google.com/"));
        
    assertEquals("http://google.com/q?%20%20%20%20%20test%20%20", classUnderTest.urlify("http://google.com/q?     test  "));
  }
}