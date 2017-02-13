package com.anthonynsimon.algorithms.stacksqueues;

import com.anthonynsimon.datastructures.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackSorterTest {

    private StackSorter<Integer> classUnderTest;
    private Stack<Integer> testStack;

    @Before
    public void setUp() {
        classUnderTest = new StackSorter<>();
        testStack = new Stack<>();
    }

    @Test
    public void testEmptyStack() {
        classUnderTest.sort(testStack);

        assertEquals(testStack.toString(), "");
    }

    @Test
    public void testTwoElementsStack() {
        testStack.push(3);
        testStack.push(4);

        assertEquals(testStack.toString(", "), "4, 3");

        classUnderTest.sort(testStack);

        assertEquals(testStack.toString(", "), "3, 4");

        classUnderTest.sort(testStack);

        assertEquals(testStack.toString(", "), "3, 4");
    }

    @Test
    public void testSmallStack() {
        testStack.push(5);
        testStack.push(3);
        testStack.push(7);
        testStack.push(0);

        assertEquals(testStack.toString(", "), "0, 7, 3, 5");

        classUnderTest.sort(testStack);

        assertEquals(testStack.toString(", "), "0, 3, 5, 7");
    }

    @Test
    public void testLargerStack() {
        testStack.push(-5);
        testStack.push(5);
        testStack.push(0);
        testStack.push(7);
        testStack.push(-1);
        testStack.push(7);
        testStack.push(44);
        testStack.push(1);
        testStack.push(7);

        assertEquals(testStack.toString(", "), "7, 1, 44, 7, -1, 7, 0, 5, -5");

        classUnderTest.sort(testStack);

        assertEquals(testStack.toString(", "), "-5, -1, 0, 1, 5, 7, 7, 7, 44");
    }
}