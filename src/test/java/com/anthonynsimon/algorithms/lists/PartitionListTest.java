package com.anthonynsimon.algorithms.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionListTest {

    private PartitionList classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new PartitionList();
    }

    @Test
    public void testOneElement() {
        PartitionList.Node head = new PartitionList.Node(7);

        head = classUnderTest.partition(head, 5);

        assertEquals(head.value, 7);
        assertEquals(head.next, null);
    }

    @Test
    public void testNoPartition() {
        int[] values = {7, 3, 5, 8, 1};

        PartitionList.Node head = new PartitionList.Node(values[0]);

        PartitionList.Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new PartitionList.Node(values[i]);
            current = current.next;
        }

        head = classUnderTest.partition(head, 0);

        current = head;
        for (int v : values) {
            assertEquals(current.value, v);
            current = current.next;
        }
    }

    @Test
    public void testPartition() {
        int[] values = {7, 3, 5, 8, 1};
        int[] expected = {1, 3, 7, 5, 8};

        PartitionList.Node head = new PartitionList.Node(values[0]);

        PartitionList.Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new PartitionList.Node(values[i]);
            current = current.next;
        }

        head = classUnderTest.partition(head, 5);

        current = head;
        for (int i = 0; i < values.length; i++) {
            assertEquals(current.value, expected[i]);
            current = current.next;
        }
    }
}