package com.mmc.data.structure.system.queue;

/**
 * @packageName：com.mmc.data.structure.system.queue
 * @desrciption: 循环队列实现
 *                  线性数据结构
 * @author: gaowei
 * @date： 2018-10-24 11:00
 * @history: (version) author date desc
 */
public class MyCircularQueue {


    private int[] elements;

    private int front;
    private int size;
    private int rear;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.elements = new int[k];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (rear == this.elements.length - 1) {
            rear = -1;
        }
        elements[++rear] = value;
        this.size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == this.elements.length - 1) {
            front = -1;
        }
        elements[++front] = 0;
        this.size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front + 1];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return (rear == -1) ? elements[elements.length - 1] : elements[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if ((this.front == -1 && this.rear == -1) || this.size == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (this.size == this.elements.length) {
            return true;
        }
        return false;
    }
}
