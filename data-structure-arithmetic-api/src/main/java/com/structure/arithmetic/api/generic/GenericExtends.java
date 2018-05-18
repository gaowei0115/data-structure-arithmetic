package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:
 * @author: gaowei
 * @date： 2018-05-07 10:27
 * @history: (version) author date desc
 */
public class GenericExtends {


    public static <T> T extendGeneric(List<T> dest, List<? extends T> src) {
        T last = null;
        for (T obj : src) {
            last = obj;
            dest.add(obj);
        }
        return  last;
    }

    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        dest.add(2L);
        dest.add(3L);
        dest.add(4L);

        List<Integer> src = new ArrayList<>();
        src.add(5);
        src.add(6);
        src.add(7);
        Number last = extendGeneric(dest, src);
    }
}
