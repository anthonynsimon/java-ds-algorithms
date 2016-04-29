package anthonynsimon.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
  
  private Queue<String> queue = new Queue<>();
  
  @Test
  public void testEmptyQueue() {
    assertEquals(queue.dequeue(), null);
    assertEquals(queue.size(), 0);
  }
  
  @Test
  public void testEnqueue() {
    queue.enqueue("this");
    
    assertEquals(queue.size(), 1);
    
    queue.enqueue("that");
    assertEquals(queue.size(), 2);
  }
  
  @Test
  public void testDequeue() {
    queue.clear();
    queue.enqueue("one");
    queue.enqueue("two");
    
    assertEquals(queue.dequeue(), "one");
    assertEquals(queue.dequeue(), "two");
    
    assertEquals(queue.size(), 0);
  }
  
  @Test
  public void testClear() {
    queue.enqueue("this");
    queue.enqueue("that");
    
    queue.clear();
    assertEquals(queue.size(), 0);
    assertEquals(queue.dequeue(), null);
  }
}