package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new BinarySearchTree<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(classUnderTest.isEmpty());

        classUnderTest.insert("hello");

        assertFalse(classUnderTest.isEmpty());
    }

    @Test
    public void testInsert() {
        assertEquals(classUnderTest.size(), 0);

        classUnderTest.insert("hello");

        assertEquals(classUnderTest.size(), 1);

        classUnderTest.insert("there");

        assertEquals(classUnderTest.size(), 2);

    }

    @Test
    public void testRemove() {
        classUnderTest.insert("hello");
        classUnderTest.insert("there");
        classUnderTest.insert("you");

        assertEquals(classUnderTest.size(), 3);
        assertEquals(classUnderTest.find("hello"), "hello");

        classUnderTest.remove("hello");

        assertEquals(classUnderTest.find("hello"), null);
        assertEquals(classUnderTest.size(), 2);

        classUnderTest.remove("there");
        classUnderTest.remove("you");

        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testRemoveRoot() {
        classUnderTest.insert("b");
        classUnderTest.insert("a2");
        classUnderTest.insert("a1");
        classUnderTest.insert("a3");
        classUnderTest.insert("c");

        assertEquals(classUnderTest.toString(), "[a1, a2, a3, b, c]");

        classUnderTest.remove("b");

        assertEquals(classUnderTest.toString(), "[a1, a2, a3, c]");
    }

    @Test
    public void testRemoveTwoChildren() {
        classUnderTest.insert("m");
        classUnderTest.insert("b");
        classUnderTest.insert("x");
        classUnderTest.insert("a");
        classUnderTest.insert("c");

        assertEquals(classUnderTest.toString(), "[a, b, c, m, x]");

        classUnderTest.remove("b");

        assertEquals(classUnderTest.toString(), "[a, c, m, x]");
    }

    @Test
    public void testFind() {
        assertEquals(classUnderTest.find("hello"), null);

        classUnderTest.insert("hello");
        classUnderTest.insert("there");
        classUnderTest.insert("you");

        assertEquals(classUnderTest.find("hello"), "hello");
        assertEquals(classUnderTest.find("there"), "there");
        assertEquals(classUnderTest.find("you"), "you");
        assertEquals(classUnderTest.find("no"), null);
    }

    @Test
    public void testSize() {
        assertEquals(classUnderTest.size(), 0);

        classUnderTest.insert("a");

        assertEquals(classUnderTest.size(), 1);

        classUnderTest.insert("c");
        classUnderTest.insert("z");
        classUnderTest.insert("0");
        classUnderTest.insert("zz");

        assertEquals(classUnderTest.size(), 5);
    }

    @Test
    public void testMaxHeight() {
        assertEquals(classUnderTest.getHeight(), 0);

        classUnderTest.insert("b");

        assertEquals(classUnderTest.getHeight(), 0);

        classUnderTest.insert("c");

        assertEquals(classUnderTest.getHeight(), 1);

        classUnderTest.insert("a");

        assertEquals(classUnderTest.getHeight(), 1);

        classUnderTest.insert("f");

        assertEquals(classUnderTest.getHeight(), 2);
    }

    @Test
    public void testToString() {
        classUnderTest.insert("b");
        classUnderTest.insert("a");
        classUnderTest.insert("c");
        classUnderTest.insert("z");
        classUnderTest.insert("0");
        classUnderTest.insert("zz");
        classUnderTest.insert("nada");
        classUnderTest.insert("naa");

        assertEquals(classUnderTest.toString(), "[0, a, b, c, naa, nada, z, zz]");
    }

    @Test
    public void testClear() {
        classUnderTest.insert("there");
        classUnderTest.insert("there");
        classUnderTest.insert("there");
        classUnderTest.insert("there");

        assertEquals(classUnderTest.size(), 4);

        classUnderTest.clear();

        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.find("there"), null);
    }
}