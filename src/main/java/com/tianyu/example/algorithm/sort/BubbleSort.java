package com.tianyu.example.algorithm.sort;

/**
 * Created by tianyu on 17/5/24.
 * 冒泡排序以及优化
 * 时间复杂度:
 * 平均:O（n^2）
 * 最好:O（n）
 * 最坏:O（n^2）
 * 稳定
 */
public class BubbleSort {
    /**
     * 基本冒泡
     * @param disorder
     * @param orderCount
     */
    public static void basicSort(int[] disorder, int orderCount) {
        for (int i = 0; i < orderCount - 1; ++i) {
            for (int j = 0; j < orderCount - i - 1; ++j) {
                if (disorder[j] > disorder[j + 1]) {
                    int tmp = disorder[j];
                    disorder[j] = disorder[j + 1];
                    disorder[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 交换位置标记
     * 基本有序时效率高
     * @param disorder
     * @param orderCount
     */
    public static void improve1Sort(int[] disorder, int orderCount) {
        int i = orderCount - 1;  //初始时,最后位置保持不变
        while (i > 0) {
            int pos = 0; //每趟开始时,无记录交换
            for (int j = 0; j < i; j++)
                if (disorder[j] > disorder[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = disorder[j];
                    disorder[j] = disorder[j + 1];
                    disorder[j + 1] = tmp;
                }
            i = pos; //为下一趟排序作准备
        }
    }

    /**
     * 双向冒泡
     * 双向冒泡可以结合位置标记进行优化
     * @param disorder
     * @param orderCount
     */
    public static void improve2Sort(int[] disorder, int orderCount) {
        int low = 0;
        int high = orderCount - 1; //设置变量的初始值
        int tmp, j;
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (disorder[j] > disorder[j + 1]) {
                    tmp = disorder[j];
                    disorder[j] = disorder[j + 1];
                    disorder[j + 1] = tmp;
                }
            //修改high值, 前移一位
            --high;
            //反向冒泡,找到最小者
            for (j = high; j > low; --j)
                if (disorder[j] < disorder[j - 1]) {
                    tmp = disorder[j];
                    disorder[j] = disorder[j - 1];
                    disorder[j - 1] = tmp;
                }
            //修改low值,后移一位
            ++low;
        }
    }

    public static void main(String[] args) {
        int[] array = {87, 45, 32, 17,5, 9,99,100, 122, 78};
        basicSort(array,array.length);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
