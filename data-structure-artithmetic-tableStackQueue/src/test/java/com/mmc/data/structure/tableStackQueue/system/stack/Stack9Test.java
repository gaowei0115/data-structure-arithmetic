package com.mmc.data.structure.tableStackQueue.system.stack;

import com.mmc.data.structure.tableStackQueue.system.queue.AutoArrayQueue;
import com.mmc.data.structure.tableStackQueue.system.queue.AutoLinkedQueue;
import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-08 16:51
 * @history: (version) author date desc
 */
public class Stack9Test {

    @Test
    public void test() {
        String str = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] strA = str.split(" ");
        // 操作符
        AutoArrayStack<String> ops = new AutoArrayStack<String>();
        // 值
        AutoArrayStack<String> values = new AutoArrayStack<String>();
        int len = strA.length;
        System.out.println("before: ");
        System.out.println(str);
        for (int i = 0; i < len; i++) {
            String s = strA[i];
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                String expre = ")" + values.poll() + ops.poll() + values.poll() + "(";
                values.push(expre);
            } else {
                values.push(s);
            }
        }

        AutoArrayStack<String> results = new AutoArrayStack<String>();
        System.out.println("result: ");
        String result = values.poll();
        System.out.println(result);

        len = result.length();
        for (int i = 0; i < len; i++) {
            char s = result.charAt(i);
            results.push(String.valueOf(s));
        }

        System.out.println("sort: ");
        while (!results.isEmpty()) {
            System.out.print(results.poll());
            System.out.print(" ");
        }

    }
}
