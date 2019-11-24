package com.sda.cw_7;

import com.sda.cw_3.EmptyListException;

import java.util.Optional;

public class GenericListImpl<T> implements GenericList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    private int size;

    @Override
    public void addFirst(T element) {

        if (head == null) {
            Node<T> newNode = new Node<>(element, null);
            head = newNode;
            tail = newNode;
        } else {
            Node<T> newNode = new Node<>(element, head);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if(head==null){
            addFirst( element);
            return;
        }
        Node<T> newNode=new Node<>(element,null);
        tail.next(newNode);
        tail = newNode;
        size++;

    }

    @Override
    public void add(T element, int index) {
        if (index > size()) {
            throw  new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Node<T> current = head;
            int counter = 1;
            while (counter < index) {
                current = current.next();
                counter++;
            }
            Node<T> newNode = new Node<>(element, current.next());
            current.next(newNode);
            size++;

        }

    }

    @Override
    public Optional<T> removeFirst() {
        if (head == null) {
            return Optional.empty();
        }
        T result = head.value();
        head = head.next();
        if (size == 1) {
            tail = null;
        }
        size--;
        return Optional.of(result);
    }

    @Override
    public Optional<T> removeLast() {
        if (size() <= 1) {
            return removeFirst();
        } else {
            Node<T> current = head;
            while (current.next().hasNext()) {
                current = current.next();
            }
            T result = current.next().value();
            current.next(null);
            tail = current;
            size--;
            return Optional.of(result);
        }
    }

    @Override
    public T remove(int index) {
        if (head == null) {
            throw new EmptyListException();
        } else if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            //noinspection OptionalGetWithoutIsPresent
            return removeFirst().get();
        } else if (index == size() - 1) {
            //noinspection OptionalGetWithoutIsPresent
            return removeLast().get();
        } else {
            Node<T> current = head;
            int counter = 0;
            while (counter < index - 1) {
                counter++;
                current = current.next();
            }
            T result = current.next().value();
            current.next(current.next().next());
            size--;
            return result;
        }
    }

    @Override
    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> current = head;
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
    public boolean contains(T element) {
        if (head == null) {
            return false;
        }
        Node<T> current  = head;
        while (true) {
            if (current.value().equals(element)) {
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
