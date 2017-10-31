package com.mmc.data.structure.system.tree;

/**
 * @packageName：com.mmc.data.structure.system.tree
 * @desrciption: 树结构定义
 * @author: gaowei
 * @date： 2017-10-31 14:28
 * @history: (version) author date desc
 */
public class TreeStructure{

    /**
     * 定义树节点
     * @param <T>
     */
    private static class TreeNode<T>{
        private T data;
        private TreeNode firstChild;
        private TreeNode<T> nextSibling;

        public TreeNode(T data_i, TreeNode<T> firstChild_i, TreeNode<T> nextSibling_i) {
            this.data = data_i;
            this.firstChild = firstChild_i;
            this.nextSibling = nextSibling_i;
        }
    }
}
