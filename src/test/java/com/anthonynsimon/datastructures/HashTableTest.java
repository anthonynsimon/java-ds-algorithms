package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable<Object, Object> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new HashTable<>();

        Random rand = new Random();
        for (int i = 0; i < 2048; i++) {
            classUnderTest.put(UUID.randomUUID().toString(), rand.nextInt(2048));
        }
    }

    @Test
    public void testGetEmpty() {
        assertNull(classUnderTest.get(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNull() throws IllegalArgumentException {
        classUnderTest.put(null, 100);
    }

    @Test
    public void testPutAndGet() {
        classUnderTest.put("hey", "there");
        classUnderTest.put(79514, "you");
        classUnderTest.put("mac", 72);

        assertEquals(classUnderTest.get("hey"), "there");
        assertEquals(classUnderTest.get(79514), "you");
        assertEquals(classUnderTest.get("mac"), 72);
    }

    @Test
    public void testReplacing() {
        classUnderTest.put("hey", "there");
        assertEquals(classUnderTest.get("hey"), "there");

        int size = classUnderTest.size();

        classUnderTest.put("hey", "you");
        assertEquals(classUnderTest.get("hey"), "you");

        assertEquals(classUnderTest.size(), size);
    }

    @Test
    public void testKeys() {
        classUnderTest.clear();
        assertArrayEquals(classUnderTest.keys(), new Object[]{});

        classUnderTest.put("what", "there");

        assertTrue(classUnderTest.keys()[0] == "what");

        classUnderTest.put("that", "there");
        classUnderTest.put("this", "there");
        classUnderTest.put(452, "there");

        assertTrue(classUnderTest.keys().length == 4);
    }

    @Test
    public void testValues() {
        classUnderTest.clear();
        assertArrayEquals(classUnderTest.values(), new Object[]{});

        classUnderTest.put("what", "some");

        assertTrue(classUnderTest.values()[0] == "some");

        classUnderTest.put("that", "things");
        classUnderTest.put("this", "are");
        classUnderTest.put(452, "there");

        assertTrue(classUnderTest.values().length == 4);
    }

    @Test
    public void testContainsValue() {
        assertFalse(classUnderTest.containsValue("there"));
        assertFalse(classUnderTest.containsValue(79514));
        assertFalse(classUnderTest.containsValue("you"));

        classUnderTest.put("what", "there");
        classUnderTest.put(155550, "you");
        classUnderTest.put("hey", 79514);

        assertTrue(classUnderTest.containsValue("there"));
        assertTrue(classUnderTest.containsValue(79514));
        assertTrue(classUnderTest.containsValue("you"));
    }

    @Test
    public void testContainsKey() {
        assertFalse(classUnderTest.containsKey("what"));
        assertFalse(classUnderTest.containsKey(79514));
        assertFalse(classUnderTest.containsKey("hey"));

        classUnderTest.put("what", "there");
        classUnderTest.put(79514, "you");
        classUnderTest.put("hey", 72);

        assertTrue(classUnderTest.containsKey("what"));
        assertTrue(classUnderTest.containsKey(79514));
        assertTrue(classUnderTest.containsKey("hey"));
    }

    @Test
    public void testSize() {
        assertEquals(classUnderTest.size(), 2048);
        classUnderTest.put("hey", "you");
        assertEquals(classUnderTest.size(), 2049);
    }

    @Test
    public void testRemoveNonExistent() {
        int size = classUnderTest.size();
        classUnderTest.remove("hey");
        assertEquals(classUnderTest.size(), size);
    }

    @Test
    public void testRemove() {
        int size = classUnderTest.size();
        classUnderTest.put("hey", "there");

        assertEquals(classUnderTest.get("hey"), "there");
        assertEquals(classUnderTest.size(), size + 1);

        classUnderTest.remove("hey");
        assertEquals(classUnderTest.get("hey"), null);
        assertEquals(classUnderTest.size(), size);

        classUnderTest.put("hey", "a");
        classUnderTest.put("hola", "b");
        classUnderTest.put("hello", "c");
        classUnderTest.put("mac", "d");

        assertEquals(classUnderTest.get("hola"), "b");
        assertEquals(classUnderTest.size(), size + 4);

        classUnderTest.remove("hola");

        assertEquals(classUnderTest.get("hello"), "c");
        assertEquals(classUnderTest.get("mac"), "d");
        assertEquals(classUnderTest.get("hey"), "a");
        assertEquals(classUnderTest.size(), size + 3);
    }

    @Test
    public void testClear() {
        assertTrue(classUnderTest.size() > 0);

        classUnderTest.clear();

        assertFalse(classUnderTest.size() > 0);
        assertArrayEquals(classUnderTest.keys(), new Object[]{});
        assertArrayEquals(classUnderTest.values(), new Object[]{});
    }
}