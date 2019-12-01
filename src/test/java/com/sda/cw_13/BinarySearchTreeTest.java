package com.sda.cw_13;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree underTest = new BinarySearchTreeImpl();

    @Test
    public void contains_returnsFalseForEmptyTree() {
        assertFalse(underTest.contains(0xCAFE_BABE));
    }

    @Test
    public void add_addsElementToEmptyTree() {
        underTest.add(0xCAFE_BABE);

        assertTrue(underTest.contains(0xCAFE_BABE));
    }

    @Test
    public void add_addsElementToNotEmptyTree() {
        underTest.add(0xCAFE_BABE);
        underTest.add(0xDEAD_BEEF);

        assertTrue(underTest.contains(0xDEAD_BEEF));
    }

    @Test
    public void add_buildsTreeCorrectly() {
        underTest.add(400);
        underTest.add(200);
        underTest.add(100);
        underTest.add(300);
        underTest.add(600);
        underTest.add(500);

        assertTrue(underTest.contains(400));
        assertTrue(underTest.contains(200));
        assertTrue(underTest.contains(100));
        assertTrue(underTest.contains(300));
        assertTrue(underTest.contains(600));
        assertTrue(underTest.contains(500));
    }


}