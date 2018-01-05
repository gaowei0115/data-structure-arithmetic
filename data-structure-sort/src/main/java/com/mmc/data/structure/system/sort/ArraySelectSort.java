package com.mmc.data.structure.system.sort;

/**
 * @packageName：com.mmc.data.structure.system.sort
 * @desrciption: 选择排序
 * @author: gaowei
 * @date： 2017/12/16 15:41
 * @history: (version) author date desc
 */
public class ArraySelectSort<T extends Comparable<T>> {

    // 定义数据
    private T[] elements;

    private int size;

    /**
     * 默认长度
     */
    private static int DEFAULT_SIZE = 20;

    public ArraySelectSort() {
        elements = (T[]) new Comparable[DEFAULT_SIZE];
        size = 0;
    }

    public ArraySelectSort(int size) {
        elements = (T[]) new Comparable[size];
        this.size = 0;
    }


    /**
     * 选择排序
     */
    public void selectSort() {
        int index = 0;
        for (int i = 0; i < size - 1; i++) {
            index = i;
            for (int j = i; j < size; j++) {
                if (elements[index].compareTo(elements[j]) > 0) {
                    index = j;
                }
            }
            swap(i, index);
        }
    }

    /**
     * 交换元素
     * @param index
     * @param swapIndex
     */
    public void swap(int index, int swapIndex) {
        T tmp = elements[index];
        elements[index] = elements[swapIndex];
        elements[swapIndex] = tmp;
    }

    /**
     *
     * @param element
     */
    public void insert(T element) {
        if (size == elements.length) {
            T[] oldElements = elements;
            elements = (T[]) new Comparable[size << 2 + 1];
            for (int i = 0; i < size; i++) {
                elements[i] = oldElements[i];
            }
        }
        elements[size++] = element;
    }

    /**
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return elements[index];
    }

    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T element = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        return element;
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
