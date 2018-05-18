package com.structure.arithmetic.api.generic.demo01;

/**
 * @packageName：com.structure.arithmetic.api.generic.demo01
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-28 16:11
 * @history: (version) author date desc
 */
public class Rectangle extends Shape {

    @Override
    void draw(Canvas canvas) {
        System.out.println("在 " + canvas.toString() + " 画布上画一个矩形");
    }
}
