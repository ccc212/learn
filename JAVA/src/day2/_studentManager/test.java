package day2._studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Student>list=new ArrayList<>();

        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    deleteStudent(list);
                    break;
                case 3:
                    updateStudent(list);
                    break;
                case 4:
                    queryStudentInfos(list);
                    break;
                case 5:
                    System.out.println("感谢您的使用, 再见");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误, 请检查");
                    break;
            }
        }
    }

    private static void queryStudentInfos(ArrayList<Student> list) {
        if(list.isEmpty()){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Student stu : list) {
            System.out.println(stu.getId()+"\t\t"+
                    stu.getName()+"\t"+
                    stu.getAge()+"\t"+
                    stu.getBirthday());
        }
    }

    private static void updateStudent(ArrayList<Student> list) {
        String id,name,birthday;
        int age;
        lo:
        while (true) {
            System.out.println("修改的学号:");
            id=sc.next();
            for (int i=0;i<list.size();i++) {
                if(id.equals(list.get(i).getId())){
                    System.out.println("姓名:");
                    name=sc.next();
                    System.out.println("年龄");
                    age=sc.nextInt();
                    if(age<0||age>130){
                        System.out.println("输入年龄有误，请重新输入");
                        continue;
                    }
                    System.out.println("生日");
                    birthday=sc.next();
                    Student newstudent=new Student(id,name,age,birthday);
                    list.set(i,newstudent);
                    System.out.println("修改成功！");
                    break lo;
                }
            }
        }
    }

    private static void deleteStudent(ArrayList<Student> list) {
        if(list.isEmpty()){
            System.out.println("学生管理系统没人");
            return;
        }
        String id;
        System.out.println("请输入您要删除的学生学号");
        id=sc.next();
        for (Student stu:list) {
            if (id.equals(stu.getId())) {
                list.remove(stu);
                return;
            }
        }
        System.out.println("查无此人，删除失败");
    }

    private static void addStudent(ArrayList<Student> list) {
        String id,name,birthday;
        int age;
        while (true) {
            System.out.println("学号:");
            id=sc.next();
            for (Student stu : list) {
                if(id.equals(stu.getId())){
                    System.out.println("您输入的学号已被占用，请重新输入:");
                    continue;
                }
            }
            System.out.println("姓名:");
            name=sc.next();
            System.out.println("年龄");
            age=sc.nextInt();
            if(age<0||age>130){
                System.out.println("输入年龄有误，请重新输入");
                continue;
            }
            System.out.println("生日");
            birthday=sc.next();
            Student newstudent=new Student(id,name,age,birthday);
            list.add(newstudent);
            System.out.println("添加成功！");
            break;
        }
    }


}
