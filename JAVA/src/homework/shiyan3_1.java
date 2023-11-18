package homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class shiyan3_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("输入两个整数完成除法运算：");
                int a = s.nextInt();
                int b = s.nextInt();
                System.out.println("结果为" + a / b);
                break;
            } catch (InputMismatchException e) {
                System.out.println("重新输入数据");
                s.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("除数为0");
                s.nextLine();
            }
        }
    }
}
