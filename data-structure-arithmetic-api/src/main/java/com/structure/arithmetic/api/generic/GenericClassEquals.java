package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-28 10:29
 * @history: (version) author date desc
 */
public class GenericClassEquals {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass().getName());
        System.out.println(list2.getClass().getName());

        System.out.println(list1.getClass() == list2.getClass());

        System.out.println(new String("111").getClass() == new String("222").getClass());
    }
}
