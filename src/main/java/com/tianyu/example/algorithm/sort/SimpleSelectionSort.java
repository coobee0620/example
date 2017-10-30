package com.tianyu.example.algorithm.sort;

/**
 * Created by tianyu on 17/5/23.
 * 选择排序
 * 简单选择排序-查找当前最小与当前一个位置的元素换位
 * 时间复杂度：
 * 平均:O（n^2）
 * 最好:O（n^2）
 * 最坏:O（n^2）
 * 不稳定
 */
public class SimpleSelectionSort {
    public static void sort(int[] disorder,int orderCount) {
        int key,temp;
        for (int i = 0;i<orderCount;++i) {
            key = selectMinKey(disorder,orderCount,i);
            if (key != i) {
                temp = disorder[i];
                disorder[i] = disorder[key];
                disorder[key] = temp;
            }
//            for (int a : disorder) {
//                System.out.print(a);
//            }
            System.out.println();
        }
    }

    private static int selectMinKey(int[] disorder,int orderCount,int currentIndex) {
        int k = currentIndex;
        for (int j = currentIndex +1;j<orderCount;++j) {
            if (disorder[k] > disorder[j]) k = j;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] disorder = {9,8,7,6,5,1,3,2};
        sort(disorder, 8);
    }
}
