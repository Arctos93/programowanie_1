package com.sda.cw_7;

import java.util.Optional;

public interface GenericList<T> {

    void addFirst(T element);

    void addLast(T element);

    void add(T element, int index);

    Optional<T> removeFirst();

    Optional<T> removeLast();

    T remove(int index);

    T get(int index);

    boolean contains(T element);

    int size();
}
