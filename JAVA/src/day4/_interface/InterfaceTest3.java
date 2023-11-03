package day4._interface;

interface InterA {
    void show();
}

interface InterB {
    void show();
}

interface InterC extends InterA, InterB {
    void show();
}

class InterCImpl implements InterC {

    @Override
    public void show() {

    }
}

public class InterfaceTest3 {
    /*
        接口和类之间的各种关系 :

            1. 类和类之间 : 继承关系, 只支持单继承, 不支持多继承, 但是可以多层继承

            2. 类和接口之间 : 实现关系, 可以单实现, 也可以多实现, 甚至可以在继承一个类的同时, 实现多个接口

            3. 接口和接口之间 : 继承关系, 可以单继承, 也可以多继承
     */
    public static void main(String[] args) {

    }
}

class Fu {
    public void show() {
        System.out.println("Fu..show");
    }
}

interface A {
    void show();
}

interface B {
    void show();
}

class Zi extends Fu implements A, B {

}

