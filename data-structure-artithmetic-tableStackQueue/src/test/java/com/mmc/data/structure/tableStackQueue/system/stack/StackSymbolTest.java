package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: 符号对称验证  如：{[()]}
 * @author: gaowei
 * @date： 2018-01-04 15:11
 * @history: (version) author date desc
 */
public class StackSymbolTest {

    @Test
    public void test() {
        // 使用自定义的数组栈实现
        AutoArrayStack<String> stack = new AutoArrayStack<String>();
        // 验证串 true
        String parameter = "[()]{}{[()()]()}";
        // 验证串 false
//        String parameter = "[()]{}{[[)()]()}";
        parameter = "{[}}";
        // 添加数据
        int length = parameter.length();
        boolean flag = false;
        System.out.println("原始数据：" + parameter);
        for (int i = 0; i < length; i++) {
            char c = parameter.charAt(i);
            String item = String.valueOf(c);
            if ("{".equals(item) || "[".equals(item) || "(".equals(item)) {
                stack.push(item);
            } else if ("}".equals(item) || "]".equals(item) || ")".equals(item)) {
                flag = false;
                if (!stack.isEmpty()) {
                    String p = stack.poll();
                    if ((item.equals("}") && "{".equals(p)) || (item.equals("]") && "[".equals(p)) || (item.equals(")") && "(".equals(p))) {
                        flag = true;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("验证结果：" + flag);
    }
}
