package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SanitizerTest {

    @Test
    public void testSanitizer() {
        char[] blacklist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};

        assertEquals("", Sanitizer.sanitize("...", blacklist));
        assertEquals("_____", Sanitizer.sanitize("_____", blacklist));
        assertEquals("asdtasdasdfas", Sanitizer.sanitize("asd,tasdasd.!fa!s", blacklist));
        assertEquals("16asd5asda87as", Sanitizer.sanitize("16asd5.asda87?as", blacklist));
        assertEquals("", Sanitizer.sanitize("", blacklist));
        assertEquals("abcdefg", Sanitizer.sanitize("a?:b,-cde'fg\"", blacklist));

        char[] blacklist2 = {'_'};

        assertEquals("", Sanitizer.sanitize("_____", blacklist2));

    }
}