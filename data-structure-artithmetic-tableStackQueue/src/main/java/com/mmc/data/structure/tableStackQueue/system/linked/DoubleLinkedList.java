package com.mmc.data.structure.tableStackQueue.system.linked;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.linked
 * 类 名: DoubleLinkedList
 * 描 述: 双端链表
 * 作 者: GW
 * 创 建： 2017-10-23 17:10
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class DoubleLinkedList<T> {


    private int size;
    private Node<T> first;
    private Node<T> last;

    public DoubleLinkedList() {
        this.size = 0;
        this.first = this.last = null;
    }

    /**
     * 链表节点
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

    /**
     * 添加元素
     * @param element
     */
    public void push(T element) {
        final Node<T> f = last;
        final Node<T> newNode = new Node<T>(f, null, element);

        last = newNode;
        if (f == null) {
            first = newNode;
        } else {
            f.next = newNode;
        }
        size++;
    }

    /**
     * IS EMPTY
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * size
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 交换此下标相邻两个节点位置
     * @param index
     */
    public void swap(int index) {
        final Node<T> n = node(index);
        if (n != null) {
            Node<T> next = n.next;
            if (next == null) {
                // 末尾节点
                Node<T> pre = n.pre;
                if (pre != null) {
                    Node<T> pre1 = pre.pre;
                    if (pre1 == null) {
                        n.next = pre;
                        pre.pre = n;
                        n.pre = null;
                        pre.next = null;
                    } else {
                        pre1.next = n;
                        n.pre = pre1;
                        n.next = pre;
                        pre.next = null;
                    }
                    last = pre;
                }
            } else {
                Node<T> pre = n.pre;
                if (pre == null) {
                    n.next = next.next;
                    n.pre = next;
                    next.next = n;
                    next.pre = null;
                    first = next;
                } else {
                    n.next = next.next;
                    n.pre = next;
                    next.next = n;
                    next.pre = pre;
                    pre.next = next;
                }
            }
        }
    }

    /**
     *
     * @param index
     * @return
     */
    public Node<T> node(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        }

        Node<T> f = first;
        if (index > size >> 1) {
            f = last;
            for (int i = size; i > index; i--) {
                f = f.pre;
            }
        } else {
            for (int i = 1; i < index; i++) {
              f = f.next;
            }
        }
        return f;
    }
}
