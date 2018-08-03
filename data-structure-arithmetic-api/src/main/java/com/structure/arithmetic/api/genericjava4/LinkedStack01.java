package com.structure.arithmetic.api.genericjava4;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-08 16:48
 * @history: (version) author date desc
 */
public class LinkedStack01<T> {


    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T item = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack01<String> stringLinkedStack01 = new LinkedStack01<>();
        stringLinkedStack01.push("stack0101");
        stringLinkedStack01.push("stack0102");
        stringLinkedStack01.push("stack0103");
        stringLinkedStack01.push("stack0104");
        stringLinkedStack01.push("stack0105");

        String temp = null;
        while ((temp = stringLinkedStack01.pop()) != null) {
            System.out.println(temp);
        }
    }

    /**
     *
     */
    private class Node{

        T item;
        Node next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return (this.item == null && this.next == null);
        }
    }
}
