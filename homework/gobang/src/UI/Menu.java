package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    public Menu(){
        JFrame frame = new JFrame("菜单");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents1(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    private static void placeComponents1(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("五子棋");
        userLabel.setBounds(50,50,300,100);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setFont(userLabel.getFont().deriveFont(30.0f));
        panel.add(userLabel);

        JButton btn1 = new JButton("创建");
        JButton btn2 = new JButton("加入");
        btn1.setBounds(50,150,100,50);
        btn2.setBounds(250,150,100,50);
        panel.add(btn1);
        panel.add(btn2);

        JTextField userText = new JTextField(20);
        userText.setBounds(150,163,100,25);
        panel.add(userText);

        btn1.addActionListener(e -> {
            System.out.println("创建");
            new Creat();
        });
        btn2.addActionListener(e -> {
            System.out.println("加入");

        });
    }

    public static void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(new Menu());
        frame.dispose();
    }
}
