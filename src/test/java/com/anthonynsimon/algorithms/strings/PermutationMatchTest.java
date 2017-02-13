package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationMatchTest {

    @Test
    public void testIsPermutation() {
        assertTrue(PermutationMatch.isPermutation("hello", "llheo"));
        assertFalse(PermutationMatch.isPermutation("what", "wa"));
    }

    @Test
    public void testTwoEmptyStrings() {
        assertTrue(PermutationMatch.isPermutation("", ""));
    }

    @Test
    public void testSameValuesDifferentChars() {
        assertFalse(PermutationMatch.isPermutation("ab", "bc"));
    }

    @Test
    public void testCaseSensitive() {
        assertFalse(PermutationMatch.isPermutation("Canada", "canada"));
    }
}
