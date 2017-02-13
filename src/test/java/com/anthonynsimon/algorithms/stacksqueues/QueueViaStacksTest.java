package com.anthonynsimon.algorithms.stacksqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueViaStacksTest {

    private QueueViaStacks<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new QueueViaStacks<>();
    }

    @Test
    public void testEmptyPeek() {
        assertEquals(classUnderTest.peek(), null);
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testEmptyDequeue() {
        assertEquals(classUnderTest.dequeue(), null);
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testEnqueue() {
        classUnderTest.enqueue("hey");
        assertEquals(classUnderTest.peek(), "hey");
        assertEquals(classUnderTest.size(), 1);

        classUnderTest.enqueue("there");
        assertEquals(classUnderTest.peek(), "hey");
        assertEquals(classUnderTest.size(), 2);

        classUnderTest.enqueue("you");
        assertEquals(classUnderTest.peek(), "hey");
        assertEquals(classUnderTest.size(), 3);
    }

    @Test
    public void testDequeue() {
        classUnderTest.enqueue("hey");

        classUnderTest.enqueue("there");

        classUnderTest.enqueue("you");

        assertEquals(classUnderTest.size(), 3);
        assertEquals(classUnderTest.dequeue(), "hey");
        assertEquals(classUnderTest.size(), 2);
        assertEquals(classUnderTest.dequeue(), "there");
        assertEquals(classUnderTest.size(), 1);
        assertEquals(classUnderTest.dequeue(), "you");
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testEmptying() {
        classUnderTest.enqueue("hey");
        classUnderTest.enqueue("there");
        classUnderTest.enqueue("you");

        assertEquals(classUnderTest.size(), 3);

        classUnderTest.dequeue();
        classUnderTest.dequeue();
        classUnderTest.dequeue();

        assertEquals(classUnderTest.size(), 0);

        assertEquals(classUnderTest.dequeue(), null);
    }
}