package com.structure.arithmetic.api.genericjava4.inter;

import java.util.Iterator;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inter
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 11:25
 * @history: (version) author date desc
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int cn = 0;

    public IterableFibonacci(int count) {
        this.cn = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int count = cn;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        IterableFibonacci integers = new IterableFibonacci(10);
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
