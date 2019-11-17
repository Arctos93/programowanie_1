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
    public void size_listHasOneElementWhenAdded() {
        underTest.addFirst(999);

        //assertEquals(1, underTest.size());
        assertEquals(999, underTest.get(0));
    }

    @Test
    public void size_listHasTwoElementsWhenAddedTwo() {
        underTest.addFirst(999);
        underTest.addFirst(888);

        //assertEquals(2, underTest.size());
        assertEquals(888, underTest.get(0));
        assertEquals(999, underTest.get(1));
    }

}