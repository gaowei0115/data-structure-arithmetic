package com.data.arithmetic.sort.merge;

import com.data.arithmetic.sort.common.RandomUtils;

/**
 * @packageName：com.data.arithmetic.sort.merge
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-20 11:02
 * @history: (version) author date desc
 */
public class MergeSort<T extends Comparable<? super T>> {


    private int currentSize;
    private T[] elements;

    private static final int DEFAULT_SIZE = 10;


    public MergeSort() {
        this(DEFAULT_SIZE);
    }

    public MergeSort(int size) {
        this.currentSize = 0;
        this.elements = (T[]) new Comparable[size];
    }

    public void insert(T ele) {
        ensureArrays();
        this.elements[currentSize++] = ele;
    }

    /**
     * 添加数组
     * @param arrays
     */
    public void addAll(T[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            insert(arrays[i]);
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort() {
        mergeSort(this.elements, (T[]) new Comparable[this.elements.length], 0, this.currentSize - 1);
    }

    public void mergeSort(T[] arrays, T[] dests, int leftPos, int rigthPos) {


        /**
         *                     10, 5, 7, 8, 4, 2, 11, 1
         *             10, 5, 7, 8                  4, 2, 11, 1
         *          10, 5       7, 8              4, 2       11, 1
         *        10      5   7      8          4      3   11      1
          */
        if (leftPos < rigthPos) {
            int centerPos = (leftPos + rigthPos) / 2;

            // 左部分排序
            mergeSort(arrays, dests, leftPos, centerPos);

            // 右部分排序
            mergeSort(arrays, dests, centerPos + 1, rigthPos);

            // 合并结果
            merge(arrays, dests, leftPos, centerPos, rigthPos);
        }


    }

    public void merge(T[] arrays, T[] dests, int leftPos, int midPos, int rigthPos) {

        int i = leftPos;
        int j = midPos + 1;
        int t = 0;
        while (i <= midPos && j <= rigthPos) {
            if (arrays[i].compareTo(arrays[j]) < 0) {
                dests[t++] = arrays[i++];
            } else {
                dests[t++] = arrays[j++];
            }
        }

        while(i <= midPos) {
            dests[t++] = arrays[i++];
        }

        while (j <= rigthPos) {
            dests[t++] = arrays[j++];
        }

        t = 0;
        while (leftPos <= rigthPos) {
            arrays[leftPos++] = dests[t++];
        }
    }




    /**
     * 确保数组长度
     */
    private void ensureArrays() {
        if (this.currentSize > this.elements.length) {
            int length = this.elements.length << 2 + 1;
            T[] newElements = (T[]) new Comparable[length];
            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }

    public void display(String message) {
        System.out.println(">> " + message);
        System.out.print("[ ");
        for (int i = 0; i < this.elements.length; i++) {
            System.out.print(this.elements[i]);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();

        sort.addAll(RandomUtils.randomIntArray());

        sort.display("merge before ");

        sort.mergeSort();

        sort.display("merge after ");
    }

}
