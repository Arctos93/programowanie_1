package com.sda.cw_8;

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

    private void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
