package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-05 13:47
 * @history: (version) author date desc
 */
public class Stack5Test {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<Integer>();
        int n = 50;
        while (n > 0) {
            stack.push((n % 2));
            n = n >> 2;
        }
        for (Integer i : stack) {
            System.out.print(Integer.toBinaryString(i));
            System.out.print(",");
        }

        System.out.println();
    }
}
