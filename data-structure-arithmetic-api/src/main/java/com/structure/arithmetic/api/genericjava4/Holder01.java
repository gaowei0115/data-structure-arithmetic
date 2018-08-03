package com.structure.arithmetic.api.genericjava4;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 14:07
 * @history: (version) author date desc
 */
public class Holder01<T> {

    private T ele;

    public Holder01() {}

    public Holder01(T element) {
        this.ele = element;
    }

    public void set(T element) {
        this.ele = element;
    }

    public T get() {
        return ele;
    }

    public static void main(String[] args) {
        /**
         * 通过<T>指定执行泛型类型</>
         */
        Holder01<Integer> number = new Holder01<>(new Integer(10));
        /**
         * 添加非指定类型时，编译出错
         */
//        number.set("");

        /**
         * 验证泛型执行某一类型时，导出类也可以存放
         */
        Holder01<Comparable> holder01 = new Holder01<>();
        holder01.set(new String());
        holder01.set(new Integer(1));
    }
}
