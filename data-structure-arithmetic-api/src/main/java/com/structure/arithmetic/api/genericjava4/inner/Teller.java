package com.structure.arithmetic.api.genericjava4.inner;

import com.structure.arithmetic.api.genericjava4.inter.Generator;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inner
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 16:22
 * @history: (version) author date desc
 */
public class Teller {

    private static long counter = 0;
    private final long id = counter++;

    public Teller() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " > " + id;
    }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}
