package com.sample.interview.cygilant;

public class CygilantTest {

    public static void main(String... args) {
        int[] arr = {-5, 0, 2, 3};
        System.out.println(binarySearch(arr));
    }
    public static int binarySearch(int[] arr){
        int len = arr.length;
        int low = 0;
        int high = len -1;

        int res = -1;
        while(low <= high) { // low - high
            int mid = (low + high) / 2;
            if(arr[mid] < mid) {
                low = mid + 1;
            } else if (arr[mid] > mid) {
                high = mid - 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }

}
