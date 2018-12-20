package com.data.arithmetic.sort.merge;

/**
 * @packageName：com.data.arithmetic.sort.merge
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-20 17:25
 * @history: (version) author date desc
 */
public class MergeSortWhile<T extends Comparable<? super T>> {

    private int size;
    private T[] elements;

    private static final int DEFAULT_SIZE = 10;


    public MergeSortWhile() {
        this(DEFAULT_SIZE);
    }

    public MergeSortWhile(int size) {
        this.size = 0;
        this.elements = (T[]) new Comparable[size];
    }

    /**
     * 添加元素
     * @param ele
     */
    public void add(T ele) {
        ensureArrays();
        this.elements[size++] = ele;
    }

    public void addAll(T[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }

        for (int i = 0; i < arrays.length; i++) {
            add(arrays[i]);
        }
    }


    public void merge() {
        if (this.elements == null && this.elements.length == 0) {
            return;
        }

        int left = 0;
        int right = this.elements.length - 1;

        while (true) {
            if (left > right) {
                break;
            }

            if (elements[left].compareTo(elements[right]) > 0) {

            }
        }

    }

    private void ensureArrays() {
        if (this.size >= this.elements.length) {
            int length = this.elements.length;
            T[] newElements = (T[]) new Comparable[length << 2 + 1];
            for (int i = 0; i < length; i++) {
                newElements[i] = elements[i];
            }
            this.elements = newElements;
        }
    }
}
