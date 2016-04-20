package anthonynsimon.dsalgorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueCharactersTest {
  @Test
  public void testHasUniqueChars() {
    UniqueCharacters classUnderTest = new UniqueCharacters();

    assertTrue("should return true", classUnderTest.hasUniqueChars("abc"));
    assertTrue("should return true", classUnderTest.hasUniqueChars("ILikeTacos"));
    assertFalse("should return false if chars not unique", classUnderTest.hasUniqueChars("hh"));
    assertFalse("should return false even with whitespace", classUnderTest.hasUniqueChars("This is a longer string"));
    assertFalse("should return false if string is empty", classUnderTest.hasUniqueChars(""));
  }
}