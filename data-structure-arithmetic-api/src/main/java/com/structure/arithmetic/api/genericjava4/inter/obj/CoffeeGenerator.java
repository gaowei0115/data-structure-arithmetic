package com.structure.arithmetic.api.genericjava4.inter.obj;

import com.structure.arithmetic.api.genericjava4.inter.Generator;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inter.obj
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 10:46
 * @history: (version) author date desc
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private static Random random = new Random(47);
    private Class<?> clazz[] = {Latte.class, Mocha.class, Cappuccino.class, Breve.class, Americano.class};

    private int size;

    public CoffeeGenerator() {}

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) clazz[random.nextInt(clazz.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public void forEach(Consumer<? super Coffee> action) {

    }

    @Override
    public Spliterator<Coffee> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        System.out.println("-------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }

        System.out.println("for each =========================");
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return (count > 0);
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super Coffee> action) {

        }
    }
}
