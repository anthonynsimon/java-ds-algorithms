package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicArrayTest {

    private DynamicArray<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new DynamicArray<>(4);
    }

    @Test
    public void testEmpty() {
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testAdding() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");

        assertEquals(classUnderTest.size(), 3);
        assertEquals(classUnderTest.capacity(), 4);
    }

    @Test
    public void testExpanding() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");
        classUnderTest.add("here");
        classUnderTest.add("a");
        classUnderTest.add("abc");

        assertEquals(classUnderTest.size(), 6);
        assertEquals(classUnderTest.capacity(), 8);
    }

    @Test
    public void testGetting() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");
        classUnderTest.add("here");
        classUnderTest.add("a");
        classUnderTest.add("abc");

        assertEquals(classUnderTest.get(0), "hello");
        assertEquals(classUnderTest.get(3), "here");
        assertEquals(classUnderTest.get(1), "something");
        assertEquals(classUnderTest.capacity(), 8);
    }

    @Test
    public void testSetting() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");
        classUnderTest.add("here");
        classUnderTest.add("a");
        classUnderTest.add("abc");

        assertEquals(classUnderTest.get(7), null);

        assertEquals(classUnderTest.get(0), "hello");
        classUnderTest.set(0, "this");
        assertEquals(classUnderTest.get(0), "this");

        assertEquals(classUnderTest.get(4), "a");
        classUnderTest.set(4, "y");
        assertEquals(classUnderTest.get(4), "y");

        assertEquals(classUnderTest.size(), 6);
        assertEquals(classUnderTest.capacity(), 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");
        classUnderTest.add("here");
        classUnderTest.add("a");
        classUnderTest.add("abc");

        classUnderTest.get(8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSettingOutOfBounds() {
        classUnderTest.add("hello");
        classUnderTest.add("something");
        classUnderTest.add("beach");
        classUnderTest.add("here");
        classUnderTest.add("a");
        classUnderTest.add("abc");

        classUnderTest.set(8, "asd");
    }
}