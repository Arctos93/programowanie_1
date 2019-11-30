package com.sda.cw_8;

import java.util.Comparator;

public class GenericSorters {

    public static <T extends Comparable<T>> void bubbleSort (T[] array) {
        Comparator<T> comparator = Comparable::compareTo;
        bubbleSort(array, comparator);

    }

    public static <T> void bubbleSort (T[] array, Comparator<T> comparator) {
        for (int i = array.length ; i > 0 ; i--) {
            for (int j = 0 ; j < i - 1 ; j++) {
                if (comparator.compare(array[j], array[j+1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }

    }

    public static <T extends Comparable<T>> void selectionSort (T[] array) {
        Comparator<T> comparator = Comparable::compareTo;
        selectionSort(array, comparator);

    }

    public static <T> void selectionSort (T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length; i++) {
            int min_idx = findMinIdx(array, i , comparator);
            swap(array, min_idx, i);
        }
    }

    private static <T> int findMinIdx(T[] array, int i, Comparator<T> comparator) {
        T min_value = array[i];
        int min_idx = i;
        for (int j = i + 1; j < array.length; j++) {
            if (comparator.compare(array[j], min_value) < 0) {
                min_idx = j;
                min_value = array[j];
            }
        }
        return min_idx;
    }

    private static void swap(Object[] arr, int i1, int i2) {
        Object tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
