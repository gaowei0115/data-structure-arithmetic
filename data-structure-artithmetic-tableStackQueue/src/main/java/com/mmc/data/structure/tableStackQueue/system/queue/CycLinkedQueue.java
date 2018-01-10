package com.mmc.data.structure.tableStackQueue.system.queue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 环形链表实现队列
 * @author: gaowei
 * @date： 2018-01-10 16:08
 * @history: (version) author date desc
 */
public class CycLinkedQueue<T extends Comparable<T>> {

    /**
     * 首节点
     */
    private Node first;
    /**
     * 尾节点
     */
    private Node last;

    /**
     * 链表长度
     */
    private int size;

    public CycLinkedQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Node节点
     * @param <T>
     */
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 添加链表节点
     * @param data
     */
    public void add(T data) {
        final Node node = new Node(data,  null);
        addLast(node);
    }

    /**
     * 尾部插入节点
     * @param node
     */
    public void addLast(final Node node) {
        final Node lastNode = last;
        last = node;
        if (lastNode == null) {
            first = node;
        } else {
            lastNode.next = node;
        }
        last.next = first;
        this.size++;
    }

    /**
     *
     * @return
     */
    public T pollFirst() {
        if (first == null) {
            System.out.println("链表为空....");
            throw new IllegalArgumentException("链表为空");
        }
        Node<T> f = first;
        first = f.next;
        T data = f.data;
        f = null;
        this.size--;
        return data;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }


    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
}
