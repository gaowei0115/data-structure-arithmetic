package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-15 17:56
 * @history: (version) author date desc
 */
public class CopyStackTest {

    @Test
    public void test() {
        CopyStack<String> copyStack = new CopyStack<String>();
        copyStack.push("stack-01");
        copyStack.push("stack-02");
        copyStack.push("stack-03");
        copyStack.push("stack-04");
        copyStack.push("stack-05");

        CopyStack<String> stack = new CopyStack<String>(copyStack);

        stack.push("copy-stack-001");

        System.out.println("原数据：");
        while (!copyStack.isEmpty()) {
            System.out.println(copyStack.poll());
        }

        System.out.println("复制数据：");
        while (!stack.isEmpty()) {
            System.out.println(stack.poll());
        }

    }
}
