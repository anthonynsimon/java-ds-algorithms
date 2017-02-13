package com.anthonynsimon.algorithms.arrays;

public final class MatrixRotation {

    /*
    * Iterate over each "layer", starting from the corners swap each cell in-place.
    *
    * Layers move from the outside-in.
    *
    * [X][X][X][X]  ->  [ ][ ][ ][ ]
    * [X][ ][ ][X]  ->  [ ][X][X][ ]
    * [X][ ][ ][X]  ->  [ ][X][X][ ]
    * [X][X][X][X]  ->  [ ][ ][ ][ ]
    *
    * Positions move from each segment's start until one unit before the last,
    * as that has already been rotated.
    *
    * A <= B <= C <= D <= A
    *
    * [D][ ][ ][C]  ->  [ ][ ][C][ ]  ->  [ ][C][ ][ ]  ->  [ ][ ][ ][ ]
    * [ ][ ][ ][ ]  ->  [D][ ][ ][ ]  ->  [ ][ ][ ][B]  ->  [ ][D][C][ ]
    * [ ][ ][ ][ ]  ->  [ ][ ][ ][B]  ->  [D][ ][ ][ ]  ->  [ ][A][B][ ]
    * [A][ ][ ][B]  ->  [ ][A][ ][ ]  ->  [ ][ ][A][ ]  ->  [ ][ ][ ][ ]
    *
    */
    public static int[][] rotate(int[][] matrix) {
        int sideLength = matrix.length;

        // Return early if matrix is not square or if it's empty
        if (sideLength == 0 || sideLength != matrix[0].length) {
            return matrix;
        }

        for (int layer = 0; layer < sideLength / 2; layer++) {
            for (int position = layer; position < sideLength - 1 - layer; position++) {
                int temp = matrix[position][layer];
                matrix[position][layer] = matrix[sideLength - 1 - layer][position];
                matrix[sideLength - 1 - layer][position] = matrix[sideLength - 1 - position][sideLength - 1 - layer];
                matrix[sideLength - 1 - position][sideLength - 1 - layer] = matrix[layer][sideLength - 1 - position];
                matrix[layer][sideLength - 1 - position] = temp;
            }
        }

        return matrix;
    }
}