package com.structure.arithmetic.api.genericjava4.inter;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inter
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 11:17
 * @history: (version) author date desc
 */
public class Fibonacci implements Generator<Integer> {

    protected int count = 0;

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
        Fibonacci fibonacci = new Fibonacci();
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(fibonacci.next());
        }
    }
}
