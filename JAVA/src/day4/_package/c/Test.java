package day4._package.c;

import day4._package.a.Student;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.eat();

        // 使用全类名创建对象 : 包名 + 类名
        day4._package.b.Student stu2 = new day4._package.b.Student();
        stu2.sleep();
    }
}
