package com.structure.arithmetic.api.generic.demo01;

import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic.demo01
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-28 16:08
 * @history: (version) author date desc
 */
public class Canvas {

    private String name;
    private String color;

    public Canvas () {

    }

    public Canvas(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void drawAlls(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw(this);
        }
    }

    @Override
    public String toString() {
        return "Canvas {" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
