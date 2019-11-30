package com.sda.cw_8;

import static com.sda.cw_8.ArrayUtils.swap;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(int[] arr) {
        for (int i = arr.length ; i > 0 ; i--) {
            for (int j = 0 ; j < i - 1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
