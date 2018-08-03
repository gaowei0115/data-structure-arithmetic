package com.structure.arithmetic.api.genericjava4.inter;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.inter
 * @desrciption: 对象生成器
 * @author: gaowei
 * @date： 2018-06-11 10:36
 * @history: (version) author date desc
 */
public interface Generator<T> {

    /**
     * 返回对象
     * @return
     */
    T next();

}
