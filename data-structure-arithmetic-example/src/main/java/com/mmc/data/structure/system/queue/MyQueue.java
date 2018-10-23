package com.mmc.data.structure.system.queue;

/**
 * @packageName：com.mmc.data.structure.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-10-23 15:50
 * @history: (version) author date desc
 */
public class MyQueue<T extends Comparable<? super T>> {

    private T[] elements;
    private int size;
    private int tail;
    private int front;

    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;


    public MyQueue() {
        this.elements = (T[]) new Comparable[DEFAULT_SIZE];
        this.size = 0;
        this.front = 0;
        this.tail = -1;
    }

    public MyQueue(int size) {
        this.elements = (T[]) new Comparable[size];
        this.front = 0;
        this.size = 0;
        this.tail = -1;
    }

    public void enqueue(T element) {
        add(element);
    }

    private void add(T elment) {
        if (isFull()) {
            return;
        }
        this.elements[++tail] = elment;
        this.size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        this.size--;
        return this.elements[front++];
    }

    /**
     * 是否满
     * @return
     */
    public boolean isFull() {
        if (size == elements.length) {
            return true;
        }
        return false;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        if (tail == -1 || this.size == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(12);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(19);

        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

    }
}
