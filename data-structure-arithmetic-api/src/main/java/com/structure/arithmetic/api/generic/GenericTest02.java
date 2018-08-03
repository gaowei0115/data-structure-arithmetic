package com.structure.arithmetic.api.generic;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 13:25
 * @history: (version) author date desc
 */
public class GenericTest02<T>  {


    private Class<T> clazz;

    public GenericTest02 (Class<T> clazz) {
        this.clazz = clazz;
    }

    public boolean compare(Object obj) {
        return clazz.isInstance(obj);
    }

    public static void main(String[] args) {
        GenericTest02<B> genericTest02 = new GenericTest02<>(B.class);
        System.out.println(genericTest02.compare(new A()));
        System.out.println(genericTest02.compare(new B()));
    }
}

class A {}

class B extends A {

}
