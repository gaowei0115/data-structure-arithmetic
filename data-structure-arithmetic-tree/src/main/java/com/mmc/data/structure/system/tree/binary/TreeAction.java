package com.mmc.data.structure.system.tree.binary;

/**
 * @packageName：com.mmc.data.structure.system.tree.binary
 * @desrciption: 树行为模板
 * @author: gaowei
 * @date： 2017-10-31 16:54
 * @history: (version) author date desc
 */
public interface TreeAction<T> {

    /**
     * 制空树存储
     */
    void makeEmpty();

    /**
     * 验证树是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含
     * @param element
     * @return
     */
    boolean isContains(T element);

    /**
     * 查找最小元素
     * @return
     */
    T findMin();

    /**
     * 查找最大元素
     * @return
     */
    T findMax();

    /**
     * 保存元素
     * @param element
     */
    void insert(T element);

    /**
     * 删除元素
     * @param element
     */
    void remove(T element);

}
