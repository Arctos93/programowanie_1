package com.sda.cw_8;

import java.util.Arrays;

public class InsertionSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int toInsert = arr[i];
            int insertionIdx = findInsertionIndex(arr, i, toInsert);
            moveForward(arr, insertionIdx, i);
            arr[insertionIdx] = toInsert;
        }
    }

    private void moveForward(int[] arr, int from, int to) {
        System.arraycopy(arr, from, arr, from + 1, to - from);
    }

    private int findInsertionIndex(int[] arr, int currentIdx, int toInsert) {
        int insertionIdx = Arrays.binarySearch(arr, 0, currentIdx, toInsert);
        return insertionIdx >= 0 ? insertionIdx : (insertionIdx + 1) * (-1);
    }
}
