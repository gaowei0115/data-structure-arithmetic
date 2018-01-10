package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-10 17:30
 * @history: (version) author date desc
 */
public class RandomQueueTest {

    /**
     * 测试弹出删除元素
     */
    @Test
    public void testDequeue() {
        RandomQueue<String> removeQueue = new RandomQueue<String>();
        removeQueue.enqueue("remove-01");
        removeQueue.enqueue("remove-02");
        removeQueue.enqueue("remove-03");
        removeQueue.enqueue("remove-04");
        removeQueue.enqueue("remove-05");

        System.out.println("原数据：" + removeQueue);

        System.out.println("删除元素" + removeQueue.dequeue());

        System.out.println("删除后数据：" + removeQueue);

    }

    /**
     * 测试弹出不删除元素
     */
    @Test
    public void testSample() {
        RandomQueue<String> queue = new RandomQueue<String>();
        queue.enqueue("queue-01");
        queue.enqueue("queue-02");
        queue.enqueue("queue-03");
        queue.enqueue("queue-04");
        queue.enqueue("queue-05");

        System.out.println("原数据：" + queue);

        System.out.println("删除元素" + queue.sample());

        System.out.println("删除后数据：" + queue);

    }
}
