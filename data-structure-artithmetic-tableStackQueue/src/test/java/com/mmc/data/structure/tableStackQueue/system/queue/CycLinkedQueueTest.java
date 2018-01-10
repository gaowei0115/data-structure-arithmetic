package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-10 16:24
 * @history: (version) author date desc
 */
public class CycLinkedQueueTest {

    @Test
    public void test() {
        CycLinkedQueue<String> queue = new CycLinkedQueue<String>();
        queue.add("queue-01");
        queue.add("queue-02");
        queue.add("queue-03");
        queue.add("queue-04");
        queue.add("queue-05");

        System.out.println("链表队列：");
        System.out.print("[");
        while (!queue.isEmpty()) {
            System.out.print(queue.pollFirst());
            System.out.print("-->");
        }
        System.out.print("]");
    }
}
