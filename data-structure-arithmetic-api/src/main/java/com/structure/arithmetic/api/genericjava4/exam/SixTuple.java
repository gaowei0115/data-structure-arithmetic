package com.structure.arithmetic.api.genericjava4.exam;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 17:22
 * @history: (version) author date desc
 */
public class SixTuple<A, B, C, D, E, F> {

    private A a;
    private B b;
    private C c;
    private D d;
    private E e;
    private F f;

    public SixTuple() {}

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                '}';
    }
}
