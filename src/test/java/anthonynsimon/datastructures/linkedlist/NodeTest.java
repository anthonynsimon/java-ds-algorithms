package anthonynsimon.datastructures.linkedlist;

import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {
  
  @Test
  public void testNodeInit() {
    Node<String> nodeWithValue = new Node<String>("test");
    assertEquals(nodeWithValue.getData(), "test");
    assertEquals(nodeWithValue.getNext(), null);

    Node<String> nodeWithNext = new Node<>("test2", nodeWithValue);
    assertEquals(nodeWithNext.getData(), "test2");
    assertEquals(nodeWithNext.getNext().getData(), "test");
    assertEquals(nodeWithNext.getNext().getNext(), null);
  }
  
  @Test
  public void testNodeChaining() {
    Node<String> head = new Node<>(String.format("element %d", 0));
    int totalNodes = 100;
   
    // Chain nodes and set sequential values
    Node<String> currentNode = head;
    for (int i = 1; i < totalNodes; i++) {
      currentNode.setNext(new Node<String>(String.format("element %d", i)));
      currentNode = currentNode.getNext();
    }
    
    // Set sequential values in reverse order
    currentNode = head;
    int i = 0;
    while (currentNode != null) {
      assertEquals(currentNode.getData(), String.format("element %d", i));
      currentNode = currentNode.getNext();
      i++;
    }
    
    assertEquals(totalNodes, i);
  }
  
  @Test
  public void testSetData() {
    Node<String> head = new Node<>(String.format("element %d", 0));
    int totalNodes = 100;
    
    // Chain nodes and set sequential values
    Node<String> currentNode = head;
    for (int i = 1; i < totalNodes; i++) {
      currentNode.setNext(new Node<String>(String.format("element %d", i)));
      currentNode = currentNode.getNext();
    }
    
    // Set sequential values in reverse order
    int i = 0;
    currentNode = head;
    while (currentNode != null) {
      currentNode.setData(String.format("element %d", totalNodes - i));
      currentNode = currentNode.getNext();
      i++;
    }
    
    // Test previous setData iteration
    i = 0;
    currentNode = head;
    while (currentNode != null) {
      assertEquals(currentNode.getData(), String.format("element %d", totalNodes - i));
      currentNode = currentNode.getNext();
      i++;
    }
    
    // Test if we still got the right number of nodes
    assertEquals(totalNodes, i);
  }
}