package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class shiyan4_1 {
    static ArrayList<String>list=new ArrayList<>();

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请输入人数:");
        int count=0;
        count=sc.nextInt();

        for(int i=0;i<count;i++){
            System.out.println("请输入第"+(i+1)+"个人的姓名:");
            list.add(sc.next());
        }

//        for(String s:list){
//            if(s.toLowerCase().startsWith("chen")){
//                System.out.println(s);
//            }
//        }

        for(String s:list){
            String temp=s.toLowerCase();
            if("chen".equals(temp.substring(0,4))){
                System.out.println(s);
            }
        }

    }
}
