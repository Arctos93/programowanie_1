package com.sda.reverter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReverterTest {

    @Test(expected = NullPointerException.class)
    public void revertInPlace_throwsExceptionForNullArgument() {
        // given
        int[] arr = null;

        // when
        ArrayReverter.revertInPlace(arr);

        // then
    }

    @Test
    public void revertInPlace_notModifiesArrayWithZeroLength() {
        // given
        int[] arr = {};

        //when
        ArrayReverter.revertInPlace(arr);

        //then
        assertEquals(arr.length, 0);
    }

    @Test
    public void revertInPlace_notModifiesArrayWithLength1() {
        // given
        int[] arr = {5};

        //when
        ArrayReverter.revertInPlace(arr);

        //then
        assertEquals(arr.length, 1);
        assertEquals(arr[0], 5);
    }

    @Test
    public void revertInPlace_revertsArrayWithFourElements() {
        // given
        int[] arr = {3, 2, 1, 0};

        //when
        ArrayReverter.revertInPlace(arr);

        //then
        assertEquals(arr.length, 4);

        assertEquals(arr[0], 0);
        assertEquals(arr[1], 1);
        assertEquals(arr[2], 2);
        assertEquals(arr[3], 3);
    }

    @Test
    public void revertInPlace_revertsArrayWithFiveElements() {
        // given
        int[] arr = {4, 3, 2, 1, 0};

        //when
        ArrayReverter.revertInPlace(arr);

        //then
        assertEquals(arr.length, 5);

        for (int i = 0; i < 5; i++) {
            assertEquals(arr[i], i);
        }
    }
}