package anthonynsimon.algorithms.lists;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveListDuplicatesTest {
    
  @Test
  public void testStrings() {
    RemoveListDuplicates<String> list = new RemoveListDuplicates<>();
    
    String[] data = new String[]{
      "this",
      "that",
      "a",
      "some",
      "house",
      "that",
      "thiss",
      "This",
      "a",
      "this"
    };
    
    String[] expectedResult = new String[]{
      "this",
      "that",
      "a",
      "some",
      "house",
      "thiss",
      "This"
    };
    
    list.build(data);
    list.removeDuplicates();
    
    assertEquals(list.toArray(), expectedResult);
  }
}