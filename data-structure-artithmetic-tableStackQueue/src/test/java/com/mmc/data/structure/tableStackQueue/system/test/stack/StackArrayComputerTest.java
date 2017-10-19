package com.mmc.data.structure.tableStackQueue.system.test.stack;

import com.mmc.data.structure.tableStackQueue.system.stack.AutoArrayStack;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.test.stack
 * 类 名: StackArrayComputerTest
 * 描 述:
 * 作 者: GW
 * 创 建： 2017-10-19 15:20
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class StackArrayComputerTest {

    /**
     * 测试入口
     */
    @Test
    public void test() {
        String computerParam = "5+4*2*(2+3)+[3+(2+1)*4]";
        AutoArrayStack<String> stack = new AutoArrayStack<String>();

        System.out.println("原始input data ： " + computerParam);

        // 542*23+*3421+*+++
        // 6523+8*+3+*
        char[] array = computerParam.toCharArray();
        int length = array.length;
        String convertStr = "";
        StringBuffer sb = new StringBuffer();
        AutoArrayStack<String> symob = new AutoArrayStack<String>();
        // a + b * c + (d * e + f) * g
        // 5+4*2*(2+3)+[3+(2+1)*4]
        for (int i = 0; i < length; i++) {
            char c = array[i];
            String p = symob.get();
            if (isOperation(c)) {
                // 操作符
                if (isComputer(c)) {
                    // 运算符
                    if (isPermission(c)) {
                        while(p != null) {
                            p = symob.poll();
                            sb.append(p);
                        }
                    } else {
                        symob.push(String.valueOf(c));
                    }
                } else {
                    if (isSmallA_KH(c)) {
                        while (p != null && !isKH(c)) {
                            p = symob.poll();
                            sb.append(p);
                        }
                    }
                }
            } else {
                // 非操作符
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }

    public boolean isKH(char c) {
        if (isBigB_KH(c) || isCenterB_KH(c) || isSmallB_KH(c)) {
            return true;
        }
        return false;
    }

    public boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')') {
            return true;
        }
        return false;
    }

    public boolean isComputer(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    public boolean isCenterB_KH(char c) {
        if (c == '[') {
            return true;
        }
        return false;
    }

    public boolean isCenterA_KH(char c) {
        if (c == '}') {
            return true;
        }
        return false;
    }

    public boolean isBigB_KH(char c) {
        if (c == '{') {
            return true;
        }
        return false;
    }

    public boolean isBigA_KH(char c) {
        if (c == '}') {
            return true;
        }
        return false;
    }

    public boolean isSmallB_KH(char c) {
        if (c == '(') {
            return true;
        }
        return false;
    }

    public boolean isSmallA_KH(char c) {
        if (c == ')') {
            return true;
        }
        return false;
    }

    public boolean isPermission(char c) {
        if (c == '*' || c == '/') {
            return true;
        }
        return false;
    }
}
