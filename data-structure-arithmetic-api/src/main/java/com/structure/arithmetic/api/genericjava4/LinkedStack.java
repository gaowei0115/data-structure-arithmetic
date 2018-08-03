package com.structure.arithmetic.api.genericjava4;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-08 16:13
 * @history: (version) author date desc
 */
public class LinkedStack<T> {


    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("stack01");
        stack.push("stack02");
        stack.push("stack03");
        stack.push("stack04");

        String temp = null;
        while ((temp = stack.pop()) != null) {
            System.out.println(temp);
        }
    }

    /**
     * 节点定义
     * @param <U>
     */
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {
            this.item = null;
            this.next = null;
        }

        Node(U item, Node<U> node) {
            this.item = item;
            this.next = node;
        }

        /**
         *
         * @return
         */
        boolean end() {
            return (item == null && next == null);
        }
    }
}
