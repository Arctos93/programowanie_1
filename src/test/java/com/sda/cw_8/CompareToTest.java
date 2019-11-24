package com.sda.cw_8;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class CompareToTest {

    @Test
    public void compareStrings() {

        List<String> strings = Stream.of("xx", "zzzz", "aaa", "xxxxxx", "")
                .collect(Collectors.toList());

        Collections.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(strings);

    }
}
