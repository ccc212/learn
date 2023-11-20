package homework;

import javax.swing.*;

//用图形界面来实现实验4的要求，点击“确认”或“删除”按钮时，增加或删除List中的一个对象。
// 点击“显示”按钮时，显示List中的全部对象。
public class shiyan5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("MyList");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton btn1 = new JButton("增加");
        JButton btn2 = new JButton("删除");
        JButton btn3 = new JButton("显示");
        btn1.setBounds(10, 10, 80, 50);
        btn2.setBounds(100, 10, 80, 50);
        btn3.setBounds(190, 10, 80, 50);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.setVisible(true);
    }
}
