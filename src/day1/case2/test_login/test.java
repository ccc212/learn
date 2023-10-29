package day1.case2.test;

import java.util.Scanner;

/**
 * 需求：模拟用户登录，一共三次机会,登录之后要给出相应的提示
 * 分析：
 * 1.定义两个字符串类型变量,模拟已经存在的用户名和密码
 * 2. 键盘录入用户输入的用户名,密码
 * 3. 比对
 */
public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String username="admin";
        String password="123456";

        int count=3;

        while (count--!=0) {
            System.out.println("请输入用户名:");
            String inputUsername=sc.nextLine();

            System.out.println("请输入密码:");
            String inputPassword=sc.nextLine();

            if(inputPassword.equals(password)==true&&inputUsername.equals(username)==true){
                System.out.println("登录成功!");
            }else if(count!=0) System.out.println("登录失败,您还有"+count+"次机会");
            else System.out.println("啧，明天再来");
        }
    }
}
