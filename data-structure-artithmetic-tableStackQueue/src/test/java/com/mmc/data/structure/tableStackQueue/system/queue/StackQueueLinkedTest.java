package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-10 16:52
 * @history: (version) author date desc
 */
public class StackQueueLinkedTest {

    /**
     * 模拟栈
     */
    @Test
    public void testStack() {
        StackQueueLinked<String> stack = new StackQueueLinked<String>();
        stack.push("stack-01");
        stack.push("stack-02");
        stack.push("stack-03");
        stack.push("stack-04");
        stack.push("stack-05");
        stack.push("stack-06");
        stack.push("stack-07");
        stack.push("stack-08");

        System.out.println("使用链表模拟栈操作：");
        System.out.print("[");

        while (!stack.isEmpty()) {
            System.out.print(stack.poll());
            System.out.print("-->");
        }
        System.out.print("]");
    }

    /**
     * 模拟队列
     */
    @Test
    public void testQueue() {
        StackQueueLinked<String> queue = new StackQueueLinked<String>();
        queue.enqueue("queue-01");
        queue.enqueue("queue-02");
        queue.enqueue("queue-03");
        queue.enqueue("queue-04");
        queue.enqueue("queue-05");
        queue.enqueue("queue-06");
        queue.enqueue("queue-07");
        queue.enqueue("queue-08");

        System.out.println("使用链表模拟队列操作：");
        System.out.print("[");

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
            System.out.print("-->");
        }
        System.out.print("]");
    }
}
