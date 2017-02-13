package com.anthonynsimon.algorithms.arrays;

public final class NullifyMatrix {

    public static int[][] nullify(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }

        // Return early if row length is not uniform
        if (!hasUniformRows(matrix)) {
            return matrix;
        }

        // Prepare helper arrays for marking position of 0's
        boolean[] nullableRows = new boolean[matrix.length];
        boolean[] nullableColumns = new boolean[matrix[0].length];

        // Scan and mark the position of each '0' found
        scanAndMarkNullable(matrix, nullableRows, nullableColumns);

        // Go through helper arrays and nullify the column and row of for each '0' marked
        nullifyRows(matrix, nullableRows);
        nullifyColumns(matrix, nullableColumns);

        return matrix;
    }

    private static boolean hasUniformRows(int[][] matrix) {
        int rowLength = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != rowLength) {
                return false;
            }
        }

        return true;
    }

    private static void scanAndMarkNullable(int[][] matrix, boolean[] nullableRows, boolean[] nullableColumns) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    nullableRows[i] = true;
                    nullableColumns[j] = true;
                }
            }
        }
    }

    private static void nullifyRows(int[][] matrix, boolean[] nullableRows) {
        for (int rowIndex = 0; rowIndex < nullableRows.length; rowIndex++) {
            if (nullableRows[rowIndex]) {
                for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }
    }

    private static void nullifyColumns(int[][] matrix, boolean[] nullableColumns) {
        for (int columnIndex = 0; columnIndex < nullableColumns.length; columnIndex++) {
            if (nullableColumns[columnIndex]) {
                for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                    matrix[rowIndex][columnIndex] = 0;
                }
            }
        }
    }
}