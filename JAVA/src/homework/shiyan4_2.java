package homework;

import java.util.ArrayList;
import java.util.List;
//编写二个实体类(如学生、用户、老师等)，再编写泛型类，该类的成员变量是一个存放以上实体类的List,该泛型类具有插入实体对象和输出List内容的方法。
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "学生: " + name + " id:" + id;
    }
}
class Teacher {
    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "老师: " + name + " id:" + id;
    }
}
class EntityList<T> {
    private List<T> entityList;

    public EntityList() {
        entityList = new ArrayList<>();
    }
    public void insertEntity(T entity) {
        entityList.add(entity);
    }
    public void printEntities() {
        for (T entity : entityList) {
            System.out.println(entity.toString());
        }
    }
}

public class shiyan4_2 {
    public static void main(String[] args) {
        EntityList<Student> studentList = new EntityList<>();
        Student student1 = new Student(1, "张三");
        Student student2 = new Student(2, "李四");
        studentList.insertEntity(student1);
        studentList.insertEntity(student2);
        studentList.printEntities();

        EntityList<Teacher> teacherList = new EntityList<>();
        Teacher teacher1 = new Teacher(101, "王五");
        Teacher teacher2 = new Teacher(102, "赵六");
        teacherList.insertEntity(teacher1);
        teacherList.insertEntity(teacher2);
        teacherList.printEntities();
    }
}
