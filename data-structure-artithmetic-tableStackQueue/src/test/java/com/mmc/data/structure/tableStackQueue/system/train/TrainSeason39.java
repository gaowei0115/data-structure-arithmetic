package com.mmc.data.structure.tableStackQueue.system.train;

import com.mmc.data.structure.tableStackQueue.system.javaApi.AutoArrayList;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason39
 * 描 述: 表、队列、栈编程
 * 作 者: GW
 * 创 建： 2017-10-26 16:55
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason39 {

    /**
     * 提供AutoArrayList addAll方法，方法addAll将添加的items添加到AutoArrayList的末端。计算运行时间，在使用Java Collection
     * API ArrayList addAll方法运行时间进行比对
     */

    /**
     * 使用AutoArrayList测试addAll
     */
    @Test
    public void test() {
        AutoArrayList<Integer> l1 = new AutoArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            l1.add(i);
        }

        AutoArrayList<Integer> l2 = new AutoArrayList<Integer>();
        for(int i = 100000; i < 110000; i++) {
            l2.add(i);
        }

        long start = System.currentTimeMillis();
        l1.addAll(l2);
        long end = System.currentTimeMillis();

        System.out.println(String.format("AutoArrayList compute result length:%s cost time %sms", l1.size(), (end -start)));
    }

    /**
     * Java Collection API ArrayList测试addAll
     */
    @Test
    public void test01() {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            l1.add(i);
        }

        ArrayList<Integer> l2 = new ArrayList<Integer>();
        for(int i = 100000; i < 110000; i++) {
            l2.add(i);
        }

        long start = System.currentTimeMillis();
        l1.addAll(l2);
        long end = System.currentTimeMillis();

        System.out.println(String.format("Java Collection API ArrayList compute result length:%s cost time %sms", l1.size(), (end -start)));
    }
}
