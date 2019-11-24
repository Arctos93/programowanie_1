package com.sda.cw_3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    private SimpleList underTest;

    @Before
    public void setUp() {
        underTest = new SingleLinkedList();
    }

    @Test
    public void size_listIsEmptyWhenCreated() {
        assertEquals(0, underTest.size());
    }

    @Test
    public void addFirst_listHasOneElementWhenAdded() {
        underTest.addFirst(999);

        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0));
    }

    @Test
    public void addFirst_listHasTwoElementsWhenAddedTwo() {
        underTest.addFirst(999);
        underTest.addFirst(888);

        assertEquals(2, underTest.size());
        assertEquals(888, underTest.get(0));
        assertEquals(999, underTest.get(1));
    }

    @Test
    public void addLast_listHasOneElementWhenAdded() {
        underTest.addLast(999);

        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0));
    }

    @Test
    public void addLast_listHasTwoElementsWhenAddedTwo() {
        underTest.addLast(999);
        underTest.addLast(888);

        assertEquals(2, underTest.size());
        assertEquals(999, underTest.get(0));
        assertEquals(888, underTest.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_throwsForIllegalIndex() {
        underTest.add(999, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add_throwsForIllegalIndexForNonEmpty() {

        underTest.addFirst(888);
        underTest.add(999, 2);
    }

    @Test
    public void add_addsToHeadWhenEmpty() {
        underTest.add(999, 0);

        assertEquals(1,  underTest.size());
        assertEquals(999,  underTest.get(0));
    }

    @Test
    public void add_addsToHeadWhenNotEmpty() {

        underTest.addFirst(888);

        underTest.add(999, 0);

        assertEquals(2,  underTest.size());
        assertEquals(999,  underTest.get(0));
        assertEquals(888,  underTest.get(1));
    }

    @Test
    public void add_addsToTailWhenNotEmpty() {

        underTest.addFirst(888);

        underTest.add(999, 1);

        assertEquals(2,  underTest.size());

        assertEquals(888,  underTest.get(0));
        assertEquals(999,  underTest.get(1));
    }

    @Test
    public void add_addsInTheMiddle() {

        underTest.addLast(111);
        underTest.addLast(222);
        underTest.addLast(333);

        underTest.add(223, 2);

        assertEquals(4, underTest.size());
        assertEquals(111, underTest.get(0));
        assertEquals(222, underTest.get(1));
        assertEquals(223, underTest.get(2));
        assertEquals(333, underTest.get(3));
    }

    @Test(expected = EmptyListException.class)
    public void removeFirst_throwsWhenEmpty() {
        underTest.removeFirst();
    }

    @Test
    public void removeFirst_isEmptyAfterLastElementRemoved() {
        underTest.addLast(999);

        int value = underTest.removeFirst();

        assertEquals(999, value);
        assertEquals(0, underTest.size());
    }

    @Test
    public void removeFirst_isNotEmptyAfterLastElementRemoved() {
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        int value = underTest.removeFirst();

        assertEquals(777, value);
        assertEquals(2, underTest.size());
        assertEquals(888, underTest.get(0));
        assertEquals(999, underTest.get(1));
    }

    @Test(expected = EmptyListException.class)
    public void removeLast_throwsWhenEmpty() {
        underTest.removeLast();
    }

    @Test
    public void removeLast_isEmptyAfterLastElementRemoved() {
        underTest.addLast(999);

        int value = underTest.removeLast();

        assertEquals(999, value);
        assertEquals(0, underTest.size());
    }

    @Test
    public void removeLast_isNotEmptyAfterLastElementRemoved() {
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        int value = underTest.removeLast();

        assertEquals(999, value);
        assertEquals(2, underTest.size());
        assertEquals(777, underTest.get(0));
        assertEquals(888, underTest.get(1));
    }

    @Test(expected = EmptyListException.class)
    public void remove_throwsWhenEmpty() {
        underTest.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove_throwsWhenNotExists() {
        underTest.addFirst(999);

        underTest.remove(1);
    }

    @Test
    public void remove_isEmptyAfterFirstElementRemoved() {
        underTest.addLast(999);

        int value = underTest.remove(0);

        assertEquals(999, value);
        assertEquals(0, underTest.size());
    }

    @Test
    public void remove_isNotEmptyAfterFirstElementRemoved() {
        underTest.addLast(999);
        underTest.addLast(888);

        int value = underTest.remove(0);

        assertEquals(999, value);
        assertEquals(1, underTest.size());
        assertEquals(888, underTest.get(0));
    }

    @Test
    public void remove_isNotEmptyAfterLastElementRemoved() {
        underTest.addLast(999);
        underTest.addLast(888);

        int value = underTest.remove(1);

        assertEquals(888, value);
        assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0));
    }

    @Test
    public void remove_isNotEmptyAfterElementRemoved() {
        underTest.addLast(777);
        underTest.addLast(888);
        underTest.addLast(999);

        int value = underTest.remove(1);

        assertEquals(888, value);
        assertEquals(2, underTest.size());
        assertEquals(777, underTest.get(0));
        assertEquals(999, underTest.get(1));
    }

    @Test
    public void contains_returnsFalseForEmptyList() {
        assertFalse(underTest.contains(999));
    }

    @Test
    public void contains_returnsFalseForOneElementListThatNotContains() {
        underTest.addFirst(888);
        assertFalse(underTest.contains(999));
    }

    @Test
    public void contains_returnsTrueForOneElementListThatContains() {
        underTest.addFirst(999);
        assertTrue(underTest.contains(999));
    }

    @Test
    public void contains_returnsFalseForMultiElementListThatNotContains() {
        underTest.addFirst(888);
        underTest.addFirst(777);
        underTest.addFirst(888);
        underTest.addFirst(444);

        assertFalse(underTest.contains(999));
    }

    @Test
    public void contains_returnsTrueForMultiElementListThatContains() {
        underTest.addFirst(888);
        underTest.addFirst(777);
        underTest.addFirst(444);
        underTest.addLast(999);

        assertTrue(underTest.contains(999));
    }












}