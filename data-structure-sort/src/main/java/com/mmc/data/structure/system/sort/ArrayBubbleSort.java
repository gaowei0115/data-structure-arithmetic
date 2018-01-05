package com.mmc.data.structure.system.sort;

/**
 * @packageName：com.mmc.data.structure.system.sort
 * @desrciption: 数组冒泡排序
 * @author: gaowei
 * @date： 2017/12/11 22:14
 * @history: (version) author date desc
 */
public class ArrayBubbleSort<T extends Comparable<T>> {

    // 定义数据
    private T[] elements;

    private int size;

    /**
     * 默认长度
     */
    private static int DEFAULT_SIZE = 20;

    public ArrayBubbleSort() {
        elements = (T[]) new Comparable[DEFAULT_SIZE];
        size = 0;
    }

    public ArrayBubbleSort(int size) {
        elements = (T[]) new Comparable[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort() {
        T temp = null;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * @param element
     */
    public void insert(T element) {
        if (size == elements.length) {
            T[] oldElements = elements;
            elements = (T[]) new Object[size << 2 + 1];
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
