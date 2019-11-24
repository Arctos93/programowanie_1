package com.sda.cw_6;

public class ArrayBasedQueue implements SimpleQueue {

    private int[] array;
    private int begin;
    private int size;

    public ArrayBasedQueue(int length) {
        this.array = new int[length];
    }

    @Override
    public void offer(int element) {
        if (isFull()) {
            throw new QueueFullException();
        }
        array[(begin + size)%array.length] = element;
        size++;

    }

    @Override
    public int poll() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        int result = array[begin];
        size--;
        begin = (begin + 1)%array.length;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return array[begin];
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
