package com.mmc.data.structure.system.tree.binary;

/**
 * @packageName：com.mmc.data.structure.system.tree.binary
 * @desrciption: 二叉查找树
 * @author: gaowei
 * @date： 2018-03-01 15:41
 * @history: (version) author date desc
 */
public class BinaryTreeSearch<T extends Comparable<? super T>> {

    /**
     * 定义树节点
     */
    private static class BinaryTreeNode<T>{
        private T value;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;


        /**
         * Constructor
         * @param value
         */
        public BinaryTreeNode(T value) {
            this(value, null, null);
        }

        /**
         * Constructor
         * @param value
         * @param left
         * @param right
         */
        public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 树根节点
     */
    private BinaryTreeNode root;

    public BinaryTreeSearch() {
        root = null;
    }

    /**
     * 添加节点
     * @param value
     */
    public void insert(T value) {
        root = insert(value, root);
    }

    /**
     * 添加节点
     * @param value
     * @param node
     * @return
     */
    private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> node) {
        if (node == null) {
            return new BinaryTreeNode<T>(value);
        }
        T ele = node.value;
        if (ele.compareTo(value) > 0) {
            // 左变插入
            node.left = insert(value, node.left);
        } else if (ele.compareTo(value) < 0) {
            // 右边插入
            node.right = insert(value, node.right);
        }
        return node;
    }

    /**
     * 删除节点
     * @param value
     */
    public T remove(T value) {
        BinaryTreeNode<T> node = remove(value, root);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    /**
     * 删除某个节点
     * @param value
     * @param node
     * @return
     */
    private BinaryTreeNode<T> remove(T value, BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        T ele = node.value;
        if (ele.compareTo(value) > 0) {
            return remove(value, node.left);
        } else if (ele.compareTo(value) < 0) {
            return remove(value, node.right);
        } else {
            // 找到节点
            if (node.left != null && node.right != null) {
                // 要删除节点存在两个子节点
                // 查找右边节点的最小节点作为要的删除的节点
                node.value = findMin(node.right).value;
                node.right = remove(node.value, node.right);
            } else {
                if (node.left != null) {
                    node = node.left;
                } else if (node.right != null) {
                    node = node.right;
                } else {
                    node = null;
                }
            }
        }
        return node;
    }

    /**
     * 查找最大节点
     * @return
     */
    public T findMax() {
        BinaryTreeNode<T> max = findMax(root);
        if (max == null) {
            return null;
        } else {
            return max.value;
        }
    }


    /**
     * 查找最大节点，使用循环方式
     * @param node
     * @return
     */
    private BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> right = node.right;
        while (right != null) {
            node = right;
            right = node.right;
        }
        return node;
    }

    /**
     * 查找最小节点
     * @return
     */
    public T findMin() {
        BinaryTreeNode<T> node = findMin(root);
        if (node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    /**
     * 查找最小节点 使用递归方式
     * @param node
     * @return
     */
    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> left = node.left;
        if (left != null) {
            return findMin(left);
        } else {
            return node;
        }
    }


    /**
     * 保存某个节点
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return contains(element, root);
    }

    /**
     * 查找树某个节点是否存在
     * @param element
     * @param node
     * @return
     */
    private boolean contains(T element, BinaryTreeNode<T> node) {
        if (node == null) {
            return false;
        }
        T ele = node.value;
        if (ele.compareTo(element) > 0) {
            return contains(element, node.left);
        } else if (ele.compareTo(element) < 0) {
            return contains(element, node.right);
        } else {
            return true;
        }
    }


}
