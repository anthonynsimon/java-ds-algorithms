package anthonynsimon.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyNodeTest {
  
  @Test
  public void testNodeInit() {
    SinglyNode<String> nodeWithValue = new SinglyNode<String>("test");
    assertEquals(nodeWithValue.getData(), "test");
    assertEquals(nodeWithValue.getNext(), null);

    SinglyNode<String> nodeWithNext = new SinglyNode<>("test2", nodeWithValue);
    assertEquals(nodeWithNext.getData(), "test2");
    assertEquals(nodeWithNext.getNext().getData(), "test");
    assertEquals(nodeWithNext.getNext().getNext(), null);
  }
  
  @Test
  public void testNodeChaining() {
    SinglyNode<String> head = new SinglyNode<>(String.format("element %d", 0));
    int totalNodes = 100;
   
    // Chain nodes and set sequential values
    SinglyNode<String> currentNode = head;
    for (int i = 1; i < totalNodes; i++) {
      currentNode.setNext(new SinglyNode<String>(String.format("element %d", i)));
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
    SinglyNode<String> head = new SinglyNode<>(String.format("element %d", 0));
    int totalNodes = 100;
    
    // Chain nodes and set sequential values
    SinglyNode<String> currentNode = head;
    for (int i = 1; i < totalNodes; i++) {
      currentNode.setNext(new SinglyNode<String>(String.format("element %d", i)));
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