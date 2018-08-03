package com.structure.arithmetic.api.genericjava4.method.exam;

import com.structure.arithmetic.api.genericjava4.inter.obj.Coffee;
import com.structure.arithmetic.api.genericjava4.method.Tuple;
import com.structure.arithmetic.api.genericjava4.method.vo.Person;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 13:31
 * @history: (version) author date desc
 */
public class TupleTest {

    static Tuple.TwoTuple<String, Integer> f1() {
        return Tuple.tuple("twoTuple", 100);
    }

    static Tuple.ThreeTuple<String, Integer, Long> f2() {
        return Tuple.tuple("threeTuple", 200, 200L);
    }

    static Tuple.FourTuple<String, Integer, Long, Double> f3() {
        return Tuple.tuple("fourTuple", 300, 300L, 300.33D);
    }

    static Tuple.FiveTuple<String, Integer, Long, Double, Coffee> f4() {
        return Tuple.tuple("fiveTuple", 400, 400L, 400.44D, new Coffee());
    }

    static Tuple.SixTuple<String, Integer, Long, Double, Coffee, Person> f5() {
        return Tuple.tuple("sixeTuple", 500, 500L, 500.55D, new Coffee(), new Person("test"));
    }

    public static void main(String[] args) {
        System.out.println("twoTuple...............");
        System.out.println(f1());
        System.out.println("threeTuple.............");
        System.out.println(f2());
        System.out.println("fourTuple..............");
        System.out.println(f3());
        System.out.println("fiveTuple..............");
        System.out.println(f4());
        System.out.println("sixTuple...............");
        System.out.println(f5());
    }
}
