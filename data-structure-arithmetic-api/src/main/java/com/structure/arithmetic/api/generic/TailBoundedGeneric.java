package com.structure.arithmetic.api.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption:泛型通配符下界
 * @author: gaowei
 * @date： 2018-06-07 13:54
 * @history: (version) author date desc
 */
public class TailBoundedGeneric {


    public static void main(String[] args) {

        List<? super RedColor> colors = new ArrayList<>();
        colors.add(new RedColor());
        colors.add(new LightRedColor());

    }
}

interface Color {

    void diaplay();
}

class RedColor implements Color {

    @Override
    public void diaplay() {
        System.out.println("display red ...");
    }
}

class LightRedColor extends RedColor {


    @Override
    public void diaplay() {
        System.out.println("display light red ...");
    }
}

class BlowColor implements Color {

    @Override
    public void diaplay() {
        System.out.println("display blow ...");
    }
}
