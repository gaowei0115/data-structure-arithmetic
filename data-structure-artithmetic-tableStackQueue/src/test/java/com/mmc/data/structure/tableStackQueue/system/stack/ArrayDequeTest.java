package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-23 16:30
 * @history: (version) author date desc
 */
public class ArrayDequeTest {

    @Test
    public void test() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            deque.addFirst("a" + i);
        }

        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }

    }

    @Test
    public void test01() {
        System.out.println(16 & 15);
    }
}
