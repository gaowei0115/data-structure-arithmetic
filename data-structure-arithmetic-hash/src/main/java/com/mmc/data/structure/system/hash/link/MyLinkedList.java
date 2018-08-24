package com.mmc.data.structure.system.hash.link;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-06 16:47
 * @history: (version) author date desc
 */
public class MyLinkedList<T extends Key> {

    private Node<T> first;
    private int size;

    private static class Node<T>{
        private T element;
        private Node<T> pre;
        private Node<T> next;

        Node(T ele, Node<T> preN, Node<T> nextN) {
            this.element = ele;
            this.pre = preN;
            this.next = nextN;
        }
    }

    public MyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insert(T ele) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(ele, null, f);
        first = newNode;
        if (f != null) {
            f.pre = newNode;
        }
        size++;
    }

    public T get(Object data) {
        Node<T> current = first;
        while (current != null) {
            if (data.equals(current.element.getKey())) {
                break;
            }
            current = current.next;
        }
        return current.element;
    }

    public T delete(Object data) {
        Node<T> current = first;
        while (current != null) {
            if (data.equals(current.element.getKey())) {
                break;
            }
            current = current.next;
        }
        T ele = current.element;
        Node<T> pre = current.pre;
        Node<T> next = current.next;
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            current.pre = null;
        }
        if (next != null) {
            next.pre = pre;
            current.next = null;
        }
        size--;
        return ele;
    }
}
