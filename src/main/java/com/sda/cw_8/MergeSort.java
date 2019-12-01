package com.sda.cw_8;

import java.util.Arrays;

public class MergeSort implements Sorter {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int[] left = splitLeft(arr);
        sort(left);
        int[] right = splitRight(arr);
        sort(right);
        merge(arr, left, right);

    }

    private void merge(int[] arr, int[] left, int[] right) {
        int idx_r=0;
        int idx_l=0;
        int idx_a=0;

        while(idx_l < left.length && idx_r < right.length) {
            if(left[idx_l]<right[idx_r]){
                arr[idx_a++]=left[idx_l++];
            } else{
                arr[idx_a++]=right[idx_r++];
            }
        }

        while(idx_l<left.length){
            arr[idx_a++]=left[idx_l++];;
        }

        while(idx_r<right.length){
            arr[idx_a++]=right[idx_r++];
        }
    }

    private int[] splitRight(int[] arr) {
        return Arrays.copyOfRange(arr, arr.length / 2 + arr.length % 2, arr.length);
    }

    private int[] splitLeft(int[] arr) {
        return Arrays.copyOf(arr, arr.length / 2 + arr.length % 2);
    }
}
