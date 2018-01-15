package com.mmc.data.structure.tableStackQueue.system.linked;

import javafx.scene.shape.MoveTo;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.linked
 * @desrciption: 前移编码
 *                  从标准输入读取一串字符，使用链表保存这些字符并清除重复字符。当读取一个从未见过字符时，将它插入表头。
 *                  当读取一个重复字符时，将它从链表中删除并再次插入表头。实现了前移编码策略，这种策略假设最近访问的元素
 *                  很有可能再次访问，因此可用于数据缓存、数据压缩等许多场景。
 * @author: gaowei
 * @date： 2018-01-15 10:11
 * @history: (version) author date desc
 */
public class MoveToFront<T extends Comparable<T>> {

    private Node<T> first;
    private Node<T> last;
    private int size;


    /**
     *
     */
    public MoveToFront() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * 链表节点
     * @param <T>
     */
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> pre;

        public Node(T data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }

    /**
     * 添加数据
     * @param data
     */
    public void put(T data) {
        final Node<T> node = new Node<T>(data, null, null);
        addFirst(node);
    }

    /**
     * 链表首部添加元素
     * @param node
     */
    private void addFirst(final Node<T> node) {
        final Node<T> f = first;
        if (isLinkedExist(node)) {
            removeNode(node);
        }
        first = node;
        if (f == null) {
            last = node;
        } else {
            f.pre = node;
            node.next = f;
        }
        this.size++;
    }

    /**
     * 获取元素
     * @return
     */
    public T get() {
        return getFirstData();
    }

    /**
     * 获取首部元素
     * @return
     */
    private T getFirstData() {
        Node<T> f = first;
        if (f == null && isEmpty()) {
            System.out.println("元素不存在....");
            throw new IllegalArgumentException("元素不存在....");
        }

        first = f.next;
        T data = f.data;
        f = null;
        this.size--;
        return data;
    }

    /**
     * 链表节点上会否存在
     * @param node
     * @return
     */
    public boolean isLinkedExist(final Node<T> node) {
        Node<T> current = first;
        if (node == null) {
            return false;
        }
        T data = node.data;
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                break;
            }
            current = current.next;
        }
        if (current != null) {
            return true;
        }
        return false;
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    private void removeNode(final Node<T> node) {
        Node<T> current = first;
        T data = node.data;
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                // 存在节点，删除
                System.out.println("删除重复节点 >> " + data);
                Node<T> pre = current.pre;
                Node<T> next = current.next;
                if (pre == null) {
                    this.first = next;
                    current = null;
                } else if (next == null) {
                    this.last = pre;
                    current = null;
                } else {
                    pre.next = next;
                    next.pre = pre;
                }
                this.size--;
            }
            current = current.next;
        }
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
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
}
