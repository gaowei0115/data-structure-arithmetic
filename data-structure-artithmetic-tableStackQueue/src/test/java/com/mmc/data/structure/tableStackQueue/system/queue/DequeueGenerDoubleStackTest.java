package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 双向队列实现两个栈
 * @author: gaowei
 * @date： 2018-01-23 15:21
 * @history: (version) author date desc
 */
public class DequeueGenerDoubleStackTest {

    @Test
   public void test() {
        DequeueGenerDoubleStack<String> dequeue = new DequeueGenerDoubleStack<>();
        for (int i = 0; i < 20; i++) {
            dequeue.addFirst("dequeue" + i);
        }



   }
}
