package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.queue
 * 类 名: AutoLinkedQueue
 * 描 述: 使用链表实现队列数据结构
 * 作 者: GW
 * 创 建： 2017-10-23 11:01
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedQueue<T> {

    /**
     *  队列特性：
     *      FIFO（先进先出）
     *  链表特性：
     *      链表由一组节点组成，节点在内存中不相连。每个节点均含有表元素和包含该元素的前后继节点的链（link）
     */

    private int size;

    private Node<T> first;
    private Node<T> last;

    public AutoLinkedQueue() {
        this.size = 0;
        first = last = null;
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        final Node<T> current = first;
        if (current == null) {
            return null;
        } else {
            Node<T> next = first.next;
            if (next != null) {
                first.next.pre = null;
            }
            first = next;
            T data = current.data;
            current.next = null;
            current.pre = null;
            current.data = null;
            size--;
            return data;
        }
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 保存元素
     * @param element
     */
    public void push(T element) {
        final Node<T> current = last;
        final Node<T> newNode = new Node<T>(current, null, element);
        last = newNode;
        if (current == null) {
            first = newNode;
        } else {
            current.next = newNode;
        }
        size++;
    }

    /**
     * size
     * @return
     */
    public int size() {
        return size;
    }


    /**
     * Node节点
     * @param <T>
     */
    private static class Node<T> {
        private T data;
        private Node<T> pre;
        private Node<T> next;

        public Node(Node pre, Node next, T data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }
    }
}
