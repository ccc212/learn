package day5._lambda.a;

public class LambdaDemo3 {
    public static void main(String[] args) {

        use(new A() {
            @Override
            public void method() {
                System.out.println("匿名内部类....");
            }
        });

        use(new A() {
            @Override
            public void method() {
                System.out.println("匿名内部类....");
            }
        });

        use(() -> {
            System.out.println("Lambda...");
        });
    }

    public static void use(A a) {
        a.method();
    }

}

interface A {
    void method();
}
