package com.anthonynsimon.algorithms.sorts;

public final class BubbleSort {

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        // Iterate over array swaping positions if does not fulfill i < i + 1 order
        // Stop iterating if no modification was done in pass
        boolean modified = true;
        while (modified) {
            modified = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    modified = true;
                }
            }
        }

        return array;
    }
}