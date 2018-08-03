package com.structure.arithmetic.api.genericjava4.method;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 14:07
 * @history: (version) author date desc
 */
public class MathSetUtils {

    public static <T> Set<T> union(Set<T> desc, Set<T> src) {
        if (desc instanceof EnumSet) {
            Set<T> result = ((EnumSet) desc).clone();
            result.addAll(src);
            return result;
        }
        Set<T> result = new HashSet<>();
        result.addAll(desc);
        result.addAll(src);
        return result;
    }

    public static <T> Set<T> interSelect(Set<T> desc, Set<T> src) {
        Set<T> result = new HashSet<>(desc);
        result.retainAll(src);
        return result;
    }

    public static <T> Set<T> diff(Set<T> desc, Set<T> src) {
        Set<T> result = new HashSet<>(desc);
        result.removeAll(src);
        return result;
    }

    public static <T> Set<T> complement(Set<T> desc, Set<T> src) {
        return diff(union(desc, src), interSelect(desc, src));
    }

    public static void main(String[] args) {
        Set<String> desc = new HashSet<>();
        desc.add("zhangsan01");
        desc.add("lisi01");
        desc.add("wangwu01");
        desc.add("zhaoliu01");

        Set<String> src = new HashSet<>();
        src.add("lisi01");
        src.add("sunqi01");

        System.out.println("union...........................");
        Set<String> result = union(desc, src);
        for (String rs : result) {
            System.out.println(">> " + rs);
        }

        System.out.println("inter............................");
        result = interSelect(desc, src);
        for (String rs : result) {
            System.out.println(">> " + rs);
        }

        System.out.println("diff............................");
        result = diff(desc, src);
        for (String rs : result) {
            System.out.println(">> " + rs);
        }

        System.out.println("complement.......................");
        result = complement(desc, src);
        for (String rs : result) {
            System.out.println(">> " + rs);
        }
    }
}
