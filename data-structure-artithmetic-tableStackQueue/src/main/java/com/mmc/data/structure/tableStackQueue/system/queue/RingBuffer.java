package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 环形缓冲区，依据数组底层结构队列实现环形队列
 *
 * @author: gaowei
 * @date： 2018-01-12 16:45
 * @history: (version) author date desc
 */
public class RingBuffer<T extends Comparable<T>> {

    /**
     * 数组表示缓存区对象
     */
    private T[] buffer;
    /**
     * 缓冲区长度
     */
    private int capacity;
    /**
     * 下一个元素读取位置
     */
    private int getIndex;
    /**
     * 下一个元素取出位置
     */
    private int putIndex;

    /**
     * 默认缓存区长度
     */
    private static final int DEFAULT_CAPACITY = 1024;


    /**
     *
     */
    public RingBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.getIndex = 0;
        this.putIndex = 0;
        this.buffer = (T[]) new Comparable[this.capacity];
    }

    /**
     * 保存环形缓存区数据
     * @param data
     */
    public void put(T data) {
        buffer[putIndex] = data;
        // 指向下一个标志位
        this.putIndex = getNextIndex(putIndex);

        System.out.println("put 元素剩余个数：");
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < capacity; i++) {
            sb.append(buffer[i]);
            if (this.capacity - 1 != i) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 环形缓冲区取数据
     * @return
     */
    public T get() {
        T data = buffer[getIndex];
        buffer[getIndex] = null;
        getIndex = getNextIndex(getIndex);
        System.out.println("get 元素剩余个数：");
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < capacity; i++) {
            sb.append(buffer[i]);
            if (this.capacity - 1 != i) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
        return data;
    }


    /**
     * 获取下一个位置标识
     *      如果达到缓存区长度时，返回到起始位置
     * @param index
     * @return
     */
    private int getNextIndex(int index) {
        return (index + 1) == this.capacity ? 0 : (index + 1);
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.getIndex == 0 && this.putIndex == 0);
    }

}
