package com.structure.arithmetic.api.genericjava4.method;

import com.structure.arithmetic.api.genericjava4.inter.Generator;
import com.structure.arithmetic.api.genericjava4.inter.obj.Coffee;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 10:29
 * @history: (version) author date desc
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> clazz) {
        this.type = clazz;
    }


    @Override
    public T next() {
        try {
            T result = type.newInstance();
            return result;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 创建对象
     * @param type
     * @param <T>
     * @return
     */
    public static <T> BasicGenerator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) throws Exception {
        BasicGenerator<Coffee> basicGenerator = new BasicGenerator<>(Coffee.class);
        System.out.println(">>> " + basicGenerator.next());
    }
}
