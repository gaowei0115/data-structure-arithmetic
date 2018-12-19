package com.data.arithmetic.sort.heap;

import com.data.arithmetic.sort.common.RandomUtils;

/**
 * @packageName：com.data.arithmetic.sort.heap
 * @desrciption: 实现堆数据结构
 * @author: gaowei
 * @date： 2018-12-18 11:15
 * @history: (version) author date desc
 */
public class MockHeap<T extends Comparable<? super T>>{

    private int size;

    private T[] elements;

    private static final int DEFAULT_SIZE = 10;

    public MockHeap() {
        this(DEFAULT_SIZE);
    }

    public MockHeap(int size) {
        this.size = 0;
        this.elements = (T[]) new Comparable[size];
    }


    /**
     * 堆中添加元素
     * @param ele
     */
    public void insert(T ele) {
        if (size == elements.length - 1) {
            enlargeArray(elements.length << 2 + 1);
        }

        /**
         * 位置
         */
        int index = size++;

        while(index > 0 && ele.compareTo(elements[index / 2]) < 0) {
            elements[index] = elements[index / 2];
            index = index / 2;
        }
        elements[index] = ele;
    }

    /**
     * 删除最小元素
     */
    public T delMin() {
        // 取顶层元素 -- 最小
        T rEle = elements[0];

        // 将最后一个节点元素放到顶层元素位置
        elements[0] = elements[--size];

        // 从顶层元素下滤，查找最小元素放置顶层
        percolateDown(0);
        return rEle;
    }

    /**
     * 删除heap根节点
     */
    public T remove() {
        T rNode = elements[0];
        elements[0] = elements[--size];

        percolateDown(0);

        return rNode;
    }

    private void percolateDown(int index) {
        int childIndex;
        T ele = elements[index];
        while (index < size / 2) {
            int leftIndex = index * 2 + 1;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && elements[leftIndex].compareTo(elements[rightIndex]) > 0) {
                childIndex = rightIndex;
            } else {
                childIndex = leftIndex;
            }

            if (ele.compareTo(elements[childIndex]) > 0) {
                elements[index] = elements[childIndex];
                index = childIndex;
            } else {
                break;
            }
        }
        elements[index] = ele;
    }

    public void addAll(T[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            insert(arrays[i]);
        }
    }

    public void display() {
        System.out.println("print : ");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                System.out.print(elements[i] + " ");
            } else {
                System.out.print("--");
            }
        }

        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".................................";
        System.out.println(dots + dots);

        while (size > 0) {
            if (column == 0) {
                for (int i = 0; i < nBlanks; i++) {
                    System.out.print(" ");
                }
            }
            System.out.print(elements[j]);
            if (++j == size) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlanks = nBlanks / 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public int getSize() {
        return size;
    }

    /**
     *
     * 扩充数组空间
     * @param largeL
     */
    private void enlargeArray(int largeL) {
        T[] oldELements = elements;
        T[] newElements = (T[]) new Comparable[largeL];

        for (int i = 0; i < oldELements.length; i++) {
            newElements[i] = oldELements[i];
        }
        elements = newElements;
    }

    public static void main(String[] args) {
        MockHeap heap = new MockHeap();
        heap.insert(10);
        heap.insert(40);
        heap.insert(12);
        heap.insert(8);
        heap.insert(1);
        heap.insert(19);

        System.out.println("before ");
        heap.display();

        heap.remove();

        System.out.println("after ");
        heap.display();


        heap.remove();

        System.out.println("again remove ");
        heap.display();


        System.out.println("use heap sort ");

        heap = new MockHeap();
        heap.addAll(RandomUtils.randomIntArray(30, 100));

        System.out.println("heap sort before ");
        heap.display();

        System.out.println("heap sort after ");

        System.out.print("[");
        int size = heap.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(heap.delMin() + " ");
        }
        System.out.print("]");

//        heap.display();

    }
}
