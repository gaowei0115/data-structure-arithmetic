package com.structure.arithmetic.api.generic.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic.demo01
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-28 16:25
 * @history: (version) author date desc
 */
public class CanvasMain {

    public static void main(String[] args) {
        Canvas canvas = new Canvas("莫名", "蓝色");
        List<Circle> circles = new ArrayList<>();
        Circle circle = new Circle();
        circles.add(circle);
        canvas.drawAlls(circles);

    }
}
