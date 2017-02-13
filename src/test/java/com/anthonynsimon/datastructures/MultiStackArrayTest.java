package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiStackArrayTest {

    private MultiStackArray<Integer> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new MultiStackArray<>(3, 256);
    }

    @Test
    public void testEmptyStacks() {
        assertEquals(classUnderTest.sizeOfStack(0), 0);
        assertEquals(classUnderTest.sizeOfStack(1), 0);
        assertEquals(classUnderTest.sizeOfStack(2), 0);
        assertEquals(classUnderTest.stackCount(), 3);
    }

    @Test
    public void testStackCounts() {
        classUnderTest = new MultiStackArray<>(1, 128);

        assertEquals(classUnderTest.stackCount(), 1);
        assertEquals(classUnderTest.sizeOfStack(0), 0);

        classUnderTest = new MultiStackArray<>(5, 64);

        assertEquals(classUnderTest.stackCount(), 5);
        assertEquals(classUnderTest.sizeOfStack(0), 0);
        assertEquals(classUnderTest.sizeOfStack(1), 0);
        assertEquals(classUnderTest.sizeOfStack(2), 0);
        assertEquals(classUnderTest.sizeOfStack(3), 0);
        assertEquals(classUnderTest.sizeOfStack(4), 0);
    }

    @Test
    public void testPushingElements() {
        classUnderTest.push(0, 152);
        classUnderTest.push(0, 355);
        classUnderTest.push(0, 722);

        assertEquals(classUnderTest.peek(0), Integer.valueOf(722));
        assertEquals(classUnderTest.sizeOfStack(0), 3);

        classUnderTest.push(2, 22);
        classUnderTest.push(2, 888);

        assertEquals(classUnderTest.peek(2), Integer.valueOf(888));
        assertEquals(classUnderTest.sizeOfStack(2), 2);

        classUnderTest.push(1, 45);

        assertEquals(classUnderTest.peek(1), Integer.valueOf(45));
        assertEquals(classUnderTest.sizeOfStack(1), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPushingOutOfRange() {
        classUnderTest = new MultiStackArray<>(3, 3);

        classUnderTest.push(0, 152);
        classUnderTest.push(0, 355);
        classUnderTest.push(0, 355);
        classUnderTest.push(0, 355);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPoppingOutOfRange() {
        classUnderTest = new MultiStackArray<>(3, 3);

        classUnderTest.push(1, 152);
        classUnderTest.push(1, 355);

        classUnderTest.pop(1);
        classUnderTest.pop(1);
        classUnderTest.pop(1);
    }

    @Test
    public void testPoppingElements() {
        classUnderTest = new MultiStackArray<>(4, 128);

        classUnderTest.push(0, 152);
        classUnderTest.push(0, 355);
        classUnderTest.push(0, 722);

        classUnderTest.push(2, 12);
        classUnderTest.push(2, 7);
        classUnderTest.push(2, 5);
        classUnderTest.push(2, 435);
        classUnderTest.push(2, 855);

        classUnderTest.push(1, 89);

        classUnderTest.push(3, 44);
        classUnderTest.push(3, 72);

        assertEquals(classUnderTest.sizeOfStack(0), 3);
        assertEquals(classUnderTest.pop(0), Integer.valueOf(722));
        assertEquals(classUnderTest.peek(0), Integer.valueOf(355));
        assertEquals(classUnderTest.sizeOfStack(0), 2);

        assertEquals(classUnderTest.sizeOfStack(1), 1);
        assertEquals(classUnderTest.pop(1), Integer.valueOf(89));
        assertEquals(classUnderTest.sizeOfStack(1), 0);

        assertEquals(classUnderTest.sizeOfStack(2), 5);
        assertEquals(classUnderTest.pop(2), Integer.valueOf(855));
        assertEquals(classUnderTest.peek(2), Integer.valueOf(435));
        assertEquals(classUnderTest.sizeOfStack(2), 4);

        assertEquals(classUnderTest.sizeOfStack(3), 2);
        assertEquals(classUnderTest.pop(3), Integer.valueOf(72));
        assertEquals(classUnderTest.peek(3), Integer.valueOf(44));
        assertEquals(classUnderTest.sizeOfStack(3), 1);
    }
}