package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverserTest {

    @Test
    public void testStringReversal() {
        assertEquals("olleh", Reverser.reverse("hello"));
        assertEquals("a", Reverser.reverse("a"));
        assertEquals("cba", Reverser.reverse("abc"));
        assertEquals("ca", Reverser.reverse("ac"));
        assertEquals("", Reverser.reverse(""));
        assertEquals("?siht si tahW", Reverser.reverse("What is this?"));
        assertEquals("  Gnirtssss tseeEtYm", Reverser.reverse("mYtEeest sssstrinG  "));

    }
}