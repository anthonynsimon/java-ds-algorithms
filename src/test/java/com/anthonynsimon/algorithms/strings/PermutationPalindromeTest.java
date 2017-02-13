package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationPalindromeTest {

    @Test
    public void testEmptyString() {
        assertFalse(PermutationPalindrome.isPermutationOfPalindrome(""));
    }

    @Test
    public void testStringsWithPalindromeOptimized() {
        String[] testStrings = {
                "a man, a plan, a canal, panama!",
                " a canal, a man, panama! a ,plan.",
                "taco cat",
                "atcc o.ta",
                "aabbcc",
                "@t@yt"
        };

        for (String str : testStrings) {
            assertTrue(PermutationPalindrome.isPermutationOfPalindrome(str));
        }
    }

    @Test
    public void testStringsWithoutPalindrome() {
        String[] testStrings = {
                "autcc ota",
                "@@yyan",
                "abc",
                "atcc o.tava",
                "4554913"
        };

        for (String str : testStrings) {
            assertFalse(PermutationPalindrome.isPermutationOfPalindrome(str));
        }
    }
}