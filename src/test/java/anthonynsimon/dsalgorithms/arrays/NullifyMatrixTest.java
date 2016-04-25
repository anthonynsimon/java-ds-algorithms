package anthonynsimon.dsalgorithms.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class NullifyMatrixTest {
  
  private NullifyMatrix classUnderTest = new NullifyMatrix();
  
  @Test
  public void testSmallMatrix() {
    int[][] originalMatrix = {
      {0, 1},
      {3, 2}
    };
    
    int[][] expectedMatrix = {
      {0, 0},
      {0, 2}
    }; 
    
    assertEquals(classUnderTest.nullify(originalMatrix), expectedMatrix);
  }
  
  @Test
  public void testBiggerMatrix() {
    int[][] originalMatrix = {
      {0, 1, 8, 6, 0, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 7, 6, 6, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 8, 4, 0, 1},
      {6, 1, 8, 6, 6, 1}
    };
    
    int[][] expectedMatrix = {
      {0, 0, 0, 0, 0, 0},
      {0, 1, 8, 6, 0, 1},
      {0, 1, 8, 6, 0, 1},
      {0, 1, 7, 6, 0, 1},
      {0, 1, 8, 6, 0, 1},
      {0, 0, 0, 0, 0, 0},
      {0, 1, 8, 6, 0, 1}
    }; 
    
    assertEquals(classUnderTest.nullify(originalMatrix), expectedMatrix);
  }
  
  @Test
  public void testIrregularMatrix() {
    int[][] originalMatrix = {
      {0, 1, 8, 6, 0, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 1},
      {6, 1, 8, 6, 6, 1},
      {6},
      {6, 1, 8, 6, 6, 1}
    };
    
    int[][] expectedMatrix = {
      {0, 1, 8, 6, 0, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 8, 6, 6, 1},
      {6, 1, 1},
      {6, 1, 8, 6, 6, 1},
      {6},
      {6, 1, 8, 6, 6, 1}
    }; 
    
    assertEquals(classUnderTest.nullify(originalMatrix), expectedMatrix);
  }
}
