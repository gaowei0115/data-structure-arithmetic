package com.mmc.data.structure.tableStackQueue.system.train;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.train
 * 类 名: TrainSeason37
 * 描 述: 表、栈、队列编程
 * 作 者: GW
 * 创 建： 2017-10-26 14:51
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class TrainSeason37 {

    /**
     * 测试如下程序运行时间
     */

    private static final int N = 1000;

    @Test
    public void test() {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            lst.add(i);
            lst.trimToSize();
        }

        long end = System.currentTimeMillis();
        System.out.println("cost time " + (end - start) + "ms");
    }
}
