package com.sda.cw_8;

import static com.sda.cw_8.ArrayUtils.swap;

public class SelectionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min_idx = findMinIdx(arr, i);
            swap(arr, min_idx, i);
        }

    }

    private int findMinIdx(int[] arr, int i) {
        int min_value = arr[i];
        int min_idx = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < min_value) {
                min_idx = j;
                min_value = arr[j];
            }
        }
        return min_idx;
    }
}
