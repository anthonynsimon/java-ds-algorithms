package anthonynsimon.algorithms.strings;

import org.junit.*;
import static org.junit.Assert.*;

public class PalindromeCheckerTest {
  
  private PalindromeChecker classUnderTest;
  
  @Before 
  public void setUp() {
    classUnderTest = new PalindromeChecker();
  }
  
  @Test
  public void testCorrectPalindrome() {
    String[] palindromes = {
      "tacocat",
      "pananap",
      "artnamenotubtimeemitbutonemantra",
      "amoreroma",
      "adogapanicinapagoda"
    };
    
    for (String p : palindromes) {
      assertTrue(classUnderTest.isPalindrome(p));
    }
  }
  
  @Test
  public void testPalindromeWithOmittableChars() {
    String[] palindromes = {
      "taco cat",
      "pananap!",
      "a lad named e. mandala",
      "a !man, a plan, a -canal: panama."
    };
    
    char[] blacklist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    for (String p : palindromes) {
      assertTrue(classUnderTest.isPalindrome(p, blacklist));
    }
  }
  
  @Test
  public void testPalindromesWithCases() {
    String[] palindromes = {
      "Taco cat",
      "Are we not pure? \"No sir!\" Panama's moody Noriega brags. \"It is garbage!\" Irony dooms a man; a prisoner up to new era."
    };
    
    char[] blacklist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    for (String p : palindromes) {
      assertTrue(classUnderTest.isPalindromeIgnoreCase(p, blacklist));
    }
  }
  
  @Test
  public void testWrongPalindrome() {
    String[] palindromes = {
      "ta51cocat",
      "panaatnap",
      "artnamenmnotubtimeemiatbutonemantra",
      "amorerosma",
      "apagoda",
      "hotdog",
      "doggot",
      "12365321"
    };
    
    for (String p : palindromes) {
      assertFalse(classUnderTest.isPalindrome(p));
    }
  }
}