package anthonynsimon.algorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationPalindromeTest {
  
  private PermutationPalindrome classUnderTest = new PermutationPalindrome();
  
  @Test
  public void testEmptyString() {
    assertFalse(classUnderTest.isPermutationOfPalindromeBruteForce(""));
  }
  
  @Test
  public void testStringsWithPalindromeBruteForce() {
    String[] testStrings = {
      /* First two omitted, would take too long on brute force
      * "a man, a plan, a canal, panama!",
      * " a canal, a man, panama! a ,plan.",
      */
      "taco cat",
      "atcc o.ta",
      "aabbcc",
      "@t@yt"
    };
    
    for (String str : testStrings) {
      assertTrue(classUnderTest.isPermutationOfPalindromeBruteForce(str));
    }
  }
  
  @Test
  public void testStringsWithPalindromeOptimized() {
    String[] testStrings = {
      "a man, a plan, a canal, panama!",
      " a canal, a man, panama! a ,plan.",
      "taco cat",
      "atcc o.ta",
      "aabbcc",
      "@t@yt"
    };
    
    for (String str : testStrings) {
      assertTrue(classUnderTest.isPermutationOfPalindrome(str));
    }
  }
  
  @Test
  public void testStringsWithoutPalindrome() {
    String[] testStrings = {
      "autcc ota",
      "@@yyan",
      "abc",
      "atcc o.tava",
      "4554913"
    };
    
    for (String str : testStrings) {
      assertFalse(classUnderTest.isPermutationOfPalindrome(str));
    }
  }
  
  @Test
  public void testStringsWithoutPalindromeBruteForce() {
    String[] testStrings = {
      "autcc ota",
      "@@yyan",
      "abc",
      "atcc o.tava",
      "4554913"
    };
    
    for (String str : testStrings) {
      assertFalse(classUnderTest.isPermutationOfPalindromeBruteForce(str));
    }
  }
}