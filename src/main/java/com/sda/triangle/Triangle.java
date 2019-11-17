package com.sda.triangle;

public class Triangle {

    private long perimeter;

    public Triangle(int a, int b, int c) {
        if (a <=0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException();
        }
        int max = Integer.max(a, Integer.max(b, c));
        long sum = (long)a + b + c - max;
        if (max >= sum) {
            throw new IllegalArgumentException();
        }
        this.perimeter = (long)a + b + c;

    }

    public long perimeter() {
        return perimeter;
    }
}
