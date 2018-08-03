package com.structure.arithmetic.api.genericjava4.method;

import com.structure.arithmetic.api.genericjava4.TwoTuple;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption: 泛型参数组
 * @author: gaowei
 * @date： 2018-06-12 11:06
 * @history: (version) author date desc
 */
public class Tuple {

    /**
     *
     * @param k
     * @param v
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> TwoTuple<K, V> tuple(K k, V v) {
        return new TwoTuple<>(k, v);
    }

    /**
     *
     * @param k
     * @param v
     * @param m
     * @param <K>
     * @param <V>
     * @param <M>
     * @return
     */
    public static <K, V, M> ThreeTuple<K, V, M> tuple(K k, V v, M m) {
        return new ThreeTuple<>(k, v, m);
    }


    public static <K, V, M, N> FourTuple<K, V, M, N> tuple(K k, V v, M m, N n) {
        return new FourTuple<>(k, v, m, n);
    }

    public static <K, V, M, N, O> FiveTuple<K, V, M, N, O> tuple(K k, V v, M m, N n, O o) {
        return new FiveTuple<>(k, v, m, n, o);
    }

    public static <K, V, M, N, O, P> SixTuple<K, V, M, N, O, P> tuple(K k, V v, M m, N n, O o, P p) {
        return new SixTuple<>(k, v, m, n, o, p);
    }

    /**
     *
     * @param <K>
     * @param <V>
     */
    public static class TwoTuple<K, V>{

        K key;
        V value;

        public TwoTuple() {}

        public TwoTuple(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{twoTuple: key:" + key + ", value: " + value + "}";
        }
    }

    public static class ThreeTuple<K, V, M> {

        K k;
        V v;
        M m;

        public ThreeTuple() {}

        public ThreeTuple(K k, V v, M m) {
            this.k = k;
            this.v = v;
            this.m = m;
        }

        @Override
        public String toString() {
            return "{threeTuple: k:" + k + ", v: " + v + ", m: " + m + "}";
        }
    }

    public static class FourTuple<K, V, M, N> {

        K k;
        V v;
        M m;
        N n;

        public FourTuple() {}

        public FourTuple(K k, V v, M m, N n) {
            this.k = k;
            this.v = v;
            this.m = m;
            this.n = n;
        }

        @Override
        public String toString() {
            return "{fourTuple: k:" + k + ", v: " + v + ", m: " + m + ", n: " + n + "}";
        }
    }

    public static class FiveTuple<K, V, M, N, O> {

        K k;
        V v;
        M m;
        N n;
        O o;

        public FiveTuple() {}

        public FiveTuple(K k, V v, M m, N n, O o) {
            this.k = k;
            this.v = v;
            this.m = m;
            this.n = n;
            this.o = o;
        }

        @Override
        public String toString() {
            return "{fiveTuple: k:" + k + ", v: " + v + ", m: " + m + ", n: " + n + ", o: " + o + "}";
        }
    }

    public static class SixTuple<K, V, M, N, O, P> {

        K k;
        V v;
        M m;
        N n;
        O o;
        P p;

        public SixTuple(){}

        public SixTuple(K k, V v, M m, N n, O o, P p) {
            this.k = k;
            this.v = v;
            this.m = m;
            this.n = n;
            this.o = o;
            this.p = p;
        }

        @Override
        public String toString() {
            return "{sixTuple: k:" + k + ", v: " + v + ", m: " + m + ", n: " + n + ", o: " + o + ", p: " + p + "}";
        }
    }

}

