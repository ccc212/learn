package day5._lambda.test;

public class LambdaTest4 {
    public static void main(String[] args) {

        useCalculator((a, b) -> a + b);

        System.out.println("---------------------------");

        useCalculator((a, b) -> a - b);

    }

    public static void useCalculator(Calculator calculator) {
        // Calculator calculator = new Calculator() {
        //            @Override
        //            public int calc(int a, int b) {
        //                return a + b;
        //            }
        //        }
        int result = calculator.calc(10, 20);
        System.out.println(result);
    }

}

interface Calculator {
    int calc(int a, int b);
}
