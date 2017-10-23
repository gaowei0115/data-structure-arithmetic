package com.mmc.data.structure.tableStackQueue.system.linked;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.linked
 * 类 名: SingleLinkedList
 * 描 述: 单链表实现
 * 作 者: GW
 * 创 建： 2017-10-23 15:59
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class SingleLinkedList<T> {

    /**
     * 单向链表
     *
     */

    private int size;
    private Node<T> first;

    /**
     * 链表节点
     * @param <T>
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 弹出元素
     * @return
     */
    public T poll() {
        final Node<T> f = first;
        T data = null;
        if (f != null) {
            first = f.next;
            f.next = null;
            data = f.data;
            f.data = null;
            size--;
        }

        return data;
    }

    /**
     * 交换两个相邻元素
     * @param index
     */
    public void swap(int index) {
        Node<T> n = node(index);
        if (n == null) {
            System.out.println("交换异常，中止");
            return;
        }
        Node<T> next = n.next;
        if (next == null) {
            System.out.println("尾部元素，向前交换");
            Node<T> n1 =  node(index - 1);
            if (n1 != null) {
                // 查找n1的前一个元素
                Node<T> n2 = node(index - 2);
                if (n2 == null) {
                    n1.next = n.next;
                    n.next = n1;
                } else {
                    n2.next = n;
                    n1.next = n.next;
                    n.next = n1;
                }

            } else {
                System.out.println("交互参数不够，交换失败");
            }
        } else {
           Node<T> pre = node(index - 1);
           if (pre == null) {
               n.next = next.next;
               next.next = n;
           } else {
               pre.next = next;
               n.next = next.next;
               next.next = n;
           }
        }
    }

    /**
     * 获取对应节点
     * @param index
     * @return
     */
    public Node<T> node(int index) {
        if (size < index || index < 0) {
            throw new IllegalArgumentException();
        }
        Node<T> current = first;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * 添加元素
     * @param element
     */
    public void push(T element) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<T>(element, f);
        first = newNode;
        if (f != null) {
            first.next = f;
        }
        size++;
    }

    public int size() {
        return size;
    }

    /**
     * is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
