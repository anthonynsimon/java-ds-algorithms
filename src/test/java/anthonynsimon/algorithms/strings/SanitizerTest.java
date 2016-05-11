package anthonynsimon.algorithms.strings;

import org.junit.*;
import static org.junit.Assert.*;

public class SanitizerTest {

  private Sanitizer classUnderTest;
      
  @Before 
  public void setUp() {
    classUnderTest = new Sanitizer();
  }
  
  @Test
  public void testSanitizer() {
    char[] blacklist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    assertEquals("", classUnderTest.sanitize("...", blacklist));
    assertEquals("_____", classUnderTest.sanitize("_____", blacklist));
    assertEquals("asdtasdasdfas", classUnderTest.sanitize("asd,tasdasd.!fa!s", blacklist));
    assertEquals("16asd5asda87as", classUnderTest.sanitize("16asd5.asda87?as", blacklist));
    assertEquals("", classUnderTest.sanitize("", blacklist));
    assertEquals("abcdefg", classUnderTest.sanitize("a?:b,-cde'fg\"", blacklist));
    
    char[] blacklist2 = {'_'};
    
    assertEquals("", classUnderTest.sanitize("_____", blacklist2));

  }
}