package com.structure.arithmetic.api.genericjava4.inter.obj;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inter.obj
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 10:38
 * @history: (version) author date desc
 */
public class Coffee {

    private static long counter = 0;
    private final long id = counter++;


    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

}
