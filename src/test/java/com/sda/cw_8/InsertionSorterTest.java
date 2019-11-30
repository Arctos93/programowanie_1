package com.sda.cw_8;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSorterTest {

    @Test
    public void sort_empty() {
        int[] arr = {};
        int[] sorted = {};

        Sorter sorter = new InsertionSort();
        sorter.sort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void sort_singleElement() {
        int[] arr = {1};
        int[] sorted = {1};

        Sorter sorter = new InsertionSort();
        sorter.sort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void sort() {
        int[] arr = {11,5,1,5,0,7,9,0};
        int[] sorted = {0,0,1,5,5,7,9,11};

        Sorter sorter = new InsertionSort();
        sorter.sort(arr);

        assertArrayEquals(sorted, arr);
    }
}