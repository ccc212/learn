package homework;
//利用实验4中所定义的实体类，对实验5进行功能扩充，增加“保存文件”和“读取文件”按钮，
// 实现List中对象保存到文件、读取文件的数据到List的功能。
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class shiyan7_2 extends JFrame {
    private MyList<Stu> stuList;

    public shiyan7_2() {
        stuList = new MyList<>();

        setTitle("MyList");
        setSize(300, 120);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btn1 = new JButton("增加");
        JButton btn2 = new JButton("删除");
        JButton btn3 = new JButton("显示");
        JButton saveButton = new JButton("保存文件");
        JButton loadButton = new JButton("读取文件");

        btn1.setBounds(10, 10, 80, 25);
        btn2.setBounds(100, 10, 80, 25);
        btn3.setBounds(190, 10, 80, 25);
        saveButton.setBounds(10, 45, 120, 25);
        loadButton.setBounds(140, 45, 120, 25);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });

        add(btn1);
        add(btn2);
        add(btn3);
        add(saveButton);
        add(loadButton);

        setVisible(true);
    }

    private void addStudent() {
        String id = JOptionPane.showInputDialog("请输入学生ID:");
        String name = JOptionPane.showInputDialog("请输入学生姓名:");

        Stu newStu = new Stu();
        if (id == null && name == null) return;
        if (newStu.setId(id)) {
            newStu.setName(name);
            stuList.addEntity(newStu);
        } else {
            JOptionPane.showMessageDialog(null, "学生ID不正确");
        }
    }

    private void removeStudent() {
        String id = JOptionPane.showInputDialog("请输入学生ID:");
        Stu targetStu;
        int i = 0, n = stuList.size();
        for (; i < n; i++) {
            targetStu = stuList.getEntity(i);
            if (targetStu.getId().equals(id)) {
                String text = "确认删除学生" + targetStu.getName() + "吗？";
                int choice = JOptionPane.showConfirmDialog(null, text, "确认删除", JOptionPane.YES_NO_OPTION);
                if (choice == 0) stuList.moveEntity(targetStu);
                break;
            }
        }
        if (i == n) System.out.println("查无此人");
    }

    private void displayStudents() {
        stuList.printEntity();
    }

    private void saveToFile() {
        // 调用保存到文件的方法
        serializeToFile(stuList, "homework/test");
        JOptionPane.showMessageDialog(this, "文件保存成功！");
    }

    private void loadFromFile() {
        // 调用从文件读取的方法
        MyList<Stu> deserializedList = deserializeFromFile("homework/test");

        if (deserializedList != null) {
            stuList = deserializedList;
            displayStudents();
            JOptionPane.showMessageDialog(this, "文件读取成功！");
        } else {
            JOptionPane.showMessageDialog(this, "文件读取失败！");
        }
    }

    private void serializeToFile(Object object, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
            System.out.println("对象写到" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T deserializeFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new shiyan7_2();
    }
}

