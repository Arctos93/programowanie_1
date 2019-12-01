package com.sda.cw_8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class SpecialSortTest {

    @Test
    public void test() {
        Random r = new Random();
        int[] intsToSort = IntStream.range(0, 10_000_000)
                .map(i -> r.nextInt(10_000))
                .toArray();

        int[] sorted = Arrays.copyOf(intsToSort, intsToSort.length);
        Arrays.sort(sorted);
        Sorter s = new SpecialSorter();
        s.sort(intsToSort);

        assertArrayEquals(sorted, intsToSort);
    }

}
