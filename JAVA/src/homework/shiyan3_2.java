package homework;

import java.util.InputMismatchException;
import java.util.Scanner;
//编写简单的成绩管理应用程序，定义二个异常类：录入的成绩低于0分和成绩超过100分的异常。
//当录入一门课程的成绩（整数）时，能够处理录入数据的类型错误异常、录入的成绩低于0分和成绩超过100分的异常。

class OverflowException extends Exception {
    String message;

    public OverflowException(String error) {
        message = error;
    }

    public String getMessage() {
        return message;
    }
}

class UnderflowException extends Exception {
    String message;

    public UnderflowException(String error) {
        message = error;
    }

    public String getMessage() {
        return message;
    }
}

public class shiyan3_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("请输入成绩：");
                int score = s.nextInt();
                if (score < 0) throw new UnderflowException("成绩低于0");
                else if (score > 100) throw new OverflowException("成绩高于100");
                System.out.println("录入成功,成绩为：" + score);
                break;
            } catch (UnderflowException e) {
                System.out.println(e.getMessage());
            } catch (OverflowException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("输入数据类型错误,请重新输入整数");
                s.nextLine();
            }
        }
    }
}
