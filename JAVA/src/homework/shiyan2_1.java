package homework;
import java.util.Scanner;
//编写程序，读取1到100之间的整数，然后计算每个数出现的次数。(假设输入是以0结束的)
public class shiyan2_1 {
    public static void main(String[] args) {
        int [] num = new int[101];
        int [] temp=new int[101];
        boolean bool=true;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            int a = sc.nextInt();
            if (a < 0 || a > 100) {
                System.out.println("超范围了");
                return;
            }
            else if (a == 0) break;
            else num[a]++;
            for(int c:temp){
                if(c==a) {
                    bool=false;
                    break;
                }
            }
            if(bool)temp[i]=a;
            bool=true;
        }
        System.out.println("-----------------------");
        for(int b : temp) if(b!=0)System.out.println(b+" 出现 "+num[b]+" 次");
    }
}
