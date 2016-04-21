package anthonynsimon.dsalgorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationMatchTest {
  
  private PermutationMatch classUnderTest = new PermutationMatch();
  
  @Test
  public void testIsPermutation() {
    assertTrue(classUnderTest.isPermutation("hello", "llheo"));
    assertFalse(classUnderTest.isPermutation("what", "wa"));
  }
  
  @Test
  public void testTwoEmptyStrings() {
    assertTrue(classUnderTest.isPermutation("", ""));
  }
  
  @Test 
  public void testSameValuesDifferentChars() {
    assertFalse(classUnderTest.isPermutation("ab", "bc"));
  }
  
  @Test
  public void testCaseSensitive() {
    assertFalse(classUnderTest.isPermutation("Canada", "canada"));
  }
}
