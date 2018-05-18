package com.structure.arithmetic.api.generic.demo01;

/**
 * @packageName：com.structure.arithmetic.api.generic.demo01
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-28 16:20
 * @history: (version) author date desc
 */
public class Circle extends Shape {

    @Override
    void draw(Canvas canvas) {
        System.out.println("在 " + canvas.toString() + " 画布上画一个圆形");
    }
}
