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
        for (int i = 0; i < currentIdx; i++) {
            if(arr[i] > toInsert) {
                return i;
            }
        }
        return currentIdx;
    }
}
