package com.anthonynsimon.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixRotationTest {

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

        assertArrayEquals(MatrixRotation.rotate(originalMatrix), expectedMatrix);
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

        assertArrayEquals(MatrixRotation.rotate(originalMatrix), expectedMatrix);
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

        assertArrayEquals(MatrixRotation.rotate(originalMatrix), expectedMatrix);
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
        MatrixRotation.rotate(originalMatrix);
        // + 180 degrees
        MatrixRotation.rotate(originalMatrix);
        // + 270 degrees
        MatrixRotation.rotate(originalMatrix);
        // + 360 degrees
        MatrixRotation.rotate(originalMatrix);

        assertArrayEquals(originalMatrix, expectedMatrix);
    }
}
