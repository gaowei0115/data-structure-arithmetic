package com.structure.arithmetic.api.generic;

/**
 * @packageName：com.structure.arithmetic.api.generic
 * @desrciption: 有界泛型 上界
 * @author: gaowei
 * @date： 2018-06-07 13:41
 * @history: (version) author date desc
 */
public class BoundedGeneric<T extends Animal> {


    private T animal;

    public BoundedGeneric(T t) {
        this.animal = t;
    }

    public void testAnimal() {
        animal.eat();
    }

    public static void main(String[] args) {
        BoundedGeneric<Dog> dog = new BoundedGeneric<>(new Dog());
        dog.testAnimal();
    }
}

interface Animal {
    void eat();
}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("dog eat Bone ......");
    }
}
