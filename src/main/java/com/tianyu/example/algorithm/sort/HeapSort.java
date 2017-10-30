package com.tianyu.example.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by tianyu on 17/5/23.
 * 时间复杂度:
 * 平均:O(nlogn )
 * 最好:O(nlogn )
 * 最坏:O(nlogn )
 * 不稳定
 */
public class HeapSort {

    public static class Heap {
        private int[] heap;

        private int[] buildMaxHeap(int[] array) {
            //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
            //最后一个有孩子的节点为(array.length - 2) / 2
            for (int i = (array.length - 2) / 2; i >= 0; i--) {
                adjustDownToUp(array, i, array.length);
            }
            return array;
        }

        private void adjustDownToUp(int[] array, int k, int length) {
            int temp = array[k];
            for (int child = 2 * k + 1; child < length; child = 2 * child + 1) {    //child为初始化为节点k的左孩子，沿节点较大的子节点向下调整
                if (child < length - 1 && array[child] < array[child + 1]) {  //取节点较大的子节点的下标
                    child++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
                }
                if (temp >= array[child]) {  //根节点 >=左右子女中关键字较大者，调整结束
                    break;
                } else {   //根节点 <左右子女中关键字较大者
                    array[k] = array[child];  //将左右子结点中较大值array[i]调整到双亲节点上
                    k = child; //【关键】修改k值，以便继续向下调整
                }
            }
            array[k] = temp;  //被调整的结点的值放人最终位置
        }

        public void reBuild() {
            heap = buildMaxHeap(heap);
        }

        //堆排序
        public int[] sort(boolean adjustSelf) {
            int []sorted;
            if (!adjustSelf) {
                sorted = ArrayUtils.clone(heap);
            } else {
                sorted = heap;
            }

            for (int i = sorted.length - 1; i > 0; i--) {
                int temp = sorted[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
                sorted[0] = sorted[i];
                sorted[i] = temp;
                adjustDownToUp(sorted, 0, i);  //整理，将剩余的元素整理成堆
            }
            return sorted;
        }

        //删除堆顶元素操作
        public int[] deleteMax() {
            heap[0] = heap[heap.length - 1];
            heap[heap.length - 1] = Integer.MIN_VALUE;
            adjustDownToUp(heap, 0, heap.length);
            return heap;
        }

        public int[] insertData(int data) {
            heap[heap.length - 1] = data; //将新节点放在堆的末端
            int k = heap.length - 1;  //需要调整的节点

            int parent = (k - 1) / 2;    //双亲节点
            while (parent >= 0 && data > heap[parent]) {
                heap[k] = heap[parent];  //双亲节点下调
                k = parent;
                if (parent != 0) {
                    parent = (parent - 1) / 2;  //继续向上比较
                } else {  //根节点已调整完毕，跳出循环
                    break;
                }
            }
            heap[k] = data;  //将插入的结点放到正确的位置
            return heap;
        }

        public void print() {
            for (int i : heap) {
                System.out.print(i + " ");
            }
        }

        public Heap(int[] arr) {
            this.heap = buildMaxHeap(arr);
        }
    }


    public static void sort(int[] disorder) {
        Heap heap = new Heap(disorder);
        heap.print();
        System.out.println();
        int[] sorted = heap.sort(true);
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
        heap.print();
        heap.reBuild();
        System.out.println();
        heap.print();
    }

    public static void main(String args[]) {
        int[] array = {87, 45, 78, 32, 17,5, 9, 122};
//        System.out.print("构建大根堆：");
//        hs.toString(hs.buildMaxHeap(array));
//        System.out.print("\n"+"删除堆顶元素：");
//        hs.toString(hs.deleteMax(array));
//        System.out.print("\n"+"插入元素63:");
//        hs.toString(hs.insertData(array, 63));
//        System.out.print("\n"+"大根堆排序：");
//        hs.toString(hs.heapSort(array));
        sort(array);
    }

}
