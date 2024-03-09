package homework;

import java.io.*;

//利用实验4中所定义的实体类，创建3个该类对象并存放到一个文件中，读取该文件，并输出对象信息。
public class shiyan7_1 {
    public static void main(String[] args) {
        MyList<Stu> stuList = new MyList<>();
        Stu stu1 = new Stu();
        Stu stu2 = new Stu();

        stu1.setId("2019001");
        stu1.setName("张三");

        stu2.setId("2018002");
        stu2.setName("李四");

        stuList.addEntity(stu1);
        stuList.addEntity(stu2);

        serializeToFile(stuList, "./test.txt");

        MyList<Stu> deserializedList = deserializeFromFile("./test.txt");
        System.out.println("List: " + deserializedList);
    }
    private static void serializeToFile(Object object, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
            System.out.println("对象写到" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static <T> T deserializeFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
