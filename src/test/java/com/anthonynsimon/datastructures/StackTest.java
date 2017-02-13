package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;

public class StackTest {

    private Stack<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Stack<>();
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() {
        assertEquals(classUnderTest.size(), 0);

        // Pop empty stack, will throw exception
        classUnderTest.pop();
    }

    @Test
    public void testPushingElements() {
        classUnderTest.push("there");

        assertEquals(classUnderTest.size(), 1);

        classUnderTest.push("hello");

        assertEquals(classUnderTest.size(), 2);
    }

    @Test(expected = EmptyStackException.class)
    public void testPoppingElements() {
        classUnderTest.push("there");
        classUnderTest.push("hello");

        assertEquals(classUnderTest.pop(), "hello");
        assertEquals(classUnderTest.pop(), "there");
        classUnderTest.pop();
    }

    @Test
    public void testToString() {
        classUnderTest.push("you");
        classUnderTest.push("there");
        classUnderTest.push("hello");

        assertEquals(classUnderTest.toString(", "), "hello, there, you");

        classUnderTest.push("hola!, ");

        assertEquals(classUnderTest.toString(), "hola!, hellothereyou");
    }

    @Test(expected = EmptyStackException.class)
    public void testPeeking() {
        classUnderTest.clear();
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

    @Test
    public void testClear() {
        classUnderTest.clear();

        assertEquals(classUnderTest.size(), 0);

        classUnderTest.push("this");
        classUnderTest.push("that");
        classUnderTest.push("some");

        assertEquals(classUnderTest.size(), 3);

        classUnderTest.clear();

        assertEquals(classUnderTest.size(), 0);
    }
}