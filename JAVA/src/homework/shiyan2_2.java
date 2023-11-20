package homework;
//编写程序,　设计一个父类People及其二个子类Student、Teacher,分别为这三个类设计相应的成员属性和行为，
// 要求：Student、Teacher类重写People类的printInfo方法，并声明父类对象来表示子类的对象，
// 通过该对象调用被子类重写的printInfo方法来输出其相应的属性值。
class People{
    String name;
    int age;
    String gender;
    public People(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public void printInfo(){
        System.out.print("姓名:"+name+" 年龄:"+age+" 性别:"+gender);;
    }
}
class student extends People{
    String school;
    public student(String name,int age,String gender,String school){
        super(name,age,gender);
        this.school=school;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println(" 学校:"+school);
    }
}
class teacher extends People{
    String subject;
    public teacher(String name,int age,String gender,String subject){
        super(name,age,gender);
        this.subject=subject;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println(" 学科:"+subject);
    }
}
public class shiyan2_2 {
    public static void main(String[] args){
        People stu=new student("小明",18,"男","广东海洋大学");
        stu.printInfo();
        People tea=new teacher("大明",48,"男","计算机");
        tea.printInfo();
    }
}
