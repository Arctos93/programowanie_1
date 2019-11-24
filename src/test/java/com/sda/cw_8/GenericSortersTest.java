package com.sda.cw_8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GenericSortersTest {

    @Test
    public void bubbleSort() {
        String[] strings = Stream.of("", "asd", "qwe", "fgh", "aaaaaaa", "dfg")
                .toArray(String[]::new);
        GenericSorters.bubbleSort(strings);
        System.out.println(Arrays.toString(strings));

    }

    @Test
    public void bubbleSort1() {
        String[] strings = Stream.of("", "asd", "qwe", "fgh", "aaaaaaa", "dfg")
                .toArray(String[]::new);
        GenericSorters.bubbleSort(strings, Comparator.comparingInt(String::length).reversed());
        System.out.println(Arrays.toString(strings));
    }
}