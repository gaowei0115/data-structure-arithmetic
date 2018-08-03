package com.mmc.data.structure.system.tree.example;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @packageName：com.mmc.data.structure.system.tree.example
 * @desrciption:
 * @author: gaowei
 * @date： 2018-07-02 17:29
 * @history: (version) author date desc
 */
public class MinMaxNodeTreeMap <T extends Comparable<? super T>> {


    private BinaryNode<T> root;

    public MinMaxNodeTreeMap() {
        this.root = null;
    }

    private int modCount = 0;

    /**
     * Tree Node
     * @param <T>
     */
    private static class BinaryNode<T> {

        private T ele;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        private BinaryNode<T> pre;
        private BinaryNode<T> next;


        BinaryNode(T element) {
            this(element, null, null, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right, BinaryNode<T> pre, BinaryNode<T> next) {
            this.ele = element;
            this.left = left;
            this.right = right;
            this.pre = pre;
            this.next = next;
        }
    }


    /**
     * 删除节点
     * @param element
     */
    public void remove(T element) {
        remove(element, root);
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        if (element == null) {
            return null;
        }

        int resultFlag = element.compareTo(node.ele);
        if (resultFlag < 0) {
            node.left = remove(element, node.left);
        } else if (resultFlag > 0) {
            node.right = remove(element, node.right);
        } else if (node.left != null && node.right != null) {
            node.ele = findMin(node.right).ele;
            node = remove(node.ele, node.right);
        } else {
            modCount++;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.ele);
            printTree(node.right);
        }
    }

    /**
     * 插入节点
     * @param element
     */
    public void insert(T element) {
        root = insert(element, root, null, null);
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> node, BinaryNode<T> next, BinaryNode<T> pre) {
        if (node == null) {
            modCount++;
            BinaryNode<T> newNode = new BinaryNode<T>(element, null, null, next, pre);
            if (next != null) {
                next.pre = newNode;
            }
            if (pre != null) {
                pre.next = newNode;
            }
            return newNode;
        }

        if (element != null) {
            int resultFlag = element.compareTo(node.ele);
            if (resultFlag < 0) {
                node.left = insert(element, node.left, node, pre);
            } else if (resultFlag > 0) {
                node.right = insert(element, node.right, next, node);
            } else {
                ;
            }
        }
        return node;
    }


    /**
     * 查找最大节点
     * @return
     * @throws UnderflowException
     */
    public T findMax() throws UnderflowException{
        if (isEmpty()) {
            throw new UnderflowException();
        }

        BinaryNode<T> node = findMax(root);
        if (node == null) {
            return null;
        }
        return node.ele;
    }

    public BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        BinaryNode<T> rightNode = node.right;
        if (rightNode == null) {
            return node;
        } else {
            return findMax(rightNode);
        }
    }

    /**
     * 查找最小节点
     * @return
     * @throws UnderflowException
     */
    public T findMin() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        BinaryNode<T> node = findMin(root);
        if (node == null) {
            return null;
        }
        return node.ele;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if(node == null) {
            return null;
        }
        BinaryNode<T> leftNode = node.left;
        if (leftNode != null) {
            return findMin(leftNode);
        } else {
            return node;
        }
    }

    /**
     * 验证tree是否为空
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 是否包含
     * @param ele
     * @return
     */
    public boolean contains(T ele) {
        return contains(root, ele);
    }

    private boolean contains(BinaryNode<T> node, T ele) {
        if (node == null) {
            return false;
        }
        int resultFlag = ele.compareTo(node.ele);
        if (resultFlag < 0) {
            return contains(node.left, ele);
        } else if (resultFlag > 0) {
            return contains(node.right, ele);
        } else {
            return true;
        }
    }


    /**
     * 迭代器
     * @return
     */
    public Iterator<T> iterator() {
        return new MinMaxNodeTreeMapIterator();
    }

    /**
     * 迭代器
     */
    class MinMaxNodeTreeMapIterator implements Iterator<T> {

        private BinaryNode<T> current;
        private BinaryNode<T> pre;
        private int exceptedModCount = modCount;
        private boolean okToRemove = false;
        private boolean atEnd = false;

        public MinMaxNodeTreeMapIterator() {
            this.current = findMin(root);
        }

        @Override
        public boolean hasNext() {
            return !atEnd;
        }

        @Override
        public T next() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T ele = current.ele;
            pre = current;
            current = current.next;
            if (current == null) {
                atEnd = true;
            }
            okToRemove = true;
            return ele;
        }

        @Override
        public void remove() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalArgumentException();
            }

            MinMaxNodeTreeMap.this.remove(pre.ele);
            okToRemove = false;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }


}
