package com.mmc.data.structure.system.tree.binary;

/**
 * @packageName：com.mmc.data.structure.system.tree.binary
 * @desrciption: 二叉树结构
 * @author: gaowei
 * @date： 2017-10-31 15:44
 * @history: (version) author date desc
 */
public class BinaryTreeStructure {

    /**
     * 二叉树结构：
     *      每个节点至多存在两个节点。
     */

    /**
     * 二叉树结构
     * @param <T>
     */
    private static class BinaryTreeNode<T>{
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

