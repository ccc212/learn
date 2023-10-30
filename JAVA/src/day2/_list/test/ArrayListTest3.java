package day2._list.test;



import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest3 {
    /*
        需求: 创建一个存储学生对象的集合, 存储3个学生对象, 使用程序实现在控制台遍历该集合
                    学生的姓名和年龄来自于键盘录入
     */
    public static void main(String[] args) {
        // 1. 准备集合容器, 用于存储学生对象
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入第" + i + "个学生信息: ");
            addStudent(list);
        }

        // 遍历集合, 打印学生信息
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName() + "---" + stu.getAge());
        }

    }

    private static void addStudent(ArrayList<Student> list) {
        // 2. 键盘录入学生信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();

        // 3. 将键盘录入的学生信息, 封装为学生对象
        Student stu = new Student(name, age);

        // 4. 将封装好的学生对象, 存入集合
        list.add(stu);
    }
}
