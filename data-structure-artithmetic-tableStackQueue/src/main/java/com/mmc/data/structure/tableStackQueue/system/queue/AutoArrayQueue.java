package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.queue
 * 类 名: AutoArrayQueue
 * 描 述: 数组实现队列结构
 * 作 者: GW
 * 创 建： 2017-10-20 16:06
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoArrayQueue<T> {

    /**
     * 数组特性
     *      一组存储有序的数据集合
     * 队列特性
     *      FIFO（先进先出）原则
     */

    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private int head;
    private int front;

    private T[] elements;


    public AutoArrayQueue() {
        clear();
    }

    public AutoArrayQueue(int capacity) {
        elements = (T[])new Object[capacity];
        size = 0;
        head = -1;
        front = 0;
    }

    /**
     * 检验队列为空
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     *
     * @param capacity
     */
    public void ensureCapacity(int capacity) {
        T[] oldElements = elements;
        T[] newElements = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
        elements = newElements;
    }

    /**
     * 清空队列
     */
    public void clear() {
        T[] newElements = (T[])new Object[DEFAULT_CAPACITY];
        elements = newElements;
        head = -1;
        front = 0;
        size = 0;
    }

    /**
     * 队列长度
     * @return
     */
    public int size() {
        return size;
    }

}
