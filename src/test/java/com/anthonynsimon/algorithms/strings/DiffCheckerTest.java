package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiffCheckerTest {

    @Test
    public void testIsEditsAway() {
        assertFalse(DiffChecker.areOneEditAway("a", "abc"));
        assertFalse(DiffChecker.areOneEditAway("ab", "aaa"));
        assertFalse(DiffChecker.areOneEditAway("pale", "bake"));
        assertFalse(DiffChecker.areOneEditAway("pale", "bak"));
        assertFalse(DiffChecker.areOneEditAway("tree", "tre  e"));
        assertFalse(DiffChecker.areOneEditAway("treeshore", "teeshorre"));

        assertTrue(DiffChecker.areOneEditAway("bale", "pale"));
        assertTrue(DiffChecker.areOneEditAway("bal", "bale"));
        assertTrue(DiffChecker.areOneEditAway("abcd", "abd"));
        assertTrue(DiffChecker.areOneEditAway("bae", "bale"));
        assertTrue(DiffChecker.areOneEditAway("bale", "ale"));
    }
}