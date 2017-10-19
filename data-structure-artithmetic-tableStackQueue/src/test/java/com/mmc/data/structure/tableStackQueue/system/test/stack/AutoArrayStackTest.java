package com.mmc.data.structure.tableStackQueue.system.test.stack;

import com.mmc.data.structure.tableStackQueue.system.stack.AutoArrayStack;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.test.stack
 * 类 名: AutoArrayStackTest
 * 描 述: 数组实现栈测试用例
 * 作 者: GW
 * 创 建： 2017-10-19 13:57
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoArrayStackTest {

    @Test
    public void test01() {
        AutoArrayStack<String> stack = new AutoArrayStack<String>();
        String computerParam = "5+4*2*(2+3)+[3+(2+1)*4]";
        System.out.println("原始input data ： " + computerParam);
        for (int i = 0; i < computerParam.length(); i++) {
            char c = computerParam.charAt(i);
            stack.push(String.valueOf(c));
        }

        System.out.println("栈中保存data : ");
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(stack.poll());
            System.out.print(" ");
        }
        System.out.println();
        AutoArrayStack<String> stack1 = new AutoArrayStack<String>();
        System.out.println("计算表达式：");
        for (int i = 0; i < computerParam.length(); i++) {
            char c = computerParam.charAt(i);
            String top = stack1.poll();
            int sum = 0;
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack1.push(String.valueOf(c));
                case ')':
                {
                    if (c == '*' || c == '/') {

                    }
                }


            }
            stack.push(String.valueOf(c));
        }


    }

    public boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(2 << 1);
        System.out.println((new Object[5]).length);
    }
}
