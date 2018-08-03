package com.structure.arithmetic.api.genericjava4.method;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption: 对象统计
 * @author: gaowei
 * @date： 2018-06-12 10:52
 * @history: (version) author date desc
 */
public class ObjectCounter {

    private static long counter = 0;

    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " > " + id;
    }
}
