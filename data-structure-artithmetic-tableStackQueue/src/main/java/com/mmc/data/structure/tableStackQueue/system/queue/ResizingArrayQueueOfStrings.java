package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 使用定长数组实现队列的抽象，然后扩展实现，使用调整数组的方式突破大小限制
 * @author: gaowei
 * @date： 2018-01-09 13:54
 * @history: (version) author date desc
 */
public class ResizingArrayQueueOfStrings<T> {

    // 数组模拟队列
    private T[] elements;

    // 队列长度
    private int size;

    // 队列取下标指引位置
    public int top;

    // 队列存储数据指引位置
    public int tail;

    // 初始化默认队列长度
    private static final int DEFAULT_SIZE = 10;

    public ResizingArrayQueueOfStrings() {
        this(DEFAULT_SIZE);
    }

    public ResizingArrayQueueOfStrings(int size) {
        this.elements = (T[]) new Object[size];
        this.size = 0;
        this.top = -1;
        this.tail = -1;
    }

    /**
     * 队列添加元素
     * @param element
     */
    public void push(T element) {
        if (isFull()) {
            System.out.println("队列已满......");
            extendsQueue(this.size << 2 + 1);
        }
        this.elements[++tail] = element;
        this.size++;
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            System.out.println("队列为空.....");
        }
        T oldElement = elements[++top];
        elements[top] = null;
        this.size--;
        return oldElement;
    }

    /**
     * 取出倒序第last元素
     * @param last
     * @return
     */
    public T getLast(int last) {
        return get(this.size - last);
    }

    /**
     *
     * @param top
     * @return
     */
    public T getTop(int top) {
        return get(top - 1);
    }

    /**
     *  获取对应的下标元素
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IllegalArgumentException("下标出错");
        }

        T oldE = elements[index];
        return oldE;
    }

    /**
     * 队列为空
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * 队列是否满
     * @return
     */
    public boolean isFull() {
        return (this.tail == (this.elements.length - 1));
    }

    /**
     * 扩充元素
     * @param length
     */
    public void extendsQueue(int length) {
        T[] oldElements = elements;
        T[] newElements = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
        elements = newElements;
    }
}

