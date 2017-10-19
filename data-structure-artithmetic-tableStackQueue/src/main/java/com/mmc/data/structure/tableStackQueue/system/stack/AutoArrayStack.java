package com.mmc.data.structure.tableStackQueue.system.stack;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.stack
 * 类 名: AutoStack
 * 描 述: 使用数组实现栈结构
 * 作 者: GW
 * 创 建： 2017-10-19 11:22
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoArrayStack<T> {

    /**
     * 栈特性：
     *      LIFO（后进先出）原则
     */

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] elements;
    private int top;
    private int peek;

    public AutoArrayStack() {
        this.top = 0;
        this.size = 0;
        elements = (T[])new Object[DEFAULT_CAPACITY];
    }

    public AutoArrayStack(int capacity) {
        this.top = 0;
        this.size = 0;
        elements = (T[])new Object[capacity];
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(T element) {
        add(top, element);
    }

    /**
     * 添加元素
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (size == elements.length) {
            ensureCapacity(size << 1 + 1);
        }
        elements[index] = element;
        size++;
        top++;
        peek++;
    }

    /**
     * 压入栈
     * @param element
     */
    public void push(T element) {
        if (size == elements.length) {
            ensureCapacity(size << 1 + 1);
        }
        elements[top++] = element;
        size++;
        peek++;
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        rangeCheck(top);
        int index = top;
        T old = elements[index];
        elements[index] = null;
        peek--;
        top--;
        size--;
        return old;
    }


    /**
     * 自动扩容
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        if (capacity < size) {
            throw new IllegalArgumentException();
        }
        T[] oldElements = elements;
        T[] newElements = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
        oldElements = null;
        elements = newElements;
    }

    /**
     * 获取指定元素
     * @return
     */
    public T get() {
        if (isEmpty()) {
            return null;
        }
        return get(top);
    }

    /**
     * 获取指定下标元素
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        T oldElement = elements[index];
        elements[index] = null;
        return oldElement;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (size <= 0 || top <= 0);
    }

    /**
     * 返回栈空间长度
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 下标检测
     * @param index
     */
    public void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index [" + index + "] out ");
        }
    }

    /**
     * 清除
     */
    public void clear() {
        size = 0;
        if (elements != null && elements.length != 0) {
            for (T temp : elements) {
                temp = null;
            }
        } else {
            elements = (T[])new Object[DEFAULT_CAPACITY];
        }
    }

}
