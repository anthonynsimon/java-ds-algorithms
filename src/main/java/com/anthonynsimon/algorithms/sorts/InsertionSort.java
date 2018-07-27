package com.anthonynsimon.algorithms.sorts;

/**
 * Created by krishna.shetty on 2/23/17.
 */
public class InsertionSort {

    public static int[] sort(int[] array) {

        if (array.length <= 1) {
            // At this length, array is already sorted
            return array;
        }


        for (int i = 0; i < array.length; i++) {

            // This is the element which we will "insert" in the right place
            final int elementBeingSorted = array[i];

            // Start with the previous index, and go until the beginning of the array if needed
            // until we find the right place for this element

            int j = i - 1;

            while (j >= 0 && array[j] >= elementBeingSorted) {

                // Since the element we are comparing elementBeingSorted to is larger,
                // we move it ahead by one index
                array[j + 1] = array[j];

                j--;

            } // End while loop

            // Once the loop is done, the element at index j will be lesser than "elementBeingSorted"
            // OR the index j will be -1, which means we have reached the beginning of the array
            // Therefore index j+1 is the right position for "elementBeingSorted"
            array[j + 1] = elementBeingSorted;

        } // End for loop

        return array;

    }

}
