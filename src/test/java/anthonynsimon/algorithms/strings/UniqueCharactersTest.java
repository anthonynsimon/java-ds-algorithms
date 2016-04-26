package anthonynsimon.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueCharactersTest {
  
  private UniqueCharacters classUnderTest = new UniqueCharacters();
  
  @Test
  public void testHasUniqueChars() {
    assertTrue(classUnderTest.hasUniqueChars("abc"));
    assertTrue(classUnderTest.hasUniqueChars("ILikeTacos"));
    assertFalse(classUnderTest.hasUniqueChars("hh"));
    assertFalse(classUnderTest.hasUniqueChars("This is a longer string"));
    assertFalse(classUnderTest.hasUniqueChars(""));
  }
}