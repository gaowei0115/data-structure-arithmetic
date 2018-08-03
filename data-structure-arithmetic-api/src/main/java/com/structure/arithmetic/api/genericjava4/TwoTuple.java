package com.structure.arithmetic.api.genericjava4;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 16:01
 * @history: (version) author date desc
 */
public class TwoTuple<P, R> {

    private P param;
    private R result;

    public TwoTuple(){}

    public TwoTuple(P param, R result) {
        this.param = param;
        this.result = result;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "param=" + param +
                ", result=" + result +
                '}';
    }
}
