package anthonynsimon.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverserTest {

  private Reverser classUnderTest = new Reverser();
  
  @Test
  public void testStringReversal() {
    assertEquals("olleh", classUnderTest.reverse("hello"));
    assertEquals("a", classUnderTest.reverse("a"));
    assertEquals("cba", classUnderTest.reverse("abc"));
    assertEquals("ca", classUnderTest.reverse("ac"));
    assertEquals("", classUnderTest.reverse(""));
    assertEquals("?siht si tahW", classUnderTest.reverse("What is this?"));
    assertEquals("  Gnirtssss tseeEtYm", classUnderTest.reverse("mYtEeest sssstrinG  "));

  }
}