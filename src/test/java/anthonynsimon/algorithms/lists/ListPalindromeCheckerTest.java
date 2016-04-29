package anthonynsimon.algorithms.lists;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListPalindromeCheckerTest {
    
  @Test
  public void testEmpty() {
    ListPalindromeChecker<String> classUnderTest = new ListPalindromeChecker<>();
    
    assertFalse(classUnderTest.isPalindrome());
  }

  @Test
  public void testOneElement() {
    ListPalindromeChecker<String> classUnderTest = new ListPalindromeChecker<>();
    
    classUnderTest.append("a");
    
    assertTrue(classUnderTest.isPalindrome());
  }

  @Test
  public void testTwoElements() {
    ListPalindromeChecker<String> classUnderTest = new ListPalindromeChecker<>();
    
    classUnderTest.append("a");
    classUnderTest.append("a");
    
    assertTrue(classUnderTest.isPalindrome());
    
    classUnderTest.clear();
    classUnderTest.append("a");
    classUnderTest.append("b");
    
    assertFalse(classUnderTest.isPalindrome());
  }
  
  @Test
  public void testThreeElements() {
    ListPalindromeChecker<String> classUnderTest = new ListPalindromeChecker<>();
    
    classUnderTest.append("a");
    classUnderTest.append("b");
    classUnderTest.append("a");
    
    assertTrue(classUnderTest.isPalindrome());
    
    classUnderTest.clear();
    classUnderTest.append("a");
    classUnderTest.append("b");
    classUnderTest.append("c");
    
    assertFalse(classUnderTest.isPalindrome());
  }
  
  @Test
  public void testManyElements() {
    ListPalindromeChecker<String> classUnderTest = new ListPalindromeChecker<>();
    
    classUnderTest.append("x");
    classUnderTest.append("5");
    classUnderTest.append("a");
    classUnderTest.append("t");
    classUnderTest.append("a");
    classUnderTest.append("5");
    classUnderTest.append("x");
    
    assertTrue(classUnderTest.isPalindrome());
    
    classUnderTest.clear();
    classUnderTest.append("x");
    classUnderTest.append("5");
    classUnderTest.append("a");
    classUnderTest.append("t");
    classUnderTest.append("t");
    classUnderTest.append("a");
    classUnderTest.append("5");
    classUnderTest.append("5");
    
    assertFalse(classUnderTest.isPalindrome());
  }
}