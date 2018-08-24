package com.mmc.data.structure.system.hash.open;

import com.mmc.data.structure.system.hash.utils.MathUtils;

/**
 * @packageName：com.mmc.data.structure.system.hash.open
 * @desrciption: 开发地址法解决hash表冲突
 * @author: gaowei
 * @date： 2018-08-10 15:20
 * @history: (version) author date desc
 */
public class QuadraticProbingHashTable<T> {

    /**
     * 默认hash表长度
     */
    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntity<T>[] elements;

    private int currentSize;

    /**
     * 节点实体
     * @param <T>
     */
    private static class HashEntity<T> {
        public T element;
        public boolean isActive;

        public HashEntity(T element) {
            this(element, true);
        }

        public HashEntity(T element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }

    }

    /**
     * 初始化
     */
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        this.elements = new HashEntity[size];
        makeEmpty();
        this.currentSize = 0;
    }

    /**
     * 插入元组
     * @param ele
     */
    public void insert(T ele) {
        int currentPos = findPos(ele);
        if (isActive(currentPos)) {
            return;
        }
        elements[currentPos] = new HashEntity<T>(ele);

        if (++currentSize > elements.length / 2) {
            rehash();
        }
    }

    /**
     * 删除节点
     * @param ele
     */
    public void remove(T ele) {
        int currentPos = findPos(ele);
        if (isActive(currentPos)) {
            elements[currentPos].isActive = false;
        }
    }

    /**
     * hash表数组大于长度的一半时，重新分配
     */
    private void rehash() {
        HashEntity<T>[] oldElements = elements;
        HashEntity<T>[] newElements = new HashEntity[MathUtils.nextPrimeNumber(oldElements.length << 1)];
        currentSize = 0;
        for (HashEntity<T> he : oldElements) {
            if (he != null && he.isActive) {
                newElements[hashValue(he.element)] = he;
                currentSize++;
            }
        }
        this.elements = newElements;
    }

    /**
     * 存在元素
     * @param ele
     * @return
     */
    public boolean contains(T ele) {
        int hashValue = findPos(ele);
        return isActive(hashValue);
    }


    /**
     * 是否活动节点
     * @param pos
     * @return
     */
    public boolean isActive(int pos) {
        return (elements[pos] != null && elements[pos].isActive);
    }

    /**
     * 采用函数探测方式查找位置
     * @param ele
     * @return
     */
    private int findPos(T ele) {
        int hashValue = hashValue(ele);
        HashEntity<T> currentEntity = this.elements[hashValue];
        int offset = 1;
        while (currentEntity != null && currentEntity.element != null) {
            if (currentEntity.element.equals(ele)) {
                break;
            }
            // 线性探测查找位置
            hashValue = hashValue + offset;
            offset += 2;
            if (hashValue >= elements.length) {
                hashValue -= elements.length;
            }
            currentEntity = elements[hashValue];
        }
        return hashValue;
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            this.elements[i] = null;
        }
    }

    /**
     * hash函数 计算hash位置
     * @param ele
     * @return
     */
    public int hashValue(T ele) {
        int hashValue = ele.hashCode();
        hashValue = hashValue % this.elements.length;
        if (hashValue < 0) {
            hashValue = this.elements.length - 1;
        }
        return hashValue;
    }

}
