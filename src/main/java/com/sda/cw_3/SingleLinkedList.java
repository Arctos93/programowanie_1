package com.sda.cw_3;

public class SingleLinkedList implements SimpleList {

    private Node head = null;

    @Override
    public void addFirst(int element) {

        head = new Node(element, head);

//        if (head == null) {
//            Node newNode = new Node(element, null);
//            head = newNode;
//        } else {
//            Node newNode = new Node(element, head);
//            head = newNode;
//        }
    }

    @Override
    public void addLast(int element) {

    }

    @Override
    public void add(int element, int index) {

    }

    @Override
    public int removeFirst() {
        return 0;
    }

    @Override
    public int removeLast() {
        return 0;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node current = head;
        while(counter < index) {
            if (current.hasNext()) {
                counter++;
                current = current.next();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return current.value();
    }

    @Override
    public boolean contains(int element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
