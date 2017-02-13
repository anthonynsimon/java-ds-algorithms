package com.anthonynsimon.algorithms.lists;

import org.junit.*;
import static org.junit.Assert.*;

public class ListPalindromeCheckerTest {
  
  private ListPalindromeChecker<String> classUnderTest;
  
  @Before 
  public void setUp() {
    classUnderTest = new ListPalindromeChecker<>();
  }
    
  @Test
  public void testEmpty() {    
    assertFalse(classUnderTest.isPalindrome());
  }

  @Test
  public void testOneElement() {    
    classUnderTest.append("a");
    
    assertTrue(classUnderTest.isPalindrome());
  }

  @Test
  public void testTwoElements() {    
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