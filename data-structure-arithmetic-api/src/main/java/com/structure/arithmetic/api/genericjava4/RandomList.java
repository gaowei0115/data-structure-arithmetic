package com.structure.arithmetic.api.genericjava4;

import java.util.ArrayList;
import java.util.Random;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 10:25
 * @history: (version) author date desc
 */
public class RandomList<T> {

    private Random random = new Random(100);
    private ArrayList<T> storage = new ArrayList<>();

    /**
     * 加入
     * @param ele
     */
    public void add(T ele) {
        storage.add(ele);
    }

    /**
     * 选择元素
     * @return
     */
    public T select() {
        if (storage.size() == 0) {
            System.out.println("storage is null !!");
            return null;
        }
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        System.out.println("add element >> ");
        for (int i = 0; i < 30; i++) {
            randomList.add("randomlist" + i);
        }

        System.out.println("out put element >> ");
        for (int i = 0; i < 30; i++) {
            System.out.println(randomList.select());
        }
        System.out.println("end..");
    }
}
