package com.mmc.data.structure.tableStackQueue.system.stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 复制栈
 *                  基于链表实现栈
 * @author: gaowei
 * @date： 2018-01-15 17:36
 * @history: (version) author date desc
 */
public class CopyStack<T extends Comparable<T>> {

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

    public CopyStack() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     *
     * @param copyStack
     */
    public CopyStack(CopyStack<T> copyStack) {
        CopyStack<T> newCopy = new CopyStack<T>();
        while (!copyStack.isEmpty()) {
            newCopy.push(copyStack.poll());
        }
        this.first = null;
        this.last = null;
        this.size = 0;
        T data = null;
        while (!newCopy.isEmpty()) {
            data = newCopy.poll();
            this.push(data);
            copyStack.push(data);
        }
    }

    /**
     * 压栈操作
     * @param data
     */
    public void push(T data) {
        final Node<T> node = new Node<T>(data, null, null);
        addFirst(node);
    }

    /**
     *
     * @return
     */
    public T poll() {
        Node<T> node = pollFirstNode();
        if (node != null) {
            T data = node.data;
            node = null;
            return data;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public Node<T> pollFirstNode() {
        Node<T> f = first;
        if (f != null) {
            first = f.next;
            this.size--;
        }
        return f;
    }

    /**
     *
     * @param node
     */
    public void addFirst(final Node<T> node) {
        Node<T> f = first;
        first = node;
        if (f == null) {
            last = node;
        } else {
            node.next = f;
            f.pre = node;
        }
        this.size++;
    }

    private class Node<T>{
        private T data;
        private Node<T> pre;
        private Node<T> next;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }
}
