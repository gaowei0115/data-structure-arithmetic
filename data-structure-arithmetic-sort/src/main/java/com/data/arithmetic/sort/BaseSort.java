package com.data.arithmetic.sort;

/**
 * @packageName：com.data.arithmetic.sort
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-17 9:57
 * @history: (version) author date desc
 */
public class BaseSort<T extends Comparable<? super T>> {

    protected T[] elements;

    private static final int DEFAULT_SIZE = 10;

    protected int size;

    public BaseSort(int size) {
        this.size = 0;
        this.elements = (T[]) new Comparable[size];
    }

    public BaseSort() {
        this.size = 0;
        this.elements = (T[]) new Comparable[DEFAULT_SIZE];
    }

    protected void add(T ele) {
        ensureCapacity(size);
        elements[size++] = ele;
    }

    /**
     * 确认数组长度，是否扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if(capacity > elements.length - 1) {
            T[] oldElements = elements;
            T[] newElements = (T[]) new Comparable[capacity << 2 + 1];
            for (int i = 0; i < oldElements.length; i++) {
                newElements[i] = oldElements[i];
            }
            this.elements = newElements;
        }
    }

    public void addAll(T[] sources) {
        for (T ele : sources) {
            add(ele);
        }
    }

    protected boolean compareTo(T t1, T t2) {
        if (t1.compareTo(t2) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 交换两个元素位置
     * @param start
     * @param end
     */
    protected void swap(int start, int end) {
        T temp = elements[start];
        elements[start] = elements[end];
        elements[end] = temp;
    }

    public void display() {
        System.out.print("reslt : [");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

}
