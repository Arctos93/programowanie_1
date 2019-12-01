package com.sda.cw_8;

public class SpecialSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        int[] occ =  new int[10_000];
        for(int i : arr) {
            occ[i]++;
        }
        int arr_idx = 0;
        for(int i = 0 ; i < occ.length ; i++) {
            for (int j = 0 ; j < occ[i] ; j ++) {
               arr[arr_idx++] = i;
            }
        }

    }
}
