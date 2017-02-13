package com.anthonynsimon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlifierTest {

    @Test
    public void testReplaceWhitespace() {
        assertEquals("the%20dog%20is%20happy",
                Urlifier.urlify("the dog is happy"));

        assertEquals("google.com/q?search=java%20data%20structures%20And%20algorithms",
                Urlifier.urlify("google.com/q?search=java data structures And algorithms"));

        assertEquals("http://google.com/asd%20tta%20%20asd", Urlifier.urlify("http://google.com/asd tta  asd"));

        assertEquals("http://google.com/", Urlifier.urlify("http://google.com/"));

        assertEquals("http://google.com/q?%20%20%20%20%20test%20%20", Urlifier.urlify("http://google.com/q?     test  "));
    }
}