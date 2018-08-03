package com.structure.arithmetic.api.genericjava4.method.exam;

import com.structure.arithmetic.api.genericjava4.inter.Generator;
import com.structure.arithmetic.api.genericjava4.method.BasicGenerator;
import com.structure.arithmetic.api.genericjava4.method.ObjectCounter;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.method.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-12 10:54
 * @history: (version) author date desc
 */
public class ObjectCounterBasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<ObjectCounter> generator = BasicGenerator.create(ObjectCounter.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(">> " + generator.next());
        }

        System.out.println("show structor create object ....");
        /**
         * show structor create object
         */
        generator = new BasicGenerator<>(ObjectCounter.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(">> " + generator.next());
        }
    }
}
