package com.sda.cw_6;

import com.sda.cw_3.SimpleList;
import com.sda.cw_3.SingleLinkedList;

public class ListBasedQueueQueue implements SimpleQueue {

    private SimpleList list = new SingleLinkedList();

    @Override
    public void offer(int element) {
        list.addLast(element);
    }

    @Override
    public int poll() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int peek() {
        return list.get(0);
    }
}
