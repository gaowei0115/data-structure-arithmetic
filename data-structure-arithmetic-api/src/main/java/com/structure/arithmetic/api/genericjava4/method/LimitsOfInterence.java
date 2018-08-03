package com.structure.arithmetic.api.genericjava4.method;

import com.structure.arithmetic.api.genericjava4.method.vo.Person;

import java.util.List;
import java.util.Map;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 9:50
 * @history: (version) author date desc
 */
public class LimitsOfInterence {

    static void f(Map<Person, List<? extends Person>> persons) {

    }

    public static void main(String[] args) {
        // error
        Map map = CollectionUtils.map();
        f(map);
    }
}
