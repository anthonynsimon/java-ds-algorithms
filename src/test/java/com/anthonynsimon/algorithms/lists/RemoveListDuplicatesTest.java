package com.anthonynsimon.algorithms.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RemoveListDuplicatesTest {

    private RemoveListDuplicates<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new RemoveListDuplicates<>();
    }

    @Test
    public void testStrings() {
        String[] data = new String[]{
                "this",
                "that",
                "a",
                "some",
                "house",
                "that",
                "thiss",
                "This",
                "a",
                "this"
        };

        String[] expectedResult = new String[]{
                "this",
                "that",
                "a",
                "some",
                "house",
                "thiss",
                "This"
        };

        classUnderTest.build(data);
        classUnderTest.removeDuplicates();

        assertArrayEquals(classUnderTest.toArray(), expectedResult);
    }
}