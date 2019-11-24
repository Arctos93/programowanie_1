package com.sda.cw_6;

import com.sda.cw_5.Limited;

public interface SimpleQueue extends Limited {

    void offer(int element);
    int poll();
    boolean isEmpty();
    int peek();
}
