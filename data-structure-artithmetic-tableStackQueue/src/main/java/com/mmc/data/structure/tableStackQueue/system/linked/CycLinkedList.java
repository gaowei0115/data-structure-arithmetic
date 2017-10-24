package com.mmc.data.structure.tableStackQueue.system.linked;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.linked
 * 类 名: CycLinkedList
 * 描 述: 环装链表
 * 作 者: GW
 * 创 建： 2017-10-24 17:16
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class CycLinkedList<T> {


    private Node<T> first;
    private Node<T> last;
    private int size;


    public CycLinkedList() {
        this.size = 0;
        this.first = this.last = null;
    }

    /**
     * 节点定义
     * @param <T>
     */
    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     *
     * @param m
     */
    public void play(int k, int m) {
        System.out.println("打印原始数据：");
        Node<T> current = first;
        System.out.print("[");
        do {
            System.out.print(current.data);
            System.out.print(",");
            current = current.next;
        } while (current != first);
        System.out.print("]");

        System.out.println("start play.... ");
        Node<T> temp = first;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }

        while (this.size != 1) {
            // 开始查找
            for (int i = 1; i < m; i++) {
                temp = temp.next;
            }
            System.out.println("要清除的数据：" + temp.data);
            // 查找前一个节点
            Node<T> pre = temp;
            while (pre.next != temp) {
                pre = pre.next;
            }

            pre.next = temp.next;
            temp = temp.next;
            size--;
        }
        System.out.println("最后清除的数据：" + temp.data);
    }

    public T poll() {
        final Node<T> f = first;
        if (f != null) {
            T data = f.data;
            first = f.next;
            f.next = null;
            f.data = null;
            return data;
        }
        return null;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 添加元素
     * @param data
     */
    public void push(T data) {
        final Node<T> f = last;
        final Node<T> newNode = new Node<T>(data, f);
        last = newNode;
        if (f == null) {
            first = newNode;
        } else {
            f.next = newNode;
        }
        last.next = first;
        size++;
    }
}
