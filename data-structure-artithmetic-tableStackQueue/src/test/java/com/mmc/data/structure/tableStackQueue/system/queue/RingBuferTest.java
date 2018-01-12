package com.mmc.data.structure.tableStackQueue.system.queue;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.queue
 * @desrciption: 环形缓存区测试
 * @author: gaowei
 * @date： 2018-01-12 17:26
 * @history: (version) author date desc
 */
public class RingBuferTest {


    /**
     *
     */
    @Test
    public void test() {
        RingBuffer<String> buffer = new RingBuffer<String>(40);
        String putStr = "buffer-";
        for (int i = 0; i < 60; i++) {
            putStr = "buffer-";
            if (i > 0 && i % 4 == 0) {
                System.out.println("取出元素：" + buffer.get());
            } else {
                putStr = putStr + i;
                System.out.println("存放元素：" + putStr);
                buffer.put(putStr);
            }
        }
    }
}
