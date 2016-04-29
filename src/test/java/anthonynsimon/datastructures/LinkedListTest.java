package anthonynsimon.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testOutOfBounds() {
    LinkedList<String> list = new LinkedList<>();
    
    list.insert(10, "hey");
    
    assertEquals(list.get(0), null);
    assertEquals(list.get(10), null);
    assertEquals(list.get(-1), null);
  }
  
  @Test
  public void testEmptyList() {
    LinkedList<String> list = new LinkedList<>();
    
    assertEquals(list.size(), 0);
    assertFalse(list.contains("Hey"));
    assertEquals(list.peek(), null);
    assertEquals(list.size(), 0);
  }
  
  @Test
  public void testListConstruction() {
    LinkedList<String> list = new LinkedList<>("Hello there");
    assertEquals(list.size(), 1);
    assertTrue(list.contains("Hello there"));
    
    LinkedList<String> list2 = new LinkedList<>();
    
    list2.build(new String[]{
      "hey",
      "you",
      "hey",
      "hey",
    });
    
    assertEquals(list2.size(), 4);
    assertTrue(list2.contains("you"));
  }
  
  @Test
  public void testListBuild() {    
    LinkedList<String> list = new LinkedList<>();
    
    list.build(new String[]{
      "hey",
      "you",
      "hey",
      "hey",
    });
    
    assertEquals(list.size(), 4);
    assertTrue(list.contains("you"));
    
    list.build(new String[]{
      "one",
      "two"
    });
    
    assertEquals(list.size(), 2);
    assertTrue(list.contains("two"));
    assertFalse(list.contains("hey"));
  }
  
  @Test
  public void testOneElement() {
    LinkedList<String> list = new LinkedList<>();
    
    list.append("first");
    
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), "first");
    assertEquals(list.peek(), "first");
    assertFalse(list.contains("Hey"));
    assertTrue(list.contains("first"));
  }

  @Test
  public void testAppendingElements() {
    LinkedList<String> list = new LinkedList<>();
    
    list.append("first");
    list.append("second");
    list.append("third");
    
    assertEquals(list.size(), 3);
    assertEquals(list.get(1), "second");
    assertEquals(list.get(2), "third");
    assertEquals(list.peek(), "first");
    assertFalse(list.contains("Hey"));
    assertTrue(list.contains("third"));
  }
  
  @Test
  public void testSettingElements() {
    LinkedList<String> list = new LinkedList<>();
    
    list.append("uno");
    list.append("dos");
    list.append("tres");
    list.set(1, "two");
    
    assertEquals(list.size(), 3);
    assertEquals(list.get(1), "two");
    assertFalse(list.contains("dos"));
    assertFalse(list.contains("dos"));
  }
  
  @Test
  public void testSimpleInsertion() {
    LinkedList<String> list = new LinkedList<>();
    
    list.append("uno");
    list.append("dos");
    list.append("tres");
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
    
    list.append("one");
    list.insert(0, "two");
    
    assertEquals(list.size(), 2);
    assertEquals(list.get(0), "two");
    assertEquals(list.get(1), "one");
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testInsertOutOfRange() {    
    LinkedList<String> list = new LinkedList<>();    
    list.append("one");
    
    list.insert(1, "two");
        
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), "one");
    assertEquals(list.get(1), null);
  }
  
  @Test
  public void testRemoveElement() {    
    LinkedList<String> list = new LinkedList<>();
     
    // Remove from list of 1 element
    list.append("one");
    list.remove(0);
    
    assertEquals(list.size(), 0);
    assertEquals(list.peek(), null);

    list.append("one");
    list.append("two");
    list.append("three");
    list.append("four");
    
    assertEquals(list.size(), 4);
    assertEquals(list.peek(), "one");
    assertEquals(list.get(3), "four");
    
    // Remove head from list of 4 elements
    list.remove(0); // => two -> three -> four
    assertEquals(list.peek(), "two");
    
    // Remove tail from list of 3 elements
    list.remove(2);  // => two -> three
    assertEquals(list.peek(), "two");
    assertEquals(list.get(1), "three");
    assertEquals(list.size(), 2);
    assertFalse(list.contains("four"));
    
    list.insert(1, "two and a half");
    list.insert(0, "one");
    
    assertEquals(list.get(2), "two and a half");

    // Remove middle element from list of 4 elements
    assertEquals(list.size(), 4);
    list.remove(2);
    assertEquals(list.size(), 3);
    
    assertEquals(list.get(1), "two");
    assertEquals(list.get(2), "three");
    
    // Remove middle element from list of 3 elements
    list.remove(1);
    
    assertEquals(list.peek(), "one");
    assertEquals(list.get(1), "three");
    
    assertEquals(list.size(), 2);
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRemoveOutOfRange() {    
    LinkedList<String> list = new LinkedList<>();
    
    list.append("you");
    list.remove(-1);
  }
  
  @Test
  public void testPop() {    
    LinkedList<String> list = new LinkedList<>();

    list.append("you");
    list.insert(0, "hey");
    list.append("dude");
    
    assertEquals(list.size(), 3);
    
    assertEquals(list.pop(), "dude");
    assertEquals(list.pop(), "you");
    assertEquals(list.pop(), "hey");
    
    assertEquals(list.size(), 0);
    assertFalse(list.contains("hey"));
    assertFalse(list.contains("you"));
    assertFalse(list.contains("dude"));
    
    assertEquals(list.pop(), null);
  }
  
  
  @Test
  public void testGetLast() {    
    LinkedList<String> list = new LinkedList<>();

    list.append("you");
    list.insert(0, "hey");
    list.append("dude");
    
    assertEquals(list.getLast(), "dude");

    list.pop();
    
    assertEquals(list.getLast(), "you");
    
    list.pop();
    list.pop();
    list.pop();
    
    assertEquals(list.getLast(), null);    
  }
  
  @Test
  public void testClear() {    
    LinkedList<String> list = new LinkedList<>();

    list.append("you");
    list.insert(0, "hey");
    list.append("dude");
    list.append("dude");
    list.append("dude");
    list.append("dude");
    list.append("dude");
    
    assertEquals(list.size(), 7);

    list.clear();
    
    assertEquals(list.size(), 0);
    assertEquals(list.getLast(), null);
    assertEquals(list.peek(), null);
  }
  
  @Test
  public void testToArray() {    
    LinkedList<String> list = new LinkedList<>();

    list.append("you");
    list.insert(0, "hey");
    list.append("dude");
    
    String[] results1 = {"hey", "you", "dude"};
    
    assertEquals(list.toArray(), results1);

    list.clear();
    
    String[] results2 = {};
    
    assertEquals(list.toArray(), results2);
  }
  
  @Test
  public void testToString() {    
    LinkedList<String> list = new LinkedList<>();

    list.append("you");
    list.insert(0, "hey");
    list.append("dude");
        
    assertEquals(list.toString(), "hey you dude");
    assertEquals(list.toString("."), "hey.you.dude");

    list.clear();
    
    assertEquals(list.toString(), "");
  }
}