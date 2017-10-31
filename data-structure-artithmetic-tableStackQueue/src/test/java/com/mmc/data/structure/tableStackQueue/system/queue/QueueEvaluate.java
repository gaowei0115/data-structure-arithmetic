package com.mmc.data.structure.tableStackQueue.system.queue;

import java.util.Stack;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.queue
 * 类 名: QueueEvaluate
 * 描 述: 算术表达式计算
 * 作 者: GW
 * 创 建： 2017-10-30 17:25
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class QueueEvaluate {

    public static void main(String[] args) {
        String values = "(1+2*(3+4)*(2+3))";
        Stack<String> ops = new Stack<String>();
        Stack<Integer> vals = new Stack<Integer>();
        int start = 0;
        int end = 1;
        while (end <= values.length()) {
            String v = values.substring(start, end);
            if ("+".equals(v)) {
                ops.push(v);
            } else if ("-".equals(v)) {
                ops.push(v);
            } else if ("/".equals(v)) {
                ops.push(v);
            } else if ("*".equals(v)) {
                ops.push(v);
            } else if ("(".equals(v)) {
                ops.push(v);
            } else if (")".equals(v)) {

                String op = null;
                while (!"(".equals(op = ops.pop())) {
                    Integer i = vals.pop();
                    if ("+".equals(op)) {
                        i = vals.pop() + i;
                    } else if ("-".equals(op)) {
                        i = vals.pop() - i;
                    } else if ("/".equals(op)) {
                        i = vals.pop() / i;
                    } else if ("*".equals(op)) {
                        i = vals.pop() * i;
                    }
                    vals.push(i);
                }
            } else {
                vals.push(Integer.parseInt(v));
            }
            start = end;
            end = end + 1;
        }
        System.out.println("计算结果：" + vals.pop());
    }
}
