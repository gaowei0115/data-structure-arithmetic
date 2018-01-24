package com.mmc.data.structure.tableStackQueue.system.stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 栈可生成性问题
 *                  假设栈测试用例将会进行一系列混合入栈和出栈操作，序列中的整数0,1,。。。,N - 1(按此先后顺序排列)表示入栈操作
 *                  ，N个减号表示出栈操作。设计一个算法，判定给定的混合序列是否会使数组向下溢出。设计一个线性时间的算法判定给定
 *                  的测试用例能否产生某个给定的排列。
 *                  解答：
 *                      除非对于某个整数K，前K次出栈操作会在前K次入栈操作前完成，否则栈不会向下溢出。
 *                      如果某个排列可以产生，那么它产生的方式一定是唯一的；如果输出排列中的下一个整数的栈顶，
 *                      则将它弹出，否则将它压入栈中。
 * @author: gaowei
 * @date： 2018-01-23 14:16
 * @history: (version) author date desc
 */
public class StackGeneratorProperm<T extends Comparable<T>> {

    /**
     * 模拟栈数据
     */
    private T[] elements;
    /**
     * 栈空间长度
     */
    private int size;
    /**
     * 栈操作下标位置
     */
    private int tail;

    /**
     * 默认栈长度
     */
    private static final int DEFAULT_SIZE = 10;

    public StackGeneratorProperm() {
        this(DEFAULT_SIZE);
    }

    public StackGeneratorProperm(int size) {
        this.elements = (T[]) new Comparable[size];
        this.size = 0;
        this.tail = -1;
    }

    /**
     * 入栈操作
     * @param element
     */
    public void push(T element) {
        if (this.size >= this.elements.length) {
            System.out.println("栈空间已满，需扩容...");
            extendsStack(this.size << 2 + 1);
        }
        this.elements[++tail] = element;
        this.size++;
    }

    /**
     * 出栈操作
     * @return
     */
    public T poll() {
        if (isEmpty()) {
            System.out.println("栈为空...");
            return null;
        }
        T oldElement = this.elements[tail];
        this.elements[tail] = null;
        this.size--;
        this.tail--;
        return oldElement;
    }

    /**
     * 空栈
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * 扩充栈空间
     * @param length
     */
    private void extendsStack(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }

        T[] oldElements = elements;
        T[] newElements = (T[]) new Comparable[length];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
    }

    /**
     * 输出元素
     */
    public void display() {
        System.out.print("result : [");
        for (int i = size - 1; i >= 0; i++) {
            System.out.print(this.elements[i]);
        }
        System.out.print("]");
    }

}
