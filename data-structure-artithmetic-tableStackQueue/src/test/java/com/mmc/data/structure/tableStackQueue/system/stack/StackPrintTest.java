package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 给定串使用栈结构输出
 * @author: gaowei
 * @date： 2018-01-04 11:28
 * @history: (version) author date desc
 */
public class StackPrintTest {

    @Test
    public void test() {
        Stack<String> stack = new Stack<String>();
        stack.push("it");
        stack.push(" ");
        stack.push("was");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("the");
        stack.push(" ");
        stack.push("best");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("of");
        stack.push(" ");
        stack.push("times");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("it");
        stack.push(" ");
        stack.push("was");
        stack.push(" ");
        stack.push("the");
        stack.push(" ");
        stack.push("-");
        stack.push(" ");
        stack.push("-");
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
