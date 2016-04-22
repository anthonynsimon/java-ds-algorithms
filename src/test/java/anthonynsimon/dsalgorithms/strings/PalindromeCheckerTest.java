package anthonynsimon.dsalgorithms.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeCheckerTest {
  
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
      assertTrue(PalindromeChecker.isPalindrome(p));
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
    
    char[] backlist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    for (String p : palindromes) {
      assertTrue(PalindromeChecker.isPalindrome(p, backlist));
    }
  }
  
  @Test
  public void testPalindromesWithCases() {
    String[] palindromes = {
      "Taco cat",
      "Are we not pure? \"No sir!\" Panama's moody Noriega brags. \"It is garbage!\" Irony dooms a man; a prisoner up to new era."
    };
    
    char[] backlist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    
    for (String p : palindromes) {
      assertTrue(PalindromeChecker.isPalindromeIgnoreCase(p, backlist));
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
      assertFalse(PalindromeChecker.isPalindrome(p));
    }
  }
}