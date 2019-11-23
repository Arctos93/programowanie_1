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
        if(head==null){
            addFirst( element);
            return;
        }
        Node current=head;
        while(current.hasNext()){
            current=current.next();
        }
        Node newNode=new Node(element,null);
        current.next(newNode);

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

        }

    }

    @Override
    public int removeFirst() {
        if (head == null) {
            throw new EmptyListException();
        }
        int result = head.value();
        head = head.next();
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
        if (head.value() == element) {
            return true;
        }
        Node current  = head;
        while (current.hasNext()) {
            if (current.value() == element) {
                return true;
            }
            current = current.next();
        }
        return false;
    }

    @Override
    public int size() {
        if(head == null){
            return 0;
        }else {
            int counter = 1;
            Node current = head;
            while(current.hasNext()){
                current = current.next();
                counter++;
            }
            return counter;
        }
    }
}
