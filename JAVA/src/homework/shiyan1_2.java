package homework;
import java.lang.Math;
import java.util.Random;
public class shiyan1_2 {
    public static void main(String[] args) {
        Random random = new Random();
        int max=0,min=99,count=0;
        for (int i = 1; i <= 100; i++) {
            int a=(int)(Math.random()*100);
//          int a = random.nextInt(100);
            System.out.printf("%2d ",a);
            if(i%10==0)System.out.println();
            if(a>max)max=a;
            if(a<min)min=a;
            if(a>50)count++;
        }
        System.out.println();
        System.out.println("max="+max);
        System.out.println("min="+min);
        System.out.println("count="+count);
    }
}
