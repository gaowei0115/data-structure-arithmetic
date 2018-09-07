package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-05 11:28
 * @history: (version) author date desc
 */
public class MockHeap<T extends Comparable<? super T>> {

    /**
     * 数组实现堆数据存储结构
     */
    private T[] arrays;

    /**
     * 默认堆结构大小
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 当前大小
     */
    private int currentSize;

    public MockHeap() {
        this(DEFAULT_SIZE);
    }

    public MockHeap(int size) {
        arrays = (T[]) new Comparable[size];
        currentSize = 0;
    }

    /**
     * 添加元素
     * @param ele
     */
    public void add(T ele) {
        if (currentSize >= arrays.length) {
            enlarge(arrays.length * 2 + 1);
        }
        int sign = currentSize++;
        arrays[sign] = ele;
        // 上浮节点
        goUp(sign);
    }

    /**
     * 移除节点
     * 删除根节点元素（堆最大最小节点）
     * @return
     */
    public T remove() {
        /**
         * 取根节点元素，删除
         */
        T ele = arrays[0];

        int index = --currentSize;
        /**
         * 尾部节点转移赋值根节点位置
         */
        T rootEle = arrays[index];
        arrays[0] = rootEle;
        arrays[index] = null;
        /**
         * 从根节点位置下浮查找最大节点值
         */
        goDown(0);

        return ele;
    }

    /**
     * 改变节点
     * @param index
     * @param newEle
     * @return
     */
    public boolean change(int index, T newEle) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        T oldEle = arrays[index];
        arrays[index] = newEle;
        if (newEle.compareTo(oldEle) > 0) {
            goUp(index);
        } else {
            goDown(index);
        }
        return true;
    }

    /**
     * 下浮节点
     * @param i
     */
    private void goDown(int i) {
        T ele = arrays[i];
        int index = i;
        if (currentSize == 1) {
            return;
        }
        int leftIndex = 0;
        int rigthIndex = 0;
        int largerIndex = 0;
        while (index < currentSize / 2) {
            leftIndex = index * 2 + 1;
            rigthIndex = leftIndex + 1;
            if (rigthIndex < currentSize && arrays[leftIndex].compareTo(arrays[rigthIndex]) < 0) {
                largerIndex = rigthIndex;
            } else {
                largerIndex = leftIndex;
            }
            if (ele.compareTo(arrays[index]) > 0) {
                break;
            }
            arrays[index] = arrays[largerIndex];
            index = largerIndex;
        }
        arrays[index] = ele;
    }

    /**
     * 上浮节点
     * @param sign
     */
    private void goUp(int sign) {
        if (sign == 0) {
            return;
        }

        T ele = arrays[sign];
        // 父节点
        int half = (sign-1) / 2;
        while (sign > 0 && ele.compareTo(arrays[half]) > 0) {
            arrays[sign] = arrays[half];
            sign = half;
            half = (half-1) / 2;
        }
        arrays[sign] = ele;
    }

    /**
     * 扩容
     * @param size
     */
    private void enlarge(int size) {
        T[] newArrays = (T[]) new Comparable[size];
        T[] oldArrays = arrays;
        for (int i = 0; i < oldArrays.length; i++) {
            newArrays[i] = oldArrays[i];
        }
        oldArrays = null;
        arrays = newArrays;
    }

    /**
     * 是否为空堆
     * @return
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * 打印堆
     */
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if (arrays[i] != null) {
                System.out.print(arrays[i] + " ");
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
            System.out.print(arrays[j]);
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

}
