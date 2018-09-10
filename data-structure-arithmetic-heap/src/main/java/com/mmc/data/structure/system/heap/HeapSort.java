package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption: 堆排序
 * @author: gaowei
 * @date： 2018-09-10 14:00
 * @history: (version) author date desc
 */
public class HeapSort<T extends Comparable<? super T>> {


    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     * 堆存储数据结构
     */
    private Node<T>[] heapArrays;
    /**
     * 当前堆存放大小
     */
    private int currentSize;
    /**
     * 堆结构存储最大长度
     */
    private int maxSize;


    public HeapSort() {
        this(DEFAULT_SIZE);
    }

    public HeapSort(int size) {
        this.maxSize = size;
        this.currentSize = 0;
        this.heapArrays = new Node[maxSize];
    }

    /**
     * 存储元素
     * @param ele
     */
    public void add(T ele) {
        if (currentSize == maxSize) {
            /**
             * 扩容堆
             */
            enlarge(currentSize << 2 + 1);
        }
        Node<T> node = new Node<>(ele, "obj" + ele);
        int index = currentSize++;
        heapArrays[index] = node;

        /**
         * 上浮节点
         */
        tickleUp(index);
    }

    /**
     * 移除元素
     * @return
     */
    public T remove() {
        Node<T> removeNode = heapArrays[0];
        T ele = null;
        if (removeNode != null) {
            ele = removeNode.key;
        }
        int index = currentSize - 1;
        heapArrays[0] = heapArrays[index];
        heapArrays[--currentSize] = null;

        /**
         * 下浮节点
         */
        trickleDown(0);
        return ele;
    }

    /**
     * 下浮节点
     * @param index
     */
    public void trickleDown(int index) {
        Node<T> currentNode = heapArrays[index];

        int valueIndex;
        while (index < currentSize / 2) {
            valueIndex = index * 2 + 1;
            if ((valueIndex + 1) <= currentSize - 1 && heapArrays[valueIndex].key.compareTo(heapArrays[valueIndex + 1].key) < 0) {
                valueIndex += 1;
            }
            if (currentNode.key.compareTo(heapArrays[valueIndex].key) > 0) {
                break;
            }

            heapArrays[index] = heapArrays[valueIndex];
            index = valueIndex;
        }
        heapArrays[index] = currentNode;
    }

    /**
     * 向上浮动节点
     * @param index
     */
    private void tickleUp(int index) {
        if(index == 0) {
            return;
        }
        Node<T> currentNode = heapArrays[index];
        int parent = (index - 1) / 2;

        while (index > 0 && currentNode.key.compareTo(heapArrays[parent].key) > 0) {
            heapArrays[index] = heapArrays[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArrays[index] = currentNode;
    }


    /**
     * 扩容堆
     * @param size
     */
    private void enlarge(int size) {
        Node<T>[] newArrays = new Node[size];
        Node[] oldArrays = heapArrays;
        for (int i = 0; i < oldArrays.length; i++) {
            newArrays[i] = oldArrays[i];
        }
        oldArrays = null;
        heapArrays = newArrays;
    }

    /**
     * 指定位置添加元素
     * @param index
     * @param ele
     */
    public void addHeap(int index, T ele) {
        if (currentSize == maxSize) {
            enlarge(currentSize << 2 + 1);
        }
        heapArrays[index] = new Node<>(ele, "obj" + ele);
    }

    /**
     * 增加堆长度
     */
    public void incrementSize() {
        currentSize++;
    }

    /**
     * 打印堆数组信息
     */
    public void dispayArrays() {
        System.out.print("[");
        for (int i = 0; i < heapArrays.length; i++) {
            System.out.print(heapArrays[i].key);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 打印堆
     */
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArrays[i] != null) {
                System.out.print(heapArrays[i].key + " ");
            } else {
                System.out.print("--");
            }
        }

        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".................................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int i = 0; i < nBlanks; i++) {
                    System.out.print(" ");
                }
            }
            System.out.print(heapArrays[j].key);
            if (++j == currentSize) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlanks = nBlanks / 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }


    /**
     * 堆数据结构节点
     * @param <T>
     */
    private static class Node<T>{
        private T key;
        private String value;


        public Node(T key, String value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
