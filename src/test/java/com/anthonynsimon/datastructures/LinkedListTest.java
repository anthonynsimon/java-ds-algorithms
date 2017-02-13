package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new LinkedList<>();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounds() {
        classUnderTest.insert(10, "hey");

        assertEquals(classUnderTest.get(0), null);
        assertEquals(classUnderTest.get(10), null);
        assertEquals(classUnderTest.get(-1), null);
    }

    @Test
    public void testEmptyList() {
        assertEquals(classUnderTest.size(), 0);
        assertFalse(classUnderTest.contains("Hey"));
        assertEquals(classUnderTest.peek(), null);
        assertEquals(classUnderTest.size(), 0);
    }

    @Test
    public void testListConstructor() {
        LinkedList<String> list = new LinkedList<>("Hello there");
        assertEquals(list.size(), 1);
        assertTrue(list.contains("Hello there"));

        LinkedList<String> list2 = new LinkedList<>();

        list2.build(new String[]{
                "hey",
                "you",
                "hey",
                "hey",
        });

        assertEquals(list2.size(), 4);
        assertTrue(list2.contains("you"));
    }

    @Test
    public void testListBuild() {
        classUnderTest.build(new String[]{
                "hey",
                "you",
                "hey",
                "hey",
        });

        assertEquals(classUnderTest.size(), 4);
        assertTrue(classUnderTest.contains("you"));

        classUnderTest.build(new String[]{
                "one",
                "two"
        });

        assertEquals(classUnderTest.size(), 2);
        assertTrue(classUnderTest.contains("two"));
        assertFalse(classUnderTest.contains("hey"));
    }

    @Test
    public void testOneElement() {
        classUnderTest.append("first");

        assertEquals(classUnderTest.size(), 1);
        assertEquals(classUnderTest.get(0), "first");
        assertEquals(classUnderTest.peek(), "first");
        assertFalse(classUnderTest.contains("Hey"));
        assertTrue(classUnderTest.contains("first"));
    }

    @Test
    public void testAppendingElements() {
        classUnderTest.append("first");
        classUnderTest.append("second");
        classUnderTest.append("third");

        assertEquals(classUnderTest.size(), 3);
        assertEquals(classUnderTest.get(1), "second");
        assertEquals(classUnderTest.get(2), "third");
        assertEquals(classUnderTest.peek(), "first");
        assertFalse(classUnderTest.contains("Hey"));
        assertTrue(classUnderTest.contains("third"));
    }

    @Test
    public void testSettingElements() {
        classUnderTest.append("uno");
        classUnderTest.append("dos");
        classUnderTest.append("tres");
        classUnderTest.set(1, "two");

        assertEquals(classUnderTest.size(), 3);
        assertEquals(classUnderTest.get(1), "two");
        assertFalse(classUnderTest.contains("dos"));
        assertFalse(classUnderTest.contains("dos"));
    }

    @Test
    public void testSimpleInsertion() {
        classUnderTest.append("uno");
        classUnderTest.append("dos");
        classUnderTest.append("tres");
        classUnderTest.insert(1, "uno y medio");

        assertEquals(classUnderTest.size(), 4);
        assertEquals(classUnderTest.get(0), "uno");
        assertEquals(classUnderTest.get(1), "uno y medio");
        assertEquals(classUnderTest.get(2), "dos");
        assertEquals(classUnderTest.get(3), "tres");
    }

    @Test
    public void testInsertAsFirst() {
        classUnderTest.append("one");
        classUnderTest.insert(0, "two");

        assertEquals(classUnderTest.size(), 2);
        assertEquals(classUnderTest.get(0), "two");
        assertEquals(classUnderTest.get(1), "one");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfRange() {
        classUnderTest.append("one");

        classUnderTest.insert(1, "two");

        assertEquals(classUnderTest.size(), 1);
        assertEquals(classUnderTest.get(0), "one");
        assertEquals(classUnderTest.get(1), null);
    }

    @Test
    public void testRemoveElement() {
        // Remove from list of 1 element
        classUnderTest.append("one");
        classUnderTest.remove(0);

        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.peek(), null);

        classUnderTest.append("one");
        classUnderTest.append("two");
        classUnderTest.append("three");
        classUnderTest.append("four");

        assertEquals(classUnderTest.size(), 4);
        assertEquals(classUnderTest.peek(), "one");
        assertEquals(classUnderTest.get(3), "four");

        // Remove head from list of 4 elements
        classUnderTest.remove(0); // => two -> three -> four
        assertEquals(classUnderTest.peek(), "two");

        // Remove tail from list of 3 elements
        classUnderTest.remove(2);  // => two -> three
        assertEquals(classUnderTest.peek(), "two");
        assertEquals(classUnderTest.get(1), "three");
        assertEquals(classUnderTest.size(), 2);
        assertFalse(classUnderTest.contains("four"));

        classUnderTest.insert(1, "two and a half");
        classUnderTest.insert(0, "one");

        assertEquals(classUnderTest.get(2), "two and a half");

        // Remove middle element from list of 4 elements
        assertEquals(classUnderTest.size(), 4);
        classUnderTest.remove(2);
        assertEquals(classUnderTest.size(), 3);

        assertEquals(classUnderTest.get(1), "two");
        assertEquals(classUnderTest.get(2), "three");

        // Remove middle element from list of 3 elements
        classUnderTest.remove(1);

        assertEquals(classUnderTest.peek(), "one");
        assertEquals(classUnderTest.get(1), "three");

        assertEquals(classUnderTest.size(), 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfRange() {
        classUnderTest.append("you");
        classUnderTest.remove(-1);
    }

    @Test
    public void testPop() {
        classUnderTest.append("you");
        classUnderTest.insert(0, "hey");
        classUnderTest.append("dude");

        assertEquals(classUnderTest.size(), 3);

        assertEquals(classUnderTest.pop(), "dude");
        assertEquals(classUnderTest.pop(), "you");
        assertEquals(classUnderTest.pop(), "hey");

        assertEquals(classUnderTest.size(), 0);
        assertFalse(classUnderTest.contains("hey"));
        assertFalse(classUnderTest.contains("you"));
        assertFalse(classUnderTest.contains("dude"));

        assertEquals(classUnderTest.pop(), null);
    }


    @Test
    public void testGetLast() {
        classUnderTest.append("you");
        classUnderTest.insert(0, "hey");
        classUnderTest.append("dude");

        assertEquals(classUnderTest.getLast(), "dude");

        classUnderTest.pop();

        assertEquals(classUnderTest.getLast(), "you");

        classUnderTest.pop();
        classUnderTest.pop();
        classUnderTest.pop();

        assertEquals(classUnderTest.getLast(), null);
    }

    @Test
    public void testClear() {
        classUnderTest.append("you");
        classUnderTest.insert(0, "hey");
        classUnderTest.append("dude");
        classUnderTest.append("dude");
        classUnderTest.append("dude");
        classUnderTest.append("dude");
        classUnderTest.append("dude");

        assertEquals(classUnderTest.size(), 7);

        classUnderTest.clear();

        assertEquals(classUnderTest.size(), 0);
        assertEquals(classUnderTest.getLast(), null);
        assertEquals(classUnderTest.peek(), null);
    }

    @Test
    public void testToArray() {
        classUnderTest.append("you");
        classUnderTest.insert(0, "hey");
        classUnderTest.append("dude");

        String[] results1 = {"hey", "you", "dude"};

        assertArrayEquals(classUnderTest.toArray(), results1);

        classUnderTest.clear();

        String[] results2 = {};

        assertArrayEquals(classUnderTest.toArray(), results2);
    }

    @Test
    public void testToString() {
        classUnderTest.append("you");
        classUnderTest.insert(0, "hey");
        classUnderTest.append("dude");

        assertEquals(classUnderTest.toString(), "hey you dude");
        assertEquals(classUnderTest.toString("."), "hey.you.dude");

        classUnderTest.clear();

        assertEquals(classUnderTest.toString(), "");
    }
}