package com.anthonynsimon.algorithms.sorts;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    private int[] actual;
    private int[] expected;
    private Random rand;

    @Before
    public void setUp() {
        rand = new Random();
    }

    @Test
    public void testSimple() {
        actual = new int[]{10, 5, 0, 9, 4, 1, 8, 3, 2, 7, 6};
        expected = actual.clone();
        Arrays.sort(expected);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testEmpty() {
        actual = new int[]{};
        expected = actual.clone();
        Arrays.sort(expected);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testEvenSize() {
        actual = new int[]{rand.nextInt(1024), rand.nextInt(1024)};
        expected = actual.clone();
        Arrays.sort(expected);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testOddSize() {
        actual = new int[]{rand.nextInt(1024), rand.nextInt(1024), rand.nextInt(1024)};
        expected = actual.clone();
        Arrays.sort(expected);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testRandom() {
        actual = generateUnsortedArray(1024);
        expected = actual.clone();
        Arrays.sort(expected);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testReversed() {
        actual = generateSortedArray(1024);
        expected = actual.clone();

        reverseArray(actual);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testPresorted() {
        actual = generateSortedArray(1024);
        expected = actual.clone();

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void testHalfSorted() {
        actual = generateSortedArray(1024);
        expected = actual.clone();
        shuffleArrayRange(actual, 0, 512);

        actual = MergeSort.sort(actual);
        assertArrayEquals(actual, expected);
    }

    private int[] generateUnsortedArray(int size) {
        int[] result = generateSortedArray(size);
        shuffleArrayRange(result, 0, size);
        return result;
    }

    private int[] generateSortedArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }

    private void reverseArray(int[] array) {
        int arraySize = array.length;
        for (int i = 0; i < arraySize / 2; i++) {
            int temp = array[i];
            array[i] = array[arraySize - 1 - i];
            array[arraySize - 1 - i] = temp;
        }
    }

    private void shuffleArrayRange(int[] array, int min, int max) {
        if (min < 0 || array.length < max) {
            return;
        }
        for (int i = min; i < max; i++) {
            swap(array, i, rand.nextInt(max));
        }
    }

    private void swap(int[] array, int a, int b) {
        if (a < 0 || array.length <= a || b < 0 || array.length <= b) {
            return;
        }

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}