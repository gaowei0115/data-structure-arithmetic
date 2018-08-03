package com.structure.arithmetic.api.genericjava4.method;

import java.util.*;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-11 17:25
 * @history: (version) author date desc
 */
public class CollectionUtils {

    /**
     * map集合
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    /**
     * list集合
     * @param <T>
     * @return
     */
    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    /**
     * 链表集合
     * @param <T>
     * @return
     */
    public static <T>LinkedList<T> linkedList() {
        return new LinkedList<>();
    }

    /**
     * set集合
     * @param <E>
     * @return
     */
    public static <E> Set<E> set() {
        return new HashSet<>();
    }

    /**
     * 队列集合
     * @param <T>
     * @return
     */
    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        List<String> list = list();

        Map<String, Object> map = map();

        LinkedList<String> linkedList = linkedList();

        Queue<String> queue = queue();
    }

}
