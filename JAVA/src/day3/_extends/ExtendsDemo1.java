package day3._extends;

public class ExtendsDemo1 {
    /*
        继承: 类与类之间产生关系(子父类关系), 子类就可以直接使用父类中, 非私有的成员
     */
    public static void main(String[] args) {
        Coder c = new Coder();
        c.setName("张三");
        c.setAge(23);
        c.setSalary(12000);

        System.out.println(c.getName() + "---" + c.getAge() + "---" + c.getSalary());
    }
}

class Employee {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


/**
   创建类的细节:
   一个.java文件中可以编写多个class
   1. 保证类与类之间是平级关系
   2. 只能有一个被public修饰
 */
class Coder extends Employee {

}

class Manager extends Employee {

}


