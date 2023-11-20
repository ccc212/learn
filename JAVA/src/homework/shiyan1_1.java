package homework;
import java.util.Scanner;
//编写应用程序，输入一个正整数max，输出满足1+2+3+.....+n<max的最大正整数n。
public class shiyan1_1 {
    public static void main(String[] args) {
        int max;
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        int sum=0;
        for (int i = 1;; i++) {
            sum += i;
            if (sum > max) {
                System.out.println(i-1);
                break;
            }
        }
    }
}
