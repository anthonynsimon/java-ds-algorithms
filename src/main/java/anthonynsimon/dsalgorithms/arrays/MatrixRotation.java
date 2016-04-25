package anthonynsimon.dsalgorithms.arrays;

public class MatrixRotation {
  
  public int[][] rotate(int[][] matrix) {
    int sideLength = matrix.length;
    
    if (sideLength != matrix[0].length) {
      return matrix;
    }
    
    for (int layer = 0; layer < sideLength/2; layer++) {
      for (int position = layer; position < sideLength-1-layer; position++) {
        int temp = matrix[position][layer];
        matrix[position][layer] = matrix[sideLength-1-layer][position];
        matrix[sideLength-1-layer][position] = matrix[sideLength-1-position][sideLength-1-layer];
        matrix[sideLength-1-position][sideLength-1-layer] = matrix[layer][sideLength-1-position];
        matrix[layer][sideLength-1-position] = temp;
      }
    } 
    
    return matrix;
  }
}