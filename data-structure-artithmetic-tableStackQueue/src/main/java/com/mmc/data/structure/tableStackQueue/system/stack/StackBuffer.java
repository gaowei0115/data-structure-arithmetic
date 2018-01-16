package com.mmc.data.structure.tableStackQueue.system.stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 使用栈实现缓冲区
 * @author: gaowei
 * @date： 2018-01-16 16:34
 * @history: (version) author date desc
 */
public class StackBuffer {

    private StackBufferAuto<Character> buffer;

    public StackBuffer() {
        this.buffer = new StackBufferAuto<Character>();
    }

    /**
     * 保存缓冲区元素
     * @param c
     */
    public void insert(char c) {
        buffer.push(c);
    }

    /**
     * 删除缓冲区元素，并返回删除元素
     * @return
     */
    public char delete() {
        return buffer.poll();
    }

    class StackBufferAuto<T> {

        private int size;
        private int tail;
        private T[] elements;
        private static final int DEFAULT_SIZE = 10;

        /**
         *
         */
        public StackBufferAuto() {
            this.size = 0;
            this.tail = -1;
            this.elements = (T[]) new Object[DEFAULT_SIZE];
        }

        /**
         * 压栈
         * @param element
         */
        public void push(T element) {
            if (this.size == this.elements.length) {
                extendStack(this.size << 2 + 1);
            }
            this.elements[++tail] = element;
            this.size++;
        }

        /**
         * 出栈
         * @return
         */
        public T poll() {
            T data = this.elements[tail];
            this.elements[tail] = null;
            this.tail--;
            this.size--;
            return data;
        }

        /**
         * 扩充元素
         * @param size
         */
        private void extendStack(int size) {
            T[] oldElements = elements;
            T[] newElements = (T[]) new Object[size];
            int length = oldElements.length;
            for (int i = 0; i < length; i++) {
                newElements[i] = oldElements[i];
            }
        }

        /**
         *
         * @return
         */
        public int size() {
            return this.size;
        }

        /**
         *
         * @return
         */
        public boolean isEmpty() {
            return (this.size == 0);
        }
    }

}
