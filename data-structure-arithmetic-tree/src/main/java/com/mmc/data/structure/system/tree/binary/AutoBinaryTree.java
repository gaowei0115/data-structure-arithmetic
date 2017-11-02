package com.mmc.data.structure.system.tree.binary;

import java.util.Comparator;

/**
 * @packageName：com.mmc.data.structure.system.tree.binary
 * @desrciption: 自定义二叉查找树结构
 * @author: gaowei
 * @date： 2017-10-31 16:48
 * @history: (version) author date desc
 */
public class AutoBinaryTree<T extends Comparable> implements TreeAction<T> {

    /**
     * 根节点
     */
    private BinaryTreeNode<T> root;
    private Comparator<? super T> cm;


    /**
     *
     */
    public AutoBinaryTree() {
        this(null);
    }

    /**
     *
     * @param cm_i
     */
    public AutoBinaryTree(Comparator<? super T> cm_i) {
        this.root = null;
        this.cm = cm_i;
    }



    @Override
    public void makeEmpty() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public boolean isContains(T element) {
        return contains(element, root);
    }

    @Override
    public T findMin() {
        final BinaryTreeNode<T> node = findMin(root);
        if (node == null) {
            return null;
        }
        return node.data;
    }

    @Override
    public T findMax() {
        final BinaryTreeNode<T> node = findMax(root);
        if (node == null) {
            return null;
        }
        return node.data;
    }

    @Override
    public void insert(T element) {
        insertNode(element, root);
    }

    @Override
    public void remove(T element) {
        removeNode(element, root);
    }

    /**
     *
     * @param element
     * @param node
     * @return
     */
    private BinaryTreeNode<T> removeNode(T element, BinaryTreeNode<T> node) {
        if (node == null) {
            return node;
        }
        int compareResult = element.compareTo(node.data);
        if (compareResult > 0) {
            node.right = removeNode(element, node.right);
        } else  if (compareResult < 0) {
            node.left = removeNode(element, node.left);
        } else if (node.left != null && node.right != null) {
            // 存在两个子节点 - 删除
            node.data = findMin(node.right).data;
            node.right = removeNode(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    /**
     * 递归插入节点
     * @param element
     * @param node
     * @return
     */
    private BinaryTreeNode<T> insertNode(T element, BinaryTreeNode<T> node) {
        if (node == null) {
            return new BinaryTreeNode<T>(element, null, null);
        }
        int compareResult = element.compareTo(node.data);
        if (compareResult > 0) {
            node.right = insertNode(element, node.right);
        } else if (compareResult < 0) {
            node.left = insertNode(element, node.left);
        }
        return node;
    }


    /**
     * 查找最小节点
     * @param node
     * @return
     */
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    /**
     * 查找最大节点
     * @param node
     * @return
     */
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }

    /**
     * 通过递归遍历验证是否包含节点
     * @param element
     * @param node
     * @return
     */
    private boolean contains(T element, BinaryTreeNode<T> node) {
        if (node == null) {
            return false;
        }
        int isCompare = autoCompare(element, node.data);
        if (isCompare > 0) {
            // 大于此节点从右节点遍历
            return contains(element, node.right);
        } else if (isCompare < 0) {
            // 小于此节点从左节点开始遍历
            return contains(element, node.left);
        } else {
            return true;
        }
    }

    private int autoCompare(T t1, T t2) {
        if (cm == null) {
            return t1.compareTo(t2);
        } else {
            return cm.compare(t1, t2);
        }
    }


    /**
     * 二叉树节点定义
     * @param <T>
     */
    private static class BinaryTreeNode<T> {
        private T data;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;

        public BinaryTreeNode(T data_i, BinaryTreeNode<T> left_i, BinaryTreeNode<T> right_i) {
            this.data = data_i;
            this.left = left_i;
            this.right = right_i;
        }
    }
}
