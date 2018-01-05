package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-05 13:57
 * @history: (version) author date desc
 */
public class Stack6Test {

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        System.out.println("原始数据：");
        System.out.print("[");
        while (!queue.isEmpty()) {
            System.out.print(queue.peek());
            System.out.print(",");
        }

        Stack<Integer> stack = new Stack<Integer>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.empty()) {
            queue.add(stack.pop());
        }

        System.out.println("转换后数据：");
        System.out.print("[");
        while (!queue.isEmpty()) {
            System.out.print(queue.peek());
            System.out.print(",");
        }
    }
}
