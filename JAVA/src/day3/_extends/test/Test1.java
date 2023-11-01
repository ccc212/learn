package day3._extends.test;

public class Test1 {
    /*
        需求:
                人类: (Person)
                        成员变量: 姓名, 年龄


                老师类:
                        成员变量: 姓名, 年龄
                        成员方法: teach
                                    - 姓名为张三, 年龄为30岁的老师正在讲课

                学生类:
                        成员变量: 姓名, 年龄, 成绩
                        成员方法: study
                                    - 姓名为李四, 年龄为20岁, 成绩为100分的学生, 正在学习
     */
    public static void main(String[] args) {
        Teacher t = new Teacher("张三", 30);
        t.teach();

        Student stu = new Student("李四", 20, 100);
        stu.study();
    }
}
