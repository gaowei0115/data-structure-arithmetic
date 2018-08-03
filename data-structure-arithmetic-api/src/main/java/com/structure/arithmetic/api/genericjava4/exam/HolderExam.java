package com.structure.arithmetic.api.genericjava4.exam;

/**
 * @packageName：com.structure.arithmetic.api.genericjava4.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-06-07 14:57
 * @history: (version) author date desc
 */
public class HolderExam<T> {

    private T ele1;
    private T ele2;
    private T ele3;


    public HolderExam(T ele1, T ele2, T ele3) {
        this.ele1 = ele1;
        this.ele2 = ele2;
        this.ele3 = ele3;
    }

    public static void main(String[] args) {
        HolderDemo ele1 = new HolderDemo("holder1");
        HolderDemo ele2 = new HolderDemo("holder2");
        HolderDemo ele3 = new HolderDemo("holder3");
        HolderExam<HolderDemo> holderExam = new HolderExam<>(ele1, ele2, ele3);

        System.out.println(holderExam.toString());
    }

    @Override
    public String toString() {
        return "HolderExam{" +
                "ele1=" + ele1 +
                ", ele2=" + ele2 +
                ", ele3=" + ele3 +
                '}';
    }

    public void setEle1(T ele1) {
        this.ele1 = ele1;
    }

    public void setEle2(T ele2) {
        this.ele2 = ele2;
    }

    public void setEle3(T ele3) {
        this.ele3 = ele3;
    }

    public T getEle1() {
        return ele1;
    }

    public T getEle2() {
        return ele2;
    }

    public T getEle3() {
        return ele3;
    }
}

class HolderDemo {
    private String name;

    public HolderDemo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HolderDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
