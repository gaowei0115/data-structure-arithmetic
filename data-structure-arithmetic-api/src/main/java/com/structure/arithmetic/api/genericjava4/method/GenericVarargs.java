package com.structure.arithmetic.api.genericjava4.method;

import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 9:57
 * @history: (version) author date desc
 */
public class GenericVarargs {

    /**
     * 组装list
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> makeList(T ...args) {
        List<T> list = CollectionUtils.list();
        if (args != null && args.length != 0) {
            for (T ele : args) {
                list.add(ele);
            }
        }
        return list;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = null;
        list = makeList("var01", "var02", "var03", "var04");

        for (String par : list) {
            System.out.println(par);
        }
    }
}

