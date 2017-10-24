package com.mmc.data.structure.tableStackQueue.system.javaApi;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.javaApi
 * 类 名: AutoLinkedList
 * 描 述:
 * 作 者: GW
 * 创 建： 2017-10-18 15:27
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedList<T> implements Iterable<T>{

    private int size;

    private int modCount;

    private Node<T> first;
    private Node<T> last;

    public AutoLinkedList() {
        clear();
    }

    /**
     * 插入元素，默认在最后一位之前插入元素
     * @param element
     */
    public void add(T element) {
        add(size(), element);
    }

    /**
     * 返回指定位置元素
     * @param index
     * @return
     */
    public T get(int index) {
        Node<T> node = getNode(index);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    /**
     * 是否包含
     * @param data
     * @return
     */
    public boolean contains(T data) {
        Node<T> current = first;
        while (current != null) {
            T ele = current.value;
            if (ele == data || ele.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * 指定位置插入元素
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index == size) {
            addAfter(element);
        } else {
            addBefore(getNode(index), element);
        }
    }

    public void addAfter(T element) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     *  指定位置插入元素
     * @param index
     * @param element
     */
    public T set(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = getNode(index);
        if (node != null) {
            T oldValue = node.value;
            node.value = element;
        }
        return null;
    }

    /**
     * 删除指定索引位置node
     * @param index
     */
    public void remove(int index) {
        remove(getNode(index));
    }

    /**
     * 删除指定位置node
     * @param node
     */
    public void remove(Node<T> node) {
        if (size != 0) {
            if (node != null) {
                Node<T> prev = node.prev;
                Node<T> next = node.next;
                prev.next = next;
                next.prev = prev;
            }
        }
    }

    /**
     * 查找指定位置元素
     * @param index
     * @return
     */
    public Node<T> getNode(int index) {
        Node<T> p;
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size() >> 1) {
            p = first;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = last;
            for (int i = size; i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    /**
     * 在一个节点之前插入节点
     * @param p
     * @param v
     */
    public void addBefore(Node<T> p, T v) {
        Node<T> newNode;
        if (p == null) {
            newNode = new Node<T>(null, v, p);
            first = newNode;
        } else {
            newNode = new Node<T>(p.prev, v, p);
            Node<T> nodePrev = p.prev;
            nodePrev.next = newNode;
        }

        newNode.next = p;
        size++;
        modCount++;
    }

    /**
     * isEmpty
     * @return
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * size
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * clear linkedlist
     */
    public void clear() {
        for (Node<T> temp = first; temp != null;) {
            Node<T> next = temp.next;
            temp.value = null;
            temp.prev = null;
            temp.next = null;
            temp = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    /**
     * Node
     * @param <T>
     */
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }


    public Iterator<T> iterator() {
        return new AutoLinkedListIterator();
    }

    private class AutoLinkedListIterator implements Iterator<T> {

        private Node<T> current = first;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return (current != last);
        }

        public T next() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T  nextItem = current.value;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalArgumentException();
            }
            AutoLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectModCount++;
        }
    }
}
