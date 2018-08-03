package com.mmc.data.structure.system.tree.example;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @packageName：com.mmc.data.structure.system.tree.example
 * @desrciption:
 * @author: gaowei
 * @date： 2018-05-23 11:22
 * @history: (version) author date desc
 */
public class MyTreeSet<T extends Comparable<? super T>> {

    /**
     *
     */
    private volatile int modcount;
    /**
     * 根节点
     */
    private BinaryNode<T> root;


    private static class BinaryNode<T> {
        /**
         * 元素
         */
        private T element;
        /**
         * 左节点
         */
        private BinaryNode<T> left;
        /**
         * 右节点
         */
        private BinaryNode<T> right;
        /**
         * 父节点
         */
        private BinaryNode<T> parent;

        public BinaryNode(T element) {
            this(element, null, null, null);
        }

        public BinaryNode(T element, BinaryNode<T> leftNode, BinaryNode<T> rightNode, BinaryNode<T> pt) {
            this.element = element;
            this.left = leftNode;
            this.right = rightNode;
            this.parent = pt;
        }
    }

    /**
     * 查找最小节点 -- 左节点
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            return null;
        } else {
            BinaryNode<T> node = findMin(root);
            if (node == null) {
                return null;
            } else {
                return node.element;
            }
        }
    }

    /**
     * 查找最大节点 -- 右节点
     * @return
     */
    public T findMax() {
        if (isEmpty()) {
            return null;
        } else {
            BinaryNode<T> max = findMax(root);
            if (max != null) {
                return max.element;
            }
        }
        return null;
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
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
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryNode<T> leftNode = node.left;
        if (leftNode == null) {
            return node;
        } else {
            return findMin(leftNode);
        }
    }

    /**
     * tree插入节点
     * @param data
     */
    public void insert(T data) {
        insert(data, root, null);
    }


    /**
     * 插入节点
     * @param data
     * @param node
     * @param parent
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> node, BinaryNode<T> parent) {
        if (node == null) {
            modcount++;
            return new BinaryNode<T>(data, null, null, parent);
        }
        int compResult = data.compareTo(node.element);
        if (compResult > 0) {
            node.right = insert(data, node.right, node);
        } else if (compResult < 0) {
            node.left = insert(data, node.left, node);
        } else {
            ;
        }
        return node;
    }

    /**
     * 移除元素
     * @param element
     */
     public void remove(T element) {
        root = remove(element, root);
    }


    private BinaryNode<T> remove(T element, BinaryNode<T> node) {
        if (node == null) {
            return node;
        }

        int compareResult = compareTo(element, node.element);
        if (compareResult < 0) {
           node.left = remove(element, node.left);
        } else if (compareResult > 0) {
            node.right = remove(element, node.right);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            modcount++;
            BinaryNode<T> tempNode = node.left;
            tempNode = (tempNode == null) ? node.right : null;
            if (tempNode == null) {
                // 不存子节点
                ;
            } else {
                // 存在子节点
                tempNode.parent = node.parent;
            }
            node = tempNode;
        }
        return node;
    }

    private int compareTo(T element, T expare) {
        if (element == null) {
            if (element == null) {
                return 0;
            } else {
                return -1;
            }
        }

        return element.compareTo(expare);
    }

    /**
     * 置空tree
     */
    public void makeEmpty() {
        modcount++;
        this.root = null;
    }

    /**
     * 中序遍历Tree
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("tree is empty");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * 是否包含
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return contains(element, root);
    }

    /**
     *
     * @param data
     * @param root
     * @return
     */
    private boolean contains(T data, BinaryNode<T> root) {
        if (isEmpty()) {
            return false;
        }

        T ele = root.element;
        int compResult = data.compareTo(ele);
        if (compResult > 0) {
            return contains(data, root.right);
        } else if (compResult < 0) {
            return contains(data, root.left);
        } else {
            return true;
        }
    }

    /**
     * 迭代器
     * @return
     */
    public Iterator<T> iterator() {
        return new MyTreeSetIterator();
    }

    /**
     * 自定义Tree迭代器
     */
    private class MyTreeSetIterator implements Iterator<T> {

        private BinaryNode<T> current;
        private int expectedModCount;
        private BinaryNode<T> previous;
        private boolean okToRemove = false;
        private boolean atEnd = false;


        public MyTreeSetIterator() {
            current = findMin(root);
            expectedModCount = modcount;
        }

        @Override
        public boolean hasNext() {
            return !atEnd;
        }

        @Override
        public T next() {
            if (modcount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T ele = current.element;
            previous = current;
            if (previous.right != null) {
                current = findMin(previous.right);
            } else {
                BinaryNode<T> child = current;
                current = current.parent;
                while (current != null && current.left != child) {
                    child = current;
                    current = current.parent;
                }
                if (current == null) {
                    atEnd = true;
                }
            }
            okToRemove = true;
            return ele;
        }

        @Override
        public void remove() {
            if (modcount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalArgumentException();
            }
            MyTreeSet.this.remove(previous.element);
            okToRemove = false;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }



}
