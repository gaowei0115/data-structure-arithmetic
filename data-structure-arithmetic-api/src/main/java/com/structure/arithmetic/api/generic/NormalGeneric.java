package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-27 14:35
 * @history: (version) author date desc
 */
public class NormalGeneric {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("normal01");
        list.add("normal02");
        list.add("normal03");
        list.add("normal04");
        list.add("normal05");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }

        list.forEach(ele -> System.out.println(ele.length()));
    }
}
