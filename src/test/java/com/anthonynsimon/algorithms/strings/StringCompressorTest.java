package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressorTest {

    @Test
    public void testEmptyString() {
        assertEquals(StringCompressor.compress(""), "");
    }

    @Test
    public void testNoCompressionNeeded() {
        assertEquals(StringCompressor.compress("abcdefg"), "abcdefg");
    }

    @Test
    public void testCompressionWorseCase() {
        // Result would actually be "a2b1" which is longer than original
        assertEquals(StringCompressor.compress("aab"), "aab");
    }

    @Test
    public void testCompressionNeeded() {
        assertEquals(StringCompressor.compress("aaabcbbbaaccccccgxgg"), "a3b1c1b3a2c6g1x1g2");
    }


}
