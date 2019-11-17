package com.sda.cw_3;

class Node {

    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int value() {
        return value;
    }

    public void next(Node next) {
        this.next = next;
    }

    public Node next() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
