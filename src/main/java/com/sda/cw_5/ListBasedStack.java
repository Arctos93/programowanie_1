package com.sda.cw_5;

import com.sda.cw_3.SimpleList;
import com.sda.cw_3.SingleLinkedList;

import java.util.EmptyStackException;

public class ListBasedStack implements SimpleStack {

    private SimpleList list = new SingleLinkedList();

    @Override
    public void push(int element) {
        list.addFirst(element);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }
}
