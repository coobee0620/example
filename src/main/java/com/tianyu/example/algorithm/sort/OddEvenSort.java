package com.tianyu.example.algorithm.sort;

/**
 * OddEvenSort
 * 奇偶交换
 * 冒泡算法的并行化升级改造前提
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 09:46
 */
public class OddEvenSort {
    public static void oddEvenSort(int[] arr) {
        int exchFlag = 1,start =0;
        while (exchFlag ==1 || start == 1) {
            exchFlag = 0; //交换标志，如果上次有交换继续下一轮，如果上一轮无交换，说明已经是有序的了
            for (int i =start; i<arr.length -1;i+=2) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    exchFlag = 1;
                }
            }
            if (start == 0) {
                start = 1;
            } else {
                start = 0;
            }
        }
    }
}
