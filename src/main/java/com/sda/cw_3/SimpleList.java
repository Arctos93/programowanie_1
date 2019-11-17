package com.sda.cw_3;

public interface SimpleList {

    void addFirst(int element);

    void addLast(int element);

    void add(int element, int index);

    int removeFirst();

    int removeLast();

    int remove(int index);

    int get(int index);

    boolean contains(int element);

    int size();

}
