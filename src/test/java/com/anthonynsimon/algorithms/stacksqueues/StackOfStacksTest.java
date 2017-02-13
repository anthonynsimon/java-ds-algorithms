package com.anthonynsimon.algorithms.stacksqueues;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class StackOfStacksTest {

    private StackOfStacks<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new StackOfStacks<>(4);
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.stackCount(), 0);

        // Pop empty stack, will throw exception
        classUnderTest.pop();
    }

    @Test
    public void testPushingElements() {
        classUnderTest.push("there");

        assertEquals(classUnderTest.size(), 1);

        classUnderTest.push("hello");

        assertEquals(classUnderTest.size(), 2);
        assertEquals(classUnderTest.stackCount(), 1);

        classUnderTest.push("something");
        classUnderTest.push("else");
        classUnderTest.push("here");

        assertEquals(classUnderTest.stackCount(), 2);
    }

    @Test(expected = EmptyStackException.class)
    public void testPoppingElements() {
        classUnderTest.push("there");
        classUnderTest.push("hello");

        assertEquals(classUnderTest.stackCount(), 1);
        assertEquals(classUnderTest.pop(), "hello");
        assertEquals(classUnderTest.size(), 1);
        assertEquals(classUnderTest.pop(), "there");
        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.stackCount(), 0);

        // Pop empty stack, exception expected
        classUnderTest.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeeking() {
        classUnderTest.push("some");
        classUnderTest.push("people");

        assertEquals(classUnderTest.peek(), "people");

        classUnderTest.pop();

        assertEquals(classUnderTest.peek(), "some");

        // Pop last element
        classUnderTest.pop();

        // Peek empty stack, will throw exception
        classUnderTest.peek();
    }
}