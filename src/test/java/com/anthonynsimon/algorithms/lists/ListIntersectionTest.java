package com.anthonynsimon.algorithms.lists;

import com.anthonynsimon.datastructures.util.SinglyNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListIntersectionTest {

    private ListIntersection<String> classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new ListIntersection<>();

    }

    @Test
    public void testOneListEmpty() {
        SinglyNode<String> headA = null;
        SinglyNode<String> headB = new SinglyNode<>("a");

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), null);
    }

    @Test
    public void testBothListsEmpty() {
        SinglyNode<String> headA = null;
        SinglyNode<String> headB = null;

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), null);
    }

    @Test
    public void testOneElementNoIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = new SinglyNode<>("a");

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), null);
    }

    @Test
    public void testOneElementWithIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = headA;

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), headB);
    }

    @Test
    public void testSameLengthWithIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = new SinglyNode<>("a");
        SinglyNode<String> intersection = new SinglyNode<>("b");
        SinglyNode<String> next = new SinglyNode<>("c");

        headA.setNext(intersection);
        headB.setNext(intersection);
        intersection.setNext(next);

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), intersection);
    }

    @Test
    public void testSameLengthNoIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = new SinglyNode<>("a");
        SinglyNode<String> nextA = new SinglyNode<>("b");
        SinglyNode<String> nextB = new SinglyNode<>("c");

        headA.setNext(nextA);
        headB.setNext(nextB);

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), null);
    }

    @Test
    public void testDifferentLengthNoIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = new SinglyNode<>("a");
        SinglyNode<String> nextA = new SinglyNode<>("b");
        SinglyNode<String> nextB = new SinglyNode<>("c");
        SinglyNode<String> nextB2 = new SinglyNode<>("c");

        headA.setNext(nextA);
        headB.setNext(nextB);
        nextB.setNext(nextB2);

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), null);
    }

    @Test
    public void testDifferentLengthWithIntersection() {
        SinglyNode<String> headA = new SinglyNode<>("a");
        SinglyNode<String> headB = new SinglyNode<>("a");
        SinglyNode<String> nextA = new SinglyNode<>("b");
        SinglyNode<String> nextB = new SinglyNode<>("c");
        SinglyNode<String> intersection = new SinglyNode<>("c");
        SinglyNode<String> last = new SinglyNode<>("d");

        headA.setNext(nextA);
        headB.setNext(nextB);
        nextA.setNext(intersection);
        nextB.setNext(intersection);
        intersection.setNext(last);

        assertEquals(classUnderTest.getIntersectionNode(headA, headB), intersection);
    }
}