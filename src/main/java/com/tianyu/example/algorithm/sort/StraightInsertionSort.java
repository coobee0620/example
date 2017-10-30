package com.tianyu.example.algorithm.sort;

/**
 * Created by tianyu on 17/5/23.
 */
public class StraightInsertionSort {
    /**
     * 直接插入排序
     * 时间复杂度：
     * 平均:O（n^2）.
     * 最好:O（n）
     * 最坏:O（n^2）
     * 稳定
     * Straight Insertion Sort
     *
     * @param disorder
     * @param orderCount 排序元素数量
     * @param dk 缩小增量
     */
    public static void sort(int[] disorder, int orderCount,int dk) {
        for (int i = dk; i < orderCount; i++) {
            if (disorder[i - dk] > disorder[i]) { //从第二位开始
                int j = i - dk; //当前游标前dk个值
                int x = disorder[i]; //选取哨兵
                disorder[i] = disorder[i-dk]; //前位填空
                while (j >= 0 && x < disorder[j]) {
                    disorder[j + dk] = disorder[j]; //后移位
                    j-=dk;
                }
                disorder[j + dk] = x; //插入
            }
        }
    }

    public static void main(String[] args) {
        int[] disorder = {7,9,8,6,5,1,4,3,2};
        sort(disorder, 9,1);
    }
}
