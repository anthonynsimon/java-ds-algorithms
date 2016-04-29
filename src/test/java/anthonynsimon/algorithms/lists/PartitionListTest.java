package anthonynsimon.algorithms.lists;

import org.junit.Test;
import static org.junit.Assert.*;

public class PartitionListTest {
  
  @Test
  public void testOneElement() {
    PartitionList classUnderTest = new PartitionList();
    
    Node head = new Node(7);
  
    head = classUnderTest.partition(head, 5);
    
    assertEquals(head.value, 7);
    assertEquals(head.next, null);
  }
  
  @Test
  public void testNoPartion() {
    PartitionList classUnderTest = new PartitionList();
    
    int[] values = {7, 3, 5, 8, 1};
    
    Node head = new Node(values[0]);
    
    Node current = head;
    for (int i = 1; i < values.length; i++) {
      current.next = new Node(values[i]);
      current = current.next;
    }
  
    head = classUnderTest.partition(head, 0);
    
    current = head;
    for (int i = 0; i < values.length; i++) {
      assertEquals(current.value, values[i]);
      current = current.next;
    }
  }

  @Test
  public void testPartition() {
    PartitionList classUnderTest = new PartitionList();
    
    int[] values = {7, 3, 5, 8, 1};
    int[] expected = {1, 3, 7, 5, 8};

    Node head = new Node(values[0]);
    
    Node current = head;
    for (int i = 1; i < values.length; i++) {
      current.next = new Node(values[i]);
      current = current.next;
    }
  
    head = classUnderTest.partition(head, 5);
    
    current = head;
    for (int i = 0; i < values.length; i++) {
      assertEquals(current.value, expected[i]);
      current = current.next;
    }
  }
}