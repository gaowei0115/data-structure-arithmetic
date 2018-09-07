package com.structure.arithmetic.api.box;

/**
 * @packageName：com.structure.arithmetic.api.box
 * @desrciption:
 * @author: gaowei
 * @date： 2018-09-04 11:25
 * @history: (version) author date desc
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("a == b : " + (a == b));

        Integer c = new Integer(11);
        Integer d = new Integer(11);
        System.out.println("c.equals(d) : " + c.equals(d));

        Integer e = 200;
        Integer f = 200;
        System.out.println("e.equals(f) : " + e.equals(f));
        System.out.println("e == f : " + (e == f));
    }
}
