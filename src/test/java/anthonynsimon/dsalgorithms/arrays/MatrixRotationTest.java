package anthonynsimon.dsalgorithms.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixRotationTest {
  
  private MatrixRotation classUnderTest = new MatrixRotation();
  
  @Test
  public void testRotateSimple() {
    int[][] originalMatrix = {
      {0, 1},
      {3, 2}
    };
    
    int[][] expectedMatrix = {
      {3, 0},
      {2, 1}
    }; 
    
    assertEquals(classUnderTest.rotate(originalMatrix), expectedMatrix);
  }
  
  @Test
  public void testRotationLetters() {
    int[][] originalMatrix = {
      {'a', 'b', 'c', 'd', 'e'},
      {'f', 'g', 'h', 'i', 'j'},
      {'k', 'l', 'm', 'n', 'o'},
      {'p', 'q', 'r', 's', 't'},
      {'u', 'v', 'w', 'x', 'y'}
    };
    
    int[][] expectedMatrix = {
      {'u', 'p', 'k', 'f', 'a'},
      {'v', 'q', 'l', 'g', 'b'},
      {'w', 'r', 'm', 'h', 'c'},
      {'x', 's', 'n', 'i', 'd'},
      {'y', 't', 'o', 'j', 'e'}
    }; 
    
    assertEquals(classUnderTest.rotate(originalMatrix), expectedMatrix);
  }
  
  @Test
  public void testNonSquareMatrix() {
    int[][] originalMatrix = {
      {'a', 'b', 'c', 'd', 'e'},
      {'f', 'g', 'h', 'i', 'j'},
      {'k', 'l', 'm', 'n', 'o'},
      {'p', 'q', 'r', 's', 't'},
      {'u', 'v', 'w', 'x', 'y'},
      {'z'}
    };
    
    int[][] expectedMatrix = {
      {'a', 'b', 'c', 'd', 'e'},
      {'f', 'g', 'h', 'i', 'j'},
      {'k', 'l', 'm', 'n', 'o'},
      {'p', 'q', 'r', 's', 't'},
      {'u', 'v', 'w', 'x', 'y'},
      {'z'}
    }; 
    
    assertEquals(classUnderTest.rotate(originalMatrix), expectedMatrix);
  }
  
  @Test
  public void testRotate360() {
    int[][] originalMatrix = {
      {'a', 'b', 'c', 'd', 'e'},
      {'f', 'g', 'h', 'i', 'j'},
      {'k', 'l', 'm', 'n', 'o'},
      {'p', 'q', 'r', 's', 't'},
      {'u', 'v', 'w', 'x', 'y'}
    };
    
    int[][] expectedMatrix = {
      {'a', 'b', 'c', 'd', 'e'},
      {'f', 'g', 'h', 'i', 'j'},
      {'k', 'l', 'm', 'n', 'o'},
      {'p', 'q', 'r', 's', 't'},
      {'u', 'v', 'w', 'x', 'y'}
    };
    
    // + 90 degrees
    classUnderTest.rotate(originalMatrix);
    // + 180 degrees
    classUnderTest.rotate(originalMatrix);
    // + 270 degrees
    classUnderTest.rotate(originalMatrix);
    // + 360 degrees
    classUnderTest.rotate(originalMatrix);

    assertEquals(originalMatrix, expectedMatrix);
  }
}
