package com.mmc.data.structure.tableStackQueue.system.javaApi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.javaApi
 * 类 名: AutoArrayList
 * 描 述:
 * 作 者: GW
 * 创 建： 2017-10-17 16:27
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoArrayList<T>  implements Iterable<T>{

    // default capacity
    private static final int DEFAULT_CAPACITY = 10;
    // collection element
    private T[] elements;
    // collection size
    private int size;

    public AutoArrayList() {
        clear();
    }

    /**
     * clear collection
     */
    public void clear() {
        this.size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * obation element
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * add element
     * @param element
     * @return
     */
    public boolean add(T element) {
        add(size, element);
        return true;
    }

    /**
     * remove element
     * @param index
     * @return
     */
    public T remove(int index) {
        rangeCheck(index);
        T oldElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return oldElement;
    }

    /**
     * add  index element
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (size() == elements.length) {
            // ensure capacity
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * set element
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element) {
        rangeCheck(index);
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index [" + index + "] out ");
        }
    }

    /**
     *
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * ensure array size
     * @param newSize
     */
    public void ensureCapacity(int newSize) {
        if (newSize < size) {
            return;
        }

        T[] oldElement = elements;
        elements = (T[])new Object[newSize];
        for (int i = 0; i < size(); i++) {
            elements[i] = oldElement[i];
        }
    }

    /**
     * array size
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * array is empty
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    public Iterator<T> iterator() {
        return new AutoArrayListIterator();
    }

    private class AutoArrayListIterator implements Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return elements[current++];
        }

        public void remove() {
            AutoArrayList.this.remove(--current);
        }
    }
}
