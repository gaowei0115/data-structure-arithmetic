package com.mmc.data.structure.tableStackQueue.system.queue;

import java.util.Random;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 随机队列，基础数据结构 -- 数组
 * @author: gaowei
 * @date： 2018-01-10 17:07
 * @history: (version) author date desc
 */
public class RandomQueue<T extends Comparable<T>> {

    /**
     * 队列元素个数
     */
    private int size;
    /**
     * 队列
     */
    private T[] elements;
    /**
     * 起始位置
     */
    private int top;
    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 5;

    public RandomQueue() {
        this.size = 0;
        this.top = -1;
        this.elements = (T[]) new Comparable[DEFAULT_SIZE];
    }

    /**
     * 队列添加元素
     * @param element
     */
    public void enqueue(T element) {
        if (this.size >= elements.length) {
            extendQueue(this.size << 2 + 1);
        }
        elements[this.size++] = element;
    }

    /**
     * 弹出元素 -- 删除
     * @return
     */
    public T dequeue() {
        Random random = new Random();
        int index = random.nextInt(this.size  - 1);
        T data = elements[index];
        tryQueue(index);
        this.size--;
        return data;
    }

    /**
     * 弹出元素 - 不删除
     * @return
     */
    public T sample() {
        Random r = new Random();
        int index = r.nextInt(this.size  - 1);
        T data = elements[index];
        return data;
    }

    public void tryQueue(int index) {
        for (;index < this.size - 1; index++) {
            elements[index] = elements[index + 1];
        }
        elements[size - 1] = null;
    }

    /**
     * 扩充存储空间
     * @param extendSize
     */
    public void extendQueue(int extendSize) {
        T[] oldElements = elements;
        T[] newElements = (T[]) new Object[extendSize];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
        elements = newElements;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i ++) {
            sb.append(elements[i]);
            if (i != this.size -1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
