package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 双向队列实现两个栈
 * @author: gaowei
 * @date： 2018-01-23 15:21
 * @history: (version) author date desc
 */
public class DequeueGenerDoubleStack<T extends Comparable<T>> {

    /**
     * 数组模拟队列
     */
   private transient T[] elements;

    /**
     * 头下标指向
     */
   private transient int head;
    /**
     * 尾下标指向
     */
   private transient int tail;

    /**
     * 默认容量
     */
   private static final int DEFAULT_CAPACITY = 16;

   public DequeueGenerDoubleStack() {
       this.elements = (T[]) new Comparable[DEFAULT_CAPACITY];
       this.head = 0;
       this.tail = 0;
   }

    /**
     * 扩容
     *      满足：head == tail
     */
   public void doubleCapacity() {
        // 验证是否满足条件
        assert head == tail;
        //
        int p = head;
        int n = elements.length;
        int r = n - p;
        T[] oldElements = elements;
        int capacity = n << 1;
        if (capacity < 0) {
            throw new IllegalArgumentException("deqeue capactiy error.");
        }
        T[] newElements = (T[]) new Comparable[capacity];

        // 复制元素
       int j = 0;
       for (int i = p; i < n; i++) {
            newElements[j++] = oldElements[i];
       }
       for (int i = p - 1; i >= 0; i--) {
           newElements[j++] = oldElements[i];
       }
       this.elements = newElements;
       this.head = 0;
       this.tail = n;
   }

    /**
     * 首部添加元素
     * @param element
     */
   public void addFirst(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        this.elements[head = (head - 1) & (this.elements.length - 1)] = element;
        if (head == tail) {
            doubleCapacity();
        }
   }

    /**
     * 尾部添加元素
     * @param element
     */
   public void addLast(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        elements[tail] = element;
        tail = (tail + 1) & (this.elements.length - 1);
        if (tail == head) {
            doubleCapacity();
        }
   }

    /**
     * 首部弹出元素
     * @return
     */
   public T pollFirst() {
        int h = head;
        T e = elements[h];
        if (e == null) {
            return null;
        }
        elements[h]= null;
        head = (h + 1) & (this.elements.length - 1);
        return e;
   }

    /**
     * 尾部弹出元素
     * @return
     */
   public T pollLast() {
       int t = (tail - 1) & (this.elements.length - 1);
       T e = elements[t];
       if (e == null) {
           throw new NullPointerException();
       }
       elements[t] = null;
       tail = t;
       return e;
   }
}
