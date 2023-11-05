package com.itheima.design.adapter;

public class AdapterTest2 {
    /*
        适配器设计模式: 解决接口与接口实现类之间的矛盾问题
     */
    public static void main(String[] args) {

    }
}

interface 和尚 {
    void 打坐();
    void 念经();
    void 撞钟();
    void 习武();
}

abstract class 和尚Adapter implements 和尚 {

    @Override
    public void 打坐() {

    }

    @Override
    public void 念经() {

    }

    @Override
    public void 撞钟() {

    }

    @Override
    public void 习武() {

    }
}

class 鲁智深 extends 和尚Adapter {
    @Override
    public void 习武() {
        System.out.println("拳打镇关西");
        System.out.println("大闹野猪林");
        System.out.println("倒拔垂杨柳");
        System.out.println("黑马学Java");
    }
}

class 唐僧 extends 和尚Adapter {

    @Override
    public void 打坐() {

    }

    @Override
    public void 念经() {

    }

    @Override
    public void 撞钟() {

    }

}