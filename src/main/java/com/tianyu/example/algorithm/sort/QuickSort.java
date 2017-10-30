package com.tianyu.example.algorithm.sort;

/**
 * Created by tianyu on 17/5/24.
 * 时间复杂度:
 * 平均:O(nlogn )
 * 最好:O(nlogn )
 * 最坏:O（n^2）
 * 不稳定
 */
public class QuickSort {
    private static int partition(int[] array, int start, int end) {
        int value = array[end];
        int index = start - 1;

        for (int i = start; i < end; i++) {
            if (array[i] < value) {
                if (++index != i) {
                    swap(array, index, i);
                }
            }
        }

        if ((++index ) != end) {
            swap(array, index, end);
        }

        return index;
    }


    private static void subQuickSort(int[] array, int start, int end) {
        if (array == null || start >= end) {
            return;
        }

        int part = partition(array, start, end);

        subQuickSort(array, start, part - 1);
        subQuickSort(array, part + 1, end);
    }

    private static void subQuickSortImprove(int[] array, int start, int end,int k) {
        if (array == null || end - start <= k) {
            return;
        }

        int part = partition(array, start, end);

        subQuickSortImprove(array, start, part - 1,k);
        subQuickSortImprove(array, part + 1, end,k);
    }


    public static void quickSort(int[] array) {
        subQuickSort(array, 0, array.length - 1);
    }

    /***
     * 改进算法
     * 只有子序列大于k时使用快排,使得序列成为基本有序的序列
     * 然后再对整个序列使用直插排序
     */
    public static void quickSortImprove(int[] array) {
        subQuickSortImprove(array, 0, array.length - 1,8);

        System.out.println("Before StraightInsertionSort:");
        printArray(array);
        StraightInsertionSort.sort(array,array.length,1);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] array = {7,9, 8, 4, 1, 6, 5,10,45,78, 3, 2,-1};

//        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};

        System.out.println("Before sort:");
        printArray(array);

        quickSortImprove(array);

        System.out.println("After sort:");
        printArray(array);
    }
}
