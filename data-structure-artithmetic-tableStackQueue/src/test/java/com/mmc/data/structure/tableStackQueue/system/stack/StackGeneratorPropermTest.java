package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-23 14:35
 * @history: (version) author date desc
 */
public class StackGeneratorPropermTest {

    /**
     * 验证栈是否溢出
     * @param args
     */
    public static boolean validatePoll(String[] args) {
        if (args.length == 0) {
            return false;
        }
        int len = args.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (args[i].compareTo("-") == 0) {
                cnt--;
            } else {
                cnt++;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println((1 & 15));
    }


}
