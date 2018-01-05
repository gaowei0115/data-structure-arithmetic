package com.mmc.data.structure.tableStackQueue.system.stack;

import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.stack
 * @desrciption: jdk api stack 遍历操作
 * @author: gaowei
 * @date： 2018-01-03 11:11
 * @history: (version) author date desc
 */
public class ForEachStackTest {

    @Test
    public void test() {
        Stack<Long> datas = new Stack<Long>();
        datas.push(100L);
        datas.push(20L);
        datas.push(30L);
        datas.push(40L);
        datas.push(60L);

        // 1. 遍历方式 for each
        System.out.println("For Each : ");
        for (Long d : datas) {
            System.out.print(d);
            System.out.print(",");
        }


        System.out.println();
        // 2. iterator 遍历
        Iterator<Long> iter = datas.iterator();
        System.out.println("Iterator : ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(",");
        }

    }
}
