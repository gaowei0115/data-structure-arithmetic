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

    /**
     * 光标左移
     * @param k
     */
    public void left(int k) {
        StackBufferAuto<Character> temp = new StackBufferAuto<Character>();
        if (k <= 0 || k > this.getSize()) {
            return ;
        }
        int i = 1;
        while (!buffer.isEmpty()) {
            Character c = buffer.poll();
            if (i > k) {
                temp.push(c);
            }
            i++;
        }

        while (!temp.isEmpty()) {
            buffer.push(temp.poll());
        }
    }

    /**
     * 右移光标
     * @param k
     */
    public void right(int k) {
        while (k > 0) {
            this.buffer.push(null);
            k--;
        }
    }

    public int getSize() {
        return this.buffer.size();
    }

    public void display() {
        buffer.display();
    }

    /**
     * 栈模拟缓存
     * @param <T>
     */
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
            this.elements = (T[]) new Comparable[DEFAULT_SIZE];
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
            T[] newElements = (T[]) new Comparable[size];
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

        public void display() {
            int i = 0;
            System.out.print("[");
            for (i = getSize() - 1; i >= 0; i--) {
                Object c = this.elements[i];
                System.out.print(c);
                if (i != 0) {
                    System.out.print(",");
                }
            }
            System.out.print("]");

        }
    }

}
