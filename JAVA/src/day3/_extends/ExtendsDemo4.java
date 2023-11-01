package day3._extends;

public class ExtendsDemo4 {
    public static void main(String[] args) {
        C c = new C();
        c.methodC();
        c.methodB();
        c.methodA();
    }
}

//java支持单继承，不支持多继承
class A {
    public void methodA() {
        System.out.println("A...");
    }
}

class B extends A {
    public void methodB() {
        System.out.println("B...");
    }
}

class C extends B {
    public void methodC() {
        System.out.println("C...");
    }
}
