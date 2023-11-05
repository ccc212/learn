package day5._lambda.test;

public class LambdaTest1 {
    public static void main(String[] args) {

        useShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类, 重写后的show方法...");
            }
        });

        System.out.println("-----------------------");

        useShowHandler(() -> System.out.println("Lambda表达式, 重写后的show方法..."));

    }

    public static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }

}

interface ShowHandler {
    void show();
}