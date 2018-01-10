package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-08 17:44
 * @history: (version) author date desc
 */
public class Stack10Test {

    /**
     *
     */
    @Test
    public void test() {
        String str = "((1+2)*((5-3)*(8+2)))";

        // 表达式
        AutoArrayStack<String> ops = new AutoArrayStack<String>();
        // 数字
        AutoArrayStack<String> vals = new AutoArrayStack<String>();

        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            String s = String.valueOf(c);
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                String op = ops.poll();
                int sum = 0;
                if ("+".equals(op)) {
                    sum = Integer.parseInt(vals.poll()) + Integer.parseInt(vals.poll());
                } else if ("-".equals(op)) {
                    int a = Integer.parseInt(vals.poll());
                    int b = Integer.parseInt(vals.poll());
                    sum = b - a;
                } else if ("*".equals(op)) {
                    sum = Integer.parseInt(vals.poll()) * Integer.parseInt(vals.poll());
                } else if ("/".equals(op)) {
                    sum = Integer.parseInt(vals.poll()) / Integer.parseInt(vals.poll());
                }
                vals.push(String.valueOf(sum));
            } else if ("(".equals(s)) {
                continue;
            } else {
                vals.push(s);
            }
        }

        System.out.println("result : " + vals.poll());
    }
}
