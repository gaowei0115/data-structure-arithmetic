package com.structure.arithmetic.api.genericjava4.method;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 17:14
 * @history: (version) author date desc
 */
public class GenericMethod {

    public <T> void fun(T ele) {
        System.out.println(ele.getClass().getName());
    }

    public <T, M, N> void fun(T t, M m, N n) {
        System.out.println(t.getClass().getName());
        System.out.println(m.getClass().getName());
        System.out.println(n.getClass().getName());
    }

    public <T, M> void fun(T t, M m, String str) {
        System.out.println(t.getClass().getName());
        System.out.println(m.getClass().getName());
        System.out.println(str.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.fun("String");
        genericMethod.fun(1);
        genericMethod.fun(1.1);
        genericMethod.fun(1.1F);
        genericMethod.fun('C');
        genericMethod.fun(10L);
        genericMethod.fun(1.2D);

        System.out.println("more generic type ");
        genericMethod.fun("String", 1, 'C');

        System.out.println("no arg type");
        genericMethod.fun(3L, 4.5F, "param");
    }
}
