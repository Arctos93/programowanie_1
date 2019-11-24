package com.sda.cw_5;

public interface Limited {

    default boolean isFull() {
        return false;
    }
}
