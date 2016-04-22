package anthonynsimon.dsalgorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class SanitizerTest {

  private Sanitizer classUnderTest = new Sanitizer();
  
  @Test
  public void testSanitizer() {
    char[] backlist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    assertEquals("", classUnderTest.sanitize("...", backlist));
    assertEquals("_____", classUnderTest.sanitize("_____", backlist));
    assertEquals("asdtasdasdfas", classUnderTest.sanitize("asd,tasdasd.!fa!s", backlist));
    assertEquals("16asd5asda87as", classUnderTest.sanitize("16asd5.asda87?as", backlist));
    assertEquals("", classUnderTest.sanitize("", backlist));
    assertEquals("abcdefg", classUnderTest.sanitize("a?:b,-cde'fg\"", backlist));
    
    char[] backlist2 = {'_'};
    
    assertEquals("", classUnderTest.sanitize("_____", backlist2));

  }
}