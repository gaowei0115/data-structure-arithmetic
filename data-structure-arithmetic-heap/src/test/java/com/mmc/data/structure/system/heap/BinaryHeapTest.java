package com.mmc.data.structure.system.heap;

/**
 * @packageName：com.mmc.data.structure.system.heap
 * @desrciption:
 * @author: gaowei
 * @date： 2018-08-30 15:06
 * @history: (version) author date desc
 */
public class BinaryHeapTest {

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.insert(50);
        heap.insert(23);
        heap.insert(12);
        heap.insert(48);
        heap.insert(36);
        heap.insert(8);
        heap.insert(19);

        heap.printHeap();

        // 删除最小节点
        heap.deleteMin();

        heap.printHeap();
    }
}
