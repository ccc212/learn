package day2._list.test;

import java.util.ArrayList;

public class ArrayListTest1 {
     /*
        需求: 创建一个存储字符串的集合, 内部存储3个字符串元素, 使用程序实现在控制台遍历该集合


        ArrayList<String> list = new ArrayList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

     */

     /*
        需求：创建一个存储字符串的集合, 内部存储字符串元素
                钢门吹雪, 西域狂鸭, 张三, 甄妮玛黛妗, 李四
                使用程序实现在控制台遍历该集合, 将4个字的人名, 打印在控制台
     */

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("钢门吹雪");
        list.add("西域狂鸭");
        list.add("张三");
        list.add("甄妮玛黛妗");
        list.add("李四");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(s.length() == 4){
                System.out.println(s);
            }
        }

    }
}
