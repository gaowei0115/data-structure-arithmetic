package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * 包 名：com.mmc.data.structure.tableStackQueue.system.queue
 * 类 名: AutoArrayQueueTest
 * 描 述:
 * 作 者: GW
 * 创 建： 2017-10-23 10:00
 * <p>
 * 历 史: (版本) 作者 时间 注释
 */
public class AutoArrayQueueTest {

    /**
     * 测试入口
     */
    @Test
    public void test() {
        AutoArrayQueue<String> aaq = new AutoArrayQueue<String>();
        aaq.push("lisi01");
        aaq.push("lisi02");
        aaq.push("lisi03");
        aaq.push("lisi04");
        aaq.push("lisi05");
        aaq.push("lisi06");
        aaq.push("lisi07");
        aaq.push("lisi08");
        aaq.push("lisi09");
        aaq.push("lisi10");
        aaq.push("lisi11");




        while (!aaq.isEmpty()) {
            System.out.println(aaq.poll());
        }

        System.out.println(aaq.size());
    }
}
