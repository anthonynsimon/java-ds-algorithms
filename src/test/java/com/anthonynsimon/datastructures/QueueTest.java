package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Queue<>();
    }

    @Test
    public void testEmptyQueue() {
        assertEquals(classUnderTest.dequeue(), null);
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testEnqueue() {
        classUnderTest.enqueue("this");

        assertEquals(classUnderTest.size(), 1);

        classUnderTest.enqueue("that");
        assertEquals(classUnderTest.size(), 2);
    }

    @Test
    public void testPeek() {
        classUnderTest.enqueue("this");
        classUnderTest.enqueue("that");

        assertEquals(classUnderTest.peek(), "this");

        classUnderTest.dequeue();

        assertEquals(classUnderTest.peek(), "that");

        classUnderTest.dequeue();

        assertEquals(classUnderTest.peek(), null);
    }

    @Test
    public void testDequeue() {
        classUnderTest.clear();
        classUnderTest.enqueue("one");
        classUnderTest.enqueue("two");

        assertEquals(classUnderTest.dequeue(), "one");
        assertEquals(classUnderTest.dequeue(), "two");

        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testClear() {
        classUnderTest.enqueue("this");
        classUnderTest.enqueue("that");

        classUnderTest.clear();
        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.dequeue(), null);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(classUnderTest.isEmpty());

        classUnderTest.enqueue("this");
        classUnderTest.enqueue("that");

        assertFalse(classUnderTest.isEmpty());
    }
}