package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    private PriorityQueue<String> pq;

    @Before
    public void setUp() {
        pq = new PriorityQueue<>();
    }

    @Test
    public void testHeapify() {
        String[] data = new String[]{
                "g",
                "h",
                "d",
                "c",
                "b",
                "f",
                "a",
                "e"
        };

        int[] priorities = new int[]{
                6,
                7,
                3,
                2,
                1,
                5,
                0,
                4
        };

        pq = new PriorityQueue<>(priorities, data);

        String[] orderedResult = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

        for (int i = 0; i < data.length; i++) {
            assertEquals(pq.removeMin(), orderedResult[i]);
        }
    }

    @Test
    public void testEmpty() {
        assertTrue(pq.isEmpty());
        assertEquals(pq.removeMin(), null);
        assertEquals(pq.peekMin(), null);
    }

    @Test
    public void testTwoElementsInsert() {
        pq.insert(4, "hello");
        pq.insert(78, "mario");
    }

    @Test
    public void testUnorderedInsert() {
        String[] data = new String[]{
                "g",
                "h",
                "d",
                "c",
                "b",
                "f",
                "a",
                "e"
        };

        for (String letter : data) {
            pq.insert(Character.getNumericValue(letter.charAt(0)), letter);
        }

        String[] orderedResult = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

        for (int i = 0; i < data.length; i++) {
            assertEquals(pq.removeMin(), orderedResult[i]);
        }
    }

    @Test
    public void testOrderedInsert() {
        String[] data = new String[]{
                "a",
                "b",
                "c",
                "d",
                "e",
                "f"
        };

        for (int i = 0; i < data.length; i++) {
            pq.insert(i, data[i]);
        }

        assertArrayEquals(pq.toArray(), data);
    }

    @Test
    public void testPeek() {
        String[] data = new String[]{
                "a",
                "b",
                "c",
                "d",
                "e",
                "f"
        };

        for (int i = 0; i < data.length; i++) {
            pq.insert(data.length - i, data[i]);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            assertEquals(pq.peekMin(), data[i]);
            pq.removeMin();
        }
    }

    @Test
    public void testReverseInsert() {
        String[] data = new String[]{
                "a",
                "b",
                "c",
                "d",
                "e",
                "f"
        };

        for (int i = 0; i < data.length; i++) {
            pq.insert(data.length - i, data[i]);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            assertEquals(pq.removeMin(), data[i]);
        }
    }

    @Test
    public void testRemoveMax() {
        pq.insert(30, "mario");
        pq.insert(15, "hello");
        pq.insert(5, "norway");
        pq.insert(10, "this");

        assertEquals(pq.removeMin(), "norway");
        assertEquals(pq.removeMin(), "this");
        assertEquals(pq.removeMin(), "hello");
        assertEquals(pq.removeMin(), "mario");
        assertEquals(pq.removeMin(), null);

        pq.insert(5, "desk");
        pq.insert(7, "top");

        assertEquals(pq.removeMin(), "desk");
        assertEquals(pq.removeMin(), "top");
        assertEquals(pq.removeMin(), null);
    }

    @Test
    public void testRemoveMin() {
        pq.insert(30, "mario");
        pq.insert(15, "hello");
        pq.insert(5, "norway");
        pq.insert(10, "this");

        assertEquals(pq.removeMin(), "norway");
        assertEquals(pq.removeMin(), "this");
        assertEquals(pq.removeMin(), "hello");
        assertEquals(pq.removeMin(), "mario");
        assertEquals(pq.removeMin(), null);

        pq.insert(5, "desk");
        pq.insert(7, "top");

        assertEquals(pq.removeMin(), "desk");
        assertEquals(pq.removeMin(), "top");
        assertEquals(pq.removeMin(), null);
    }

    @Test
    public void testBuildFromArray() {

    }

    @Test
    public void testSize() {
        assertEquals(pq.size(), 0);

        pq.insert(17, "mario");
        pq.insert(44, "hello");
        pq.insert(90, "norway");
        pq.insert(82, "this");

        assertEquals(pq.size(), 4);

        pq.removeMin();

        assertEquals(pq.size(), 3);

        pq.removeMin();
        pq.removeMin();
        pq.removeMin();
        pq.removeMin();
        pq.removeMin();

        assertEquals(pq.size(), 0);
    }

    @Test
    public void testClear() {
        pq.insert(17, "mario");
        pq.insert(44, "hello");
        pq.insert(90, "norway");
        pq.insert(82, "this");

        assertEquals(pq.size(), 4);

        pq.clear();

        assertEquals(pq.size(), 0);
        assertEquals(pq.removeMin(), null);

        pq.insert(17, "mario");
        pq.insert(44, "hello");
        pq.insert(90, "norway");
        pq.insert(82, "this");

        assertEquals(pq.removeMin(), "mario");
    }

    @Test
    public void testToString() {
        assertEquals(pq.toString(), "");

        pq.insert(2, "hello");
        pq.insert(3, "mario");
        pq.insert(1, "this");
        pq.insert(0, "norway");

        assertEquals(pq.toString(), "norway, this, hello, mario");
    }

    @Test
    public void testToArray() {
        assertArrayEquals(pq.toArray(), new String[]{});

        pq.insert(4, "hello");
        pq.insert(7, "mario");
        pq.insert(2, "this");
        pq.insert(1, "norway");

        assertArrayEquals(pq.toArray(), new String[]{"norway", "this", "hello", "mario"});
    }
}