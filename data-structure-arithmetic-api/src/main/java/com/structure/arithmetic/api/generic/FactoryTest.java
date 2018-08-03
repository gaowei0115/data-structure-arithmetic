package com.structure.arithmetic.api.generic;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 13:36
 * @history: (version) author date desc
 */
public class FactoryTest {

    public static void main(String[] args) {
        new Product(new ProductFactory());
    }
}

interface Factory<T> {
    T create();
}

class Product<T> {

    public <F extends Factory<T>> Product(F factory) {
        factory.create();
    }
}

class ProductFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        Integer i = new Integer(10);
        System.out.println(i);
        return i;
    }
}
