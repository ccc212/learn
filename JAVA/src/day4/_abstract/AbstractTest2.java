package day4._abstract;

public class AbstractTest2 {
    /*
        抽象类的注意事项 :

            1. 抽象类不能实例化
                - 如果抽象类允许创建对象, 就可以调用内部没有方法体的抽象方法了
            2. 抽象类存在构造方法
                - 交给子类, 通过super进行访问
            3. 抽象类中可以存在普通方法
                - 可以让子类继承到继续使用
            4. 抽象类的子类
                    1). 要么重写抽象类中的所有抽象方法
                    2). 要么是抽象类
     */
    public static void main(String[] args) {
         Zi z = new Zi();
         z.method();

    }
}

abstract class A {
    public  abstract void showA();
}

abstract class B extends A {

    @Override
    public void showA() {

    }

    public abstract void showB();
}

class C extends B {

    @Override
    public void showB() {

    }
}


abstract class Fu {

    public Fu(){

    }

    public abstract void show();

    public void method(){
        System.out.println("method...");
    }

}

class Zi extends Fu {

    public Zi(){
        super();
    }

    @Override
    public void show() {

    }
}