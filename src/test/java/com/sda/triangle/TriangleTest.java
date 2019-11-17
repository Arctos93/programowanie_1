package com.sda.triangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test(expected = IllegalArgumentException.class)
    public void construct_throwExceptionWhenFirstLenghtNonPosistive() {
        new Triangle(0, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construct_throwExceptionWhenSecondLenghtNonPosistive() {
        new Triangle(1, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construct_throwExceptionWhenSecondLenghtNegative() {
        new Triangle(1, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construct_throwExceptionWhenLengthsIllegal() {
        new Triangle(1, 2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construct_throwExceptionWhenLengthsIllegal0() {
        new Triangle(1, 2, 3);
    }

    @Test
    public void perimeter_returnsCorrectPerrimeter() {
        Triangle t = new Triangle(2,2,3);

        assertEquals(7, t.perimeter());
    }

    @Test
    public void perimeter_returnsCorrectPerrimeterForBigValues() {
        Triangle t = new Triangle(Integer.MAX_VALUE - 2,Integer.MAX_VALUE - 1,2);

        assertEquals((long)Integer.MAX_VALUE - 2 + Integer.MAX_VALUE - 1 + 2, t.perimeter());
    }

}