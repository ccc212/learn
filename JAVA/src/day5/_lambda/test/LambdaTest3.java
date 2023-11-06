package day5._lambda.test;

import java.util.Random;

public class LambdaTest3 {
    public static void main(String[] args) {

        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                return new Random().nextInt(100) + 1;
            }
        });

        System.out.println("-----------------------");

        useRandomNumHandler(() -> new Random().nextInt(100) + 1);

    }

    public static void useRandomNumHandler(RandomNumHandler randomNumHandler) {
        // RandomNumHandler randomNumHandler = new RandomNumHandler() {
        //            @Override
        //            public int getNumber() {
        //                Random r = new Random();
        //                int num = r.nextInt(100) + 1;
        //                return num;
        //            }
        //        }
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}

interface RandomNumHandler {
    int getNumber();
}
