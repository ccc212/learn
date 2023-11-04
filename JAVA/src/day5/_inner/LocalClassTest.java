package day5._inner;

public class LocalClassTest {
    /*
        局部内部类: 放在方法、代码块、构造器等执行体中
     */
    public static void main(String[] args) {
        A a = new A();
        a.show();
    }
}

class A {

    public void show(){

        class B {
            public void method(){
                System.out.println("method...");
            }
        }

        B b = new B();
        b.method();

    }

}