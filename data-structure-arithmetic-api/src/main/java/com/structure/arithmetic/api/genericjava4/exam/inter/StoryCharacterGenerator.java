package com.structure.arithmetic.api.genericjava4.exam.inter;

import com.structure.arithmetic.api.genericjava4.inter.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam.inter
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 16:41
 * @history: (version) author date desc
 */
public class StoryCharacterGenerator implements Generator<StoreCharater>, Iterable<StoreCharater> {

    private int count;
    private Class<?>[] types = {DarthVader.class, JabbaTheHut.class, LukeSkywalker.class, Yoda.class};

    private static Random random = new Random();

    public StoryCharacterGenerator() {}

    public StoryCharacterGenerator(int c) {
        this.count = c;
    }

    @Override
    public StoreCharater next() {
        try {
        return (StoreCharater) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoreCharater> iterator() {
        return new StoryIterator();
    }

    class StoryIterator implements Iterator<StoreCharater> {
        int size = count;

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public StoreCharater next() {
            size--;
            return StoryCharacterGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        StoryCharacterGenerator storeCharaters = new StoryCharacterGenerator();
        int size = 5;
        for (int i = 0; i < size; i++) {
            System.out.println(storeCharaters.next());
        }

        System.out.println("---------------------------");
        for (StoreCharater sc : new StoryCharacterGenerator(5)) {
            System.out.println(sc);
        }
    }
}
