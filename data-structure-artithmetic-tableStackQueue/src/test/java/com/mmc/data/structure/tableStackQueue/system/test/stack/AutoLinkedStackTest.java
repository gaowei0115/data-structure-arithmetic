package com.mmc.data.structure.tableStackQueue.system.test.stack;

import com.mmc.data.structure.tableStackQueue.system.stack.AutoLinkedStack;
import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.test.stack
 * 类 名: AutoLinkedStackTest
 * 描 述: 链表实现栈测试
 * 作 者: GW
 * 创 建： 2017-10-20 15:34
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoLinkedStackTest {

    /**
     * 测试入口
     */
    @Test
    public void test() {
        String computerParam = "5+4*2*(2+3)+[3+(2+1)*4]";
        AutoLinkedStack<String> stack = new AutoLinkedStack<String>();

        System.out.println("原始input data ： " + computerParam);

        // 542*23+*3421+*+++
        // 6523+8*+3+*
        char[] array = computerParam.toCharArray();
        int length = array.length;
        String convertStr = "";
        StringBuffer sb = new StringBuffer();
        AutoLinkedStack<String> symob = new AutoLinkedStack<String>();
        // a + b * c + (d * e + f) * g
        // 5+4*2*(2+3)+[3+(2+1)*4]
        for (int i = 0; i < length; i++) {
            char c = array[i];
            String p = symob.get();
            if (isComputer(c)) {
                while (p != null && isPermission(c, p)) {
                    sb.append(symob.poll());
                    p = symob.get();
                }
                symob.push(String.valueOf(c));
            } else if (isKH(c)) {
                if (isBigB_KH(c)) {
                    symob.push(String.valueOf(c));
                } else if (isCenterB_KH(c)) {
                    symob.push(String.valueOf(c));
                } else if (isSmallB_KH(c)) {
                    symob.push(String.valueOf(c));
                } else if (isBigA_KH(c)) {
                    while (p != null && !isBigB_KH(p.toCharArray()[0])) {
                        sb.append(symob.poll());
                        p = symob.get();
                    }
                    symob.poll();
                } else if (isCenterA_KH(c)) {
                    while (p != null && !isCenterB_KH(p.toCharArray()[0])) {
                        sb.append(symob.poll());
                        p = symob.get();
                    }
                    symob.poll();
                } else if (isSmallA_KH(c)) {
                    while (p != null && !isSmallB_KH(p.toCharArray()[0])) {
                        sb.append(symob.poll());
                        p = symob.get();
                    }
                    symob.poll();
                }
            } else {
                sb.append(c);
            }
        }

        while (!symob.isEmpty()) {
            sb.append(symob.poll());
        }

        System.out.println("中缀转换成后缀：" + sb.toString());

        System.out.println("计算结果：" + computer(sb.toString()));

    }


    /**
     * 计算结果
     * @param param
     */
    public int computer(String param) {
        if (param == null) {
            throw new IllegalArgumentException();
        }
        int length = param.length();
        AutoLinkedStack<Integer> computer = new AutoLinkedStack<Integer>();
        for (int i = 0; i < length; i++) {
            char c = param.charAt(i);
            int d1 = 0;
            int d2 = 0;
            int sum = 0;
            switch (c) {
                case '*':
                    d1 = computer.poll();
                    d2 = computer.poll();
                    sum = d1 * d2;
                    computer.push(sum);
                    break;
                case '/' :
                    d1 = computer.poll();
                    d2 = computer.poll();
                    if (d2 == 0) {
                        throw new IllegalArgumentException();
                    }
                    sum = d1 / d2;
                    computer.push(sum);
                    break;
                case '+':
                    d1 = computer.poll();
                    d2 = computer.poll();
                    sum = d1 + d2;
                    computer.push(sum);
                    break;
                case '-':
                    d1 = computer.poll();
                    d2 = computer.poll();
                    sum = d1 - d2;
                    computer.push(sum);
                    break;
                default:
                    computer.push(Integer.parseInt(String.valueOf(c)));
            }

        }
        return computer.poll();
    }

    public boolean isKH(char c) {
        if (isBigB_KH(c) || isCenterB_KH(c) || isSmallB_KH(c) || isBigA_KH(c) || isCenterA_KH(c) || isSmallA_KH(c)) {
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
        if (c == ']') {
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

    public boolean isPermission(char toC, String fromC) {
        int toR = 0;
        int fromR = 0;
        if (toC == '*' || toC == '/') {
            toR = 2;
        } else if (toC == '+' || toC == '/') {
            toR = 1;
        }

        if ("*".equals(fromC) || "/".equals(fromC)) {
            fromR = 2;
        } else  if ("-".equals(fromC) || "+".equals(fromC)) {
            fromR = 1;
        }
        if (toR < fromR) {
            return true;
        } else if (toR  == 0 || fromR == 0) {
            return false;
        } else if (toR == fromR) {
            return true;
        } else {
            return false;
        }
    }
}
