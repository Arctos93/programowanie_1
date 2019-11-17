package com.sda.reverter;

import java.util.Objects;

public class ArrayReverter {

    public static void revertInPlace(int[] arr) {
        Objects.requireNonNull(arr);

        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i , arr.length - 1 - i);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
