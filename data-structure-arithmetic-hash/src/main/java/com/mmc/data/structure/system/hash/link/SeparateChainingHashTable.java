package com.mmc.data.structure.system.hash.link;

import com.mmc.data.structure.system.hash.utils.MathUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @packageName：com.mmc.data.structure.system.hash.link
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-09 11:20
 * @history: (version) author date desc
 */
public class SeparateChainingHashTable<AnyType> {

    /**
     * 默认大小取数数
     */
    private static final int DEFAULT_TABLE_SIZE = 101;

    /**
     * 存储元素集合
     */
    private List<AnyType>[] elements;

    /**
     * 存储元素大小
     */
    private int size;


    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * 初始化hash表
     * @param size
     */
    public SeparateChainingHashTable(int size) {
        this.elements = new LinkedList[size];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    /**
     * 插入元组
     * @param ele
     */
    public void insert(AnyType ele) {
        int hash = hashValue(ele);
        List<AnyType> link = elements[hash];
        if (link == null) {
            link = new LinkedList<>();
        }
        if (!link.contains(ele)) {
            link.add(ele);
            if (++size > elements.length) {
                rehash();
            }
        }
    }

    /**
     * 移除元组
     * @param ele
     */
    public void remove(AnyType ele) {
        int hash = hashValue(ele);
        List<AnyType> list = this.elements[hash];
        if (list.contains(ele)) {
            list.remove(ele);
            this.size--;
        }
    }

    /**
     * 存储元组大于数组长度时，再次hash分组
     */
    private void rehash() {
        // 原hash表数据
        List<AnyType>[] oldElements = this.elements;

        this.elements = new LinkedList[MathUtils.nextPrimeNumber(oldElements.length << 1)];
        int length = oldElements.length;
        for (int i = 0; i < length; i++) {
            List<AnyType> list = oldElements[i];
            for (AnyType t : list) {
                insert(t);
            }
        }
    }

    /**
     * 验证hash表中是否存在元组
     * @param ele
     * @return
     */
    public boolean contains(AnyType ele) {
        List<AnyType> linked = this.elements[hashValue(ele)];
        return linked.contains(ele);
    }


    /**
     * 置空hash表
     */
    public void makeEmpty() {
        for (int i = 0; i < elements.length; i++) {
            this.elements[i].clear();
        }
        this.size = 0;
    }




    /**
     * 计算hash值
     * @param ele
     * @return
     */
    public int hashValue(AnyType ele) {
        int hashVal = ele.hashCode();
        // 取模获取hash算法得到hash位置
        hashVal = hashVal % elements.length;

        if (hashVal < 0) {
            hashVal = elements.length - 1;
        }
        return hashVal;
    }

}
