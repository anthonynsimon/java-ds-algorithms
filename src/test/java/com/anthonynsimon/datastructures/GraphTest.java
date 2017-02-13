package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

    private Graph classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Graph();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(classUnderTest.isEmpty());
    }

    @Test
    public void testAddingVertices() {
        classUnderTest.addVertex("ABC");

        assertFalse(classUnderTest.isEmpty());
    }

    @Test
    public void testRemovingVertices() {
        classUnderTest.addVertex("123");

        assertTrue(classUnderTest.containsVertex("123"));
        assertFalse(classUnderTest.isEmpty());

        classUnderTest.removeVertex("123");

        assertFalse(classUnderTest.containsVertex("123"));
        assertTrue(classUnderTest.isEmpty());
    }

    @Test
    public void testAddingEdges() {
        classUnderTest.addVertex("A");
        classUnderTest.addVertex("B");
        classUnderTest.addVertex("C");
        classUnderTest.addVertex("D");
        classUnderTest.addVertex("E");
        classUnderTest.addVertex("F");

        classUnderTest.addEdge("A", "B");
        classUnderTest.addEdge("B", "C");
        classUnderTest.addEdge("D", "C");
        classUnderTest.addEdge("E", "B");
        classUnderTest.addEdge("D", "G");

        assertTrue(classUnderTest.distanceBetween("A", "B") == 1);
        assertTrue(classUnderTest.distanceBetween("A", "C") == 2);
        assertTrue(classUnderTest.distanceBetween("A", "D") == 3);
        assertTrue(classUnderTest.distanceBetween("C", "B") == 1);
        assertTrue(classUnderTest.distanceBetween("D", "B") == 2);
        assertTrue(classUnderTest.distanceBetween("D", "E") == 3);
        assertTrue(classUnderTest.distanceBetween("D", "F") == 0);
        assertTrue(classUnderTest.distanceBetween("D", "G") == 0);
    }

    @Test
    public void testRemovingEdges() {
        classUnderTest.addVertex("A");
        classUnderTest.addVertex("B");
        classUnderTest.addVertex("C");

        classUnderTest.addEdge("A", "B");
        classUnderTest.addEdge("B", "C");

        assertTrue(classUnderTest.distanceBetween("A", "B") == 1);
        assertTrue(classUnderTest.distanceBetween("A", "C") == 2);

        classUnderTest.removeEdge("B", "C");
        classUnderTest.removeEdge("B", "F");

        assertTrue(classUnderTest.distanceBetween("A", "B") == 1);
        assertTrue(classUnderTest.distanceBetween("A", "C") == 0);
    }

    @Test
    public void testClear() {
        classUnderTest.addVertex("A");
        classUnderTest.addVertex("B");
        classUnderTest.addVertex("C");

        classUnderTest.addEdge("A", "B");
        classUnderTest.addEdge("B", "C");

        assertFalse(classUnderTest.isEmpty());
        assertTrue(classUnderTest.containsVertex("B"));

        classUnderTest.clear();

        assertTrue(classUnderTest.isEmpty());
        assertFalse(classUnderTest.containsVertex("B"));

        classUnderTest.addVertex("A");
        classUnderTest.addVertex("B");

        classUnderTest.addEdge("A", "B");

        assertFalse(classUnderTest.isEmpty());
        assertTrue(classUnderTest.containsVertex("B"));
    }
}