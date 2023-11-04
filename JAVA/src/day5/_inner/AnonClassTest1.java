package day5._inner;

public class AnonClassTest1 {
    /*
        匿名内部类 :

            概述 : 匿名内部类本质上是一个特殊的局部内部类（定义在方法内部）
            前提 : 需要存在一个接口或类
            格式 :
                    new 类名\接口名 () {

                    }

                    new 类名(){}  : 代表继承这个类
                    new 接口名(){} : 代表实现这个接口

            结论 : 可以让代码变得更加简洁, 在定义类的时候对其进行实例化
     */
    public static void main(String[] args) {

        // 问题: 方法的形参是接口类型, 我们该传入的是什么?
        // 答案: 传入的是该接口的实现类对象
        useInter(new InterImpl());

        useInter(new Inter(){

            @Override
            public void show() {
                System.out.println("匿名内部类...show...");
            }
        });

    }

    public static void useInter(Inter i){   // Inter i = new InterImpl();
        i.show();
    }
}

interface Inter {
    void show();
}

class InterImpl implements Inter {
    @Override
    public void show() {
        System.out.println("InterImpl...show...");
    }
}