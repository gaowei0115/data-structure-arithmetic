package com.mmc.data.structure.system.tree.example;

/**
 * @packageName：com.mmc.data.structure.system.tree.example
 * @desrciption:
 * @author: gaowei
 * @date： 2018-07-05 11:16
 * @history: (version) author date desc
 */
public class LazyDeleteBinaryTree<T extends Comparable<? super T>> {

    private LazyTreeNode<T> root;
    private int size;
    private int delSize;

    public LazyDeleteBinaryTree() {
        this.size = 0;
        this.delSize = 0;
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
        this.size = 0;
        this.delSize = 0;
    }

    /**
     *
     */
    public boolean isEmpty() {
        if (size == delSize) {
            return true;
        }
        return false;
    }

    /**
     * 删除节点
     * @param element
     */
    public void remove(T element) {
        remove(element, root);
    }

    private LazyTreeNode<T> remove(T element, LazyTreeNode<T> node) {
        if (node == null) {
            return null;
        }

        int resultFlag = element.compareTo(node.element);
        if (resultFlag > 0) {
            node.right = remove(element, node.right);
        } else if (resultFlag < 0) {
            node.left = remove(element, node.left);
        } else {
            node.isDelete = true;
            this.delSize++;
            this.size--;
            if (delSize >= size) {
                if (node.right != null && node.left != null) {
                    // 存在两个子节点
                    LazyTreeNode<T> tmep_node = findMin(node.right);
                    node.element = tmep_node.element;
                    node.right = remove(node.element, node.right);
                } else {
                    node = (node.left != null) ? node.left : node.right;
                    delSize--;
                }
            }
        }
        return node;
    }


    /**
     * 查找最大元素
     * @return
     */
    public T findMax() {
        LazyTreeNode<T> node = findMax(root);
        if (node == null ) {
            return null;
        }
        return node.element;
    }

    /**
     *
     * @return
     */
    private LazyTreeNode<T> findMax(LazyTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        LazyTreeNode<T> right = node.right;
        if (right == null) {
            return node;
        } else {
            return findMax(node);
        }
    }

    /**
     * 查找最小节点
     * @return
     */
    public T findMin() {
        LazyTreeNode<T> treeNode = findMin(root);
        if (treeNode == null) {
            return null;
        }
        return treeNode.element;
    }

    private LazyTreeNode<T> findMin(LazyTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        LazyTreeNode<T> left = node.left;
        if (left == null) {
            return node;
        } else {
            return findMin(left);
        }
    }

    /**
     * 保存节点
     * @param element
     */
    public void insert(T element) {
        size++;
        root = insert(element, root);
    }

    /**
     * 保存节点
     * @param element
     * @param node
     * @return
     */
    private LazyTreeNode insert(T element, LazyTreeNode<T> node) {
        if (node == null) {
            return new LazyTreeNode(element);
        }
        int resultFlag = element.compareTo(node.element);
        if (resultFlag > 0) {
            node = insert(element, node.right);
        } else if (resultFlag < 0) {
            node = insert(element, node.left);
        } else {
            ;
        }
        return node;
    }

    /**
     * treenode
     * @param <T>
     */
    private static class LazyTreeNode<T> {

        private LazyTreeNode<T> left;
        private LazyTreeNode<T> right;
        private boolean isDelete;

        private T element;

        public LazyTreeNode(T element) {
            this(element, null, null);
        }

        public LazyTreeNode(T element, LazyTreeNode<T> leftNode, LazyTreeNode<T> rightNode) {
            this.element = element;
            this.left = leftNode;
            this.right = rightNode;
        }

        public void setDelete(boolean delete) {
            isDelete = delete;
        }
    }
}
