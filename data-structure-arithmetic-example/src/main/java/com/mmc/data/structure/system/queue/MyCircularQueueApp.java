package com.mmc.data.structure.system.queue;

/**
 * @packageName：com.mmc.data.structure.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-10-24 11:11
 * @history: (version) author date desc
 */
public class MyCircularQueueApp {

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
//        for (int i = 0; i < 11; i++) {
//            boolean re = queue.enQueue(i + 1);
//            if (i == 9) {
//                System.out.println("front " + queue.Front() + " rear " + queue.Rear());
//                queue.deQueue();
//            }
//            System.out.println(i + " enqueue: " + re);
//        }
//
//        for (int i = 0; i < 12; i++) {
//            boolean re = queue.deQueue();
//            System.out.println(i + " dequeue: " + re);
//        }

        /**
         * ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
         [[3],[1],[2],[3],[4],[],[],[],[4],[]]
         */

        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}
