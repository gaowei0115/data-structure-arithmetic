package com.mmc.data.structure.system.tree.binary;

/**
 * @packageName：com.mmc.data.structure.system.tree.binary
 * @desrciption:
 * @author: gaowei
 * @date： 2018-05-18 14:53
 * @history: (version) author date desc
 */
public class AVLBinaryTree<T extends Comparable<? super T>> {


    /**
     * 根节点
     */
    private AVLTreeNode<T> root;

    /**
     * 平衡二叉树节点
     * @param <T>
     */
    private static class AVLTreeNode<T> {

        private AVLTreeNode<T> leftNode;
        private AVLTreeNode<T> rightNode;
        private T element;
        private int height;

        AVLTreeNode(T element) {
            this(null, null, element);
        }

        AVLTreeNode(AVLTreeNode<T> left, AVLTreeNode<T> right, T element) {
            this.leftNode = left;
            this.rightNode = right;
            this.element = element;
            this.height = 0;
        }

    }

    private int height(AVLTreeNode<T> node) {
        return node == null ? -1 : node.height;
    }

    /**
     * 插入树节点
     * @param element
     * @return
     */
    public AVLTreeNode<T> insert(T element) {
        return insertNode(element, root);
    }

    private AVLTreeNode<T> insertNode(T element, AVLTreeNode<T> node) {
        if (node == null) {
            return new AVLTreeNode(null, null, element);
        }

        int result = compareNode(element, node.element);
        if (result > 0) {
            // 右树添加节点
            node.rightNode = insertNode(element, node.rightNode);

            if (height(node.rightNode) - height(node.leftNode) == 2) {
                if (compareNode(element, node.rightNode.element) > 0) {
                    //
                }
            }
        }

        return null;
    }

    /**
     * 右侧单旋转
     * @param node
     * @return
     */
    private AVLTreeNode<T> rotateWithRightChild(AVLTreeNode<T> node) {
        AVLTreeNode<T> rootNode = node.rightNode;
        node.rightNode = rootNode.leftNode;
        rootNode.leftNode = node;

        rootNode.height = Math.max(height(rootNode.leftNode), height(rootNode.rightNode)) + 1;
        return node;
    }

    /**
     * 比较两个节点值
     * @param newNodeValue
     * @param rootValue
     * @return
     */
    private int compareNode(T newNodeValue, T rootValue) {
        if (rootValue == null || newNodeValue == null) {
            return 0;
        }
        return newNodeValue.compareTo(rootValue);
    }
}
