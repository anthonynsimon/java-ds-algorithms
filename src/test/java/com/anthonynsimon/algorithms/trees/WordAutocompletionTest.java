package com.anthonynsimon.algorithms.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WordAutocompletionTest {

    private WordAutocompletion autocompletion;
    private String[] emptyStringArray;

    @Before
    public void setUp() {
        autocompletion = new WordAutocompletion();

        String[] memberWords = new String[]{
                "hello",
                "Germany",
                "mountains",
                "alps",
                "germ",
                "MOUNTAIN",
                "hold",
                "hair",
                "marathon",
                "mars",
                "he"
        };

        for (String word : memberWords) {
            autocompletion.put(word, Integer.toString(word.length()));
        }

        emptyStringArray = new String[]{};
    }

    @Test
    public void testEmptyString() {
        assertArrayEquals(autocompletion.autocomplete(""), emptyStringArray);
    }

    @Test
    public void testNonMemberWord() {
        assertArrayEquals(autocompletion.autocomplete("x"), emptyStringArray);
        assertArrayEquals(autocompletion.autocomplete("germo"), emptyStringArray);
    }

    @Test
    public void testMemberWordWithSuggestions() {
        assertArrayEquals(autocompletion.autocomplete("ger"), new String[]{
                "germ",
                "germany"
        });
    }

    @Test
    public void testMemberWordWithoutSuggestions() {
        assertArrayEquals(autocompletion.autocomplete("hair"), emptyStringArray);
    }
}