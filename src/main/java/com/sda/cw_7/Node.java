package com.sda.cw_7;

class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T value() {
        return value;
    }

    public void next(Node<T> next) {
        this.next = next;
    }

    public Node<T> next() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
