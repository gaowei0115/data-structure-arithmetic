package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption: 泛型导致ClassCaseException
 * @author: gaowei
 * @date： 2018-04-27 14:16
 * @history: (version) author date desc
 */
public class GenericClassCast {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("classCase1");
        list.add("classCase2");
        list.add("classCase3");
        list.add("classCase4");
        list.add(1);

        for (int i =0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }
}
