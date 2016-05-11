package anthonynsimon.algorithms.strings;

import org.junit.*;
import static org.junit.Assert.*;

public class OneEditCheckerTest {
  
  private OneEditChecker classUnderTest;
          
  @Before 
  public void setUp() {
    classUnderTest = new OneEditChecker();
  }
  
  @Test
  public void testIsEditsAway() {
    assertFalse(classUnderTest.areOneEditAway("a", "abc"));
    assertFalse(classUnderTest.areOneEditAway("ab", "aaa"));
    assertFalse(classUnderTest.areOneEditAway("pale", "bake"));
    assertFalse(classUnderTest.areOneEditAway("pale", "bak"));
    assertFalse(classUnderTest.areOneEditAway("tree", "tre  e"));
    assertFalse(classUnderTest.areOneEditAway("treeshore", "teeshorre"));
     
    assertTrue(classUnderTest.areOneEditAway("bale", "pale"));
    assertTrue(classUnderTest.areOneEditAway("bal", "bale"));
    assertTrue(classUnderTest.areOneEditAway("abcd", "abd"));
    assertTrue(classUnderTest.areOneEditAway("bae", "bale"));
    assertTrue(classUnderTest.areOneEditAway("bale", "ale"));
  }
}