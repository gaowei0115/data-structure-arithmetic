package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption: 降序堆
 * @author: gaowei
 * @date： 2018-09-10 16:32
 * @history: (version) author date desc
 */
public class DownHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_SIZE = 10;

    private HeapNode<T>[] heapArrays;
    private int currentSize;
    private int maxSize;

    public DownHeap() {
        this(DEFAULT_SIZE);
    }

    public DownHeap(int size) {
        this.currentSize = 0;
        this.maxSize = size;
        heapArrays = new HeapNode[maxSize];
    }

    /**
     * 添加元素
     * @param ele
     * @return
     */
    public boolean add(T ele) {
        if (currentSize == maxSize) {
            return false;
        }
        heapArrays[currentSize++] = new HeapNode<>(ele);

        floatUp(currentSize - 1);
        return true;
    }

    /**
     * 删除元素
     * @return
     */
    public T remove() {
        if (currentSize == 0) {
            return null;
        }
        HeapNode<T> ele = heapArrays[0];
        int index = currentSize - 1;
        heapArrays[0] = heapArrays[index];
        heapArrays[index] = null;
        currentSize--;

        /**
         * 下浮
         */
        floatDown(0);
        return ele.iData;
    }

    /**
     * 下浮节点
     * @param index
     */
    private void floatDown(int index) {
        HeapNode<T> currentNode = heapArrays[index];
        int valueIndex = index * 2 + 1;
        while (index < currentSize / 2) {
            if ((valueIndex + 1 < currentSize) && heapArrays[valueIndex].iData.compareTo(heapArrays[valueIndex + 1].iData) > 0) {
                valueIndex += 1;
            }

            if (currentNode.iData.compareTo(heapArrays[valueIndex].iData) < 0) {
                break;
            }
            heapArrays[index] = heapArrays[valueIndex];
            index = valueIndex;
            valueIndex = valueIndex * 2 + 1;
        }
        heapArrays[index] = currentNode;
    }

    /**
     * 上浮
     * @param index
     */
    private void floatUp(int index) {
        if (index == 0) {
            return;
        }

        HeapNode<T> currentNode = heapArrays[index];
        while (index > 0 && currentNode.iData.compareTo(heapArrays[index / 2].iData) < 0) {
            heapArrays[index] = heapArrays[index / 2];
            index = index / 2;
        }
        heapArrays[index] = currentNode;
    }

    public void displayHeap() {
        HeapUtils.displayHeap(heapArrays);
    }

    /**
     * 堆节点
     * @param <T>
     */
    private static class HeapNode<T> {
        private T iData;

        public HeapNode(T iData) {
            this.iData = iData;
        }

        @Override
        public String toString() {
            return iData + "";
        }

        public T getiData() {
            return iData;
        }

        public void setiData(T iData) {
            this.iData = iData;
        }
    }
}
