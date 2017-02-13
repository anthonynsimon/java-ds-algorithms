package com.anthonynsimon.algorithms.stacksqueues;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class MinStackTest {

    private MinStack<Integer> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new MinStack<>();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmpty() {
        assertEquals(classUnderTest.min(), null);
        classUnderTest.pop();
    }

    @Test
    public void testOneElement() {
        classUnderTest.push(5);

        assertEquals(classUnderTest.min(), Integer.valueOf(5));
        assertEquals(classUnderTest.pop(), Integer.valueOf(5));
    }

    @Test
    public void testTwoElementsOneMin() {
        classUnderTest.push(1);
        classUnderTest.push(5);

        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(5));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
    }

    @Test
    public void testTwoElementsTwoMin() {
        classUnderTest.push(5);
        classUnderTest.push(1);

        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
        assertEquals(classUnderTest.min(), Integer.valueOf(5));
        assertEquals(classUnderTest.pop(), Integer.valueOf(5));
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackMin() {
        classUnderTest.push(5);
        classUnderTest.push(1);

        classUnderTest.pop();
        classUnderTest.pop();

        // Exception expected
        classUnderTest.min();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStackPop() {
        classUnderTest.push(5);
        classUnderTest.push(1);

        classUnderTest.pop();
        classUnderTest.pop();

        // Pop empty stack, exception expected
        classUnderTest.pop();
    }

    @Test
    public void testLongerStackOneMin() {
        classUnderTest.push(5);
        classUnderTest.push(1);
        classUnderTest.push(3);
        classUnderTest.push(3);
        classUnderTest.push(7);
        classUnderTest.push(3);

        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(3));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(7));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(3));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(3));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
        assertEquals(classUnderTest.min(), Integer.valueOf(5));
        assertEquals(classUnderTest.pop(), Integer.valueOf(5));
    }

    @Test
    public void testLongerStackMultipleMins() {
        classUnderTest.push(5);
        classUnderTest.push(1);
        classUnderTest.push(3);
        classUnderTest.push(1);
        classUnderTest.push(7);
        classUnderTest.push(1);

        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(7));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(3));
        assertEquals(classUnderTest.min(), Integer.valueOf(1));
        assertEquals(classUnderTest.pop(), Integer.valueOf(1));
        assertEquals(classUnderTest.min(), Integer.valueOf(5));
        assertEquals(classUnderTest.pop(), Integer.valueOf(5));
    }
}