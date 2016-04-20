package anthonynsimon.dsalgorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationMatchTest {
  @Test
  public void testIsPermutation() {
    PermutationMatch classUnderTest = new PermutationMatch();

    assertTrue("it's permutation, should return true", classUnderTest.isPermutation("hello", "llheo"));
    assertTrue("empty returns true as they match", classUnderTest.isPermutation("", ""));
    assertFalse("their values add to the same, but different chars", classUnderTest.isPermutation("ab", "bc"));
    assertFalse("different length", classUnderTest.isPermutation("what", "wa"));
    assertFalse("case sensitive", classUnderTest.isPermutation("Canada", "canada"));
  }
}
