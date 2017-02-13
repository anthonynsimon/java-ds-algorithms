package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharactersTest {

    @Test
    public void testHasUniqueChars() {
        assertTrue(UniqueCharacters.hasUniqueChars("abc"));
        assertTrue(UniqueCharacters.hasUniqueChars("ILikeTacos"));
        assertFalse(UniqueCharacters.hasUniqueChars("hh"));
        assertFalse(UniqueCharacters.hasUniqueChars("This is a longer string"));
        assertFalse(UniqueCharacters.hasUniqueChars(""));
    }
}