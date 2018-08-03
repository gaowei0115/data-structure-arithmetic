package com.structure.arithmetic.api.generic;


import com.structure.arithmetic.api.generic.domain.Apple;
import com.structure.arithmetic.api.generic.domain.Firut;
import com.structure.arithmetic.api.generic.domain.RedApple;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-06 14:12
 * @history: (version) author date desc
 */
public class GenericTest01 {

    public static void superG() {
        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new RedApple());

        List<? extends Apple> extendsList = new ArrayList<>();
//        extendsList.add(new RedApple());
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        System.out.println((list1.getClass() == list2.getClass()));
    }
}
