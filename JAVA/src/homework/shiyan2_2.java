package homework;
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
