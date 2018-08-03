package com.structure.arithmetic.api.genericjava4.method;

import com.structure.arithmetic.api.genericjava4.inter.Fibonacci;
import com.structure.arithmetic.api.genericjava4.inter.Generator;
import com.structure.arithmetic.api.genericjava4.inter.obj.Coffee;
import com.structure.arithmetic.api.genericjava4.inter.obj.CoffeeGenerator;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 10:04
 * @history: (version) author date desc
 */
public class Generators {

    /**
     * collection
     * @param coll
     * @param generator
     * @param n
     * @param <T>
     * @return
     */
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(generator.next());
        }
        return coll;
    }

    /**
     * list
     * @param list
     * @param generator
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> fill(List<T> list, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            list.add(generator.next());
        }
        return list;
    }

    /**
     * set
     * @param set
     * @param generator
     * @param n
     * @param <T>
     * @return
     */
    public static <T> Set<T> fill(Set<T> set, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            set.add(generator.next());
        }
        return set;
    }

    /**
     * queue
     * @param queue
     * @param generator
     * @param n
     * @param <T>
     * @return
     */
    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            queue.add(generator.next());
        }
        return queue;
    }

    public static void main(String[] args) {
        Collection<Coffee> coll = fill(CollectionUtils.<Coffee>list(), new CoffeeGenerator(), 10);

        System.out.println("-----------------------collection-------------------");
        for (Coffee coffee : coll) {
            System.out.println(">>> " + coffee);
        }

        System.out.println("-------------------------list------------------------");
        List<Integer> list = fill(CollectionUtils.list(), new Fibonacci(), 10);
        for (int i : list) {
            System.out.println(">>> " + i);
        }

        System.out.println("--------------------------set-------------------------");
        Set<Integer> set = fill(CollectionUtils.set(), new Fibonacci(), 10);
        for (int i : set) {
            System.out.println(">>> " + i);
        }

        System.out.println("---------------------------queue----------------------");
        Queue<Coffee> queues = fill(CollectionUtils.queue(), new CoffeeGenerator(), 10);
        for (Coffee cf : queues) {
            System.out.println(">>> " + cf);
        }
    }
}
