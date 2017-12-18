package com.mmc.data.structure.system.sort;

import java.util.Arrays;

/**
 * @packageName：com.mmc.data.structure.system.sort
 * @desrciption:
 * @author: gaowei
 * @date： 2017/12/16 19:12
 * @history: (version) author date desc
 */
public class ArrayInsertSort<T extends Comparable<T>> {

    // 数组长度
    private int size;
    // 数组
    private T[] elements;

    // 默认长度
    private static final int DEFAULT_LENGTH = 20;

    /**
     *
     */
    public ArrayInsertSort() {
        size = 0;
        elements = (T[]) new Comparable[DEFAULT_LENGTH];
    }

    /**
     *
     * @param size
     */
    public ArrayInsertSort(int size) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayInsertSort<?> that = (ArrayInsertSort<?>) o;

        if (size != that.size) return false;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(elements);
        return result;
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
