package anthonynsimon.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCompressorTest {
  
  private StringCompressor classUnderTest = new StringCompressor();
  
  @Test
  public void testEmptyString() {
    assertEquals(classUnderTest.compress(""), "");
  }
  
  @Test
  public void testNoCompressionNeeded() {
    assertEquals(classUnderTest.compress("abcdefg"), "abcdefg");
  }
  
  @Test
  public void testCompressionWorseCase() {
    // Result would actually be "a2b1" which is longer than original
    assertEquals(classUnderTest.compress("aab"), "aab");
  }
  
  @Test
  public void testCompressionNeeded() {
    assertEquals(classUnderTest.compress("aaabcbbbaaccccccgxgg"), "a3b1c1b3a2c6g1x1g2");
  }
  

}
