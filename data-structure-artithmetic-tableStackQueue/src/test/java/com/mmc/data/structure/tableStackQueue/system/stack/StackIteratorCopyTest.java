package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 可迭代Stack Iterator Copy
 * @author: gaowei
 * @date： 2018-01-09 11:17
 * @history: (version) author date desc
 */
public class StackIteratorCopyTest {

    /**
     *
     * @param stack
     * @return
     */
    public Stack<String> copy(Stack<String> stack) {
        // 最终复制结果
        Stack<String> result = new Stack<String>();
        // 中间变量
        Stack<String> temp = new Stack<String>();

        if (stack == null) {
            return null;
        }
        System.out.println("原stack ： ");
        System.out.print("[ ");
        // 先拷贝到中间变量
        while (!stack.isEmpty()) {
            String p = stack.pop();
            temp.push(p);
            System.out.print(p);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();

        // 由中间变量拷贝到结果变量
        while (!temp.isEmpty()) {
            result.push(temp.pop());
        }

        return result;
    }

    @Test
    public void test() {
        Stack<String> stack = new Stack<String>();
        stack.push("first stack");
        stack.push("second stack");
        stack.push("threed stack");

        Stack<String> result = copy(stack);
        System.out.println("copy stack ：");
        System.out.print("[ ");
        while (!result.isEmpty()) {
            System.out.print(result.pop());
            System.out.print(" ");
        }
        System.out.print("]");
    }
}
