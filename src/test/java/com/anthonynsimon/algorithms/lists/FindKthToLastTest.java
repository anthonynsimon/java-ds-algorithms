package com.anthonynsimon.algorithms.lists;

import org.junit.*;
import static org.junit.Assert.*;

public class FindKthToLastTest {
  
  private FindKthToLast<String> classUnderTest;
  private String[] emptyData;
  private String[] data;
  
  @Before
  public void setUp() {
    classUnderTest = new FindKthToLast<>();
    
    emptyData = new String[]{};
    
    data = new String[]{
      "ab",
      "cd",
      "ef",
      "gh"
    };
    
  }
    
  @Test
  public void testEmpty() {
    classUnderTest.build(emptyData);
    
    assertEquals(classUnderTest.findKthToLast(-1), null);    
    assertEquals(classUnderTest.findKthToLast(5), null);    
    assertEquals(classUnderTest.findKthToLast(0), null);    
  }
  
  @Test
  public void testNotLongEnough() {    
    classUnderTest.build(data);
    
    assertEquals(classUnderTest.findKthToLast(4), null);
    assertEquals(classUnderTest.findKthToLast(10), null);
  }
  
  @Test
  public void testFindKthToLast() {
    classUnderTest.build(data);
    
    assertEquals(classUnderTest.findKthToLast(2), "cd");
    assertEquals(classUnderTest.findKthToLast(0), "gh");
    assertEquals(classUnderTest.findKthToLast(3), "ab");
  }
}