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
     *
     * @return
     */
    public T pollFirst() {
        final Node<T> f = first;
        if (f != null) {
            T data = f.data;
            first = first.next;
            size--;
            return data;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T pollLast() {
        final Node<T> l = last;
        if (l != null) {
            T data = l.data;
            last = last.pre;
            size--;
            return data;
        }
        return null;
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
        // 目标交换节点
        final Node<T> targetNode = node(index);
        if (targetNode != null) {
            if (targetNode.next == null) {
                // 尾部节点 -- 向前交换
                Node<T> pre = targetNode.pre;
                if (pre != null) {
                    Node<T> prep = pre.pre;
                    if (prep == null) {
                        pre.next = null;
                        pre.pre = targetNode;
                        targetNode.next = pre;
                        targetNode.pre = null;
                    } else {
                        pre.next = null;
                        pre.pre = targetNode;
                        targetNode.next = pre;
                        targetNode.pre = prep;
                        prep.next = targetNode;
                    }
                    last = pre;
                }
            } else if (targetNode.pre == null) {
                // 头部节点
                Node<T> next = targetNode.next;
                if (next != null) {
                    Node<T> nextn = next.next;
                    if (nextn == null) {
                        targetNode.next = null;
                        targetNode.pre = next;
                        next.next = targetNode;
                        next.pre = null;
                    } else {
                        targetNode.next = nextn;
                        targetNode.pre = next;
                        nextn.pre = targetNode;
                        next.next = targetNode;
                        next.pre = null;
                    }
                    first = next;
                }
            } else {
                // 中间节点 -- 后续
                Node<T> next = targetNode.next;
                Node<T> pre = targetNode.pre;
                targetNode.next = next.next;
                targetNode.pre = next;
                next.next = targetNode;
                next.pre = pre;
                pre.next = next;
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
