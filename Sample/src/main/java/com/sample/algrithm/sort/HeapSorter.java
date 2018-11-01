package com.sample.algrithm.sort;

import java.util.Arrays;

public class HeapSorter {

    public static void main(String[] args) {
        int[] arr = {45, 36, 63, 14, 27, 98, 35, 18, 25};
        heapSort(arr, arr.length);

//        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
//        for(int e : arr) {
//            System.out.println(e);
//        }
    }
    /**
     * 将数组arr构建大根堆
     * @param arr 待调整的数组
     * @param i   待调整的数组元素的下标
     * @param len 数组的长度
     */
    static void heapAdjust(int arr[], int i, int len)
    {
        int child;
        int temp;

        for (; 2 * i + 1 < len; i = child)
        {
            child = 2 * i + 1;  // 子结点的位置 = 2 * 父结点的位置 + 1
            // 得到子结点中键值较大的结点
            if (child < len - 1 && arr[child + 1] > arr[child])
                child ++;
            // 如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
            if (arr[i] < arr[child])
            {
                temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
            }
            else
                break;
        }

        System.out.println();
        Arrays.stream(arr).forEach(j -> System.out.print(j + " "));
    }

    /**
     * 堆排序算法
     */
    static void heapSort(int arr[], int len)
    {
        int i;
        // 调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
        for (i = len / 2 - 1; i >= 0; i--)
        {
            heapAdjust(arr, i, len);
        }

        for (i = len - 1; i > 0; i--)
        {
            // 将第1个元素与当前最后一个元素交换，保证当前的最后一个位置的元素都是现在的这个序列中最大的
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            heapAdjust(arr, 0, i);
        }
    }
}
