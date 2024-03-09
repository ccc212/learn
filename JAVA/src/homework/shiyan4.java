package homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//编写一个实体类(如学生、用户、老师等)，该泛型类具有插入实体对象和输出List内容的方法。
//     要求1. 该实体类至少有一个编号的成员变量和设置编号的成员方法。在设置编号时，要求进行编号校验
//     （自定义校验规则：如编号的前4位为2019等等），符合规则则返回true,否则返回false。
//        2.定义存放实体类的List。
//        3.能够实现对该List增加和删除一个实体对象，并显示操作后的结果。
interface Entity{
    String getId();
    String getName();
}
class Stu implements Entity,Serializable{

    private String id;
    private String name;
    public Stu() {
    }
    public Stu(String id,String name){
        if("2019".equals(id.substring(0,4))){
            this.id = id;
        }
        this.name = name;
    }
    public boolean setId(String id) {
        if("2019".equals(id.substring(0,4))){
            this.id = id;
            return true;
        }else {
            return false;
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
class MyList<T extends Entity> implements Serializable {
    private List<T> MyList;
    public MyList(){
        MyList = new ArrayList<>();
    }
    public void printEntity(){
        System.out.println("当前成员有:");
        for (T entity : MyList) {
            System.out.println("id:"+entity.getId()+"\t"+"name:"+entity.getName());
        }
        System.out.println();
    }
    public void addEntity(T entity){
        System.out.println("添加成员"+entity.getName());
        MyList.add(entity);
        printEntity();
    }
    public void moveEntity(T entity){
        System.out.println("删除成员"+entity.getName());
        MyList.remove(entity);
        printEntity();
    }
    public int size(){
        return MyList.size();
    }
    public T getEntity(int index){
        if(index<0||index>size()){
            System.out.println("下标越界");
            return null;
        }else{
            return MyList.get(index);
        }
    }
}
public class shiyan4 {
    public static void main(String[] args) {
        MyList<Stu> stuList=new MyList<>();
        Stu stu1=new Stu();
        Stu stu2=new Stu();
        System.out.println(stu1.setId("2019001"));
        stu1.setName("张三");
        System.out.println(stu2.setId("2018002"));
        stu2.setName("李四");
        stuList.addEntity(stu1);
        stuList.addEntity(stu2);
        stuList.moveEntity(stu1);
    }
}

