package com.mmc.data.structure.tableStackQueue.system.analyze;

/**
 * @packageName：com.mmc.data.structure.tableStackQueue.system.analyze
 * @desrciption: 时间计算
 * @author: gaowei
 * @date： 2018-01-24 17:31
 * @history: (version) author date desc
 */
public class Stopwatch {

    /**
     * 创建对象时获取开始时间
     */
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * 计算从创建对象到执行结束耗时 单位：秒
     * @return
     */
    public double stop() {
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
