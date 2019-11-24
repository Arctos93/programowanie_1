package com.sda.cw_3;

public class SingleLinkedList implements SimpleList {

    private Node head = null;
    private Node tail = null;

    private int size;

    @Override
    public void addFirst(int element) {

        if (head == null) {
            Node newNode = new Node(element, null);
            head = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node(element, head);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(int element) {
        if(head==null){
            addFirst( element);
            return;
        }
        Node newNode=new Node(element,null);
        tail.next(newNode);
        tail = newNode;
        size++;

    }

    @Override
    public void add(int element, int index) {
        if (index > size()) {
            throw  new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Node current = head;
            int counter = 1;
            while (counter < index) {
                current = current.next();
                counter++;
            }
            Node newNode = new Node(element, current.next());
            current.next(newNode);
            size++;

        }

    }

    @Override
    public int removeFirst() {
        if (head == null) {
            throw new EmptyListException();
        }
        int result = head.value();
        head = head.next();
        if (size == 1) {
            tail = null;
        }
        size--;
        return result;
    }

    @Override
    public int removeLast() {
        if (size() <= 1) {
            return removeFirst();
        } else {
            Node current = head;
            while (current.next().hasNext()) {
                current = current.next();
            }
            int result = current.next().value();
            current.next(null);
            tail = current;
            size--;
            return result;
        }
    }

    @Override
    public int remove(int index) {
        if (head == null) {
            throw new EmptyListException();
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            Node current = head;
            int counter = 0;
            while (counter < index - 1) {
                counter++;
                current = current.next();
            }
            int result = current.next().value();
            current.next(current.next().next());
            size--;
            return result;
        }
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
        if (head == null) {
            return false;
        }
        Node current  = head;
        while (true) {
            if (current.value() == element) {
                return true;
            }
            if (current.hasNext()) {
                current = current.next();
            } else {
                break;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;

    }
}
