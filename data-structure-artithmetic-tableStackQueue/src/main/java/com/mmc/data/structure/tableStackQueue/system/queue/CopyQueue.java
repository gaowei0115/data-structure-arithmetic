package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 复制队列
 * @author: gaowei
 * @date： 2018-01-15 11:15
 * @history: (version) author date desc
 */
public class CopyQueue<T extends Comparable<T>> {


    private T data;
    private int size;
    private T[] elements;
    private int top;
    private int bottom;
    private static final int DEFAULT_SIZE = 10;

    public CopyQueue() {
        this.elements = (T[]) new Comparable[DEFAULT_SIZE];
        this.size = 0;
        this.top = -1;
        this.bottom = -1;
    }

    public CopyQueue(int size) {
        this.elements = (T[]) new Comparable[size];
        this.size = 0;
        this.top = -1;
        this.bottom = -1;
    }

    /**
     * 通过构造器实现队列复制
     * @param queue
     */
    public CopyQueue(CopyQueue<T> queue) {
        if (queue != null) {
            CopyQueue<T> newQueue = new CopyQueue<T>();
            this.elements = (T[]) new Comparable[DEFAULT_SIZE];
            this.size = 0;
            this.top = -1;
            this.bottom = -1;
            while (!queue.isEmpty()) {
                T data = queue.poll();
                push(data);
                newQueue.push(data);
            }
            queue.top = -1;
            queue.bottom = -1;
            while (!newQueue.isEmpty()) {
                queue.push(newQueue.poll());
            }
        }
    }

    /**
     * 添加元素
     * @param data
     */
    public void push(T data) {
        if (isFull()) {
            System.out.println("队列为满,扩充队列长度");
            extendQueue(this.size << 2 + 1);
        }
        if (this.bottom == this.elements.length - 1) {
            this.bottom = -1;
        }
        elements[++this.bottom] = data;
        this.size++;
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        if (top == this.elements.length - 1) {
            top = -1;
        }
        T data = elements[++top];
        this.size--;
        elements[top] = null;
        return data;
    }

    /**
     * 扩充队列
     * @param size
     */
    public void extendQueue(int size) {
        T[] oldElements = elements;
        T[] newElements = (T[]) new Comparable[size];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = oldElements[i];
        }
    }

    /**
     * 队列满
     * @return
     */
    public boolean isFull() {
        return (this.size == elements.length);
    }

    /**
     * 队列为空
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int getSize() {
        return size;
    }
}
