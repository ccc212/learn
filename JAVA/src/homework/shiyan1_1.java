package homework;
import java.util.Scanner;
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
