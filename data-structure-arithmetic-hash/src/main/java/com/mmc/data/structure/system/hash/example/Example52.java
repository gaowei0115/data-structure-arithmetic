package com.mmc.data.structure.system.hash.example;

import com.mmc.data.structure.system.hash.utils.MathUtils;

/**
 * @packageName：com.mmc.data.structure.system.hash.example
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-14 15:55
 * @history: (version) author date desc
 */
public class Example52 {


    public static void main(String[] args) {
        LinerHashTable<Integer> linerHashTable = new LinerHashTable<>();
        linerHashTable.insert(22);
        linerHashTable.insert(12);
        linerHashTable.insert(30);
        linerHashTable.insert(26);
        linerHashTable.insert(33);
        linerHashTable.insert(44);
        linerHashTable.insert(23);

        System.out.println(linerHashTable.conflictCount());

        System.out.println("----------------------------------------");
        LinerSqrHashTable<Integer> linerSqrHashTable = new LinerSqrHashTable<>();
        linerSqrHashTable.insert(22);
        linerSqrHashTable.insert(12);
        linerSqrHashTable.insert(30);
        linerSqrHashTable.insert(26);
        linerSqrHashTable.insert(33);
        linerSqrHashTable.insert(44);
        linerSqrHashTable.insert(23);

        System.out.println(linerSqrHashTable.conflictCount);

    }

    static class LinerSqrHashTable<T> {

        private static final int DEFAULT_SIZE = 11;
        private int currentSize;
        private HashEntity<T>[] elements;
        private int conflictCount;

        /**
         * 承载因子
         */
        private static final double LOAD_FACTOR = 0.7;

        public LinerSqrHashTable() {
            this(DEFAULT_SIZE);
        }

        public LinerSqrHashTable(int size) {
            currentSize = 0;
            elements = new HashEntity[size];
        }

        /**
         * 保存节点
         * @param ele
         */
        public void insert(T ele) {
            int hashValue = findPos(ele);
            if (isActive(hashValue)) {
                return;
            }
            elements[hashValue] = new HashEntity<T>(ele);
            if (++currentSize > elements.length * LOAD_FACTOR) {
                rehash();
            }
        }

        public void remove(T ele) {
            int hashValue = findPos(ele);
            if (isActive(hashValue)) {
                elements[hashValue].isActity = false;
            }
        }

        public boolean contain(T ele) {
            int hashValue = findPos(ele);
            return isActive(hashValue);
        }

        /**
         * 重新hash分配
         */
        private void rehash() {
            HashEntity<T>[] oldElements = elements;
            HashEntity<T>[] newElements = new HashEntity[MathUtils.nextPrimeNumber(elements.length) * 3];

            int length = oldElements.length;
            HashEntity<T> entity;
            for (int i = 0; i < length; i++) {
                entity = oldElements[i];
                if (entity != null && entity.isActity) {
                    newElements[findPos(entity.ele)] = entity;
                    currentSize++;
                }
            }
            this.elements = newElements;
        }

        /**
         * 是否为活动节点
         * @param pos
         * @return
         */
        private boolean isActive(int pos) {
            HashEntity<T> entity = elements[pos];
            return entity != null && entity.isActity;
        }

        /**
         * 查找hash表下标位置
         * @param key
         * @return
         */
        private int findPos(T key) {
            int hashVal = hashValue(key);
            int hash = hashVal;
            int k = 1;
            while (elements[hash] != null && elements[hash].isActity) {
                hash = hashVal;
                if (key.equals(elements[hash])) {
                    break;
                }
                hash += k * k;

                if (hash > elements.length) {
                    hash = hash - elements.length;
                }
            }
            return hash;
        }

        public int conflictCount() {
            return conflictCount;
        }

        /**
         * 求hash值
         * @param key
         * @return
         */
        public int hashValue(T key) {
            int hashCode = key.hashCode();
            int hashValue = hashCode % elements.length;
            if (hashValue < 0) {
                hashValue = elements.length - 1;
            }
            return hashValue;
        }


        /**
         * hash表存储节点
         * @param <T>
         */
        private class HashEntity<T> {
            private T ele;
            private boolean isActity;

            HashEntity(T ele) {
                this(ele, true);
            }

            HashEntity(T ele, boolean isActity) {
                this.ele = ele;
                this.isActity = isActity;
            }
        }
    }

    static class LinerHashTable<T> {

        private static final int DEFAULT_SIZE = 11;
        private int currentSize;
        private HashEntity<T>[] elements;
        private int conflictCount;

        /**
         * 承载因子
         */
        private static final double LOAD_FACTOR = 0.7;

        public LinerHashTable() {
            this(DEFAULT_SIZE);
        }

        public LinerHashTable(int size) {
            currentSize = 0;
            elements = new HashEntity[size];
        }

        /**
         * 保存节点
         * @param ele
         */
        public void insert(T ele) {
            int hashValue = findPos(ele);
            if (isActive(hashValue)) {
                return;
            }
            elements[hashValue] = new HashEntity<T>(ele);
            if (++currentSize > elements.length * LOAD_FACTOR) {
                rehash();
            }
        }

        public void remove(T ele) {
            int hashValue = findPos(ele);
            if (isActive(hashValue)) {
                elements[hashValue].isActity = false;
            }
        }

        public boolean contain(T ele) {
            int hashValue = findPos(ele);
            return isActive(hashValue);
        }

        /**
         * 重新hash分配
         */
        private void rehash() {
            HashEntity<T>[] oldElements = elements;
            HashEntity<T>[] newElements = new HashEntity[MathUtils.nextPrimeNumber(elements.length) * 3];

            int length = oldElements.length;
            HashEntity<T> entity;
            for (int i = 0; i < length; i++) {
                entity = oldElements[i];
                if (entity != null && entity.isActity) {
                    newElements[findPos(entity.ele)] = entity;
                    currentSize++;
                }
            }
            this.elements = newElements;
        }

        /**
         * 是否为活动节点
         * @param pos
         * @return
         */
        private boolean isActive(int pos) {
            HashEntity<T> entity = elements[pos];
            return entity != null && entity.isActity;
        }

        /**
         * 查找hash表下标位置
         * @param key
         * @return
         */
        private int findPos(T key) {
            int hashValue = hashValue(key);
            HashEntity<T> entity = elements[hashValue];
            while (entity != null && entity.ele != null) {
                if (entity.ele.equals(key)) {
                    break;
                }
                hashValue = hashFun(hashValue);
                entity = elements[hashValue];
                conflictCount++;
            }
            return hashValue;
        }

        public int conflictCount() {
            return conflictCount;
        }

        private int hashFun(int value) {
            if (++value > elements.length) {
                value = value - elements.length;
            }
            return value;
        }

        public int hashValue(T key) {
            int hashCode = key.hashCode();
            int hashValue = hashCode % elements.length;
            if (hashValue < 0) {
                hashValue = elements.length - 1;
            }
            return hashValue;
        }


        /**
         * hash表存储节点
         * @param <T>
         */
        private class HashEntity<T> {
            private T ele;
            private boolean isActity;

            HashEntity(T ele) {
                this(ele, true);
            }

            HashEntity(T ele, boolean isActity) {
                this.ele = ele;
                this.isActity = isActity;
            }
        }
    }
}
