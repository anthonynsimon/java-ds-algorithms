package com.anthonynsimon.algorithms.sorts;

public final class MergeSort {

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int min, int max) {
        // Base case, a list of one element is by definition sorted
        if (min == max) {
            return new int[]{array[min]};
        }

        // Divide array into halves while recursively merging
        int mid = (min + max) / 2;
        int[] left = mergeSort(array, min, mid);
        int[] right = mergeSort(array, mid + 1, max);

        // Recombine halves while sorting and return
        return combine(left, right);
    }

    // Combines left and right array by picking the smallest element between the two at each position
    private static int[] combine(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // 1. Pick the smallest between the left and right until one of the array's end is reached
        // 2. Copy the selected to the result
        // 3. Move the index from the picked and the result
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // The larger array still has elements that have not been placed into results
        // Move them into the results starting from the last known index
        // Note that only one of the two loops will enter
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}