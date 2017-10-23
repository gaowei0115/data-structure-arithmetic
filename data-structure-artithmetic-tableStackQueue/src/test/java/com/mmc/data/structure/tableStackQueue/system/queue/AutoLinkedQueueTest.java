package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.queue
 * 类 名: AutoLinkedQueueTest
 * 描 述: 链表实现的队列测试
 * 作 者: GW
 * 创 建： 2017-10-23 13:37
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedQueueTest {

    /**
     * 测试入口
     */
    @Test
    public void test() {
        AutoLinkedQueue<String> queue = new AutoLinkedQueue<String>();
        queue.push("张三01");
        queue.push("张三02");
        queue.push("张三03");
        queue.push("张三04");
        queue.push("张三05");
        queue.push("张三06");
        queue.push("张三07");
        queue.push("张三08");
        queue.push("张三09");
        queue.push("张三10");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

