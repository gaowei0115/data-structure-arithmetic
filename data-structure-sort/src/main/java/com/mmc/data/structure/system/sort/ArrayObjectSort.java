package com.mmc.data.structure.system.sort;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.sort
 * @desrciption: 对象排序
 * @author: gaowei
 * @date： 2017/12/18 21:31
 * @history: (version) author date desc
 */
public class ArrayObjectSort<T extends Comparable<T>>{

    // 数组长度
    private int size;
    // 数组
    private T[] elements;

    // 默认长度
    private static final int DEFAULT_LENGTH = 20;

    /**
     *
     */
    public ArrayObjectSort() {
        size = 0;
        elements = (T[]) new Comparable[DEFAULT_LENGTH];
    }

    /**
     *
     * @param size
     */
    public ArrayObjectSort(int size) {
        this.size = 0;
        elements = (T[]) new Comparable[size];
    }


    /**
     * 插入排序
     */
    public void insertSort() {
        T ele = null;
        for (int i = 1; i < size; i++) {
            ele = elements[i];
            int j = 0;
            for (j = i; j > 0 && ele.compareTo(elements[j - 1]) < 0; j--) {
                elements[j] = elements[j - 1];
            }
            elements[j] = ele;
        }
    }

    /**
     * 选择排序
     * 根据排序规则选择最大或最小者的索引位置进行交换
     */
    public void selectSort() {
        int index = 0;
        T ele = null;
        for (int i = 0; i < size - 1; i++) {
            index = i;
            for (int j = i; j < size - 1; j++) {
                if (elements[index].compareTo(elements[j + 1]) > 0) {
                    index = j + 1;
                }
            }
            // 交换元素
            ele = elements[i];
            elements[i] = elements[index];
            elements[index] = ele;
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort() {
        T ele = null;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    ele = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = ele;
                }
            }
        }
    }

    /**
     * 确认长度
     * @param length
     */
    public void ensureCapacity(int length) {
        if (length > elements.length - 1) {
            // 扩充数组长度
            T[] oldElements = elements;
            elements = (T[]) new Comparable[length << 2 + 1];
            for (int i = 0; i < size; i++) {
                elements[i] = oldElements[i];
            }
        }
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(T element) {
        ensureCapacity(size);
        elements[size++] = element;
    }

    /**
     * 查找索引位置元素
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        return elements[index];
    }

    /**
     * 删除下标元素
     * @param index
     * @return
     */
    public T remove(int index) {
        return getAndRemove(index);
    }

    /**
     * 删除
     * @param e
     * @return
     */
    public boolean remove(T e) {
        if (!(e instanceof Comparable)) {
            throw new IllegalArgumentException("参数类型不匹配");
        }
        if (e == null) {
            throw new IllegalArgumentException("查询条件参数为空");
        }

        if (e == null) {
            for (int index = 0; index < size; index++)
                if (elements[index] == null) {
                    getAndRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (e.equals(elements[index])) {
                    getAndRemove(index);
                    return true;
                }
        }
        return false;
    }

    /**
     *
     * @param index
     * @return
     */
    public T getAndRemove(int index) {
        T e = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        T[] newELement = (T[]) new Comparable[size - 1];
        T[] oldElement = elements;
        for (int i = 0; i < newELement.length; i++) {
            newELement[i] = oldElement[i];
        }
        elements = newELement;
        return e;
    }

    public void display() {
        System.out.print("reslt : [");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i != size - 1) {
                System.out.println("");
            }
        }
        System.out.print("]");
        System.out.println();
    }

}
