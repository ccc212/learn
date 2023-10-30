package day1._string.test;

import java.util.Scanner;

public class test2 {
     /*
        需求 : 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数
                (不考虑其他字符)

                例如 :  aAb3&c2B*4CD1

                小写字母 : 3个
                大写字母 : 4个
                数字字母 : 4个
     */
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.println("请输入:");
         String input=sc.nextLine();
         char[]array=input.toCharArray();
         int smallCount=0,bigCount=0,numCount=0;
         for (int i = 0; i < array.length; i++) {
             char c = array[i];
             if (c >= 'a' && c <= 'z') smallCount++;
             else if (c >= 'A' && c <= 'Z') bigCount++;
             else if (c >= '0' && c <= '9') numCount++;
         }
         System.out.println("小写字母 : " + smallCount + "个");
         System.out.println("大写字母 : " + bigCount + "个");
         System.out.println("数字字符 : " + numCount + "个");
         
     }
}
