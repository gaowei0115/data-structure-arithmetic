package com.structure.arithmetic.api.genericjava4.method.vo;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method.vo
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 9:53
 * @history: (version) author date desc
 */
public class Person {

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{person: name: " + name + "}";
    }
}
