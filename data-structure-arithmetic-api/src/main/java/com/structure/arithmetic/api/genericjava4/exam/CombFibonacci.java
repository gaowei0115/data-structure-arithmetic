package com.structure.arithmetic.api.genericjava4.exam;

import com.structure.arithmetic.api.genericjava4.inter.Generator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 14:14
 * @history: (version) author date desc
 */
public class CombFibonacci implements Generator<Integer>, Iterable<Integer> {

    private int count = 0;

    private int size;

    public CombFibonacci() {
    }

    public CombFibonacci(int sz) {
        this.size = sz;
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        CombFibonacci combFibonacci1 = new CombFibonacci();
        int size = 20;
        for (int i = 0; i < size; i++) {
            System.out.println(combFibonacci1.next());
        }

        System.out.println("--------------------------------------------");
        for (int ele : new CombFibonacci(size)) {
            System.out.println(ele);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int cn = size;
            @Override
            public boolean hasNext() {
                return cn > 0;
            }

            @Override
            public Integer next() {
                cn--;
                return CombFibonacci.this.next();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {

    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }
}
