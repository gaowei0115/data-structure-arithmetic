package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 依托链表实现栈队列功能的api
 * @author: gaowei
 * @date： 2018-01-10 16:34
 * @history: (version) author date desc
 */
public class StackQueueLinked<T extends Comparable<T>> {


    /**
     * 首节点
     */
    private Node<T> first;
    /**
     * 尾节点
     */
    private Node<T> last;
    /**
     * 长度
     */
    private int size;

    /**
     *
     */
    public StackQueueLinked() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * 压入栈操作
     * @param data
     */
    public void push(T data) {
        final Node<T> node = new Node<T>(data, null);
        addFirst(node);
    }

    /**
     * 弹出栈操作
     * @return
     */
    public T poll() {
        return pollFirst();
    }

    /**
     * 存放队列
     * @param data
     */
    public void enqueue(T data) {
        final Node<T> node = new Node<T>(data, null);
        addLast(node);
    }

    /**
     * 队列弹出元素
     * @return
     */
    public T dequeue() {
        return pollFirst();
    }

    /**
     * 尾部插入链表节点
     * @param node
     */
    public void addLast(final Node<T> node) {
        Node<T> l = last;
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        this.size++;
    }

    /**
     * 首部插入链表节点
     * @param node
     */
    public void addFirst(final Node<T> node) {
        Node<T> f = first;
        first = node;
        if (f == null) {
            last = node;
        } else {
            node.next = f;
        }
        this.size++;
    }

    /**
     * 首部弹出节点
     * @return
     */
    public T pollFirst() {
        Node<T> f = first;
        T data = f.data;
        first = f.next;
        f = null;
        this.size--;
        return data;
    }

    /**
     * 尾部弹出节点
     * @return
     */
    public T pollLast() {
        Node<T> l = last;
        T data = l.data;
        Node<T> newFirst = new Node<T>(null, null);
        newFirst.next = first;
        Node<T> current = newFirst;
        while (current.next != null) {
            if (current.next == last) {
                break;
            }
        }
        l = null;
        last = current;
        this.size--;
        return data;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * 链表节点
     * @param <T>
     */
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
