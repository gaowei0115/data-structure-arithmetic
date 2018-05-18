package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-05-07 13:31
 * @history: (version) author date desc
 */
public class SuperGeneric {

    public static <T> T superGeneric(List<? super T> dest, List<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            dest.add(ele);
        }
        return last;
    }


    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();

        dest.add(2L);

        List<Integer> src = new ArrayList<>();
        src.add(3);
        src.add(4);

        Integer last = superGeneric(dest, src);
        System.out.println(last);
    }
}
