package com.mmc.data.structure.tableStackQueue.system.analyze;

import org.junit.Test;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption:
 * @author: gaowei
 * @date： 2018-01-24 17:34
 * @history: (version) author date desc
 */
public class StopwatchTest {

    @Test
    public void test() {
        Stopwatch stopwatch = new Stopwatch();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            sum += i;
        }
        System.out.println("cost time : " + stopwatch.stop() + " s");
    }
}
