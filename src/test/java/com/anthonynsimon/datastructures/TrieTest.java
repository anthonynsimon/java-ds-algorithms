package com.anthonynsimon.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie<Integer> trie;

    @Before
    public void setUp() {
        trie = new Trie<>();
    }

    @Test
    public void testPut() {
        trie.put("hello", 7);
        trie.put("GOOD", 64);
        trie.put("a", 4);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testPutIllegalArgument() throws IllegalArgumentException {
        trie.put(null, 5);
    }

    @Test
    public void testRemove() {
        String[] memberWords = new String[]{
                "hello",
                "Germany",
                "mountains",
                "ab",
                "w",
                "ger",
                "mountAINS"
        };

        for (String word : memberWords) {
            trie.put(word, word.length());
        }

        assertTrue(trie.get("hello") == "hello".length());

        trie.remove("hello");

        assertEquals(trie.get("hello"), null);

        assertTrue(trie.get("germany") == "germany".length());

        trie.remove("germany");

        assertEquals(trie.get("germany"), null);

        assertTrue(trie.get("ger") == "ger".length());
    }

    @Test
    public void testGet() {
        String[] memberWords = new String[]{
                "hello",
                "Germany",
                "mountains",
                "ab",
                "w",
                "ger",
                "mountAINS"
        };

        String[] nonMemberWords = new String[]{
                "hallo",
                "fiji",
                "sea",
                "b",
                "z",
                "ountAINS"
        };

        for (String word : memberWords) {
            trie.put(word, word.length());
        }

        for (String word : memberWords) {
            assertTrue(trie.get(word) == word.length());
        }

        for (String word : nonMemberWords) {
            assertEquals(trie.get(word), null);
        }
    }

    @Test
    public void testClear() {
        String[] memberWords = new String[]{
                "hello",
                "Germany",
                "mountains",
                "ab",
                "w",
                "ger",
                "mountAINS"
        };

        for (String word : memberWords) {
            trie.put(word, word.length());
        }

        trie.clear();

        for (String word : memberWords) {
            assertEquals(trie.get(word), null);
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(trie.isEmpty());

        String[] memberWords = new String[]{
                "hello",
                "Germany",
                "mountains",
                "ab",
                "w",
                "ger",
                "mountAINS"
        };

        for (String word : memberWords) {
            trie.put(word, word.length());
        }

        assertFalse(trie.isEmpty());

        trie.clear();

        assertTrue(trie.isEmpty());
    }
}