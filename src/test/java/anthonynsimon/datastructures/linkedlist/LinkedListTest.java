package anthonynsimon.datastructures.linkedlist;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
  
  @Test
  public void testEmptyList() {
    LinkedList<String> list = new LinkedList<>();
    
    assertEquals(list.size(), 0);
    assertEquals(list.get(0), null);
    assertEquals(list.get(10), null);
    assertEquals(list.get(-1), null);
    assertEquals(list.peek(), null);
    assertFalse(list.contains("Hey"));
  }

  @Test
  public void testOneElement() {
    LinkedList<String> list = new LinkedList<>();
    
    list.add("first");
    
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), "first");
    assertEquals(list.get(10), null);
    assertEquals(list.get(-1), null);
    assertEquals(list.peek(), "first");
    assertFalse(list.contains("Hey"));
    assertTrue(list.contains("first"));
  }

  @Test
  public void testAddingElements() {
    LinkedList<String> list = new LinkedList<>();
    
    list.add("first");
    list.add("second");
    list.add("third");
    
    assertEquals(list.size(), 3);
    assertEquals(list.get(1), "second");
    assertEquals(list.get(2), "third");
    assertEquals(list.get(7), null);
    assertEquals(list.get(-1), null);
    assertEquals(list.peek(), "first");
    assertFalse(list.contains("Hey"));
    assertTrue(list.contains("third"));
  }
  
  @Test
  public void testSettingElements() {
    LinkedList<String> list = new LinkedList<>();
    
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.set(1, "two");
    
    assertEquals(list.size(), 3);
    assertEquals(list.get(1), "two");
    assertFalse(list.contains("dos"));
    assertFalse(list.contains("dos"));
  }
  
  @Test
  public void testSimpleInsertion() {
    LinkedList<String> list = new LinkedList<>();
    
    list.add("uno");
    list.add("dos");
    list.add("tres");
    list.insert(1, "uno y medio");
    
    assertEquals(list.size(), 4);
    assertEquals(list.get(0), "uno");
    assertEquals(list.get(1), "uno y medio");
    assertEquals(list.get(2), "dos");
    assertEquals(list.get(3), "tres");
  }
  
  @Test
  public void testInsertAsFirst() {    
    LinkedList<String> list = new LinkedList<>();
    
    list.add("one");
    list.insert(0, "two");
    
    assertEquals(list.size(), 2);
    assertEquals(list.get(0), "two");
    assertEquals(list.get(1), "one");
  }
  
  @Test
  public void testInsertOutOfRange() {    
    LinkedList<String> list = new LinkedList<>();    
    list.add("one");
    list.insert(1, "two");
    
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), "one");
    assertEquals(list.get(1), null);
  }
  
  // TODO(anthonynsimon): add tests for remove, pop, clear, toArray, toString
}