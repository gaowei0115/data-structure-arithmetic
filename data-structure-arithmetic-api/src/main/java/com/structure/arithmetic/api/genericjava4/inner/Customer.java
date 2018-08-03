package com.structure.arithmetic.api.genericjava4.inner;

import com.structure.arithmetic.api.genericjava4.inter.Generator;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inner
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 16:18
 * @history: (version) author date desc
 */
public class Customer {

    private static long counter = 0;
    private final long id = counter++;

    public Customer(){

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " > " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
