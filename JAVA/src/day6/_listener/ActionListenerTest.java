package com.itheima.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest {
    /*
        动作事件 : ActionListener

                1. 鼠标点击  2. 空格按键
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btn = new JButton("按钮");
        btn.setBounds(0,0,100,100);
        frame.getContentPane().add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我被点了!!!");
            }
        });


        frame.setVisible(true);
    }
}
