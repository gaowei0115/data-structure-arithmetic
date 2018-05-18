package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption: 泛型通配符
 * @author: gaowei
 * @date： 2018-04-28 14:12
 * @history: (version) author date desc
 */
public class GenericCurrency {


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("string01");
        strings.add("string02");
        strings.add("string03");
        strings.add("string04");

        print(strings);
        List<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(200);
        integers.add(300);
        integers.add(400);
        print(integers);
    }


    public static void print(Collection<?> colls) {
        for (Object coll : colls) {
            System.out.println(coll);
        }
        System.out.println("--------------------------------------------");
    }
}
