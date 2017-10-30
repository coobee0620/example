package com.tianyu.example.algorithm.sort;

/**
 * Created by tianyu on 17/5/23.
 * 希尔排序又叫缩小增量排序
 * 时效难以计算
 * 平均 O（n^1.3）
 * 最好 O（n）
 * 最坏 O（n^2）
 */
public class ShellSort {
    public static void sort(int[] disorder, int orderCount) {
        int dk = orderCount / 2;
        while (dk >= 1) {
            StraightInsertionSort.sort(disorder, orderCount, dk);
            dk = dk / 2;
        }
    }

    public static void main(String[] args) {
        int[] disorder = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(disorder, 8);
    }
}
