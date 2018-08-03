package com.structure.arithmetic.api.genericjava4.exam.inter;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam.inter
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 16:20
 * @history: (version) author date desc
 */
public class StoreCharater {

    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " >>> " + id;
    }
}
