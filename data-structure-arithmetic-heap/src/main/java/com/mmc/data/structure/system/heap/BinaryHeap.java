package com.mmc.data.structure.system.heap;

import java.util.NoSuchElementException;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-27 15:17
 * @history: (version) author date desc
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;

    private int currentSize;
    private T[] elements;

    public BinaryHeap() {
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int capacity) {
        this.elements = (T[]) new Comparable[capacity];
        this.currentSize = 0;
    }

    public BinaryHeap(T[] elements) {
        currentSize = elements.length;
        this.elements = (T[]) new Comparable[currentSize * 2 + 1];
        int i = 1;
        for (T t : elements) {
            this.elements[i++] = t;
        }
        // 构建堆数据结构
        buildHeap();
    }

    /**
     * 添加元素
     * @param ele
     */
    public void insert(T ele) {
        if (currentSize == elements.length - 1) {
            // 达到堆空间最大值扩容
            enlargeHeap(elements.length * 2 + 1);
        }

        /**
         * heap.insert(50);
         heap.insert(23);
         heap.insert(12);
         heap.insert(48);
         heap.insert(36);
         heap.insert(8);
         heap.insert(19);
         */
        int hold = ++currentSize;
        /**
         * 采用上滤方式查找存放位置
         * 堆特性：快速操作
         */
        for (; hold > 1 && ele.compareTo(elements[hold / 2]) < 0; hold /= 2) {
            elements[hold] = elements[hold / 2];
        }
        elements[hold] = ele;
    }

    /**
     * 查找最小元素
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[1];
    }

    /**
     * 删除最小元素
     * @return
     */
    public T deleteMin() {
        T minEle = findMin();
        // 末尾元素赋值头元素
        elements[1] = elements[currentSize--];
        // 从头部元素向下过滤找出最小元素放入头部
        percolateDown(1);
        return minEle;
    }

    /**
     * 下滤元素
     * @param hole
     */
    private void percolateDown(int hole) {
        int child = 0;
        T tmpEle = elements[hole];
        for (; 2 * hole <= currentSize; hole = child) {
            child = 2 * hole;
            // 选择堆下滤分支
            if (child != currentSize && elements[child + 1].compareTo(elements[child]) < 0) {
                child++;
            }
            if (tmpEle.compareTo(elements[child]) > 0) {
                elements[hole] = elements[child];
            } else {
                break;
            }
        }
        elements[hole] = tmpEle;
    }

    private void buildHeap() {
        int hole = 0;
        for (hole = currentSize / 2; hole > 0; hole--) {
            percolateDown(hole);
        }
    }

    /**
     * 扩容堆
     * @param size
     */
    private void enlargeHeap(int size) {

    }

    public void printHeap() {
        if (isEmpty()) {
            System.out.println("binary heap is empty....");
        }
        System.out.print("[");
        for (int i = 1; i <= currentSize; i++) {
            System.out.print(elements[i]);
            if (i != currentSize) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    /**
     * 验证是否为空
     * @return
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        this.currentSize = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }


}
