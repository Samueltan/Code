package com.sample.algrithm.sort;

import java.util.Arrays;

public class MyQuickSorter {

    public static void main(String[] args) {
        int[] arr = {45, 8, 23, 97, 128, 36, 53, 227, 19, 85, 62, 75};
        qsort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach((x) -> System.out.print(x + " "));
    }

    private static void qsort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = getPivot(arr, low, high);
            qsort(arr, low, pivot - 1);
            qsort(arr, pivot + 1, high);
        }
    }

    private static int getPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        while(low < high) {
            while(low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while(low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;

        return low;
    }
}
