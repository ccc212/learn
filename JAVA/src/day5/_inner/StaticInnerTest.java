package day5._inner;

public class StaticInnerTest {
    /*
        静态内部类 : static 修饰的成员内部类

        创建对象格式 : 外部类名.内部类名 对象名 = new 外部类名.内部类对象();

        注意事项 : 静态只能访问静态
     */
    public static void main(String[] args) {
        OuterClass.InnerClass.show();
    }
}

class OuterClass {

    int num1 = 10;
    static int num2 = 20;

    static class InnerClass {

        public static void show(){
            System.out.println("show...");

            OuterClass o = new OuterClass();
            System.out.println(o.num1);

            System.out.println(num2);
        }

    }

}
