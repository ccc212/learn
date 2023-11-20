package homework;

import javax.swing.*;
import java.awt.event.*;

public class shiyan5 {
    public static void main(String[] args) {
        MyList<Stu> stuList=new MyList<>();
        JFrame frame = new JFrame();
        frame.setTitle("MyList");
        frame.setSize(300, 120);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton btn1 = new JButton("增加");
        JButton btn2 = new JButton("删除");
        JButton btn3 = new JButton("显示");
        btn1.setBounds(10, 10, 80, 50);
        btn2.setBounds(100, 10, 80, 50);
        btn3.setBounds(190, 10, 80, 50);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("请输入学生ID:");
                String name = JOptionPane.showInputDialog("请输入学生姓名:");

                Stu newStu = new Stu();
                if(id==null&&name==null)return;
                if (newStu.setId(id)) {
                    newStu.setName(name);
                    stuList.addEntity(newStu);
                } else {
                    JOptionPane.showMessageDialog(null, "学生ID不正确");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=JOptionPane.showInputDialog("请输入学生ID:");
                Stu targetStu;
                int i=0,n= stuList.size();
                for (;i<n;i++){
                    targetStu=stuList.getEntity(i);
                    if (targetStu.getId().equals(id)){
                        String text="确认删除学生"+targetStu.getName()+"吗？";
                        int choice = JOptionPane.showConfirmDialog(null, text, "确认删除", JOptionPane.YES_NO_OPTION);
                        if(choice==0)stuList.moveEntity(targetStu);
                        break;
                    }
                }
                if(i==n) System.out.println("查无此人");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stuList.printEntity();
            }
        });
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.setVisible(true);
    }
}
