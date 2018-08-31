package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption: 左式堆实现
 * @author: gaowei
 * @date： 2018-08-31 16:01
 * @history: (version) author date desc
 */
public class LeftistHeap<T extends Comparable<? super T>> {

    /**
     * 根节点
     */
    private Node<T> root;

    public LeftistHeap() {
        this.root = null;
    }



    /**
     * 节点
     * @param <T>
     */
    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        private int npl;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.npl = 0;
        }
    }
}
