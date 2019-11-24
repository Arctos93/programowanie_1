package com.sda.cw_5;

import java.util.EmptyStackException;

public class ArrayBasedStack implements SimpleStack {

    private int[] array;
    private int top;

    public ArrayBasedStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        array = new int[size];
    }

    @Override
    public void push(int element) {
        if (isFull()) {
            throw new StackFullException();
        }
        array[top++] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[--top];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
