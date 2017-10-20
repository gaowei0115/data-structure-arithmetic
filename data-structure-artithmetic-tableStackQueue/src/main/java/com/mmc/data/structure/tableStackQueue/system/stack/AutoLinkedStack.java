package com.mmc.data.structure.tableStackQueue.system.stack;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.stack
 * 类 名: AutoLinkedStack
 * 描 述: 使用链表实现栈结构
 * 作 者: GW
 * 创 建： 2017-10-20 13:58
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedStack<T> {

    /**
     * 链表特性
     *      链表由一组节点组成，节点在内存中不相连。每个节点均含有表元素和包含该元素的前后继节点的链（link）
     *  栈特性
     *      LIFO（后进先出）原则
     */

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     *
     */
    public AutoLinkedStack() {
        clear();
    }

    /**
     * 弹出元素 尾部弹出
     */
    public T poll() {
        final Node<T> current = last;

        if (current == null) {
            return null;
        } else {
            Node<T> pre = current.previous;
            T d = current.data;
            current.previous = null;
            if (pre != null) {
                pre.next = null;
            }
            last = pre;
            size--;
            return d;
        }
    }

    /**
     * 插入元素 尾部插入
     * @param d
     */
    public void push(T d) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, null, d);
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     *
     * @return
     */
    public T get() {
        final Node<T> current = last;

        if (current == null) {
            return null;
        } else {
            return current.data;
        }
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return (last == null && first == null) || (size == 0);
    }

    /**
     * 指定位置添加元素
     * @param index
     * @param d
     * @return
     */
    public void add(int index, T d) {
        if (index == size) {
            add(d);
        } else {
            addBefore(d, getNode(index));
        }
    }

    public Node<T> getNode(int index) {
        int p = size >> 2;
        Node<T> current = null;
        if (p > index) {
            for (int i = size - 1; i > index; i--) {
                current = last;
                current = current.previous;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = first;
                current = current.next;
            }
        }
        return current;
    }

    /**
     * 添加元素
     * @param d
     */
    public void add(T d) {
        if (last == null) {
            addLast(d);
        } else {
            addFirst(d);
        }
    }


    /**
     * 某个节点之前追加节点
     * @param d
     * @param node
     */
    public void addBefore(T d, Node<T> node) {
        final Node<T> pre = node.previous;
        final Node<T> newNode = new Node<T>(pre, node, d);
        newNode.next = node;
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
        size++;
    }

    /**
     * 开始位置追加
     * @param d
     */
    public void addFirst(T d) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<T>(null, f, d);
        if (f == null) {
            last = newNode;
        } else {
            f.previous = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * 在末尾追加
     * @param d
     */
    public void addLast(T d) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, null, d);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 清空
     */
    public void clear() {
        Node<T> current = first;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current.previous = null;
            current.data = null;
            current = next;
        }
        size = 0;
        first = last = null;
    }


    private static class Node<T> {

        private Node<T> previous;
        private Node<T> next;
        private T data;

        /**
         * @param pre
         * @param next
         * @param data
         */
        public Node(Node pre, Node next, T data) {
            this.previous = pre;
            this.next = next;
            this.data = data;
        }



    }
}
